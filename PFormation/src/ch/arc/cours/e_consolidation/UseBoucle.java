
package ch.arc.cours.e_consolidation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import ch.arc.cours.z_annexe.material.Worker;

public class UseBoucle
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
		System.out.println("boucle sans for");

		useBoucle();
		useCreateTab();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * remplacement de la boucle for
	 */
	private static void useBoucle()
		{
		int n = 10;

		// sequentiel : code standad
			{
			System.out.println("sequentiel");

			for(int i = 0; i < n; i++)
				{
				Worker.work(i);
				}
			}

		// sequentiel : sans stream
			{
			System.out.println("\nsequentiel : sans stream ");

			List<Integer> listIndice = List.of(0, 2, 3, 4, 5, 6, 7, 8, 9);

			listIndice.forEach(Worker::work);
			}

		// sequentiel : sans stream
			{
			System.out.println("\nsequentiel : sans stream ");

			Integer[] tabIndice = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };// Integer et pas int

			// array as list puis idem ci-dessus
			Arrays.asList(tabIndice).forEach(Worker::work);
			}

		// sequentiel : avec stream
			{
			System.out.println("\nsequentiel : stream indice");

			int[] tabIndice = { 0, 2, 3, 4, 5, 6, 7, 8, 9, 9 };
			// La stream sert les indices ci-dessus!

			Arrays//
					.stream(tabIndice)//
					.forEach(Worker::work);
			}

		// parallel : IntStream infinite
			{
			System.out.println("\nparallel : stream infinite");

			IntStream//
					.iterate(0, i -> i + 1)//
					.limit(n)//
					.forEach(Worker::work);
			}

		// parallel : IntStream range [0,n[
			{
			System.out.println("\nparallel : IntStream");

			IntStream//
					.range(0, n)//
					.forEach(Worker::work);
			}
		}

	/**
	 * creer et initialier un tableau
	 */
	private static void useCreateTab()
		{
		int n = 3;

		// sequentiel : code standad
			{
			double[] tab = new double[n];

			for(int i = 0; i < n; i++)
				{
				tab[i] = i * Math.PI;
				}

			System.out.println(Arrays.toString(tab));
			}

		// parallel : IntStream range
			{
			double[] tab = IntStream//
					.range(0, n)//
					.parallel()//
					.mapToDouble(i -> i * Math.PI)//
					.toArray(); //TODO creer et remplire le tableau

			System.out.println(Arrays.toString(tab));
			}
		}

	}
