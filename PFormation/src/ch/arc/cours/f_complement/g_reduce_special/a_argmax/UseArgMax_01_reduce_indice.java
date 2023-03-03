
package ch.arc.cours.f_complement.g_reduce_special.a_argmax;

import java.util.List;
import java.util.OptionalInt;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;

import ch.arc.cours.z_annexe.material.Voiture;
import ch.arc.cours.z_annexe.material.VoitureTools;

public class UseArgMax_01_reduce_indice
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
		System.out.println("max / argmax problem : reduce indice");

		// avec indice (utile pour obtenir en une passe arg et argmax)
			{
			argmax_indice_voiture();
			argmax_indice_image();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*		Indice 					*|
	\*------------------------------*/

	/**
	 * <pre>
	 * Quoi : 	max et argmax (en une seule passe)
	 *
	 * Indications:

	 * 		(I1) Travailler avec une stream d'indice du debut jusqu'a la fin
	 *
	 * 		(I2) Rechercher l'indice de la position de la valeur max
	 *
	 * 		(I3) plein d'indice, 1 elu, c'est une reduction d'indice!
	 *
	 *		(I4) BinaryOperator : deux indices en compétition : on garde le "best" indice
	 *
	 *								i1 op i2 = indice du tableau contenant la voiture la plus cher
	 *
	 *		(I5) Reduce sans valeur d'init, car pas de reduction numerique de type sum+=, donc resultat Optional (necessaire si stream vide)
	 * </pre>
	 */
	private static void argmax_indice_voiture()
		{
		int n = 100;
		List<Voiture> listVoiture = VoitureTools.create(n);
		Voiture[] tabVoiture = listVoiture.parallelStream().toArray(Voiture[]::new);

		IntBinaryOperator indiceVoitureMostExpensive = (i1, i2) -> tabVoiture[i1].getPrix() > tabVoiture[i2].getPrix() ? i1 : i2;

		// Warning:  les inputs sont des indices (int) et l'output est aussi un indice (int)
		OptionalInt iWinner = IntStream.range(0, n).reduce(indiceVoitureMostExpensive);

		// Finalisation
		//		(I1) utiliser iWinner
		//		(I2) utiliser tabVoiture
		Voiture voitureMostExpensive = tabVoiture[iWinner.getAsInt()];
		int prixMax = voitureMostExpensive.getPrix();

		// check
			{
			System.out.println("\nvoitureMostExpensive (by indice reduce): " + voitureMostExpensive);
			System.out.println("\nprixMax              (by indice reduce): " + prixMax);

			Assertions.assertEquals(voitureMostExpensive, listVoiture.get(listVoiture.size() - 1));
			Assertions.assertEquals(prixMax, 1099);
			}
		}

	/*------------------------------*\
	|*		arg et argmax			*|
	\*------------------------------*/

	/**
	 * <pre>
	 * Pixel le plus clair et sa position dans une image en niveau de gris
	 *
	 * Contrainte : max et argmax (en une seule passe)
	 * </pre>
	 */
	private static void argmax_indice_image()
		{
		int[] tab = { 2, 4, 5, 1, 8, 10, 3, 7, 9 };

		IntBinaryOperator indiceValeurMax = (i1, i2) -> tab[i1] > tab[i2] ? i1 : i2;
		OptionalInt optionalIndiceMax = IntStream.range(0, tab.length).reduce(indiceValeurMax);
		int valueMax = tab[optionalIndiceMax.getAsInt()];

		// check
			{
			optionalIndiceMax.ifPresent(System.out::println);
			System.out.println("valueMax = " + valueMax);

			Assertions.assertTrue(optionalIndiceMax.isPresent());
			Assertions.assertEquals(optionalIndiceMax.getAsInt(), 5);
			Assertions.assertEquals(valueMax, 10);
			}
		}
	}
