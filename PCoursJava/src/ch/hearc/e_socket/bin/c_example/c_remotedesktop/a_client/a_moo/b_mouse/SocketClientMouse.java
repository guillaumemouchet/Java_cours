
package ch.hearc.e_socket.bin.c_example.c_remotedesktop.a_client.a_moo.b_mouse;

import ch.hearc.e_socket.bin.a_tools.Ports;
import ch.hearc.e_socket.bin.a_tools.status.listener.StatusAdapter;
import ch.hearc.e_socket.bin.a_tools.status.listener.StatusListener;
import ch.hearc.e_socket.bin.a_tools.status.listener.error.ErrorEvent;
import ch.hearc.e_socket.bin.b_api.client.SocketClient;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.a_client.a_moo.b_mouse.deviceusb.XeoxListener;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.c_common.mouse.MouseAction;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.d_tools.xeox.GamepadXeox;

/**
 * singleton
 */
public class SocketClientMouse
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private SocketClientMouse()
		{
		print();

		start();
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static synchronized SocketClientMouse getInstance()
		{
		if (instance == null)
			{
			instance = new SocketClientMouse();
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

	public synchronized void sendMouseAction(MouseAction mouseAction)
		{
		// TODO
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

	private void startDeviceUSB()
		{
		// debug temp
		//			{
		//			new GamePadBouchon(this).start();
		//			}

		XeoxListener xeoxListener = new XeoxListener(this);
		GamepadXeox.getInstance().addGamepadListener(xeoxListener);
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
	private SocketClient<MouseAction, Byte> socketClient;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static SocketClientMouse instance = null;

	private static final String TITLE = "SocketMouse";
	private static final String IP = System.getProperty("ip", "localhost");
	private static final int PORT = Integer.parseInt(System.getProperty("port", "" + Ports.DEFAULT_PORT)) + 1;

	}
