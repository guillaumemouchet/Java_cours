
package ch.hearc.e_socket.bin.c_example.c_remotedesktop.a_client.a_moo.a_image;

import ch.hearc.e_socket.bin.a_tools.Ports;
import ch.hearc.e_socket.bin.a_tools.status.listener.StatusAdapter;
import ch.hearc.e_socket.bin.a_tools.status.listener.StatusListener;
import ch.hearc.e_socket.bin.a_tools.status.listener.error.ErrorEvent;
import ch.hearc.e_socket.bin.b_api.client.SocketClient;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.a_client.a_moo.a_image.listener.RemoteDataListenerizable;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.c_common.image.RemoteData;

/**
 * singleton
 */
public class SocketClientImage extends RemoteDataListenerizable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private SocketClientImage()
		{
		super();

		print();

		start();
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static synchronized SocketClientImage getInstance()
		{
		if (instance == null)
			{
			instance = new SocketClientImage();
			}

		return instance;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public boolean isStarted()
		{
		return this.isStarted;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void print()
		{
		System.out.println("[Client] : " + TITLE);
		System.out.println("[Client] : serveur ip   = " + IP);
		System.out.println("[Client] : serveur port = " + PORT);
		}

	private void start()
		{
		// TODO
		}

	private void startRecuperationImage()
		{
		this.threadRecuperationRemoteImage = new Thread(createRunnable());
		this.threadRecuperationRemoteImage.start();
		}

	private Runnable createRunnable()
		{
		return null; //TODO
		}



	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static StatusListener createStatusListener()
		{
		return new StatusAdapter()
			{

			//			@Override
			//			public void onSuccess(SuccessEvent successEvent)
			//				{
			//				System.out.println();
			//				System.out.println(successEvent);
			//				System.out.println();
			//				}

			@Override
			public void onError(ErrorEvent errorEvent)
				{
				System.err.println();
				System.err.println(errorEvent);
				System.err.println();
				}
			};
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Outputs
	private boolean isStarted;

	// Tools
	private SocketClient<Byte, RemoteData> socketClient;
	private Thread threadRecuperationRemoteImage;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static SocketClientImage instance = null;

	private static Byte BYTE_1 = (byte)1;

	private static final String TITLE = "SocketClientImage";
	private static final String IP = System.getProperty("ip", "localhost");
	private static final int PORT = Integer.parseInt(System.getProperty("port", "" + Ports.DEFAULT_PORT));

	}
