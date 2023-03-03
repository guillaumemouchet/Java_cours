
package ch.arc.cours.a_lamda.b_neu_interfacefonctionelle.d_function;

import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import org.junit.Assert;

import ch.arc.cours.z_annexe.material.Maison;
import ch.arc.cours.z_annexe.material.MaisonTools;

public class Use_c_FilterMapReduce
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
		System.out.println("filter map Reduce : Predicate Function binaryOperator ");

		filterMapReduce();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void filterMapReduce()
		{
		int n = 4;
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

	/*--------------------------------------------------*\
	|*	Predicate<T> Function<T1,T2>  BinaryOperator<T> *|
	\*--------------------------------------------------*/

	/**
	 * somme des prix des maisons dont nbPiece>20
	 *
	 * Classe Interne anonyme
	 */
	private static int version1(List<Maison> list)
		{
		Predicate<Maison> predicate = new Predicate<Maison>()
			{

			@Override
			public boolean test(Maison m)
				{
				return m.getNbPiece() > 20;
				}
			};

		ToIntFunction<Maison> maisonToPrix = new ToIntFunction<Maison>()
			{

			@Override
			public int applyAsInt(Maison m)
				{
				return m.getPrix();
				}
			};

		IntBinaryOperator add = new IntBinaryOperator()
			{

			@Override
			public int applyAsInt(int left, int right)
				{
				return left + right;
				}
			};

		return MaisonManipulator.filterMapReduce(list, predicate, maisonToPrix, add, 0);
		}

	/*------------------------------*\
	|*				lamda			*|
	\*------------------------------*/

	/**
	 * somme des prix des maisons dont nbPiece>20
	 *
	 * lamda dans variable
	 */
	private static int version2(List<Maison> list)
		{
		Predicate<Maison> nbPiecesBigger20 = m -> m.getNbPiece() > 20;
		ToIntFunction<Maison> maisonToPrix = m -> m.getPrix();
		IntBinaryOperator add = (t, u) -> t + u;

		return MaisonManipulator.filterMapReduce(list, nbPiecesBigger20, maisonToPrix, add, 0);
		}

	/**
	 * somme des prix des maisons dont nbPiece>20
	 *
	 * reference methode dans variable, partout ou c'est possible!
	 */
	private static int version3(List<Maison> list)
		{
		Predicate<Maison> nbPiecesBigger20 = m -> m.getNbPiece() > 20;
		ToIntFunction<Maison> maisonToPrix = Maison::getPrix;
		IntBinaryOperator add = Integer::sum;

		//return MaisonManipulator.filterMapReduce(list, nbPiecesBigger20, maisonToPrix, add, 0);
		return list//
				.stream()//
				.filter(nbPiecesBigger20)//
				.mapToInt(maisonToPrix)//
				.reduce(0, add);
		}

	/*------------------------------*\
	|*				Tools			*|
	\*------------------------------*/

	private static void check(List<Maison> list, int sum)
		{
		System.out.println("sum prix = " + sum);

		Assert.assertTrue(sum == 7);
		}

	}
