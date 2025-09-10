
package ch.hearc.b_poo.i_classe_interne_anonyme.a_interface.sort.b_adroit.a_classe_separee;

import java.util.Comparator;

import ch.hearc.b_poo.i_classe_interne_anonyme.a_interface.sort.b_adroit.Banane;

public class ComparatorPrice implements Comparator<Banane>
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public int compare(Banane b1, Banane b2)
		{
		return Integer.compare(b1.getPrice(), b2.getPrice());
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}

