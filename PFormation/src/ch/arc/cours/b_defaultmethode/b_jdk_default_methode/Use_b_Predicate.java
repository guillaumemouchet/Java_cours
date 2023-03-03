
package ch.arc.cours.b_defaultmethode.b_jdk_default_methode;

import java.util.function.Predicate;

import ch.arc.cours.a_lamda.b_neu_interfacefonctionelle.a_predicate.HommeManipulator;
import ch.arc.cours.z_annexe.material.Homme;
import ch.arc.cours.z_annexe.material.HommeTools;

public class Use_b_Predicate
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
		System.out.println("Predicate Default Methode : ");

		int n = 5;
		composition(n);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * homme dont hauteur <= 20 et dont le poids est >6
	 *
	 * lamda dans variable
	 */
	private static void composition(int n)
		{
		Iterable<Homme> iterable = HommeTools.create(n);
		System.out.println("Before : " + iterable);

		// deja coder:
		Predicate<Homme> hauteurBigger20 = homme -> homme.getHauteur() > 20;
		Predicate<Homme> poidsBigger6 = homme -> homme.getPoids() > 6;

		// a coder:
		Predicate<Homme> hauteurLessEquals20 = hauteurBigger20.negate();// TODO use hauteurBigger20 et default methode
		Predicate<Homme> predicateFinal = hauteurLessEquals20.and(poidsBigger6);// TODO  use hauteurLessEquals20 et poidsBigger6 et default methode

		Iterable<Homme> iterableFiltrer = HommeManipulator.filter(iterable, predicateFinal);

		System.out.println("After : " + iterableFiltrer);
		}

	}
