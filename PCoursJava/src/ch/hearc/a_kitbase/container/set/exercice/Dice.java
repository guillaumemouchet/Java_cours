
package ch.hearc.a_kitbase.container.set.exercice;

/**
 * #lancer moyen pour obtenir au moins une fois chacune des 6 faces
 */
public class Dice
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * Generalisation
	 */
	public static int run(int nbExperience, int nbFace)
		{
		long nbLancerTotal = 0;

		for(int i = 0; i < nbExperience; i++)
			{
			nbLancerTotal += Experience.run(nbFace);
			}

		double mean = nbLancerTotal / (double)nbExperience;

		return (int)Math.ceil(mean);
		}

	/**
	 * Dice a 6 face
	 */
	public static int run(int nbExperience)
		{
		return run(nbExperience, 6);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
