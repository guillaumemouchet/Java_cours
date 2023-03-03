
package ch.arc.cours.f_complement.g_reduce_special.a_argmax;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import org.junit.jupiter.api.Assertions;

import ch.arc.cours.z_annexe.material.Voiture;
import ch.arc.cours.z_annexe.material.VoitureTools;

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
public class UseArgMax_00_rappel
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
		System.out.println("max / argmax problem : rappel : ");

		// rappel
			{
			max();
			argmax();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			Rappel				*|
	\*------------------------------*/

	/**
	 * max : prix de la voiture la plus cher
	 */
	private static void max()
		{
		int n = 3;
		List<Voiture> list = VoitureTools.create(n);
		System.out.println("\n" + list + "\n");

		// Warning: la stream forunit des voitures, l'output est un int, il y a une transformation
		OptionalInt prixMax = list.stream().mapToInt(Voiture::getPrix).max();

		// check
			{
			System.out.println("prixMax        : " + prixMax);
			Assertions.assertTrue(prixMax.isPresent());
			Assertions.assertTrue(prixMax.getAsInt() == 1002);
			}
		}

	/**
	 * argmax : voiture la plus cher
	 */
	private static void argmax()
		{
		int n = 100;
		List<Voiture> list = VoitureTools.create(n);

		Comparator<Voiture> prix = (v1, v2) -> Integer.compare(v1.getPrix(), v2.getPrix());

		// Warning: la stream forunit des voitures, l'output est une voiture, il n'y a pas de transformation
		Optional<Voiture> voitureMostExpensive = list.stream().max(prix);

		// check
			{
			System.out.println("\nvoitureMostExpensive (by max): " + voitureMostExpensive);
			Assertions.assertTrue(voitureMostExpensive.isPresent());
			Assertions.assertTrue(voitureMostExpensive.get() == list.get(list.size() - 1));
			}
		}

	}
