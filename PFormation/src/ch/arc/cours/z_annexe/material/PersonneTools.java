
package ch.arc.cours.z_annexe.material;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonneTools
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static List<Personne> create(int n)
		{
		long seed = 1;
		Random random = new Random(seed);

		List<Personne> list = new ArrayList<Personne>(n);

		for(int i = 0; i < n - 1; i++)
			{
			Personne personne = new Personne(random.nextInt(100), random.nextInt(10), random.nextBoolean());
			list.add(personne);
			}

		return list;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
