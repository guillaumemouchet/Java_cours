
package ch.hearc.e_socket.bin.c_example.c_remotedesktop.a_client.b_gui;

import ch.hearc.c_gui.tools.decorateur.JFrameBaseLine;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.a_client.a_moo.a_image.SocketClientImage;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.a_client.a_moo.a_image.listener.RemoteDataListenerizable;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.a_client.a_moo.b_mouse.SocketClientMouse;

public class UseRemoteDesktopClientGUI
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		SocketClientMouse.getInstance();

		if (SocketClientImage.getInstance().isStarted())
			{
			RemoteDataListenerizable remoteDataListenerizable = SocketClientImage.getInstance();

			new JFrameBaseLine(new JRemote(remoteDataListenerizable));
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
