
package ch.arc.cours.c_stream.c_referencemethode;

import java.util.Arrays;
import java.util.Comparator;

public class UseReferenceMethode_04_training
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
		System.out.println("reference methode : training 2");

		sortSansStream();
		sortAvecStream();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * tri d'un tableau de string
	 */
	private static void sortSansStream()
		{
		// sans stream
			{
			// classe interne anonyme
				{
				String[] tab = { "maison", "banane", "Meteo", "repas" };

				System.out.println("avant : " + Arrays.asList(tab));

				Comparator<String> comparator = new Comparator<String>()
					{

					@Override
					public int compare(String s1, String s2)
						{
						return s1.compareTo(s2);
						}
					};

				Arrays.sort(tab, comparator); // sur place

				System.out.println("après : " + Arrays.toString(tab));
				}

			// sans stream, tri parallel,lambda
				{
				String[] tab = { "maison", "banane", "Meteo", "repas" };

				// , sans stream, tri parallel !
				// sur place
				Arrays.parallelSort(tab, (s1, s2) -> s1.compareTo(s2));

				System.out.println("après : " + Arrays.toString(tab));
				}

			// sans stream, tri parallel, reference methode
				{
				String[] tab = { "maison", "banane", "Meteo", "repas" };


				// sur place
				Arrays.parallelSort(tab, String::compareTo);

				System.out.println("après : " + Arrays.toString(tab));
				}
			}
		}

	/**
	 * tri d'un tableau de string
	 */
	private static void sortAvecStream()
		{
		// avec stream, tri parallel
			{
			String[] tab = { "maison", "banane", "Meteo", "repas" };

			// reference methode si possible, sans variable
				{
				String[] tabSorted = Arrays//
						.stream(tab)//
						.parallel()//
						.sorted(String::compareTo)
						.toArray(String[]::new);

				System.out.println("après : " + Arrays.toString(tabSorted));
				}
			}
		}

	}
