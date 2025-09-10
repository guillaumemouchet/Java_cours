
package ch.hearc.e_socket.bin.c_example.c_remotedesktop.b_server.a_image;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.function.Supplier;

import ch.hearc.e_socket.bin.a_tools.Ports;
import ch.hearc.e_socket.bin.a_tools.image.ImageSerializable;
import ch.hearc.e_socket.bin.a_tools.status.listener.StatusAdapter;
import ch.hearc.e_socket.bin.a_tools.status.listener.StatusListener;
import ch.hearc.e_socket.bin.a_tools.status.listener.error.ErrorEvent;
import ch.hearc.e_socket.bin.a_tools.status.listener.success.SuccessEvent;
import ch.hearc.e_socket.bin.b_api.server.SocketServer;
import ch.hearc.e_socket.bin.b_api.server.communication.Transformer_I;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.c_common.image.RemoteData;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.d_tools.MouseService;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.d_tools.ScreenService;

/**
 * singleton
 */
public class SocketServerImage
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private SocketServerImage()
		{
		this.mouseService = MouseService.getInstance();
		this.screenService = ScreenService.getInstance();
		this.compressionQuality01 = 1;//compressionQuality01 in [01] 1 best
		this.i = 0;

		start();
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static synchronized SocketServerImage getInstance()
		{
		if (instance == null)
			{
			instance = new SocketServerImage();
			}

		return instance;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void start()
		{
		this.serverSocket = new SocketServer<Byte, RemoteData>(createSupplier(), TITLE, PORT);

		serverSocket.addStatusListener(createStatusListener());// facultatif
		serverSocket.start(); // async
		}

	private Supplier<Transformer_I<Byte, RemoteData>> createSupplier()
		{
		return new Supplier<Transformer_I<Byte, RemoteData>>()
			{

			@Override
			public Transformer_I<Byte, RemoteData> get()
				{
				return createTransformer(); // methode ci-dessous
				}
			};
		}

	private Transformer_I<Byte, RemoteData> createTransformer()
		{
		return new Transformer_I<Byte, RemoteData>()
			{

			@Override
			public RemoteData transform(Byte message)
				{
				//System.out.print("image" + i++ + " ");

				// Response (independant du message)
					{
					// image
					BufferedImage bimage = screenService.getImage();
					ImageSerializable simage = new ImageSerializable(bimage, compressionQuality01);

					// mouse
					Point point = mouseService.location();

					// reseau
					return new RemoteData(simage, point.x, point.y);
					}
				}

			};
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static StatusListener createStatusListener()
		{
		return new StatusAdapter()
			{

			@Override
			public void onSuccess(SuccessEvent successEvent)
				{
				System.out.println(successEvent);
				}

			@Override
			public void onError(ErrorEvent errorEvent)
				{
				System.err.println(errorEvent);
				}
			};
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Outputs

	// Tools
	private MouseService mouseService;
	private ScreenService screenService;
	private float compressionQuality01;
	private int i;

	private SocketServer<Byte, RemoteData> serverSocket;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static SocketServerImage instance = null;

	private final String TITLE = "SocketServerImage";
	private final int PORT = Integer.parseInt(System.getProperty("port", "" + Ports.DEFAULT_PORT));

	}
