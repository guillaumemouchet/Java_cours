
package ch.arc.cours.f_complement.h_grouping.a_collect_toMap;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <pre>
 * Voir aussi plus tard:
 *
 * 		.collect(Collectors.groupingBy(classifier, valueCollector));
 *
 * Bien plus puissant!
 * Prochainement sur vos ecrans!
 * </pre>
 */
public class UseCollectMap
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
		System.out.println("collect : toMap : simple");

		// toMap
			{
			useCollectToMap_1();
			useCollectToMap_2();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * <pre>
	 * toMap
	 * 		key   : name
	 * 		value : nombre de caractere
	 * </pre>
	 */
	private static void useCollectToMap_1()
		{
		String[] tab = { "Bob", "Alice", "Bernard", "Ariane", "Claire", "Alfred", "Alice" };

		// lambda
			{
			// Indication:	 keyMapper
			// 		(I1) le nom finit dans la key,
			Function<String, String> keyMapper = i -> i;

			// Indication:	valueMapper
			//		(I1) le nombre de caracteres du nom
			Function<String, Integer> valueMapper = String::length;

			// Indications:
			//		(I1)  Collectors.toMap
			//		(I2)  distinct before collect (un seule des deux Alices passera) : filtre!
			Map<String, Integer> map = Arrays//
					.stream(tab)//
					.distinct()//
					.collect(Collectors.toMap(keyMapper, valueMapper));

			System.out.println(map);
			}

		// reference methode :
			{
			Map<String, Integer> map = Arrays//
					.stream(tab)//
					.distinct()//
					.collect(Collectors.toMap(p -> p, String::length));

			System.out.println(map);
			}
		}

	/**
	 * <pre>
	 * toMap
	 * 		key   : name
	 * 		value : nombre de caractere different!
	 * </pre>
	 */
	private static void useCollectToMap_2()
		{
		String[] tab = { "bob", "alice", "bernard", "ariane", "claire", "alfred", "alice" };// tout en minuscule

		// lambda
			{
			Function<String, String> keyMapper = p -> p;

			// Indications:
			//
			//		(I1) fabriquer une stream de char
			//
			//				name.chars() 		renvoie une stream
			//
			//		(I2) employer la technique du distinct

			Function<String, Integer> valueMapper = nom -> (int)nom.chars().distinct().count();

			Map<String, Integer> map = Arrays//
					.stream(tab)//
					.distinct()//
					.collect(Collectors.toMap(keyMapper, valueMapper));

			System.out.println(map);
			}
		}

	}
