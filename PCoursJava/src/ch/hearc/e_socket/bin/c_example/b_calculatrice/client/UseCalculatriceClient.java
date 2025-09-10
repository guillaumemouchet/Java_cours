
package ch.hearc.e_socket.bin.c_example.b_calculatrice.client;

import ch.hearc.e_socket.bin.a_tools.Ports;
import ch.hearc.e_socket.bin.a_tools.status.listener.StatusAdapter;
import ch.hearc.e_socket.bin.a_tools.status.listener.StatusListener;
import ch.hearc.e_socket.bin.a_tools.status.listener.error.ErrorEvent;
import ch.hearc.e_socket.bin.b_api.client.SocketClient;
import ch.hearc.e_socket.bin.c_example.b_calculatrice.Inputs;


public class UseCalculatriceClient
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
		final String TITLE = "Calculatrice";

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
			SocketClient<Inputs,Double> client = new SocketClient<Inputs,Double>(ip, title, port);
			client.addStatusListener(createStatusListener());// facultatif

			if (client.start())
				{
				// exemple1
					{
					System.out.println("exemple 1 : send-reponse send-reponse : \n");

					client.send(new Inputs(2 * Math.PI, -Math.PI));
					double result = client.waitResponse();
					System.out.println(result);

					client.send(new Inputs(1, 10));
					System.out.println(client.waitResponse());
					}

				System.out.println();

				// exemple2
					{
					System.out.println("exemple 2 : send-send reponse-reponse : \n");

					client.send(new Inputs(2, 20));
					client.send(new Inputs(3, 30));

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
