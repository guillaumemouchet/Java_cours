
package ch.arc.cours.a_lamda.b_neu_interfacefonctionelle.c_binaryoperator.b_integer;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

import org.junit.Assert;

import ch.arc.cours.z_annexe.material.NumberTools;

public class UseReduceAddInteger
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
		System.out.println("reduce : IntBinaryOperator : add");
		reduceAdd();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void reduceAdd()
		{
		int n = 3;
		int[] tab = NumberTools.create(n);

		int sum1 = version1(tab);
		int sum2 = version2(tab);
		int sum3 = version3(tab);

		// check
			{
			System.out.println(Arrays.toString(tab));
			System.out.println("sum = " + sum1);
			System.out.println("sum = " + sum2);
			System.out.println("sum = " + sum3);

			int sumTrue = n * (n + 1) / 2;

			Assert.assertTrue(sum1 == sumTrue);
			Assert.assertTrue(sum2 == sumTrue);
			Assert.assertTrue(sum3 == sumTrue);
			}
		}

	/*------------------------------*\
	|*	IntBinaryOperator<T>		*|
	\*------------------------------*/

	/**
	 * classe interne anonyme
	 */
	private static int version1(int[] tab)
		{
		IntBinaryOperator intBinaryOperator = new IntBinaryOperator()
			{

			@Override
			public int applyAsInt(int left, int right)
				{
				return left + right;
				}
			};
		return NumberManipulatorInteger.reduce(tab, intBinaryOperator, 0);
		}

	/**
	 * lamda dans variable
	 */
	private static int version2(int[] tab)
		{
		IntBinaryOperator intBinaryOperator = (t, u) -> t + u;
		return NumberManipulatorInteger.reduce(tab, intBinaryOperator, 0);
		}

	/**
	 * reference methode sans variable
	 */
	private static int version3(int[] tab)
		{
		return NumberManipulatorInteger.reduce(tab, Integer::sum, 0);
		}

	}
