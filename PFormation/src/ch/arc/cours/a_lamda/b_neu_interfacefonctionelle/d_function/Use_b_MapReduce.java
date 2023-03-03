
package ch.arc.cours.a_lamda.b_neu_interfacefonctionelle.d_function;

import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.ToIntFunction;

import org.junit.Assert;

import ch.arc.cours.z_annexe.material.Maison;
import ch.arc.cours.z_annexe.material.MaisonTools;

public class Use_b_MapReduce
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
		System.out.println("map reduce : Function binaryOperator ");

		mapReduce();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void mapReduce()
		{
		int n = 3;
		List<Maison> list = MaisonTools.create(n);

		int sum1 = version1(list);
		int sum2 = version2(list);
		int sum3 = version3(list);

		// check
			{
			System.out.println(list);

			check(list, sum1);
			check(list, sum2);
			check(list, sum3);
			}
		}

	/*-------------------------------------*\
	|*	Function<T1,T2>  BinaryOperator<T> *|
	\*-------------------------------------*/

	/**
	 * somme des prix des maisons
	 *
	 * Classe Interne anonyme
	 */
	private static int version1(List<Maison> list)
		{
		ToIntFunction<Maison> toIntFunction = new ToIntFunction<Maison>()
			{

			@Override
			public int applyAsInt(Maison maison)
				{
				return maison.getPrix();
				}
			};
		IntBinaryOperator intBinaryOperator = new IntBinaryOperator()
			{

			@Override
			public int applyAsInt(int left, int right)
				{
				return left + right;
				}
			};
		return MaisonManipulator.mapReduce(list, toIntFunction, intBinaryOperator, 0);
		}

	/*------------------------------*\
	|*				lamda			*|
	\*------------------------------*/

	/**
	 * somme des prix des maisons
	 *
	 * lamda dans variable
	 */
	private static int version2(List<Maison> list)
		{
		ToIntFunction<Maison> maisonToPrix = m -> m.getPrix();
		IntBinaryOperator addPrix = (t, u) -> t + u;
		return MaisonManipulator.mapReduce(list, maisonToPrix, addPrix, 0);
		}

	/**
	 * somme des prix des maisons
	 *
	 * Reference methode dans variable : partout ou c'est possible!
	 */
	private static int version3(List<Maison> list)
		{
		ToIntFunction<Maison> maisonToPrix = Maison::getPrix;
		IntBinaryOperator addPrix = Integer::sum;
		return list.stream().mapToInt(maisonToPrix).reduce(0, addPrix);
		//return MaisonManipulator.mapReduce(list, maisonToPrix, addPrix, 0);
		}

	/*------------------------------*\
	|*				Tools			*|
	\*------------------------------*/

	private static void check(List<Maison> list, int sum)
		{
		System.out.println("sum prix = " + sum);

		int n = list.size();
		Assert.assertTrue(sum == n * (n + 1) / 2);
		}

	}
