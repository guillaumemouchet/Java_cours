
package ch.hearc.e_socket.bin.c_example.b_calculatrice.server;

import java.util.function.Supplier;

import ch.hearc.b_poo.j_thread.Threads;
import ch.hearc.e_socket.bin.a_tools.Ports;
import ch.hearc.e_socket.bin.a_tools.status.listener.StatusAdapter;
import ch.hearc.e_socket.bin.a_tools.status.listener.StatusListener;
import ch.hearc.e_socket.bin.a_tools.status.listener.error.ErrorEvent;
import ch.hearc.e_socket.bin.a_tools.status.listener.success.SuccessEvent;
import ch.hearc.e_socket.bin.b_api.server.SocketServer;
import ch.hearc.e_socket.bin.b_api.server.communication.Transformer_I;
import ch.hearc.e_socket.bin.c_example.b_calculatrice.Inputs;

public class UseCalculatriceServer
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
		try
			{
			final String TITLE = "Calculatrice";
			final int PORT = Integer.parseInt(System.getProperty("port", "" + Ports.DEFAULT_PORT));
			final long LIFE_TIME_SERVER_MS = 10 * 1000 * 6 * 2;// disons 2 minutes

			SocketServer<Inputs, Double> server = new SocketServer<Inputs, Double>(createSupplier(), TITLE, PORT);
			server.addStatusListener(createStatusListener());// facultatif
			server.start(); // async

			Threads.sleep(LIFE_TIME_SERVER_MS);

			server.stop(); // en pratique on ne l'arrete jamais
			}
		catch (Exception e)
			{
			e.printStackTrace();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static Supplier<Transformer_I<Inputs, Double>> createSupplier()
		{
		return new Supplier<Transformer_I<Inputs, Double>>()
			{

			@Override
			public Transformer_I<Inputs, Double> get()
				{
				return createTransformer(); // methode ci-dessous
				}
			};
		}

	private static Transformer_I<Inputs, Double> createTransformer()
		{
		return new Transformer_I<Inputs, Double>()
			{

			@Override
			public Double transform(Inputs inputs)
				{
				return inputs.getA() + inputs.getB();
				}
			};
		}

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

	}
