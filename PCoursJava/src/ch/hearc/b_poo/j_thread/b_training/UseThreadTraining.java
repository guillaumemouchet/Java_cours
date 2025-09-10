
package ch.hearc.b_poo.j_thread.b_training;

import ch.hearc.b_poo.c_runnable.quadratique.Quadratique;

public class UseThreadTraining
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
		useQuadratique();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void useQuadratique()
		{
		Quadratique quadratique1 = new Quadratique(1,-1,2);
		Quadratique quadratique2 = new Quadratique(1,-1,2);

		Thread thread1 = new Thread(quadratique1); // Quadratique impl�mente Runnable !
		Thread thread2 = new Thread(quadratique2);

		thread1.start(); // Asynchrone : la méthode run() de Quadratique est exécutée par le thread1
		thread2.start(); // Asynchrone

		try
			{
			thread1.join(); // Le thread courrant attend la fin du thread1
			thread2.join(); // Le thread courrant attend la fin du thread2
			// Qui est le thread courrant? Le thread qui exécute la ligne de code
			// Ici le thread courrant est le thread main

			System.out.println(quadratique1); // join() nécessaire car sinon on afficherait les solutions avant qu'elles ne soient calculées
			System.out.println(quadratique2);
			}
		catch (InterruptedException e)
			{
			e.printStackTrace();
			}
		}
	}

