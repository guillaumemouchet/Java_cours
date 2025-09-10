
package ch.hearc.e_socket.bin.c_example.c_remotedesktop.b_server;

import ch.hearc.e_socket.bin.c_example.c_remotedesktop.b_server.a_image.SocketServerImage;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.b_server.b_mouse.SocketServerMouse;

public class UseRemoteDesktopServer
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
		SocketServerImage.getInstance();
		SocketServerMouse.getInstance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
