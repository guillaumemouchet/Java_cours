
package ch.arc.cours.f_complement.a_any;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;

import org.junit.jupiter.api.Assertions;

import ch.arc.cours.z_annexe.material.Personne;
import ch.arc.cours.z_annexe.material.PersonneTools;

public class UseAny_01
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
		System.out.println("any  : \n");

		useAny_1();
		useAny_2();
		useAny_3();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void useAny_1()
		{
		int[] tab = { 1, 3, 5, 7, 9, 2 };

		// anyMatch
			{
			IntPredicate isPaire = i -> i % 2 == 0;
			boolean isOnePair = Arrays//
					.stream(tab)//
					.anyMatch(isPaire);

			Assertions.assertTrue(isOnePair);
			}
		}

	private static void useAny_2()
		{
		int[] tab = { 1, 3, 5, 7, 9, 2 };

		// v1: allMatch
			{
			IntPredicate isImpaire = i -> i % 2 == 1;
			boolean isAllImpair = Arrays//
					.stream(tab)//
					.allMatch(isImpaire);

			Assertions.assertFalse(isAllImpair);
			}
		}

	private static void useAny_3()
		{
		List<Personne> listPersonne = PersonneTools.create(10);

		// mixte (femme et homme)
			{
			boolean isOneFemme = listPersonne//
					.stream()//
					.anyMatch(Personne::isFeminin);
			boolean isOneHomme = listPersonne//
					.stream()//
					.anyMatch(Personne::isMasculin);

			boolean isMixte = isOneFemme && isOneHomme;

			Assertions.assertTrue(isMixte);
			}
		}
	}
