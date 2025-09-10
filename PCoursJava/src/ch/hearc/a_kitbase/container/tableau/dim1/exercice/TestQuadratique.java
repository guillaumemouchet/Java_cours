
package ch.hearc.a_kitbase.container.tableau.dim1.exercice;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestQuadratique
	{

	 /*------------------------------------------------------------------*\
	 |*							Methodes Public							*|
	 \*-----------------------------------------------------------------*/

	/**
	 * xx+x+1
	 */
	@Test
	public void test0Solution()
		{
		double a = 1;
		double b = 1;
		double c = 1;

		double[] tabX = Quadratique.solve(a, b, c); // aucune solution
		Assertions.assertEquals(0, tabX.length);
		}

	/**
	 * 3(x-1)(x-1)=0 ssi x=1
	 */
	@Test
	public void test1Solutions()
		{
		double a = 3;
		double b = -6;
		double c = 3;

		double[] tabX = Quadratique.solve(a, b, c);

		Assertions.assertEquals(1, tabX.length);
		Assertions.assertEquals(0, Quadratique.f(a, b, c, tabX[0]));
		Assertions.assertEquals(1, tabX[0]);
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

		double[] tabXEmpirique = Quadratique.solve(a, b, c);// 1 et 2
		double[] tabXTheorique = { 2, 1 };

		Assertions.assertEquals(2, tabXEmpirique.length);
		Assertions.assertEquals(2, tabXTheorique.length);
		Assertions.assertEquals(0, Quadratique.f(a, b, c, tabXEmpirique[0]));
		Assertions.assertEquals(0, Quadratique.f(a, b, c, tabXEmpirique[1]));
		Assertions.assertEquals(0, Quadratique.f(a, b, c, tabXTheorique[0]));
		Assertions.assertEquals(0, Quadratique.f(a, b, c, tabXTheorique[1]));

		Arrays.sort(tabXEmpirique);
		Arrays.sort(tabXTheorique);

		//v1
			{
			for(int i = 0; i < tabXTheorique.length; i++)
				{
				Assertions.assertEquals(tabXTheorique[i], tabXEmpirique[i]);
				}
			}

		//V2
			{
			//toujours aller chercher dans la classe Arrays si problème tableau
			Assertions.assertTrue(Arrays.equals(tabXTheorique, tabXEmpirique));
			}

		//V3
			{
			Assertions.assertArrayEquals(tabXTheorique, tabXEmpirique);// /!\ prendre celui avec array
			}

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
