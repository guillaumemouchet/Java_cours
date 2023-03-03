
package ch.arc.cours.f_complement.b_argmax;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import org.junit.jupiter.api.Assertions;

import ch.arc.cours.z_annexe.material.Voiture;
import ch.arc.cours.z_annexe.material.VoitureTools;
import ch.arc.cours.z_annexe.tools.Int;

/**
 * <pre>
 *
 * Soit f: x -> y
 *
 * Observation 1:
 *
 * 		max(f) se trouve sur l'axe des y
 *
 * Definition 1:
 *
 * 		argmax(f) n'est pas le max de f, mais le x qui realise le max de f.
 *
 * Observation 2:
 *
 * 		argmax(f) se trouve sur l'axe des x
 *
 * Clin d'oeil:
 *
 * 		f(argmax(f))=max(f)
 *
 * </pre>
 */
public class UseArgMax
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
		System.out.println("max / argmax problem : ");

		// max
			{
			max1();
			max2();
			}

		// argmax
			{
			argmax();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			Max 				*|
	\*------------------------------*/

	private static void max1()
		{
		Int[] tab = { new Int(1), new Int(2), new Int(3) };
		System.out.println("\n" + Arrays.toString(tab));

		// Ex1
			{
			Comparator<Int> comparator = Int::compare;// reference methode
			//Le max/min d'aucun élément est indéfini (Optional)
			Optional<Int> max = Arrays//
					.stream(tab)//
					.max(comparator);//
			Optional<Int> min = Arrays//
					.stream(tab)//
					.min(comparator);

			// check
				{
				System.out.println(max);
				System.out.println(min);
				Assertions.assertTrue(max.isPresent());
				Assertions.assertTrue(min.isPresent());
				Assertions.assertTrue(max.get().intvalue() == 3);
				Assertions.assertTrue(min.get().intvalue() == 1);
				}
			}

		// Ex2 : le min par le max
		//		 Contraintes :
		//			(C1) utiliser max
		//			(C2) utiliser comparator
		//	 	 Indication :
		//			(I1) utiliser default methode
			{
			Comparator<Int> comparator = Int::compare; // celui-la et pas un autre
			Optional<Int> min = Arrays//
					.stream(tab)//
					.max(comparator.reversed()); // max( f(x) ) == min( -f(x) )

			// check
				{
				System.out.println(min);
				Assertions.assertTrue(min.isPresent());
				Assertions.assertTrue(min.get().intvalue() == 1);
				}
			}

		}

	/**
	 * max : prix de la voiture la plus cher
	 */
	private static void max2()
		{
		int n = 3;
		List<Voiture> list = VoitureTools.create(n);
		System.out.println("\n" + list + "\n");

		OptionalInt prixMax = list//
				.stream()//
				.mapToInt(Voiture::getPrix)//
				.max();// on recoit des prix, on prend le max des prix

		// check
			{
			System.out.println("prixMax : " + prixMax);
			Assertions.assertTrue(prixMax.isPresent());
			Assertions.assertTrue(prixMax.getAsInt() == 1002);
			}
		}

	/*------------------------------*\
	|*		argmax 					*|
	\*------------------------------*/

	/**
	 * argmax : voiture la plus cher
	 */
	private static void argmax()
		{
		int n = 100;
		List<Voiture> list = VoitureTools.create(n);

		Comparator<Voiture> prix = (v1, v2) -> Integer.compare(v1.getPrix(), v2.getPrix());

		// Indication :
		//		(I1) utiliser max sur la stream, comme pour le max
		//		(I2) passer a max, un Comparator<Voiture>, des lors max devient un argmax
		Optional<Voiture> voitureMostExpensive = list//
				.stream()//
				.max(prix);//  On recoit des voiturses, on garde la plus cher! Une stream avec des voitures du debut jusqu'a la fin

		// check
			{
			System.out.println("\nvoitureMostExpensive (by max): " + voitureMostExpensive);
			Assertions.assertTrue(voitureMostExpensive.isPresent());
			Assertions.assertTrue(voitureMostExpensive.get() == list.get(list.size() - 1));
			}
		}

	}
