
package ch.hearc.e_socket.bin.b_api.server.communication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

import ch.hearc.e_socket.bin.a_tools.status.Loggable;
import ch.hearc.e_socket.bin.a_tools.status.listener.error.ErrorType;
import ch.hearc.e_socket.bin.a_tools.status.listener.success.SuccessType;
import ch.hearc.e_socket.bin.b_api.tools.serialization.Serializeur_I;

/**
 * <pre>
 * Une communication par client
 *
 * TMessage  type generic qui doit etre Serializable
 * TResponse type generic qui doit etre Serializable
 * </pre>
 */
public class Communication<TMessage extends Serializable, TResponse extends Serializable> //
		extends Loggable implements Runnable

	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Communication(Socket clientSocket, Supplier<Transformer_I<TMessage, TResponse>> suplierTransformer, String title, Serializeur_I<TMessage> serializeurMessage, Serializeur_I<TResponse> serializeurReponse)
		{
		super("[Communication " + compteurInstance.incrementAndGet() + "] : in " + title);

		// Inputs
			{
			this.socketToClient = clientSocket;
			this.transformer = suplierTransformer.get(); // chaque communication doit avoir sa propre instance de Transformer_I. Le Supplier cree ces transformer
			this.serializeurMessage = serializeurMessage;
			this.serializeurReponse = serializeurReponse;
			}

		// tools
			{
			this.isFini = new AtomicBoolean(true);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		isFini.set(false);

		onStart();

		readReply();

		onEnd();
		}

	public void stop()
		{
		this.isFini.set(true);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private boolean onStart()
		{
		try
			{
			// output
				{
				this.os = this.socketToClient.getOutputStream();
				this.dos = new DataOutputStream(this.os);
				}

			// warning (pour initier la creation du socket, il faut "repondre" par un flush
				{
				this.dos.flush(); // sinon la commande read ci-dessous bloque :  this.dis = new DataInputStream(this.is) bloque sur ObjectInputStream
				this.os.flush(); // utile?
				}

			// Input
				{
				this.is = this.socketToClient.getInputStream();
				this.dis = new DataInputStream(this.is);
				}

			avertirListener(SuccessType.STARTED);
			return true;
			}
		catch (Exception e)
			{
			avertirListener(ErrorType.START_FAILED, e);
			return false;
			}
		}

	private boolean onEnd()
		{
		try
			{
			// output
				{
				this.dos.close();
				this.os.close();
				}

			// Input
				{
				this.dis.close();
				this.is.close();
				}

			// socket
				{
				this.socketToClient.close();
				}

			avertirListener(SuccessType.STOPPED);
			return true;
			}
		catch (IOException e)
			{
			avertirListener(ErrorType.STOP_FAIL, e);
			return false;
			}
		}

	/*------------------------------*\
	|*		 Communication			*|
	\*------------------------------*/

	private void readReply()
		{
		try
			{
			while(!isFini.get())
				{
				//System.out.println(prefixeMessage + " : waiting message ...");

				// Message
				TMessage message = readMessage();

				// Reponse
				TResponse response = transformer.transform(message);
				sendResponse(response);
				}
			}
		catch (EOFException e)
			{
			avertirListener(ErrorType.CLOSED_BY_CLIENT_PROBABLY, e);
			}
		catch (Exception e)
			{
			avertirListener(ErrorType.READ_REPLY_FAILED, e);
			}
		}

	/*------------------------------*\
	|*		 Communication			*|
	\*------------------------------*/

	private TMessage readMessage() throws ClassNotFoundException, IOException
		{
		// header
		int nbByte = this.dis.readInt();
		byte[] tabByte = new byte[nbByte];

		// Corps
		this.dis.readFully(tabByte, 0, nbByte);

		// to Object
		return serializeurMessage.unserialize(tabByte);
		}

	private void sendResponse(TResponse response) throws IOException
		{
		try
			{
			// to byte[]
			byte[] tabByte = this.serializeurReponse.serialize(response);

			// header
			this.dos.writeInt(tabByte.length);

			// corps
			this.dos.write(tabByte);

			// warning
			this.dos.flush();
			this.os.flush(); // utile? non

			}
		catch (IOException e)
			{
			avertirListener(ErrorType.SEND_FAIL, e);
			throw e;
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Inputs
	private Socket socketToClient;
	private Transformer_I<TMessage, TResponse> transformer;
	private Serializeur_I<TMessage> serializeurMessage;
	private Serializeur_I<TResponse> serializeurReponse;

	//Tools write
	private OutputStream os;
	private DataOutputStream dos;

	//Tools read
	private InputStream is;
	private DataInputStream dis;

	// Tools
	private AtomicBoolean isFini;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static AtomicInteger compteurInstance = new AtomicInteger(0);
	}
