
package ch.arc.cours.a_lamda.b_neu_interfacefonctionelle.b_consumer;

import java.util.function.Consumer;
import java.util.function.Predicate;

import ch.arc.cours.z_annexe.material.Homme;

public class HommeManipulator
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * sur place, modifie homme
	 *
	 * see chapter stream to see beautiful flexible optimized code
	 */
	public static void foreach(Iterable<Homme> iterable, Consumer<Homme> consumer)
		{
		for(Homme homme:iterable)
			{
			consumer.accept(homme);
			}

		}

	/**
	 * sur place, modifie homme filtrer
	 *
	 * see chapter stream to see beautiful flexible optimized code
	 */
	public static void filterForeach(Iterable<Homme> iterable, Predicate<Homme> predicate, Consumer<Homme> consumer)
		{
		for(Homme homme:iterable)
			{
			if(predicate.test(homme))
				{
				consumer.accept(homme);
				}
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
