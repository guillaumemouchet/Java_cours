
package ch.hearc.e_socket.bin.b_api.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

import ch.hearc.e_socket.bin.a_tools.Ports;
import ch.hearc.e_socket.bin.a_tools.status.Loggable;
import ch.hearc.e_socket.bin.a_tools.status.listener.error.ErrorType;
import ch.hearc.e_socket.bin.a_tools.status.listener.success.SuccessType;
import ch.hearc.e_socket.bin.b_api.tools.Service_I;
import ch.hearc.e_socket.bin.b_api.tools.serialization.Serializeur;
import ch.hearc.e_socket.bin.b_api.tools.serialization.Serializeur_I;

/**
 * <pre>
 * TMessage  type generic qui doit etre Serializable
 * TResponse type generic qui doit etre Serializable
 * </pre>
 */
public class SocketClient<TMessage extends Serializable, TResponse extends Serializable> //
		extends Loggable implements Service_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public SocketClient(String ip, String title, int port, Serializeur_I<TMessage> serializeurMessage, Serializeur_I<TResponse> serializeurReponse)
		{
		super("[Client] -> [Serveur] " + ip + ":" + port + " " + title);

		// Inputs
			{
			this.ip = ip;
			this.port = port;
			this.serializeurMessage = serializeurMessage;
			this.serializeurReponse = serializeurReponse;
			}

		// Tools
			{
			this.isStarded = new AtomicBoolean(false);
			}
		}

	public SocketClient(String ip, String title, int port)
		{
		this(ip, title, port, new Serializeur<TMessage>(), new Serializeur<TResponse>());
		}

	public SocketClient(String ip, String title)
		{
		this(ip, title, Ports.DEFAULT_PORT);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			 Connection			*|
	\*------------------------------*/

	@Override
	public synchronized boolean start()
		{
		if (!isStarded.get())
			{
			try
				{
				this.clientSocket = new Socket(this.ip, this.port);

				// output
					{
					this.os = this.clientSocket.getOutputStream();
					this.dos = new DataOutputStream(this.os);
					}

				// warning (pour initier la creation du socket, il faut "parler" au serveur par un flush
					{
					this.dos.flush();
					this.os.flush(); // utile?
					}

				// input
					{
					this.is = this.clientSocket.getInputStream();
					this.dis = new DataInputStream(this.is);
					}

				this.isStarded.set(true);

				//System.out.println(prefixeMessage + " : connected !\n");

				avertirListener(SuccessType.CONNEXION_SUCCESS);
				return true;
				}
			catch (Exception e)
				{
				this.isStarded.set(false);
				//System.err.println(prefixeMessage + " : start : fail : " + e);
				avertirListener(ErrorType.CONNEXION_FAIL, e);
				return false;
				}
			}
		else
			{
			System.out.println(prefixeMessage + " : warning : start ask, but already running");

			avertirListener(SuccessType.CONNEXION_SUCCESS);

			return true;
			}
		}

	@Override
	public synchronized boolean stop()
		{
		if (isStarded.get())
			{
			try
				{

				// output
					{
					this.dos.close();
					this.os.close();
					}

				// input
					{
					this.dis.close();
					this.is.close();
					}

				// socket
					{
					this.clientSocket.close();
					}

				this.isStarded.set(false);
				avertirListener(SuccessType.STOPPED);
				return true;
				}
			catch (IOException e)
				{
				this.isStarded.set(true);

				//System.err.println(prefixeMessage + ": stop : fail " + e);
				//e.printStackTrace();
				avertirListener(ErrorType.STOP_FAIL, e);

				return false;
				}
			}
		else
			{
			System.out.println(prefixeMessage + " : warning : stop ask , but not running!");
			avertirListener(SuccessType.STOPPED);
			return true;
			}
		}

	/*------------------------------*\
	|*		 Communication			*|
	\*------------------------------*/

	public void send(TMessage message) throws IOException
		{
		try
			{
			// to byte[]
			byte[] tabByte = this.serializeurMessage.serialize(message);

			// header
			this.dos.writeInt(tabByte.length);

			// corps
			this.dos.write(tabByte);

			// warning
			this.dos.flush();
			this.os.flush();// utile? non
			}
		catch (IOException e)
			{
			avertirListener(ErrorType.SEND_FAIL, e);
			//e.printStackTrace();
			throw e;
			}
		}

	public TResponse waitResponse() throws Exception
		{
		try
			{
			// header
			int nbByte = this.dis.readInt();
			byte[] tabByte = new byte[nbByte];

			// corps
			this.dis.readFully(tabByte, 0, nbByte);

			// to Object
			return this.serializeurReponse.unserialize(tabByte);
			}
		catch (ClassNotFoundException | IOException e)
			{
			avertirListener(ErrorType.READ_FAIL, e);
			//e.printStackTrace();
			throw e;
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methode	 Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Inputs
	private String ip;
	private int port;
	private Serializeur_I<TMessage> serializeurMessage;
	private Serializeur_I<TResponse> serializeurReponse;

	//Tools
	private Socket clientSocket;
	private AtomicBoolean isStarded;

	// Tools write
	private OutputStream os;
	private DataOutputStream dos;

	// Tools read
	private InputStream is;
	private DataInputStream dis;

	}
