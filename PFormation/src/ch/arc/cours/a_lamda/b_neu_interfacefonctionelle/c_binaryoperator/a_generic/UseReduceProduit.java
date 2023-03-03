
package ch.arc.cours.a_lamda.b_neu_interfacefonctionelle.c_binaryoperator.a_generic;

import java.util.Arrays;
import java.util.function.BinaryOperator;

import org.junit.Assert;

import ch.arc.cours.z_annexe.material.NumberTools;

public class UseReduceProduit
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
		System.out.println("reduce : BinaryOperator<Integer> : product");
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
		int produit3 = version3(tab);

		// check
			{
			System.out.println(Arrays.toString(tab));
			System.out.println("product = " + produit1);
			System.out.println("product = " + produit2);
			System.out.println("product = " + produit3);

			int produitTrue = 24;
			Assert.assertTrue(produit1 == produitTrue);
			Assert.assertTrue(produit2 == produitTrue);
			Assert.assertTrue(produit3 == produitTrue);
			}
		}

	/*------------------------------*\
	|*		BinaryOperator<T>		*|
	\*------------------------------*/

	/**
	 * lamda dans variable
	 */
	private static int version1(int[] tab)
		{
		BinaryOperator<Integer> binaryOperator = (t, u) -> t * u;
		return NumberManipulator.reduce(tab, binaryOperator, 1);
		}

	/**
	 * reference methode dans variable
	 * (reference methode static avec parametre)
	 */
	private static int version2(int[] tab)
		{
		BinaryOperator<Integer> binaryOperator = Math::multiplyExact;
		// Indication : Solution dans Integer, ou Math
		return NumberManipulator.reduce(tab, binaryOperator, 1);
		}

	/**
	 * reference sans variable
	 */
	private static int version3(int[] tab)
		{
		return NumberManipulator.reduce(tab, Math::multiplyExact, 1);
		}

	}
