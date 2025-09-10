
package ch.hearc.b_poo.j_thread.a_hello;

import ch.hearc.b_poo.j_thread.Threads;

public class UseHelloThread
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		System.out.println("Fin main\t:" + Thread.currentThread().getName());
		}

	public static void main()
		{
		//useRunnable();
		useThread();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void useRunnable()
		{
		long delai1Ms = 1000;
		long delai2Ms = 2000;

		Runnable runnable1 = createRunnable(delai1Ms);
		Runnable runnable2 = createRunnable(delai2Ms);

		runnable1.run();
		runnable2.run();
		}

	private static void useThread()
		{
		long delai1Ms = 1000;
		long delai2Ms = 2000;

		Runnable runnable1 = createRunnable(delai1Ms);
		Runnable runnable2 = createRunnable(delai2Ms);

		Thread thread1 = new Thread(runnable1);
		Thread thread2 = new Thread(runnable2);

		thread1.setName("thread1");
		thread2.setName("thread2");

		thread1.start(); // Asynchrone : ne va pas attendre la fin de start() avant de continuer
		thread2.start(); // same
		}

	private static Runnable createRunnable(long delaiMs)
		{
		return new Runnable()
			{

			@Override
			public void run()
				{
				System.out.println("Début Run\t:" + Thread.currentThread().getName());
				Threads.sleep(delaiMs);
				System.out.println("Fin Run\t\t:" + Thread.currentThread().getName());
				}
			};
		}
	}
