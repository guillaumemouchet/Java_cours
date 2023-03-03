
package ch.arc.cours.a_lamda.a_origine_interfacefonctionelle.runnable;

public class UseRunnable
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
		// Version standard
			{
			version1();
			version2();
			version3();
			}

		// Version lamda
			{
			version4();
			version5();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * Classe separer
	 */
	private static void version1()
		{
		Runnable runnable = new RunnableSeparer();

		Thread thread = new Thread(runnable);
		thread.start();
		}

	/**
	 * classe interne anonyme
	 * dans variable
	 */
	private static void version2()
		{
		Runnable runnable = new Runnable()
			{

			@Override
			public void run()
				{
				System.out.println("Hello2");
				}
			};

		new Thread(runnable).start();
		}

	/**
	 * classe interne anonyme
	 * sans variable
	 */
	private static void version3()
		{
		new Thread(new Runnable()
			{

			@Override
			public void run()
				{
				System.out.println("Hello4");
				}
			}).start();
		}

	/*------------------------------*\
	|*		Version lamda			*|
	\*------------------------------*/

	/**
	 * Expression lamda dans variable, (syntaxe aussi light que possible)
	 */
	private static void version4()
		{
		Runnable runnable = () -> System.out.println("V4");
		new Thread(runnable).start();
		}

	/**
	 * Expression lamda sans variable, (syntaxe aussi light que possible)
	 */
	private static void version5()
		{
		new Thread(() -> System.out.println("V5")).start();
		}

	}
