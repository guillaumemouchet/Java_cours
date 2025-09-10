
package ch.hearc.b_poo.i_classe_interne_anonyme.a_interface.sort.b_adroit.b_classe_interne_anonyme;

import java.util.Arrays;
import java.util.Comparator;

import ch.hearc.b_poo.i_classe_interne_anonyme.a_interface.sort.b_adroit.Banane;

public class UseBanane1
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
		Banane b1 = new Banane(1, 10);
		Banane b2 = new Banane(2, 20);
		Banane b3 = new Banane(3, 30);
		Banane b4 = new Banane(1, 11);
		Banane b5 = new Banane(1, 12);
		Banane b6 = new Banane(7, 20);
		Banane b7 = new Banane(6, 20);

		Banane[] tab = { b1, b2, b3, b4, b5, b6, b7 };

		// Le compilateur va créer une classe séparée, comme nous l'avions fait dans le package "a_classe_separee"
		// /!\ WARNING : Contrairement aux apparences, nous n'instancions pas une interface (Comparator EST une interface !)
		// En effet; il est impossible d'instancier une interface, car une interface N'EST PAS une classe,
		//   et seule les classes sont instenciable.
		// Nous instancions une classe sans nom, qui implémente l'interface Comparator.
		// On appel ça : Une classe interne anonyme.
		// Il s'agit d'un sucre syntaxique !
		Comparator<Banane> comparatorWeight = new Comparator<Banane>()
			{

			@Override
			public int compare(Banane b1, Banane b2)
				{
				return Integer.compare(b1.getWeight(), b2.getWeight());
				}
			};

		Comparator<Banane> comparatorPrice = new Comparator<Banane>()
			{
				@Override
				public int compare(Banane b1, Banane b2)
					{
					return Integer.compare(b1.getPrice(), b2.getPrice());
					}
			};

		System.out.println("Comparaison par prix");
		Arrays.sort(tab, comparatorPrice);
		System.out.println(Arrays.toString(tab));

		System.out.println("\nComparaison par poids");
		Arrays.sort(tab, comparatorWeight);
		System.out.println(Arrays.toString(tab));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
