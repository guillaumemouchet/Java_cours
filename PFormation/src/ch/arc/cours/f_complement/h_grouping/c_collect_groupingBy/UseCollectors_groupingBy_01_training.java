
package ch.arc.cours.f_complement.h_grouping.c_collect_groupingBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import ch.arc.cours.z_annexe.material.Voyageur;
import ch.arc.cours.z_annexe.material.VoyageurTools;
import ch.arc.cours.z_annexe.tools.CollectionTools;

public class UseCollectors_groupingBy_01_training
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
		System.out.println("collectors : groupingBy : training 1");

		// groupingBy
			{
			useGrouping_toList();

			//useSansGrouping();

			useGrouping_counting();
			useGrouping_summingInt();
			useGrouping_reducing();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*		level1	: toList		*|
	\*------------------------------*/

	/**
	 * <pre>
	 * Data			: tab de Voyageur(name,city, money)
	 *
	 * 					Voyageurs [name=bob		, city=ne	, money=1000]
	 *					Voyageurs [name=alice	, city=vd	, money=2000]
	 *					Voyageurs [name=marc	, city=ne	, money=3000]
	 *					Voyageurs [name=alice	, city=vs	, money=4000]
	 *					Voyageurs [name=bob		, city=vd	, money=5000]
	 *
	 * Probleme   	: regrouper les voyageurs par city
	 *
	 * Contrainte 	: output dans Map avec:
	 * 						- key   = city
	 *                      - value = List voyageur etant dans la city
	 *
	 * Output:
	 *
	 * 				ne
	 *
	 * 					Voyageurs [name=bob		, city=ne	, money=1000]
	 * 					Voyageurs [name=marc	, city=ne	, money=3000]
	 *
	 * 				vs
	 *
	 * 					Voyageurs [name=alice	, city=vs	, money=4000]
	 *
	 * 				vd
	 *
	 * 					Voyageurs [name=alice	, city=vd	, money=2000]
	 * 					Voyageurs [name=bob		, city=vd	, money=5000]
	 *</pre>
	 */
	private static void useGrouping_toList()
		{
		Voyageur[] tabVoyageur = VoyageurTools.create(); // Voyageur(name,city, money)

		CollectionTools.println("data input", tabVoyageur);

		// avec variable et type
			{
			// functionCLassifier:
			//		(I2) C'est une fonction, donc une transformation
			//		(I3) La stream donne des Voyageurs, dans la key da la map  on veut des city
			//
			//					Transformation:		Voyageur ----> City
			//

			Function<Voyageur, String> voyageurToCity = Voyageur::getCity; // functionCLassifier

			// valueCollector:
			//		(I1) On fait rarement des Collector soi meme!
			//		(I2) On utilise si on peut des Collector existants
			//		(I3) On recoit les voyageurs d'une meme ville, on les collect comment?
			//					Avec un collector!
			//			 		Celui qui met tout dans une liste!
			Collector<Voyageur, ?, List<Voyageur>> toList = Collectors.toList(); // valueCollector

			Map<String, List<Voyageur>> mapCityVoyageur = Arrays//
					.stream(tabVoyageur)//
					.collect(Collectors.groupingBy(voyageurToCity, toList));

			// check
			CollectionTools.println("[groupingBy city et Voyageur] : ", mapCityVoyageur);
			}

		// sans variable
		// sans value collector (par defaut c'est une liste!)
			{
			Map<String, List<Voyageur>> mapCityVoyageur = Arrays//
					.stream(tabVoyageur)//
					.collect(Collectors.groupingBy(Voyageur::getCity, Collectors.toList()));

			// Observation : Collectors.groupingBy(classifier) et valueCollector par default (toList)
			//
			//		- Output est une map<Key,value>
			//		- La valeur de la map et une list<T> ou T est le type fournit par la stream !
			//		- la key de map est fournit par un classifier de type Function<T,Key>

			// check
			CollectionTools.println("[groupingBy city et Voyageur] : ", mapCityVoyageur);
			}
		}

	/**
	 * But:
	 * 		meme exercice, mais sans  Collectors.groupingBy
	 *
	 * Contrainte :
	 *
	 * 		code style deuxieme annee
	 *
	 * Note:
	 *
	 * 		Travail laisser au lecteur  a faire a la maison)
	 */
	private static void useSansGrouping()
		{
		Voyageur[] tabVoyageur = VoyageurTools.create(); // Voyageur(name,city, money)

		CollectionTools.println("data input", tabVoyageur);

		Map<String, List<Voyageur>> mapCityVoyageur = null;// TODO

		// check
		CollectionTools.println("[groupingBy city et Voyageur] : ", mapCityVoyageur);
		}

	/*------------------------------*\
	|*		level2 : counting		*|
	\*------------------------------*/

	/**
	 * <pre>
	 * Data			: tab de Voyageur(name,city, money)
	 *
	 * 					Voyageurs [name=bob		, city=ne	, money=1000]
	 *					Voyageurs [name=alice	, city=vd	, money=2000]
	 *					Voyageurs [name=marc	, city=ne	, money=3000]
	 *					Voyageurs [name=alice	, city=vs	, money=4000]
	 *					Voyageurs [name=bob		, city=vd	, money=5000]
	 *
	 * Probleme   	: Nombre de Voyageur par city
	 *
	 * Contrainte 	: output dans Map avec:
	 * 						- key= city
	 *                      - value= nombre de voyageur dans cette city
	 *
	 * Output:
	 *
	 * 					ne	2
	 *					vs	1
	 *					vd	2
	 * </pre>
	 */
	private static void useGrouping_counting()
		{
		Voyageur[] tabVoyageur = VoyageurTools.create();

		// sans variable
			{
			Map<String, Long> mapCityVoyageurCount = Arrays//
					.stream(tabVoyageur)//
					.collect(Collectors.groupingBy(Voyageur::getCity, Collectors.counting()));

			CollectionTools.print("[groupingBy City et VoyageurCount] : ", mapCityVoyageurCount);
			}
		}

	/*------------------------------*\
	|*		level3 / summingInt		*|
	\*------------------------------*/

	/**
	 * <pre>
	 * Data			: tab de Voyageur(name,city, money)
	 *
	 * 					Voyageurs [name=bob		, city=ne	, money=1000]
	 *					Voyageurs [name=alice	, city=vd	, money=2000]
	 *					Voyageurs [name=marc	, city=ne	, money=3000]
	 *					Voyageurs [name=alice	, city=vs	, money=4000]
	 *					Voyageurs [name=bob		, city=vd	, money=5000]
	 *
	 * Probleme   	: Nombre d'argent par ville
	 *
	 * Contrainte 	: output dans Map avec:
	 * 						- key= city
	 *                      - value= nombre d'argent par ville
	 *
	 * Output:
	 *
	 * 					ne	4000
	 *					vs	4000
	 *					vd	7000
	 * </pre>
	 */
	private static void useGrouping_summingInt()
		{
		Voyageur[] tabVoyageur = VoyageurTools.create();

		// sans variable
			{
			Map<String, Integer> mapCityVoyageurCount = Arrays//
					.stream(tabVoyageur)//
					.collect(Collectors.groupingBy(Voyageur::getCity, Collectors.summingInt(Voyageur::getMoney)));

			CollectionTools.print("[groupingBy City et sumMoney] : ", mapCityVoyageurCount);
			}
		}

	/**
	 * idem ci-dessus, mais avec un reducing
	 */
	private static void useGrouping_reducing()
		{
		Voyageur[] tabVoyageur = VoyageurTools.create();

		// sans variable
			{
			Map<String, Integer> mapCityVoyageurCount = Arrays//
					.stream(tabVoyageur)//
					.collect(Collectors.groupingBy(Voyageur::getCity, Collectors.reducing(0, Voyageur::getMoney, Integer::sum)));

			CollectionTools.print("[groupingBy City et sumMoney] : ", mapCityVoyageurCount);
			}
		}

	}
