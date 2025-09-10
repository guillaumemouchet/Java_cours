
package ch.hearc.b_poo.c_runnable.quadratique;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestQuadratique
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * xx+x+1
	 */
	@Test
	public void test0Solution()
		{
		double a = 1;
		double b = 1;
		double c = 1;

		double[] tabXExpected = new double[0];

		test(a, b, c, tabXExpected);
		}

	/**
	 * 3(x-1)(x-1)=0 ssi x=1
	 */
	@Test
	public void test1Solution()
		{
		double a = 3;
		double b = -6;
		double c = 3;

		double[] tabXExpected = { 1 }; // syntaxe light

		test(a, b, c, tabXExpected);
		}

	/**
	 * 2(x-1)(x-2)=0 ssi x=1 ou x=2
	 */
	@Test
	public void test2Solutions()
		{
		double a = 2;
		double b = -6;
		double c = 4;

		double[] tabXExpected = { 1, 2 }; // syntaxe light

		test(a, b, c, tabXExpected);
		}

	/**
	 * 2(x-1)(x-2)=0 ssi x=1 ou x=2
	 */
	@Test
	public void test2SolutionInverser()
		{
		double a = 2;
		double b = -6;
		double c = 4;

		double[] tabXExpected = { 2, 1 }; // inverse de la solution ci-dessus

		test(a, b, c, tabXExpected);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void test(double a, double b, double c, double[] tabXExpected)
		{
		Quadratique quadratique = new Quadratique(a, b, c);
		quadratique.run();

		double[] tabXEmpirical = quadratique.getTabX();

		// Goal : chek number solution
			{
			Assertions.assertEquals(tabXExpected.length, tabXEmpirical.length);
			Assertions.assertEquals(tabXExpected.length, quadratique.nbSolution());
			}

		// Goal : comparaison des 2 tableaux
		// Tip  : Pour s'affranchir de l'ordre lors de la comparaison ci-dessous, on trie d'abord!
			{
			Arrays.sort(tabXEmpirical);
			Arrays.sort(tabXExpected);

			// v1
				{
				Assertions.assertArrayEquals(tabXExpected, tabXEmpirical); // warning array
				}

			// v2
				{
				Assertions.assertTrue(Arrays.equals(tabXExpected, tabXEmpirical));
				}
			}

		// goal : check zero
			{
			checkZero(quadratique, tabXExpected);
			checkZero(quadratique, tabXEmpirical);
			}
		}

	private static void checkZero(Quadratique quadratique, double[] tabX)
		{
		for(int i = 0; i < tabX.length; i++)
			{
			Assertions.assertEquals(0, quadratique.f(tabX[i]));
			}
		}

	}
