
package ch.hearc.a_kitbase.container.tableau.dim1.exercice;

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
		useSolution0();
		useSolution1();
		useSolution2();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * xx+x+1
	 */
	private static void useSolution0()
		{
		double a = 1;
		double b = 1;
		double c = 1;

		double[] tabX = Quadratique.solve(a, b, c); // aucune solution
		Quadratique.print(a, b, c, tabX);

		// check
			{//Indique la portée du commentaire et la portée d'une variable ne sort pas du bloc = pas de conflit
			Assertions.assertTrue(tabX.length == 0);
			}
		}

	/**
	 * 3(x-1)(x-1)=0 ssi x=1
	 */
	private static void useSolution1()
		{
		double a = 3;
		double b = -6;
		double c = 3;

		double[] tabX = Quadratique.solve(a, b, c);
		Quadratique.print(a, b, c, tabX);// 1

		// check
			{
			System.out.println(Quadratique.f(a, b, c, tabX[0]));// doit etre 0

			Assertions.assertTrue(tabX.length == 1);
			Assertions.assertTrue(Quadratique.f(a, b, c, tabX[0]) == 0);
			Assertions.assertTrue(tabX[0] == 1);
			}
		}

	/**
	 * 2(x-1)(x-2)=0 ssi x=1 ou x=2
	 */
	private static void useSolution2()
		{
		double a = 2;
		double b = -6;
		double c = 4;

		double[] tabX = Quadratique.solve(a, b, c);// 1 et 2
		Quadratique.print(a, b, c, tabX);

		// check
			{
			System.out.println(Quadratique.f(a, b, c, tabX[0]));// doit etre 0
			System.out.println(Quadratique.f(a, b, c, tabX[1]));// doit etre 0

			Assertions.assertTrue(tabX.length == 2);
			Assertions.assertTrue(Quadratique.f(a, b, c, tabX[0]) == 0);
			Assertions.assertTrue(Quadratique.f(a, b, c, tabX[1]) == 0);
			Assertions.assertTrue((tabX[0] == 1 && tabX[1] == 2) || (tabX[0] == 2 && tabX[1] == 1));
			}
		}

	}
