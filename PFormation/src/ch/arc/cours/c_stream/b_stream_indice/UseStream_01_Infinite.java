
package ch.arc.cours.c_stream.b_stream_indice;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Assert;

public class UseStream_01_Infinite
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
		System.out.println("Stream indice : infinite : UnaryOperator");

		useIterate1();
		useIterate2();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * Apprentissage:
	 *
	 * 		stream infinite pour remplacer boucle
	 *
	 * Activite:
	 *
	 * 		stream pour afficher les 10 premiers nombres paires
	 */
	private static void useIterate1()
		{
		int n = 10;

		// code de base
			{
			for(int i = 0; i < n; i = i + 2)
				{
				System.out.println(i);// affiche mombre paire
				}
			}

		// stream : lamda dans variable
			{
			UnaryOperator<Integer> inc2 = i -> i + 2; // TODO incrementer de 2
			Consumer<Integer> print = System.out::println; // TODO

			Stream // Stream<Integer>
					.iterate(0, inc2) // stream infinite
					.limit(n / 2) // warning n/2
					.forEach(print);
			}

		// stream : lamda,  sans aucune variable
			{
			Stream // Stream<Integer>
					.iterate(0, i -> i + 2) // stream infinite
					.limit(n / 2) // warning n/2
					.forEach(System.out::println);
			}

		// stream : reference methode si possible, une seule ligne
		// sans wrapper : IntStream.iterate(...)
			{
			IntStream // 10x plus rapide
					.iterate(0, i -> i + 2) // stream infinite
					.limit(n / 2) // warning n/2
					.forEach(System.out::println);
			}
		}

	/**
	 * 	somme des n premiers nombre entier
	 */
	private static void useIterate2()
		{
		int n = 4;

		// code de base
			{
			long sum = 0;
			for(int i = 0; i < n; i++)
				{
				sum += i;
				}

			Assert.assertTrue(sum == n * (n - 1) / 2);
			}

		// stream infinite : reference methode si possible, une seule ligne, sans wrapper
			{
			long sum = IntStream//
					//.iterate(0, i -> i++)  FAUX
					//.iterate(0, i -> ++i)
					.iterate(0, i -> i + 1)//
					.limit(n)//
					.parallel()//
					.sum();// TODO

			Assert.assertTrue(sum == n * (n - 1) / 2);
			}
		}

	}
