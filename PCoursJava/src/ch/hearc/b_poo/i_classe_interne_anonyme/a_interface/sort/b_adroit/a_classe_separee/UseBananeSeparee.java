
package ch.hearc.b_poo.i_classe_interne_anonyme.a_interface.sort.b_adroit.a_classe_separee;

import java.util.Arrays;
import java.util.Comparator;

import ch.hearc.b_poo.i_classe_interne_anonyme.a_interface.sort.b_adroit.Banane;

public class UseBananeSeparee
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

		Comparator<Banane> comparatorPrice = new ComparatorPrice();
		Comparator<Banane> comparatorWeight = new ComparatorWeight();

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
