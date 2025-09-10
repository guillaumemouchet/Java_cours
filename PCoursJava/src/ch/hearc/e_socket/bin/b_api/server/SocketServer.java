
package ch.hearc.e_socket.bin.b_api.server;

import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import ch.hearc.e_socket.bin.a_tools.Ports;
import ch.hearc.e_socket.bin.a_tools.status.Loggable;
import ch.hearc.e_socket.bin.a_tools.status.listener.StatusListener;
import ch.hearc.e_socket.bin.a_tools.status.listener.error.ErrorType;
import ch.hearc.e_socket.bin.a_tools.status.listener.success.SuccessType;
import ch.hearc.e_socket.bin.b_api.server.communication.Communication;
import ch.hearc.e_socket.bin.b_api.server.communication.Transformer_I;
import ch.hearc.e_socket.bin.b_api.tools.Service_I;
import ch.hearc.e_socket.bin.b_api.tools.serialization.Serializeur;
import ch.hearc.e_socket.bin.b_api.tools.serialization.Serializeur_I;

/**
 * <pre>
 * Principe:
 * 		Le serveur cree une communication pour chaque nouveau client, dans un thread separer.
 *
 * Probleme P1 :
 * 		Comme il s'agit d'une API generique, comment modeliser de maniere abstraites,
 * 		ce que doit faire le server lorsqu'il recoit des message des clients?
 *
 * Solution S1 :
 * 		Employer  l'interface Transformer_I  qui possède une unique methode transform
 *      qui transforme le message en une reponse
 *
 * Problem P2:
 * 		Chaque communication doit posserder une instance differente de Transformer_I
 * 		Mais on ne connait pas le nombre de client a l'avance!
 * 		On doit pouvoir instancier a la volee des Transformer_I
 * 		chaque fois q'un nouveau clinet arrive
 *
 * Solution P2:
 * 		Il faut passer par un Supplier
 * 		IL s'agit s'une sorte de "Factory", qui est capable de fabriquer a la demande des Transformer_I
 *
 * TMessage  type generic qui doit etre Serializable
 * TResponse type generic qui doit etre Serializable
 * </pre>
 */
public class SocketServer<TMessage extends Serializable, TResponse extends Serializable> //
		extends Loggable implements Service_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * <pre>
	 * Supplier<Transformer_I> : l'objet capable de fabriquer autant de Transformer_I qu'il est necessaire, et a la volee.
	 * Il faut un objet Transformer_I par client, ie un objet transformer par communication.
	 * </pre>
	 */
	public SocketServer(Supplier<Transformer_I<TMessage, TResponse>> suplierTransformer, String title, int port, Serializeur_I<TMessage> serializeurMessage, Serializeur_I<TResponse> serializeurReponse)
		{
		super("[Server] : " + title + ":" + port);

		// Inputs
			{
			this.port = port;
			this.suplierTransformer = suplierTransformer;
			this.title = title;
			this.serializeurMessage = serializeurMessage;
			this.serializeurReponse = serializeurReponse;
			}

		// Tools
			{
			this.listThread = new ArrayList<Thread>();
			this.listCommunication = new ArrayList<Communication<TMessage, TResponse>>();
			}
		}

	public SocketServer(Supplier<Transformer_I<TMessage, TResponse>> suplierTransformer, String title, int port)
		{
		this(suplierTransformer, title, port, new Serializeur<TMessage>(), new Serializeur<TResponse>());
		}

	public SocketServer(Supplier<Transformer_I<TMessage, TResponse>> suplierTransformer, String title)
		{
		this(suplierTransformer, title, Ports.DEFAULT_PORT);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public synchronized boolean start()
		{
		this.threadServer = new Thread(createRunnable());
		this.threadServer.setName("serveur_socket_" + title);
		this.threadServer.start();

		return true;
		}

	@SuppressWarnings("deprecation")
	@Override
	public synchronized boolean stop()
		{
		try
			{
			for(Communication<TMessage, TResponse> communication:listCommunication)
				{
				communication.stop();
				}

			for(Thread thread:listThread)
				{
				thread.stop();
				}

			this.serverSocket.close();
			threadServer.stop();

			avertirListener(SuccessType.STOPPED);
			return true;
			}
		catch (IOException e)
			{
			//e.printStackTrace();
			avertirListener(ErrorType.STOP_FAIL, e);
			return false;
			}
		}

	/*------------------------------*\
	|*			  StatusListener	*|
	\*------------------------------*/

	@Override
	public synchronized void addStatusListener(StatusListener statustListener)
		{
		super.addStatusListener(statustListener);

		for(Communication<TMessage, TResponse> communication:listCommunication)
			{
			communication.addStatusListener(statustListener);
			}
		}

	@Override
	public synchronized void removeStatusListener(StatusListener statustListener)
		{
		super.removeStatusListener(statustListener);

		for(Communication<TMessage, TResponse> communication:listCommunication)
			{
			communication.removeStatusListener(statustListener);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private Runnable createRunnable()
		{
		return new Runnable()
			{

			@Override
			public void run()
				{
				runServeur();
				}
			};
		}

	private void runServeur()
		{
		try
			{
			// v1
			this.serverSocket = new ServerSocket(this.port);

			//v2
			//			this.serverSocket = new ServerSocket();
			//			this.serverSocket.setReuseAddress(true);
			//			this.serverSocket.bind(new InetSocketAddress(this.port));

			System.out.println(prefixeMessage + " : STARTED");
			//avertirListener(SuccessType.STARTED);

			while(true)
				{
				// on attend un client
				// on reste bloquer sur la methode accept ci-dessous
				// puis on demare une communication avec ce client des qu'il y en a un
				this.clientSocket = serverSocket.accept();// synchrone (attend un nouveau client)

				avertirListener(SuccessType.NEW_CLIENT_DETECT);
				//System.out.println(prefixeMessage + " : new client detect");

				startCommunicationAsync();// non bloquant
				}
			}
		catch (IOException e)
			{
			//System.err.println(prefixeMessage + " :  create socket : fail : " + e);
			//e.printStackTrace();
			avertirListener(ErrorType.START_FAILED, e);
			}
		}

	/**
	 * <pre>
	 * Doit redonner la main au plus vite
	 * Pour que la methode accept ci-dessus puisse recevoir de nouveau client
	 * </pre>
	 */
	private void startCommunicationAsync()
		{
		// Communication:
		// Goal :	Chaque Client comminique avec le serveur via l'objet communication
		//			Et dans un thread dedier (cf ci-dessous)
		Communication<TMessage, TResponse> communicationMOO = new Communication<TMessage, TResponse>(this.clientSocket, this.suplierTransformer, prefixeMessage, serializeurMessage, serializeurReponse);

		// Thread:
		// Goal : 	Pour redonner la main a la boucle infini d'attente de nouveau clients (methode accept ci-dessus)
		// 			la communication sera gerer dans un thread dedier
		Thread thread = new Thread(communicationMOO);
		thread.setName(prefixeMessage);

		// List:
		// Goal:	Pour pouvoir stopper plus tard sur demande une communication
		listThread.add(thread);
		listCommunication.add(communicationMOO);

		// Repousser les statusListener (loggable)  du server aux communications
		for(StatusListener statusListener:this.listStatusListeners)
			{
			communicationMOO.addStatusListener(statusListener);
			}

		thread.start(); // ainsi startCommunicationAsync est bien async
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Inputs
	private int port;
	private Supplier<Transformer_I<TMessage, TResponse>> suplierTransformer;
	private String title;
	private Serializeur_I<TMessage> serializeurMessage;
	private Serializeur_I<TResponse> serializeurReponse;

	//Tools
	private Thread threadServer;
	private ServerSocket serverSocket;
	private Socket clientSocket;

	private List<Thread> listThread;
	private List<Communication<TMessage, TResponse>> listCommunication;

	}
