
package ch.arc.cours.a_lamda.a_origine_interfacefonctionelle.comparator;

import java.util.Arrays;
import java.util.Comparator;

import ch.arc.cours.z_annexe.material.Banane;
import ch.arc.cours.z_annexe.material.BananeTools;

public class UseComparator
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
		int n = 5;

		// old school
			{
			version1(n);
			version2(n);
			}

		// Version lamda
			{
			version3(n);
			version4(n);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * Classe separer
	 */
	private static void version1(int n)
		{
		Banane[] tab = BananeTools.createTab(n);

		Comparator<Banane> comparator = new ComparatorSeparer();

		BananeTools.print("Before", tab);

		Arrays.sort(tab, comparator); // tri sur place

		BananeTools.print("After 1:", tab);
		}

	/**
	 * Classe interne anonyme
	 * Avec variable
	 */
	private static void version2(int n)
		{
		Banane[] tab = BananeTools.createTab(n);

		Comparator<Banane> comparator = new Comparator<Banane>()
			{

			@Override
			public int compare(Banane b1, Banane b2)
				{
				return Integer.compare(b1.getPoids(), b2.getPoids());
				}
			};

		Arrays.sort(tab, comparator); // tri sur place

		BananeTools.print("After 2", tab);
		}

	/*------------------------------*\
	|*		Version lamda			*|
	\*------------------------------*/

	/**
	 * avec {return ... ;}
	 */
	private static void version3(int n)
		{
		Banane[] tab = BananeTools.createTab(n);

		Comparator<Banane> comparator = (b1, b2) -> {return Integer.compare(b1.getPoids(), b2.getPoids());};

		Arrays.sort(tab, comparator); // tri sur place

		BananeTools.print("After 3", tab);
		}

	/**
	 * sans {return ... ;}
	 */
	private static void version4(int n)
		{
		Banane[] tab = BananeTools.createTab(n);

		Comparator<Banane> comparator = (b1, b2) -> Integer.compare(b1.getPoids(), b2.getPoids());

		Arrays.sort(tab, comparator); // tri sur place

		BananeTools.print("After 4", tab);
		}

	}
