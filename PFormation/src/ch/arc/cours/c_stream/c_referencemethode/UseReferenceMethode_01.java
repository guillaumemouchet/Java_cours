
package ch.arc.cours.c_stream.c_referencemethode;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

import org.junit.Assert;

import ch.arc.cours.z_annexe.material.Maison;
import ch.arc.cours.z_annexe.tools.Int;

public class UseReferenceMethode_01
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
		System.out.println("reference methode static/non static constructeur ...");

		// static
			{
			methodeStaticMath();
			methodeStaticInteger();
			}

		// non static
			{
			methodeNonStaticMaison();
			}

		// constructeur
			{
			constructeurInteger();
			}

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Static			*|
	\*------------------------------*/

	private static void methodeStaticMath()
		{
		// classe interne anonyme
			{
			Function<Double, Double> f = new Function<Double, Double>()
				{

				@Override
				public Double apply(Double t)
					{
					return Math.abs(t);
					}
				};

			Assert.assertTrue(f.apply(-1d) == 1);
			}

		// reference methode
			{
			Function<Double, Double> f = Math::abs;

			Assert.assertTrue(f.apply(-1d) == 1);
			}
		}

	/**
	 * sum des nombres paires
	 */
	private static void methodeStaticInteger()
		{
		Integer[] tab = { 1, 2, 3, 4, 5, 6, 7, 8 };

		// lambda
			{
			Integer sumPaire = Arrays//
					.stream(tab)//
					.filter(i -> i % 2 == 0)//
					.reduce(0, (x, y) -> x + y);

			Assert.assertTrue(sumPaire == 2 + 4 + 6 + 8);
			}

		// reference methode:
			{
			// Indication: use classe Int
			Integer sumPaire = Arrays//
					.stream(tab)//
					.filter(i -> i % 2 == 0)//
					.reduce(0, Int::sum);

			Assert.assertTrue(sumPaire == 2 + 4 + 6 + 8);
			}
		}

	/*------------------------------*\
	|*			non	Static			*|
	\*------------------------------*/

	/**
	 * sum des prix des maisons
	 */
	private static void methodeNonStaticMaison()
		{
		Maison[] tab = { new Maison(1, 10, 100), new Maison(2, 20, 200) }; // Maison (prix, piece ,surface)

		// lambda
			{
			int prixTotal = Arrays//
					.stream(tab)//
					.mapToInt(m -> m.getPrix())//
					.sum();

			Assert.assertTrue(prixTotal == 3);
			}

		// reference methode
			{
			int prixTotal = Arrays//
					.stream(tab)//
					.mapToInt(Maison::getPrix)//
					.sum();

			Assert.assertTrue(prixTotal == 3);
			}
		}

	/*------------------------------*\
	|*				Constructeur	*|
	\*------------------------------*/

	/**
	 * <pre>
	 *
	 * Construire une liste d'entier depuis un tableau de string
	 *
	 * 			String[] 	to 		List<Integer>
	 *
	 * Rappel
	 * 			String		to 		Integer
	 * 			s                    new Integer(s)
	 *
	 * </pre>
	 */
	private static void constructeurInteger()
		{
		String[] tabString = { "1", "2", "3", "4" };

		// lambda
			{
			try
				{
				Function<String, Integer> toInteger = s -> Integer.parseInt(s);

				List<Integer> list = Arrays//
						.stream(tabString)//
						.map(toInteger)//
						.collect(Collectors.toList());

				System.out.println(list);
				}
			catch (Exception e)
				{
				System.out.println("impossible");
				}
			}

		// reference methode pour constructeur
			{
			try
				{
				List<Integer> list = Arrays//
						.stream(tabString)//
						.map(Integer::parseInt)//
						.collect(Collectors.toList());

				System.out.println(list);
				}
			catch (Exception e)
				{
				System.out.println("impossible");
				}
			}
		}

	/**
	 * <pre>
	 *
	 * Construire une tableau d'entier  depuis un tableau de string
	 *
	 * 			String[] 	to 		Integer[]
	 *
	 * Rappel
	 *
	 * 			String		to 		Integer
	 * 			s                   new Integer(s)
	 *
	 * Rappel:
	 *
	 * 			C++:
	 *
	 * 				A* tab=new a[n]			n+1 objets instancie: le tableau et n objet A
	 * 										A doit posséder un constrcuteur sans parametre (sinon compile pas)
	 * 										Chaque case contient deja un A.
	 *
	 * 				A** tab=new A*[n]		1 objet instancier: le tableau.
	 * 										Les cases du tableau contiennent des pointeurs null.
	 *
	 * 			Java:
	 *
	 * 				A[] tab=new A[n]		1 objet instancier: le tableau.
	 * 										Les cases du tableau contiennent des références null.
	 *
	 * </pre>
	 */
	private static void constructeurArrayInteger()
		{
		String[] tabString = { "1", "2", "3", "4" };

		// lambda, avec variable
			{
			try
				{
				// Indication generator :
				//		(I1) generator input  : n la taille du tableau
				//		(I2) generator output : un tableau de n joueur
				//
				IntFunction<Integer[]> generatorStringArray = n -> new Integer[n];
				Function<String, Integer> stringToInteger = s -> Integer.parseInt(s);

				Integer[] tabInteger = Arrays//
						.stream(tabString)//
						.map(stringToInteger)//
						.toArray(generatorStringArray);

				System.out.println(Arrays.toString(tabInteger));
				}
			catch (Exception e)
				{
				System.out.println("impossible");
				}
			}

		// reference methode, avec variable
			{
			try
				{
				IntFunction<Integer[]> generatorStringArray = Integer[]::new;
				Function<String, Integer> stringToInteger = Integer::parseInt;

				Integer[] tabInteger = Arrays//
						.stream(tabString)//
						.map(stringToInteger)//
						.toArray(generatorStringArray);

				System.out.println(Arrays.toString(tabInteger));
				}
			catch (Exception e)
				{
				System.out.println("impossible");
				}
			}

		// reference methode, sans variable
			{
			try
				{
				Integer[] tabInteger = Arrays//
						.stream(tabString)//
						.map(Integer::parseInt)//
						.toArray(Integer[]::new);

				System.out.println(Arrays.toString(tabInteger));
				}
			catch (Exception e)
				{
				System.out.println("impossible");
				}
			}

		// reference methode, sans variable
		// Output : int[] et non Integer[]
			{
			try
				{
				// v1: un seule "map"
					{
					int[] tabInteger = Arrays//
							.stream(tabString)//
							.mapToInt(Integer::parseInt)//
							.toArray();

					System.out.println(Arrays.toString(tabInteger));
					}

				// v2: plusieurs map (c'est possible!)
					{
					int[] tabInteger = Arrays//
							.stream(tabString)//
							.map(Integer::parseInt)//
							.mapToInt(Integer::valueOf)//
							.toArray();

					System.out.println(Arrays.toString(tabInteger));
					}
				}
			catch (Exception e)
				{
				System.out.println("impossible");
				}
			}
		}
	}
