
package ch.arc.cours.c_stream.b_stream_indice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 * Attention aux deux types ci-dessous:
 *
 * 		Stream<Integer>
 * 		IntStream
 *
 * Avantage :
 *
 * 		IntStream	plus riche que 	Stream<Integer>
 *
 * Conseil :
 *
 * 		Utiliser IntStream dès que possible!
 *
 */
public class UseStream_02_range
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
		System.out.println("Stream indice : range");

		useRange();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * Quoi: 		boucle by stream
	 *
	 * Comment :	IntStream : range
	 */
	private static void useRange()
		{
		int n = 3;

		// Rappel
			{
			// code de base
				{
				for(int i = 0; i < n; i++)
					{
					System.out.println(i);
					}
				}

			// default methode foreach de List
				{
				// lambda dans variable (Rappel)
					{
					List<Integer> listSource = List.of(1, 2, 3);

					Consumer<Integer> print = System.out::println;//TODO
					listSource.forEach(print);
					}

				// reference methode, mono ligne
					{
					List<Integer> listSource = Arrays.asList(1, 2, 3);

					listSource.forEach(System.out::print);
					}
				}
			}

		// new Range
			{
			// range : lambda dans variable, sans wrapper
				{
				IntConsumer print = i -> System.out.println(i);//TODO
				IntStream.range(0, n).forEach(print);
				// [0,n[
				}

			// range :  reference methode, sans wrapper
				{
				IntStream.range(0, n).forEach(System.out::println);
				// [0,n[
				}
			}

		}

	}
