
package ch.arc.cours.e_consolidation;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntFunction;

import org.junit.Assert;

import ch.arc.tools.Chrono;

public class UseDefi
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
		System.out.println("defi");

		defi();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * Probleme : Combien de thread utilisé dans un stream parallel?
	 *
	 * Srategie :
	 *
	 * 			Step 1 : recuperer le nom des threads
	 * 			Step 2 : les collecter dans un Set
	 */
	private static void defi()
		{
		int n = Integer.MAX_VALUE;

		// parallel
			{
			Chrono chrono = new Chrono();

			IntFunction<String> nameThread = null; // TODO lamda (reference methode impossible)

			// Instream d'indice parrallel
			// pour chaque indice on recupere le nom du thread qui gere cet indice
			HashSet<String> setThreadName = null;// TODO s

			chrono.stop();

			print(setThreadName, "parallel", chrono);
			}

		// sequentiel (pour voir difference de performance)
			{
			Chrono chrono = new Chrono();

			IntFunction<String> nameThread = null;// TODO lamda (reference methode impossible)

			HashSet<String> setThreadName = null;// TODO

			chrono.stop();

			print(setThreadName, "sequential", chrono);

			// check
				{
				Assert.assertTrue(setThreadName.size() == 1);
				}
			}
		}

	/*------------------------------*\
	|*			  Tools				*|
	\*------------------------------*/

	private static void print(Set<String> setThreadName, String title, Chrono chrono)
		{
		System.out.println("\nNameThread : \n");

		Consumer<String> print = null;// TODO Reference methode
		setThreadName.forEach(print); // forEach defaut methode des Set (pas de sream ici)

		System.out.println();
		System.out.println("#Thread    = " + setThreadName.size());
		System.out.println("#processor = " + Runtime.getRuntime().availableProcessors());
		System.out.println(title + " " + chrono);
		}

	}
