
package ch.hearc.e_socket.bin.c_example.c_remotedesktop.b_server.b_mouse;

import java.util.function.Supplier;

import org.junit.jupiter.api.Assertions;

import ch.hearc.e_socket.bin.a_tools.Ports;
import ch.hearc.e_socket.bin.a_tools.status.listener.StatusAdapter;
import ch.hearc.e_socket.bin.a_tools.status.listener.StatusListener;
import ch.hearc.e_socket.bin.a_tools.status.listener.error.ErrorEvent;
import ch.hearc.e_socket.bin.a_tools.status.listener.success.SuccessEvent;
import ch.hearc.e_socket.bin.b_api.server.SocketServer;
import ch.hearc.e_socket.bin.b_api.server.communication.Transformer_I;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.c_common.mouse.ClickType;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.c_common.mouse.MouseAction;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.d_tools.MouseService;

/**
 * singleton
 */
public class SocketServerMouse
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private SocketServerMouse()
		{
		this.mouseService = MouseService.getInstance();
		this.i = 0;

		start();
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static synchronized SocketServerMouse getInstance()
		{
		if (instance == null)
			{
			instance = new SocketServerMouse();
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
		//v1
		this.serverSocket = new SocketServer<MouseAction, Byte>(createSupplier(), TITLE, PORT);

		//v2
		//this.serverSocket = new SocketServer<MouseAction, Byte>(createSupplier(), TITLE, PORT, new SerializeurGZIP<MouseAction>(), new Serializeur<Byte>());

		serverSocket.addStatusListener(createStatusListener());// facultatif
		serverSocket.start(); // async
		}

	private Supplier<Transformer_I<MouseAction, Byte>> createSupplier()
		{
		return new Supplier<Transformer_I<MouseAction, Byte>>()
			{

			@Override
			public Transformer_I<MouseAction, Byte> get()
				{
				return createTransformer(); // methode ci-dessous
				}
			};
		}

	private Transformer_I<MouseAction, Byte> createTransformer()
		{
		return new Transformer_I<MouseAction, Byte>()
			{

			@Override
			public Byte transform(MouseAction mouseAction)
				{
				//System.out.print("mouse" + i++ + " ");

				// Message
				process(mouseAction);

				// Response (independant du message)
					{
					// reseau
					return BYTE_1;
					}
				}

			};
		}

	private void process(MouseAction mouseAction)
		{
		// debug
			{
			//System.out.println(mouseAction);
			}

		// Movement
		if (mouseAction.getDx() != 0 || mouseAction.getDy() != 0)
			{
			mouseService.translate(mouseAction.getDx(), mouseAction.getDy());
			}

		// click type
		ClickType clickType = mouseAction.getClickType();

		switch(clickType)
			{
			case NONE:
				break;
			case LEFT_CLICKED:
				mouseService.clickLeft();
				break;
			case LEFT_PRESSED:
				mouseService.pressLeft();
				break;
			case LEFT_RELEASED:
				mouseService.releaseLeft();
				break;
			case DOUBLE_CLICK_LEFT:
				mouseService.doubleClickLeft();
				break;
			case RIGHT_CLICKED:
				mouseService.clickRight();
				break;
			case RIGHT_PRESSED:
				mouseService.pressRight();
				break;
			case RIGHT_RELEASED:
				mouseService.releaseRight();
				break;
			default:
				{
				Assertions.fail("[SocketServerMouse] : process Message : unimplemented" + mouseAction);
				break;
				}
			}
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
	private int i;

	private SocketServer<MouseAction, Byte> serverSocket;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static SocketServerMouse instance = null;

	private static final Byte BYTE_1 = (byte)1;

	private static final String TITLE = "SocketServerMouse";
	private static final int PORT = Integer.parseInt(System.getProperty("port", "" + Ports.DEFAULT_PORT)) + 1;

	}
