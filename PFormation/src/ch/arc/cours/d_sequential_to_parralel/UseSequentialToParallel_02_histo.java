
package ch.arc.cours.d_sequential_to_parralel;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

import ch.arc.cours.z_annexe.material.HistoTools;

public class UseSequentialToParallel_02_histo
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
		System.out.println("sequentiel to parallel : histo");

		// Standard
			{
			histoStandard();
			}

		// stream
			{
			histoStreamSequentiel();
			histoStreamParallel();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * standard
	 */
	private static void histoStandard()
		{
		System.out.println("\nfor : \n");

		// Data
		int limite = 256; // data in [0,LIMIT[
		int[] tabData = HistoTools.createDataInput(limite);

		// code standard, sequentiel
			{
			int[] histo = new int[limite];

			// init
				{
				for(int s = 0; s < histo.length; s++)
					{
					histo[s] = 0;
					}
				}

			// fill
				{
				for(int s = 0; s < tabData.length; s++)
					{
					histo[tabData[s]]++;
					}
				}

			// check
				{
				//System.out.println("tabData" + Arrays.toString(tabData));
				System.out.println("Histo" + Arrays.toString(histo));
				HistoTools.check(histo);
				}
			}
		}

	/**
	 * stream
	 */
	private static void histoStreamSequentiel()
		{
		System.out.println("\nstream sequential v1: \n");

		// Data
		int limite = 256; // data in [0,LIMIT[
		int[] tabData = HistoTools.createDataInput(limite);

		// v1 : init histo :
		//		histo existe deja, il faut juste le remplir avec des 0
			{
			int[] histo = new int[limite];

			IntStream//
					.range(0, limite)//
					.forEach(s -> histo[s] = 0);
			}

		// v2 : init histo :
		//		mieux : la stream doit fabriquer histo, et mettre des zeros dedans

		// TODO
		int[] histo = IntStream//
				.range(0, limite)//
				.map(i -> 0)// Astuce de l'exercice
				.toArray();

		// fill histo : sequentiel !

		// TODO
		Arrays//
				.stream(tabData)//
				.forEach(pixel -> histo[pixel]++);

		// check
			{
			System.out.println("Histo" + Arrays.toString(histo));
			HistoTools.check(histo);
			}
		}

	/**
	 * Tout en parallel!
	 */
	private static void histoStreamParallel()
		{
		System.out.println("\nstream parallel: \n");

		int limite = 256; // data in [0,LIMIT[
		int[] tabData = HistoTools.createDataInput(limite);

		// Indicatation: Utiliser AtomicLong au lieu de long

		// Init
		AtomicLong[] histoAtomic = IntStream//
				.range(0, limite)//
				.parallel()//
				.mapToObj(i -> new AtomicLong(0))//
				.toArray(AtomicLong[]::new); // TODO La stream init et cree le tableau

		// Fill
		Arrays//
				.stream(tabData)//
				.parallel()//
				.forEach(pixel -> histoAtomic[pixel].incrementAndGet());

		// Convertion (pas cher, que 256 cases)
		long[] histo = Arrays//
				.stream(histoAtomic)//
				//.parallel()// trop peu de valeurs l'initialisation des threads dépasse le bénéfice du parallélisme
				.mapToLong(AtomicLong::longValue)//
				.toArray(); // TODO en parallel

		// check
			{
			System.out.println("Histo" + Arrays.toString(histoAtomic));
			System.out.println("Histo" + Arrays.toString(histo));
			HistoTools.check(histo);
			}
		}

	}
