
package ch.arc.cours.f_complement.h_grouping.b_collector;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;

import ch.arc.cours.z_annexe.material.Maison;
import ch.arc.cours.z_annexe.material.MaisonTools;

/**
 * <pre>
 * Observations:
 *
 * 		(O1)	collect a besoin d'un Collector en input
 *
 * 					collect(collector)
 *
 * 		(O2)	La classe Collectors fabrique des Collector, que des Collector,et il y en a beaucoup
 *
 * 					Collectors.yyy()	renvoie une Collector
 *
 * 				"Avec collect, tout est collector"
 *
 * 		(O3)	On cree rarement un collector from scratch, en emploie plutot les nombreux
 * 				collector fournit par la classe Colletors
 *
 * 		(O3)	Collector n'est pas une interface fonctionelle!
 *
 * Buts:
 *
 * 		(B1) 	Consolidation de collect
 *
 * 		(B2) 	Quelques trucs nouveaux, ie quelques collector nouveau!
 *
 * 		(B3)	Se prepaper aux futurs gros chapitre : groupBy
 *
 * et aussi:
 *
 * 		Voir debriefing en fin de fichier
 * </pre>
 */
public class UseCollectors
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
		System.out.println("Use Collectors");

		// Collection
			{
			useToSet();
			}

		// reduction
			{
			useReducing_hello();
			useReducing_mapping();

			useSummingInt_1();// reduction avec mapping
			useSummingInt_2();// reduction avec mapping
			}

		// et aussi
			{
			useMaxBy();
			useCount();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Collections		*|
	\*------------------------------*/

	private static void useToSet()
		{
		List<Integer> list = List.of(1, 2, 3, 4, 1);

		// collect : sans variable
			{
			Set<Integer> set = list.stream().collect(Collectors.toSet());
			Assertions.assertTrue(set.size() == 4);
			}

		// collect : avec variable
			{
			// Collector:
			//		Input	: Integer
			//		Output	: Set<Integer>
			Collector<Integer, ?, Set<Integer>> toSet = Collectors.toSet();

			Set<Integer> set = list.stream().collect(toSet); // collect emploie un collector

			Assertions.assertTrue(set.size() == 4);
			}
		}

	/*------------------------------*\
	|*		reduce/mapping			*|
	\*------------------------------*/

	/**
	 * Collectors.reducing(init,binaryOperator)
	 */
	private static void useReducing_hello()
		{
		List<Integer> list = List.of(1, 2, 3, 4);

		// collect : sans variable
			{
			Integer sum = list.stream().collect(Collectors.reducing(0, Integer::sum));

			Assertions.assertTrue(1 + 2 + 3 + 4 == sum);
			}
		}

	/**
	 * Collectors.reducing(init,mapper,binaryOperator)
	 */
	private static void useReducing_mapping()
		{
		int n = 5;
		List<Maison> list = MaisonTools.create(n);

		// collect : sans variable
			{
			Integer sum = list//
					.stream()//
					.collect(Collectors.reducing(0, Maison::getPrix, Integer::sum));

			Assertions.assertTrue(1 + 2 + 3 + 4 + 5 == sum);
			}
		}

	/**
	 * 	Collectors.summingInt(mapper)
	 */
	private static void useSummingInt_1()
		{
		List<Integer> list = List.of(1, 2, 3, 4);

		// collect : sans variable
			{
			int sum = list.stream().collect(Collectors.summingInt(Integer::intValue)); //plus simple, i->i

			Assertions.assertTrue(sum == 1 + 2 + 3 + 4);
			}

		// collect : avec variable
			{
			ToIntFunction<Integer> mapper = Integer::intValue;
			Collector<Integer, ?, Integer> summingInt = Collectors.summingInt(mapper);

			int sum = list.stream().collect(summingInt);//collect emploie un collector

			Assertions.assertTrue(sum == 1 + 2 + 3 + 4);
			}
		}

	/**
	 * idem ci-dessus, autre data
	 */
	private static void useSummingInt_2()
		{
		int n = 5;
		List<Maison> list = MaisonTools.create(n);

		// Collectors.summingInt(mapper)
			{
			int sum = list//
					.stream()//
					.collect(Collectors.summingInt(Maison::getPrix));

			Assertions.assertTrue(sum == 1 + 2 + 3 + 4 + 5);
			}
		}

	/*------------------------------*\
	|*			  et aussi			*|
	\*------------------------------*/

	/**
	 * Collectors.counting()
	 */
	private static void useCount()
		{
		List<Integer> list = List.of(1, 2, 3, 4);

		// collect : sans variable
			{
			long count = list.stream().collect(Collectors.counting());

			Assertions.assertTrue(count == 4);
			}
		}

	/**
	 * argmax, la maison la plus cher
	 *
	 * Collectors.maxBy(comparator)
	 */
	private static void useMaxBy()
		{
		int n = 5;
		List<Maison> list = MaisonTools.create(n);

		Comparator<Maison> prix = (m1, m2) -> Integer.compare(m1.getPrix(), m2.getPrix());

		// standard
			{
			Optional<Maison> maisonPlusCher = list//
					.stream()//
					.max(prix);
			maisonPlusCher.ifPresent(System.out::println);
			}

		// collect : sans variable
			{
			Optional<Maison> maisonPlusCher = list//
					.stream()//
					.collect(Collectors.maxBy(prix));

			maisonPlusCher.ifPresent(System.out::println);
			}
		}

	}
