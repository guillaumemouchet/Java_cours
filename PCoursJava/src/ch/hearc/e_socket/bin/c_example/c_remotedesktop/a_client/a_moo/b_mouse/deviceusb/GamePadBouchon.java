
package ch.hearc.e_socket.bin.c_example.c_remotedesktop.a_client.a_moo.b_mouse.deviceusb;

import ch.hearc.b_poo.j_thread.Threads;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.a_client.a_moo.b_mouse.SocketClientMouse;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.c_common.mouse.MouseAction;

public class GamePadBouchon implements Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public GamePadBouchon(SocketClientMouse socketClientMouse)
		{
		this.socketClientMouse = socketClientMouse;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		while(true)
			{
			Threads.sleep(100);
			socketClientMouse.sendMouseAction(TRANSLATE_DX);
			}
		}

	public void start()
		{
		new Thread(this).start();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private SocketClientMouse socketClientMouse;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final MouseAction TRANSLATE_DX = new MouseAction(1, 0);

	}
