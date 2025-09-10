
package ch.hearc.b_poo.h_enum.b_advanced;

/**
 * Chaque enumération ci-dessous (Europe, Amerique, ...) est une instance de la classe Continents
 * => Une enum en Java est une classe dont le nombre d'instance est connu et fixe. <=
 *
 * Exemple : Europe est une instance de la classe Continents (une référence pointant vers une instance de la classe Continents)
 * 			 Pareil pour les autres.
 */
public enum Continents
	{

EUROPE(10180000, 748306285), //
AMERIQUE(42550000, 1002000000), //
ASIE(43810582, 4342255000L), //
OCEANIE(8525989, 42352038), //
AFRIQUE(30415873, 1300000000); // HYPER IMPORTANT

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private Continents(int superficie, long nbHabitants)
		{
		this.superficie = superficie;
		this.nbHabitants = nbHabitants;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public int getSuperficie()
		{
		return this.superficie;
		}

	public long getNbHabitants()
		{
		return this.nbHabitants;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// inputs
	private int superficie;

	private long nbHabitants;

	}
