
package ch.arc.cours.f_complement.g_reduce_special.a_argmax;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;

import ch.arc.cours.z_annexe.material.Voiture;
import ch.arc.cours.z_annexe.material.VoitureTools;

/**
 * stream de voiture du debut jusqua la fin
 */
public class UseArgMax_02_reduce_maxBy
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
		System.out.println("max / argmax problem : reduce voiture (stream de voiture du debut jusqua la fin)");

		// argmax (avec reduce)
			{
			argmax_by_reduce_voiture_manuel();
			argmax_by_reduce_voiture_maxBy();
			argmax_by_reduce_voiture_collect_maxBy();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			Autre approche		*|
	\*------------------------------*/

	/**
	 * <pre>
	 * Rappel:
	 *
	 * 		On veut pas le prix max,mais la voiture dont le prix est max!
	 * 		ie on cherche non pas le max, mais l'argmax
	 *
	 * Technique:
	 *
	 * 		(T1) 	Stream de voiture du debut jusqu'a la fin
	 *
	 * 		(T2) 	Reduction:
	 *
	 *					(R1) voiture en competion, on garde la voiture la plus cher
	 *
	 *							v1 op v2 = v3 ou v3 est la voiture la plus cher entre v1 ez v2
	 *
	 *					(R2) sans valeur d'init, car ici reduction non "numerique",
	 *						 donc pas besoin d'une valeur de depart, car pas de mecanisme du type
	 *
	 *							sum+=...  qui requiererait sum=0 au debut
	 *
	 * </pre>
	 */
	private static void argmax_by_reduce_voiture_manuel()
		{
		int n = 100;
		List<Voiture> list = VoitureTools.create(n);

		// Indications :
		//				(I1) reduction standard:
		//
		//						- avec un binaryOperator  qui donne la voiture la plus chere:
		//
		//								v1 op v2 = v3 ou v3 est la voiture la plus cher entre v1 et v2
		//
		//						- sans valeur d'init,car reduce pas numerique

		BinaryOperator<Voiture> opMostExpensive = new BinaryOperator<Voiture>()
			{

			@Override
			public Voiture apply(Voiture v1, Voiture v2)
				{
				// Rappel: compare
				//
				// 		compare(a,b) == -1 ssi a<b
				// 		compare(a,b) == 0 ssi a==b
				// 		compare(a,b) == 1 ssi a>b

				// But     : return voiture la plus cher
				// Note    : Code non agreable a produire!
				// Syntaxe : java17
				return switch(Integer.compare(v1.getPrix(), v2.getPrix()))
					{
					case -1 -> v1;

					case 0 -> v1;

					case 1 -> v2;

					default -> throw new IllegalArgumentException("Panic Error : impossible");
					};
				}
			};

		// Indication :
		//		(I1) Une stream avec des voitures du debut jusqu'a la fin
		//		(I2) Une reduction de voiture avec notre BinaryOperator<Voiture>
		Optional<Voiture> voitureMostExpensive = list.stream().reduce(opMostExpensive);

		// check
			{
			System.out.println("\nvoitureMoreExpensive (by reduce manuel): " + voitureMostExpensive);
			Assertions.assertTrue(voitureMostExpensive.isPresent());
			Assertions.assertTrue(voitureMostExpensive.get() == list.get(list.size() - 1));
			}
		}

	/**
	 * <pre>
	 * But:
	 *
	 * 		idem ci-desus, mais code plus propre!
	 *
	 * Indication:
	 *
	 *		(I1) 	Toujours une reduction de voiture
	 *		(I2) 	Toujours avec un BinaryOperator<Voiture>
	 *		(I3) 	Mais on fabrique ici facilement celui-ci avec
	 *
	 * 					BinaryOperator<Voiture> opMostExpensive=BinaryOperator.maxBy(Comparator<Voiture>);
	 * </pre>
	 */
	private static void argmax_by_reduce_voiture_maxBy()
		{
		int n = 100;
		List<Voiture> list = VoitureTools.create(n);

		// BinaryOperator<Voiture>
		Comparator<Voiture> prix = (v1, v2) -> Integer.compare(v1.getPrix(), v2.getPrix());
		BinaryOperator<Voiture> opMostExpensive = BinaryOperator.maxBy(prix);

		// Idem ci-dessus
		Optional<Voiture> voitureMostExpensive = list.stream().reduce(opMostExpensive); // Une stream avec des voitures du debut jusqu'a la fin

		// check
			{
			System.out.println("\nvoitureMostExpensive (by reduce and maxBy: " + voitureMostExpensive);
			Assertions.assertTrue(voitureMostExpensive.isPresent());
			Assertions.assertTrue(voitureMostExpensive.get() == list.get(list.size() - 1));
			}
		}

	/**
	 * <pre>
	 * But:
	 *
	 * 		Idem ci-dessus, mais version Collectors
	 *
	 * Indication:
	 *
	 * 		Collectors.maxBy(Comparator<Voiture>))
	 * </pre>
	 */
	private static void argmax_by_reduce_voiture_collect_maxBy()
		{
		int n = 100;
		List<Voiture> list = VoitureTools.create(n);

		Comparator<Voiture> prix = (v1, v2) -> Integer.compare(v1.getPrix(), v2.getPrix());

		Optional<Voiture> voitureMostExpensive = list.stream().collect(Collectors.maxBy(prix));// Une stream avec des voitures du debut jusqu'a la fin

		// check
			{
			System.out.println("\nvoitureMostExpensive (by collect and maxBy: " + voitureMostExpensive);
			Assertions.assertTrue(voitureMostExpensive.isPresent());
			Assertions.assertTrue(voitureMostExpensive.get() == list.get(list.size() - 1));
			}
		}

	}
