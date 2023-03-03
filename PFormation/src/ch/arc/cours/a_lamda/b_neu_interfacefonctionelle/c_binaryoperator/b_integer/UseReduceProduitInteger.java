
package ch.arc.cours.a_lamda.b_neu_interfacefonctionelle.c_binaryoperator.b_integer;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

import org.junit.Assert;

import ch.arc.cours.z_annexe.material.NumberTools;

public class UseReduceProduitInteger
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
		System.out.println("reduce : IntBinaryOperator : product");

		reduceProduit();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void reduceProduit()
		{
		int n = 4;
		int[] tab = NumberTools.create(n);

		int produit1 = version1(tab);
		int produit2 = version2(tab);

		// check
			{
			System.out.println(Arrays.toString(tab));
			System.out.println("product = " + produit1);
			System.out.println("product = " + produit2);

			int produitTrue = 24;
			Assert.assertTrue(produit1 == produitTrue);
			Assert.assertTrue(produit2 == produitTrue);
			}
		}

	/*------------------------------*\
	|*	IntBinaryOperator<T>		*|
	\*------------------------------*/

	/**
	 * lamda dans variable
	 */
	private static int version1(int[] tab)
		{
		IntBinaryOperator intBinaryOperator = (t, u) -> t * u;
		return NumberManipulatorInteger.reduce(tab, intBinaryOperator, 1);
		}

	/**
	 * reference methode sans variable
	 */
	private static int version2(int[] tab)
		{
		return NumberManipulatorInteger.reduce(tab, Math::multiplyExact, 1);
		}

	}
