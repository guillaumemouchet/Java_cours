
package ch.arc.cours.a_lamda.b_neu_interfacefonctionelle.c_binaryoperator.a_generic;

import java.util.Arrays;
import java.util.function.BinaryOperator;

import org.junit.Assert;

import ch.arc.cours.z_annexe.material.NumberTools;

public class UseReduceAdd
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
		System.out.println("reduce : BinaryOperator<Integer> : add");
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
		int sum4 = version4(tab);

		// check
			{
			System.out.println(Arrays.toString(tab));
			System.out.println("sum = " + sum1);
			System.out.println("sum = " + sum2);
			System.out.println("sum = " + sum3);
			System.out.println("sum = " + sum4);

			int sumTrue = n * (n + 1) / 2;

			Assert.assertTrue(sum1 == sumTrue);
			Assert.assertTrue(sum2 == sumTrue);
			Assert.assertTrue(sum3 == sumTrue);
			Assert.assertTrue(sum4 == sumTrue);
			}
		}

	/*------------------------------*\
	|*		BinaryOperator<T>		*|
	\*------------------------------*/

	/**
	 * classe interne anonyme
	 */
	private static int version1(int[] tab)
		{
		BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>()
					{

						@Override
						public Integer apply(Integer t, Integer u)
							{
								return t + u;
							}

					};
		return NumberManipulator.reduce(tab, binaryOperator, 0);
		}

	/**
	 * lamda dans variable
	 */
	private static int version2(int[] tab)
		{
		BinaryOperator<Integer> binaryOperator = (t, u) -> t + u;
		return NumberManipulator.reduce(tab, binaryOperator, 0);
		}


	/**
	 * reference methode dans varaible
	 * (reference methode static avec parametre)
	 */
	private static int version3(int[] tab)
		{
		BinaryOperator<Integer> binaryOperator = Integer::sum;
		// Indication : Solution dans Integer, ou Math
		return NumberManipulator.reduce(tab, binaryOperator, 0);
		}

	/**
	 * reference methode sans variable
	 */
	private static int version4(int[] tab)
		{
		return NumberManipulator.reduce(tab, Integer::sum, 0);
		}

	}
