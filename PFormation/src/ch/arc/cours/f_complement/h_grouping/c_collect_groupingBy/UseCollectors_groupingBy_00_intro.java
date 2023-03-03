
package ch.arc.cours.f_complement.h_grouping.c_collect_groupingBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import ch.arc.cours.z_annexe.material.Personne;
import ch.arc.cours.z_annexe.material.PersonneTools;

public class UseCollectors_groupingBy_00_intro
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
		System.out.println("groupingBy : clustering : hello");

		useHello();
		useTreeSet();
		useCounting();

		// clustering binaire
			{
			useMappingReducing();
			usePartitioningBy();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*	groupingBy 					*|
	\*------------------------------*/

	/**
	 * <pre>
	 * Exemple:
	 *
	 * 		Input	:	{ "Bob", "Alice", "Bernard", "Ariane", "Claire", "Alfred", "Alice" };
	 *
	 * 		Output	:	Une map, ie une collection (key,value)
	 *
	 * 						A=[Alice, Ariane, Alfred, Alice]
	 * 						B=[Bob, Bernard]
	 * 						C=[Claire]
	 *
	 * 					On regroupe les noms commencant par la meme lettre!
	 * Technique :
	 *
	 * 		Collectors.groupingBy(functionClassifier, valueCollector)
	 *
	 * 			ou
	 * 				- functionClassifier :
	 * 							- Input : les objets qui arrivent dans methode collect (ici les noms)
	 * 							- Output: Chaque output de la function cree une classe
	 *
	 * 				- valueCollector
	 * 							- Specifier comment collecter les elements  d'une meme classe
	 * 							  Exemples:
	 * 									- les mettre dans une List
	 * 									- les mettre dans un  Set
	 * 									- les compter
	 * 									- les reduire
	 * 									- ...
	 * </pre>
	 */
	private static void useHello()
		{
		String[] tab = { "Bob", "Alice", "Bernard", "Ariane", "Claire", "Alfred", "Alice" };

		// avec variable
			{
			// functionClassifier:
			// Transformation    : nom -> sa premiere lettre
			Function<String, Character> functionClassifier = name -> name.charAt(0);

			// valueCollector:
			//					String			List<String>
			//					nom1 nom2 ... -> list de nom
			Collector<String, ?, List<String>> valueCollector = Collectors.toList();

			// Indication:
			//		(I1) Collectors.groupingBy(functionClassifier,valueCollector)
			Map<Character, List<String>> mapLettreName = Arrays//
					.stream(tab)//
					.collect(Collectors.groupingBy(functionClassifier, valueCollector));

			System.out.println(mapLettreName);
			}

		// sans variable, mais dans un TreeMap
			{
			// Indication:
			//		(I1) Collectors.groupingBy(functionClassifier,supplier,valueCollector)

			TreeMap<Character, List<String>> mapLettreName = Arrays//
					.stream(tab)//
					.collect(Collectors.groupingBy(name -> name.charAt(0), TreeMap::new, Collectors.toList()));

			System.out.println(mapLettreName);
			}
		}

	/**
	 * <pre>
	 * Exercice:
	 *
	 * 		Comme ci-dessus, mais regroupement dans un TreeSet
	 *
	 * Exemple:
	 *
	 * 		Input	:	{ "Bob", "Alice", "Bernard", "Ariane", "Claire", "Alfred", "Alice" };
	 *
	 * 		Output	:
	 * 						A=[Alice, Ariane, Alfred]
	 * 						B=[Bob, Bernard]
	 * 						C=[Claire]
	 * </pre>
	 */
	private static void useTreeSet()
		{
		String[] tab = { "Bob", "Alice", "Bernard", "Ariane", "Claire", "Alfred", "Alice" };

		// sans variable
			{
			Map<Character, Set<String>> mapLettreName = Arrays//
					.stream(tab)//
					.collect(Collectors.groupingBy(name -> name.charAt(0), Collectors.toSet()));

			System.out.println(mapLettreName);
			}

		// avec variable
			{
			Function<String, Character> functionClassifier = name -> name.charAt(0);
			Collector<String, ?, TreeSet<String>> valueCollector = Collectors.toCollection(TreeSet::new);
			Collector<String, ?, Map<Character, TreeSet<String>>> groupingBy = Collectors.groupingBy(functionClassifier, valueCollector);

			Map<Character, TreeSet<String>> mapLettreName = Arrays//
					.stream(tab)//
					.collect(groupingBy);

			System.out.println(mapLettreName);
			}
		}

	/**
	 * <pre>
	 * Exercice:
	 *
	 * 		Comme ci-dessus, mais on compte les elements regrouper
	 *
	 * Exemple:
	 *
	 * 		Input	:	{ "Bob", "Alice", "Bernard", "Ariane", "Claire", "Alfred", "Alice" };
	 * 		Output	:
	 * 					A=4
	 * 					B=3
	 * 					C=1
	 *
	 * 		On regroupe les noms commencant par la meme lettre!
	 * 		et on les comptes!
	 * </pre>
	 */
	private static void useCounting()
		{
		String[] tab = { "Bob", "Alice", "Bernard", "Ariane", "Claire", "Alfred", "Alice" };

		// sans variable
			{
			Map<Character, Long> mapLettreCount = Arrays//
					.stream(tab)//
					.collect(Collectors.groupingBy(name -> name.charAt(0), Collectors.counting()));

			System.out.println(mapLettreCount);
			}
		}

	/*------------------------------*\
	|*	clustering	 binaire		*|
	\*------------------------------*/

	/**
	 * <pre>
	 * Exercice:
	 *
	 * 		regrouper des personnes par sex, et obtenir la somme des ages des deux groupes
	 *
	 * Exemple:
	 *
	 * 		Input	:	Une liste de Personne(sex, age)
	 * 		Output	:	Une map de type {false=538, true=96}
	 *
	 * 		On regroupe les Personnes de meme sex
	 * 		Dans chacun des deux groupes on sum les ages
	 *
	 * </pre>
	 */
	private static void useMappingReducing()
		{
		int n = 10;
		List<Personne> listPersonne = PersonneTools.create(n);

		// sans variable
			{
			Map<Boolean, Integer> map = listPersonne//
					.stream()//
					.collect(Collectors.groupingBy(Personne::isMasculin, Collectors.summingInt(Personne::getAge)));

			System.out.println(map);
			}
		}

	/*------------------------------*\
	|*	partitioningBy 				*|
	\*------------------------------*/

	/**
	 * <pre>
	 * Dans le cas d'un clustering binaire, on peut avantageusement remplacer le functionClassifier par un predicate
	 *
	 * General:
	 *
	 * 		Collectors.groupingBy(functionClassifier, valueCollector)
	 *
	 * Binaire:
	 *
	 * 		Collectors.partitioningBy(Predicate<T>, valueCollector)
	 * </pre>
	 */
	private static void usePartitioningBy()
		{
		int n = 10;
		List<Personne> listPersonne = PersonneTools.create(n);

		// Deux classes: homme et femme, on aimerait connaitre le nombre d'homme et le nombre de femme
			{
			Map<Boolean, Integer> map = listPersonne//
					.stream()//
					.collect(Collectors.partitioningBy(Personne::isMasculin, Collectors.summingInt(Personne::getAge)));
			System.out.println(map);
			}
		}

	}
