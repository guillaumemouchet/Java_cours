
package ch.hearc.e_socket.bin.c_example.a_echo.client;

import ch.hearc.e_socket.bin.a_tools.Ports;
import ch.hearc.e_socket.bin.a_tools.status.listener.StatusAdapter;
import ch.hearc.e_socket.bin.a_tools.status.listener.StatusListener;
import ch.hearc.e_socket.bin.a_tools.status.listener.error.ErrorEvent;
import ch.hearc.e_socket.bin.b_api.client.SocketClient;

public class UseEchoClient
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
		final String TITLE = "Echo";

		final String IP = System.getProperty("ip", "localhost");
		final int PORT = Integer.parseInt(System.getProperty("port", "" + Ports.DEFAULT_PORT));

		System.out.println("[Client] : " + TITLE);
		System.out.println("serveur ip   = " + IP);
		System.out.println("serveur port = " + PORT);
		System.out.println();

		doSomething(IP, PORT, TITLE);
		}

	public static void doSomething(String ip, int port, String title)
		{
		try
			{
			SocketClient<String,String> client = new SocketClient<String,String>(ip, title, port);
			client.addStatusListener(createStatusListener());// facultatif

			if (client.start())
				{
				// exemple1
					{
					System.out.println("exemple 1 : send-reponse send-reponse : \n");

					client.send("salut");
					String response = client.waitResponse();
					System.out.println(response);

					client.send("hello");
					System.out.println(client.waitResponse());
					}

				System.out.println();

				// exemple2
					{
					System.out.println("exemple 2 : send-send reponse-reponse : \n");

					client.send("ciao");
					client.send("tchuss");

					System.out.println(client.waitResponse());
					System.out.println(client.waitResponse());
					}

				client.stop();
				}
			}
		catch (Exception e)
			{
			e.printStackTrace();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Facultatif		*|
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

	}
