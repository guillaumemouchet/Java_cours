
package ch.arc.cours.a_lamda.a_origine_interfacefonctionelle.comparator;

import java.util.Comparator;

import ch.arc.cours.z_annexe.material.Banane;

public class ComparatorSeparer implements Comparator<Banane>
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * 1 	si b11>b2
	 * 0 	si b1=b2
	 * -1 	si b1<b2
	 *
	 * sort by poids
	 */
	@Override public int compare(Banane b1, Banane b2)
		{
		return Integer.compare(b1.getPoids(), b2.getPoids());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
