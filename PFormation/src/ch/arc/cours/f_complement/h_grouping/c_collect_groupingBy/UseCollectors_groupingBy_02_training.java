
package ch.arc.cours.f_complement.h_grouping.c_collect_groupingBy;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;

public class UseCollectors_groupingBy_02_training
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
		System.out.println("collectors : groupingBy : training 2");

		// reducing (difficulty : trouver le classifier)
			{
			use_reducing_01();
			use_reducing_02();
			}

		// reducing_maping
			{
			use_reducing_mapping();
			use_grouping_summingInt();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*		Reducing				*|
	\*------------------------------*/

	/**
	 * <pre>
	 * Data:		1,2,3,4
	 *
	 * Output:
	 *				0	6		somme des nombres paires
	 *				1	4		somme des nombres impaires
	 *
	 * </pre>
	 */
	private static void use_reducing_01()
		{
		List<Integer> list = List.of(1, 2, 3, 4);

		// avec variable
			{
			// functionClassifier:
			//
			//		(I2) C'est une fonction, donc une transformation
			//
			//		(I3) La stream donne des int, dans la key da la map on veut quoi?
			//					i ----> 0 si paire
			//					i ----> 1 si impaire
			//
			Function<Integer, Integer> functionClassifier = i -> i % 2;

			// valueCollector:
			//
			//		(I1) On ne fait rarement des Collector soi meme
			//		(I2) On utilise si on peut des Collector existants
			//		(I3) On recoit des nombres regrouper selon leur pariter.
			//			 	On fait quoi avec?
			//			 	On les sommes!
			//			 	Comment?
			//			 	En les reduisant avec un Collector existant
			//
			Collector<Integer, ?, Integer> reducing = Collectors.summingInt(i -> i);

			Map<Integer, Integer> map = list.stream().collect(Collectors.groupingBy(functionClassifier, reducing));

			// check
				{
				Assertions.assertTrue(map.keySet().size() == 2);
				Assertions.assertTrue(map.get(0) == 6);
				Assertions.assertTrue(map.get(1) == 4);

				System.out.println(map);
				}
			}

		// sans variable : groupingBy
			{
			// Warning : la key est Boolean
			//
			// Output:
			//				true	6		somme des nombres paires
			//				false	4		somme des nombres impaires
			//
			Map<Boolean, Integer> map = list//
					.stream()//
					.collect(Collectors.groupingBy(i -> i % 2 == 0, Collectors.summingInt(i -> i)));

			// check
				{
				Assertions.assertTrue(map.keySet().size() == 2);
				Assertions.assertTrue(map.get(true) == 6);
				Assertions.assertTrue(map.get(false) == 4);

				System.out.println(map);
				}
			}

		// sans variable : partitioningBy
			{
			Map<Boolean, Integer> map = list//
					.stream()//
					.collect(Collectors.partitioningBy(i -> i % 2 == 0, Collectors.summingInt(i -> i)));

			// check
				{
				Assertions.assertTrue(map.keySet().size() == 2);
				Assertions.assertTrue(map.get(true) == 6);
				Assertions.assertTrue(map.get(false) == 4);

				System.out.println(map);
				}
			}
		}

	/**
	 * <pre>
	 * Data:		1,2,3,4
	 *
	 * Output:
	 *				paire	6		somme des nombres paires
	 *				impaire	4		somme des nombres impaires
	 *
	 * Observation:
	 *
	 * 				Idem ci-dessus, mais le type de la key a changer, c'est une string maintenant
	 * </pre>
	 */
	private static void use_reducing_02()
		{
		List<Integer> list = List.of(1, 2, 3, 4);

		// avec variable
			{
			// functionClassifier:
			//
			//		(I2) C'est une fonction, donc une transformation
			//
			//		(I3) La stream donne des int, dans la key da la map on veut quoi ?
			//
			//					i ----> "paire" si paire
			//					i ----> "impaire" si impaire
			//
			Function<Integer, String> intToPariter = i -> i % 2 == 0 ? "paire" : "impaire"; // operateur ternaire

			Collector<Integer, ?, Integer> reducing = Collectors.summingInt(i -> i); // valueCollector

			Map<String, Integer> map = list//
					.stream()//
					.collect(Collectors.groupingBy(intToPariter, reducing));
			// check
				{
				Assertions.assertTrue(map.keySet().size() == 2);
				Assertions.assertTrue(map.get("paire") == 6);
				Assertions.assertTrue(map.get("impaire") == 4);

				System.out.println(map);
				}
			}

		}

	/*------------------------------*\
	|*		ReducingMapping			*|
	\*------------------------------*/

	/**
	 * <pre>
	 * Data:		1,2,3,4
	 *
	 * Output:
	 *				0	20		somme des carrer des nombres paires
	 *				1	10		somme des carrer des nombres impaires
	 *
	 * </pre>
	 */
	private static void use_reducing_mapping()
		{
		List<Integer> list = List.of(1, 2, 3, 4);

		// sans variable
			{
			Map<Integer, Integer> map = list//
					.stream()//
					.collect(Collectors.groupingBy(i -> i % 2, Collectors.reducing(0, i -> i * i, Integer::sum)));

			// check
				{
				Assertions.assertTrue(map.keySet().size() == 2);
				Assertions.assertTrue(map.get(0) == 20);
				Assertions.assertTrue(map.get(1) == 10);

				System.out.println(map);
				}
			}
		}

	/*------------------------------*\
	|*				summingInt		*|
	\*------------------------------*/

	/**
	 * idem precedent mais autre technique
	 */
	private static void use_grouping_summingInt()
		{
		List<Integer> list = List.of(1, 2, 3, 4);

		// sans variable
			{
			Map<Integer, Integer> map = list//
					.stream()//
					.collect(Collectors.groupingBy(i -> i % 2, Collectors.summingInt(i -> i * i)));

			// check
				{
				Assertions.assertTrue(map.keySet().size() == 2);
				Assertions.assertTrue(map.get(0) == 20);
				Assertions.assertTrue(map.get(1) == 10);

				System.out.println(map);
				}
			}
		}

	}
