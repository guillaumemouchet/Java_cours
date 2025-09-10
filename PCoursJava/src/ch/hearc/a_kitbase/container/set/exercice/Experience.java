
package ch.hearc.a_kitbase.container.set.exercice;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.Assertions;

/**
 * <pre>
 * quoi   : jet d'un Dice jusqua obtenir chacune des 6 faces
 * input  : nbFace
 * output : nbLancer
 * </pre>
 */
public class Experience
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static int run(int nbFace)
		{
		int nbLancer = 0;
		Set<Integer> setFaceObtenu = new HashSet<Integer>(nbFace); //Set car Unicité, HashSet car pas besoin d'ordre

		Random random = new Random();
		do
			{
			int random16 = random16(nbFace, random);

			setFaceObtenu.add(random16);// rappel : set comme list mais avec unicite

			nbLancer++;

			} while(setFaceObtenu.size() < nbFace);

		return nbLancer;
		}



	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static int random16(int nbFace, Random random)
		{
		double random01 = random.nextDouble(); // in [01[
		int random16 = 1 + (int)(random01 * nbFace); // in [16]

		Assertions.assertTrue(random16 >= 1 && random16 <= nbFace);

		return random16;
		}

	}
