
package ch.hearc.b_poo.c_runnable.quadratique;

import org.junit.jupiter.api.Assertions;

public class UseQuadratique
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
		solution0();
		solution1();
		solution2();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * xx+x+1
	 */
	private static void solution0()
		{
		double a = 1;
		double b = 1;
		double c = 1;

		Quadratique quadratique = new Quadratique(a, b, c);
		quadratique.run();
		System.out.println(quadratique);

		Assertions.assertEquals(0, quadratique.getTabX().length);
		Assertions.assertEquals(0, quadratique.nbSolution());
		}

	/**
	 * 3(x-1)(x-1)=0 ssi x=1
	 */
	private static void solution1()
		{
		double a = 3;
		double b = -6;
		double c = 3;

		Quadratique quadratique = new Quadratique(a, b, c);
		quadratique.run();
		System.out.println(quadratique);

		Assertions.assertEquals(1, quadratique.getTabX().length);
		Assertions.assertEquals(1, quadratique.nbSolution());
		}

	/**
	 * 2(x-1)(x-2)=0 ssi x=1 ou x=2
	 */
	private static void solution2()
		{
		double a = 2;
		double b = -6;
		double c = 4;

		Quadratique quadratique = new Quadratique(a, b, c);
		quadratique.run();
		System.out.println(quadratique);

		Assertions.assertEquals(2, quadratique.getTabX().length);
		Assertions.assertEquals(2, quadratique.nbSolution());
		}

	}
