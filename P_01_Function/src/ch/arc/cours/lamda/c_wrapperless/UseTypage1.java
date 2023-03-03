
package ch.arc.cours.lamda.c_wrapperless;

import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;

public class UseTypage1
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
		System.out.println("typage 1 : sans wrapper");

		avecWrapper();
		System.out.println();
		sansWrapper();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Avec wrapper		*|
	\*------------------------------*/

	private static void avecWrapper()
		{
		System.out.println("\nAvec wrapper");

		BiFunction<Integer, Integer, Integer> f = (x1, x2) -> x1 + x2; // 3 wrapper lents

		work(f);
		}

	private static void work(BiFunction<Integer, Integer, Integer> f)
		{
		final int N = 3;
		final int M = 2;

		for(int i = 0; i < N; i++)
			{
			for(int j = 0; j < M; j++)
				{
				Integer y = f.apply(i, j);
				System.out.print(y + "\t");
				}
			System.out.println();
			}
		}

	/*------------------------------*\
	|*			  sans wrapper		*|
	\*------------------------------*/

	/**
	 * idem ci-dessus, mais sans wrapper et avec interface fonctionelle
	 */
	private static void sansWrapper()
		{
		System.out.println("avec wrapper");

		IntBinaryOperator f = (x,y) -> x + y;

		work2(f);
		}


	private static void work2(IntBinaryOperator f)
		{
		final int N = 3;
		final int M = 2;

		for(int i = 0; i < N; i++)
			{
			for(int j = 0; j < M; j++)
				{
				Integer y = f.applyAsInt(i, j);
				System.out.print(y + "\t");
				}
			System.out.println();
			}
		}
	}
