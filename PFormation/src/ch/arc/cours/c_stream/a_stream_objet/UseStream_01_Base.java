
package ch.arc.cours.c_stream.a_stream_objet;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Assert;

import ch.arc.cours.z_annexe.material.Personne;
import ch.arc.cours.z_annexe.material.PersonneTools;

public class UseStream_01_Base
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
		int n = 5;

		System.out.println("stream : interface fonctionel :  classique");

		usePredicate(n);
		useConsumer(n);
		usePredicateConsumer(n);

		useBinaryOperator();

		usePredicateBinaryOperator();
		useFunctionBinaryOperator(n);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * Probleme :	nombre de personne dont l'age est > 50
	 */
	private static void usePredicate(int n)
		{
		List<Personne> list = PersonneTools.create(n);

		System.out.println("Avant : " + list);

		Predicate<Personne> ageBigger50 = personne -> personne.getAge() > 50;// TODO

		long count = list.stream().filter(ageBigger50).count();// TODO
		// count : terminal, interdit employer stream apres

		System.out.println("age > 50 : " + count);
		}

	/**
	 * Probleme :	incrementer de 1 l'age des personnes
	 */
	private static void useConsumer(int n)
		{
		List<Personne> list = PersonneTools.create(n);

		// reference methode si possible
			{
			Consumer<Personne> incAge = Personne::incAge; // TODO

			list.stream().forEach(incAge);
			//list.forEach(incAge); light mais cantonné au foreach
			// forEach : terminal, interdit employer stream apres, sur place
			}

		System.out.println("Apres : " + list);
		}

	/**
	 * Probleme :	incrementer de 1 l'age des personnes > 50
	 */
	private static void usePredicateConsumer(int n)
		{
		List<Personne> list = PersonneTools.create(n);

		// reference methode si possible
			{
			Predicate<Personne> ageBigger50 = p -> p.getAge() > 50;
			Consumer<Personne> incAge = Personne::incAge;

			list.stream().filter(ageBigger50).forEach(incAge);

			// filter : non terminal stream-in, stream-out
			// forEach : terminal , sur place, interdit employer stream apres, sur place
			}

		System.out.println("Apres : " + list);
		}

	/**
	 * Probleme :	somme des elements de la liste
	 */
	private static void useBinaryOperator()
		{
		List<Integer> list = List.of(1, 2, 3);

		// reference methode si possible
			{
			Integer sum = list.stream().reduce(0, Integer::sum);
			// reduce : terminal, interdit employer stream apres

			Assert.assertTrue(sum == 1 + 2 + 3);
			}
		}

	/**
	 * Probleme :	somme des elements paires de la liste
	 */
	private static void usePredicateBinaryOperator()
		{
		Integer[] tab = { 1, 2, 3, 4 };

		Predicate<Integer> isPaire = i -> i % 2 == 0;

		// reference methode si possible
			{
			Integer sum = Arrays//
					.stream(tab)//
					.filter(isPaire)//
					.reduce(0, Integer::sum);
			// filter : non terminal stream-in, stream-out
			// reduce : terminal, interdit employer stream apres

			Assert.assertTrue(sum == 2 + 4);
			}
		}

	/**
	 * Probleme :	somme des ages
	 */
	private static void useFunctionBinaryOperator(int n)
		{
		List<Personne> list = PersonneTools.create(n);

		// reference methode si possible
			{
			// map
				{
				Integer sum = list//
						.stream()//
						.map(Personne::getAge)//
						.reduce(0, Integer::sum);

				//Exercice de typage et détection de wrappers
				Function<Personne, Integer> age = Personne::getAge;

				Stream<Integer> stream = list//
						.stream()//
						.map(age);

				System.out.println("somme des ages = " + sum);
				}

			// Mieux : mapToInt
				{
				// mapToInt renvoie une IntStream qui travaille sans wrapper

				// Avantages:
				//		(A1) : plus performant car pas de wrapper
				//		(A2) : Instream est une stream specialiser pour les int, il y a des methodes specifiques aux int: fort pratique!
				//
				// Warning:
				//		(W1) : Instream ne derive pas de Stream<Integer>, ie ceci est faux: public class IntStream extends Stream<Integer> : Faux!
				//             car ca emploierait toujours des wrappers!

				Integer sum = list//
						.stream()//
						.mapToInt(Personne::getAge)//
						.reduce(0, Integer::sum);

				ToIntFunction<Personne> age = Personne::getAge;
				IntStream stream = list//
						.stream()//
						.mapToInt(age);

				}

			}

		// mapToInt sera traiter plus en profondeur dans un prochain chapitre
		}

	}
