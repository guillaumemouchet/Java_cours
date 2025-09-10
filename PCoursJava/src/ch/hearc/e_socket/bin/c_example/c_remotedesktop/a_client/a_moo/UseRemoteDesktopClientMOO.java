
package ch.hearc.e_socket.bin.c_example.c_remotedesktop.a_client.a_moo;

import ch.hearc.e_socket.bin.c_example.c_remotedesktop.a_client.a_moo.a_image.SocketClientImage;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.a_client.a_moo.a_image.listener.RemoteDataEvent;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.a_client.a_moo.a_image.listener.RemoteDataListener;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.a_client.a_moo.b_mouse.SocketClientMouse;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.c_common.image.RemoteData;

public class UseRemoteDesktopClientMOO
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

		SocketClientImage.getInstance().addRemoteDataListener(createRemoteDataListener());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static RemoteDataListener createRemoteDataListener()
		{
		return new RemoteDataListener()
			{

			@Override
			public void remoteDataPerformed(RemoteDataEvent remoteDataEvent)
				{
				RemoteData remoteData = remoteDataEvent.getRemoteData();

				System.out.println(remoteData);
				}
			};
		}

	}
