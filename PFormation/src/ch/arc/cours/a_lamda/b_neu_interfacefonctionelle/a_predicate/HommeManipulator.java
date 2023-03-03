
package ch.arc.cours.a_lamda.b_neu_interfacefonctionelle.a_predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import ch.arc.cours.z_annexe.material.Homme;

public class HommeManipulator
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * see chapter stream to see beautiful flexible optimized code
	 */
	public static Iterable<Homme> filter(Iterable<Homme> iterable, Predicate<Homme> predicate)
		{
		List<Homme> list = new ArrayList<Homme>();

		for(Homme homme:iterable)
			{
			if (predicate.test(homme))
				{
				list.add(homme);
				}
			}

		return list;
		}


	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
