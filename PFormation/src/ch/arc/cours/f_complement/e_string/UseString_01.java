
package ch.arc.cours.f_complement.e_string;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;

public class UseString_01
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
		System.out.println("String : \n");

		// Conactenation
			{
			concatenation1();
			concatenation2();
			}

		// flatmap
			{
			useArrayString();
			useListString();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*		Concatenation			*|
	\*------------------------------*/

	/**
	 * Input   : un tableau de noms
	 * Outputs : une unique String contenant tout les noms, separer de DELIMITER
	 */
	private static void concatenation1()
		{
		String[] tab = { "Alice", "Bob", "Claire", "Julien" };
		final String DELIMITER = " ";

		// v1.1 : naif (plusieurs noms ---> 1 seul nom, c'est de la reduction)
			{
			String result = Arrays//
					.stream(tab)//
					.reduce("", (s1, s2) -> s1 + DELIMITER + s2);

			System.out.println(result);
			}

		// v1.2 : idem v1.1 sans valeur d'init
			{
			Optional<String> result = Arrays//
					.stream(tab)//
					.reduce((s1, s2) -> s1 + DELIMITER + s2);

			result.ifPresent(System.out::println);
			}

		// V2.1 : idem v1 mais avec StringBuilder
			{
			String result = Arrays//
					.stream(tab)//
					.map(StringBuilder::new)//
					.reduce(new StringBuilder(), (s1, s2) -> s1.append(DELIMITER).append(s2))//
					.toString(); // mapping : String ---> StringBuilder

			System.out.println(result);
			}

		// V2.2 : idem v2.1 mais supprimer l'espace au debut
			{
			StringBuilder result = Arrays//
					.stream(tab)//
					.skip(1)//
					.map(StringBuilder::new)//
					.reduce(new StringBuilder(tab[0]), (s1, s2) -> s1.append(DELIMITER).append(s2)); // mapping : String ---> StringBuilder

			System.out.println(result);
			}

		// V3 : Autre approche : forEach + StringBuilder extern remplace reduce
			{
			StringBuilder sb = new StringBuilder();

			Arrays//
					.stream(tab)//
					.forEach(s -> sb.append(s).append(DELIMITER));

			System.out.println(sb);
			}

		// V4 : Autre approche : .colect(Collectors.joigning(SEPARATOR));
			{
			String result = Arrays//
					.stream(tab)//
					.collect(Collectors.joining(DELIMITER));

			System.out.println(result);
			}
		}

	/**
	 * Input   : un tableau de noms : { "Alice", "Bob", "Claire", "Julien" }
	 * Outputs : une unique String  : "<Alice,Bob,Claire,Julien">"
	 *
	 * Indication : .collect(Collectors.joining(DELIMITER, PREFIXE,SUFFIXE)
	 */
	private static void concatenation2()
		{
		String[] tab = { "Alice", "Bob", "Claire", "Julien" };
		final String DELIMITER = ",";
		final String PREFIXE = "<";
		final String SUFFIXE = ">";

		String result = Arrays//
				.stream(tab)//
				.collect(Collectors.joining(DELIMITER, PREFIXE, SUFFIXE));

		System.out.println(result);
		}

	/*------------------------------*\
	|*		flatmap					*|
	\*------------------------------*/

	private static void useArrayString()
		{
		System.out.println("\nuseArrayString:\n");

		String[] phrase1 = { "Il", "fait" };
		String[] phrase2 = { "beau", "today" };
		String[] phrase3 = { "et", "chaud" };

		String[][] tabPhrase = { phrase1, phrase2, phrase3 };

		// Ex1 : Afficher sous cette forme tabPhrase
		//
		//			Il
		//			fait
		//			beau
		//			today
		//			et
		//			chaud
		//
			{
			// reference methode sans variable
				{
				Arrays//
						.stream(tabPhrase)//
						.flatMap(Arrays::stream)//
						.forEach(System.out::println);
				}
			}

		// Ex2: Afficher sous cette forme tabPhrase
		//
		//			Il fait beau today et chaud
		//
			{
			final String ESPACE = " ";

			String result = Arrays//
					.stream(tabPhrase)//
					.flatMap(Arrays::stream)//
					.collect(Collectors.joining(ESPACE));

			System.out.println(result);
			}
		}

	/**
	 * compter le nombre de mot contenant a ou de A
	 */
	private static void useListString()
		{
		System.out.println("\nuseListString:\n");

		List<String> phrase1 = List.of("Il", "fait");
		List<String> phrase2 = List.of("beau", "today");
		List<String> phrase3 = List.of("et", "CHAUD");

		// compter le nombre de mot contenant a ou de A
			{
			Stream<List<String>> streamPhrase = Stream.of(phrase1, phrase2, phrase3);

			// Contrainte :
			//		(C1) mapping beau ----> BEAU
			long count = streamPhrase//
					.flatMap(List::stream)//
					.map(String::toUpperCase)//
					.filter(m -> m.contains("A"))//
					.count();

			System.out.println("count=" + count);
			Assertions.assertTrue(count == 4);
			}

		// tableaux des mots contenant a ou A
			{
			Stream<List<String>> streamPhrase = Stream.of(phrase1, phrase2, phrase3);

			// Contraintes :
			//		(C1) les mots de doivent pas etre modifier!
			String[] tab = streamPhrase//
					.flatMap(List::stream)//
					.filter(m -> m.toUpperCase().contains("A"))//
					.toArray(String[]::new);

			System.out.println("world contain a or A = " + Arrays.toString(tab));
			}
		}

	}
