
package ch.arc.cours.c_stream.c_referencemethode;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Assert;

import ch.arc.cours.z_annexe.material.CompteUBS;

public class UseReferenceMethode_02_speciale
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
		System.out.println("reference methode speciale ...");

		// Methode non static
			{
			sysout();
			ubs();
			}

		// experimentation
			{
			reference_attribut_instance_ubs();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*		methode non static		*|
	\*------------------------------*/

	private static void sysout()
		{
		List<String> list = Arrays.asList("Alice", "Bob", "Claire", "Jules");

		// v1 lambda
			{
			Consumer<String> print = s-> System.out.println(s);
			list.forEach(print);
			}

		// v2 reference methode
			{
			Consumer<String> print = System.out::println;
			list.forEach(print);
			}

		// v2 reference methode sans varaible
			{
			list.forEach(System.out::println);
			}
		}

	private static void ubs()
		{
		List<CompteUBS> list = Arrays.asList(new CompteUBS(10), new CompteUBS(100), new CompteUBS(1000));

		// v1
			{
			double gainTotal = 0;
			for(CompteUBS compte:list)
				{
				gainTotal += CompteUBS.tauxInteret.gain(compte.getMontant());
				//  CompteUBS.tauxInteret est un objet de type TauxInteret.
				//  tauxInteret attribut public static de CompteUBS
				}

			Assert.assertTrue(gainTotal == 15 + 150 + 1500);
			}

		// v2.1 lambda sans variable : 1x mapToDouble
			{
			double gainTotal = list//
					.stream()//
					.mapToDouble(cubs -> CompteUBS.tauxInteret.gain(cubs.getMontant()))//
					.sum();

			Assert.assertTrue(gainTotal == 15 + 150 + 1500);
			}

		// v2.2 lambda sans variable : 2 map

			{
			// Contraintes:
			//			1 mapToDouble 	(pour extraire montant)
			//			1 map 			(pour calcul du gain)
			double gainTotal = list//
					.stream()//
					.mapToDouble(cubs -> cubs.getMontant())//
					.map(m-> CompteUBS.tauxInteret.gain(m))//
					.sum();

			Assert.assertTrue(gainTotal == 15 + 150 + 1500);
			}

		// v3 reference methode sans varaible
			{
			double gainTotal = list//
					.stream()//
					.mapToDouble(CompteUBS::getMontant)//
					.map(CompteUBS.tauxInteret::gain)//
					.sum();

			Assert.assertTrue(gainTotal == 15 + 150 + 1500);
			}
		}

	/*------------------------------*\
	|*	Attribut d'instance			*|
	\*------------------------------*/

	private static void reference_attribut_instance_ubs()
		{
		List<CompteUBS> list = Arrays.asList(new CompteUBS(10), new CompteUBS(100), new CompteUBS(1000));

		// v1
			{
			double sumMontant = 0;
			for(CompteUBS compte:list)
				{
				sumMontant += compte.getMontant();
				}

			Assert.assertTrue(sumMontant == 10 + 100 + 1000);
			}

		// v2.1 getMontant : reference methode
			{
			double sumMontant = list//
					.stream()//
					.mapToDouble(CompteUBS::getMontant)//
					.sum(); //  use attribut montant

			Assert.assertTrue(sumMontant == 10 + 100 + 1000);
			}

		// v3 : reference si possible! attribut "montant" (mis public pour pouvoir y acceder)
			{
//			double sumMontant = list//
//					.stream()//
//					.mapToDouble(CompteUBS::montant)//
//					.sum(); //  possible? non!
			}
		}

	}
