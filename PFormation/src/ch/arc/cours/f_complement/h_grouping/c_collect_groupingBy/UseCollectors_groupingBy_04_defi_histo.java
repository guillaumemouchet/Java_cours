
package ch.arc.cours.f_complement.h_grouping.c_collect_groupingBy;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.IntToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ch.arc.cours.z_annexe.material.HistoTools;
import ch.arc.tools.Chrono;

public class UseCollectors_groupingBy_04_defi_histo
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
		System.out.println("collectors : groupingBy : defi 2 : histo : \n");
		System.out.println("Please wait ...\n");

		// warmup
			{
			//histoStreamParalel1_AtomicLong();
			}

		// new
			{
			histoStreamParalel_Grouping();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*		sans GrounpingBy		*|
	\*------------------------------*/

	/**
	 * stream parallel AtomicLong (sans groupingBy)
	 */
	private static void histoStreamParalel1_AtomicLong()
		{
		System.out.println("\nHisto : stream parallel : AtomicLong\n");

		Chrono chrono = new Chrono();

		// Input
		int[] tabData = HistoTools.createDataInput(LIMITE); // data in [0,LIMIT[

		// Init (create et 0)
		AtomicLong[] histo = null;//TODO

		// fill histo ci-dessus
		// TODO

		System.out.println(chrono);

		// check
			{
			//System.out.println("Histo" + Arrays.toString(histo));
			HistoTools.check(histo);
			}
		}

	/*------------------------------*\
	|*			  GrounpingBy		*|
	\*------------------------------*/

	/**
	 * stream parallel sans AtomicLong
	 */
	private static void histoStreamParalel_Grouping()
		{
		System.out.println("\nHisto : stream parallel : groupingBy\n");

		Chrono chrono = new Chrono();

		// Input
		int[] tabData = HistoTools.createDataInput(LIMITE);// data in [0,LIMIT[

		// Indications:
		//		(I1) Function.identity(), utile ?
		Map<Integer, Long> mapHisto = Arrays//
				.stream(tabData)//
				.boxed()//
				.collect(Collectors.groupingBy(i -> i, Collectors.counting()));

		System.out.println(chrono);

		// Piege :
		//			Observation : 0 n'apparait pas dans la map.
		//
		//			Warning		: pourrait arriver aussi a d'autres valeurs
		//
		//			Consequence : le code ci-dessus n'est pas totalement finaliser, et en plus un histogramme est un tableau , pas une map

		// Finalisation : map to tab et injections valeur manquantes
			{
			// Version naive (fausse)
				{
				//				long[] histo = mapHisto//
				//						.values()//
				//						.mapToLong(Long::longValue)//
				//						.toArray();

				// System.out.println("Histo" + Arrays.toString(histo)); // 0 n'apparait toujours pas
				}

			// version juste (juste avec 0)
				{
				IntToLongFunction iToFrequence = i -> mapHisto.containsKey(i) ? mapHisto.get(i) : 0;// voir mapToLong ci-dessous

				long[] histo = IntStream//
						.range(0, 256)//
						//.parallel()// Overkill
						.mapToLong(iToFrequence)// lit dans la map la key(i), si elle existe, sinon 0
						.toArray();

				// check
					{
					//System.out.println("Histo" + Arrays.toString(histo));
					HistoTools.check(histo);
					}
				}
			}
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final int LIMITE = 1024 * 10 * 4;

	}
