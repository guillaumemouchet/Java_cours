
package ch.arc.cours.d_sequential_to_parralel;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.Assert;

public class UseSequentialToParallel_01_vector
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
		System.out.println("sequentiel to parallel : Math");

		addVectoriel();
		dotProd();
		factoriel();
		norme();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * addition vectorielle parallele
	 */
	private static void addVectoriel()
		{
		// Data
		int n = 5;

		Integer[] v1 = { 1, 2, 3, 4, 5 };
		Integer[] v2 = { 10, 20, 30, 40, 50 };

		Assert.assertTrue(v1.length == n && v2.length == n);

		// sequentiel : code standad
			{
			System.out.println("\nsequentiel");

			Integer[] tabSum = new Integer[n];
			for(int i = 0; i < n; i++)
				{
				tabSum[i] = v1[i] + v2[i];
				}

			System.out.println(Arrays.toString(tabSum));
			}

		// parallel : stream : v1 (Tableau resultat externe)
			{
			System.out.println("\nparallel v1");

			Integer[] tabSum = new Integer[n];

			IntStream//
					.range(0, n)//
					.parallel()//
					.forEach(i -> tabSum[i] = v1[i] + v2[i]); // On accède a un tableau à l'extérieur en écriture
																// DANGEREUX à éviter

			System.out.println(Arrays.toString(tabSum));
			}

		// parallel : stream : v2 (Tableau resultat creer par la stream)
			{
			System.out.println("\nparallel v2");

			long[] tabSum = IntStream//
					.range(0, n)//
					.parallel()//
					.mapToLong(i -> v1[i] + v2[i])//
					.toArray(); // TODO tout sur cette ligne

			System.out.println(Arrays.toString(tabSum));
			}
		}

	/**
	 * produit scalaire parallele
	 */
	private static void dotProd()
		{
		// Data
		int n = 5;
		Integer[] v1 = { 1, 2, 3, 4, 5 };
		Integer[] v2 = { 10, 20, 30, 40, 50 };
		Assert.assertTrue(v1.length == n && v2.length == n);

		// sequentiel : code standad
			{
			System.out.println("\nsequentiel");

			long sum = 0;
			for(int i = 0; i < n; i++)
				{
				sum += v1[i] * v2[i];
				}

			System.out.println("produit scalaire = " + sum);
			}

		// parallel : stream
			{
			System.out.println("\nparallel");

			long produitScalaire = IntStream//
					.range(0, n)//
					.parallel()//
					.mapToLong(i -> v1[i] * v2[i])//
					.sum(); // TODO tout sure cette ligne

			System.out.println("produit scalaire = " + produitScalaire);
			}
		}

	/**
	 * Factorielle paralelle
	 */
	private static void factoriel()
		{
		int n = 4;

		// sequentiel : code standad
			{
			System.out.println("\nsequentiel");

			long facto = 1;
			for(int i = 1; i <= n; i++)
				{
				facto *= i;
				}

			// check
				{
				System.out.println("facto= " + facto);
				Assert.assertTrue(facto == 1 * 2 * 3 * 4);
				}
			}

		// parallel : stream
			{
			System.out.println("\nparallel");

			// Indication : on a plein de nombre, 1,2,3,4,5 et  la fin plus que un, c'est une?

			long facto = IntStream//
					.range(1, n + 1)// warning 1 et n+1
					.parallel()//
					.mapToLong(i -> i)//
					.reduce(1, Math::multiplyExact);// TODO reference methode only

			// check
				{
				System.out.println("facto= " + facto);
				Assert.assertTrue(facto == 1 * 2 * 3 * 4);
				}
			}
		}

	/**
	 * norme en parallele
	 */
	private static void norme()
		{
		// Data
		Integer[] v = { 1, 2, 3, 4, 5 };
		int n = v.length;

		// sequentiel : code standad
			{
			System.out.println("\nsequentiel");

			long sum = 0;
			for(int i = 0; i < n; i++)
				{
				sum += v[i] * v[i];
				}

			double norme = Math.sqrt(sum);
			System.out.println("norme = " + norme);
			}

		// parallel : stream
			{
			System.out.println("\nparallel");

			// Contrainte : sans indice (ie sans range et sans iterate)
			// Indication : si une stream ne vous sert pas des indices, elle vous sert directement des donnée.
			// Conseil    : Quand c'est possible, utiliser toujours une stream qui vous sert des données

			long sum = Arrays//
					.stream(v)// vi descend dans le tube
					.parallel()//
					.mapToLong(vi -> vi * vi)//
					.sum(); // TODO

			double norme = Math.sqrt(sum);
			System.out.println("norme = " + norme);
			}
		}

	}
