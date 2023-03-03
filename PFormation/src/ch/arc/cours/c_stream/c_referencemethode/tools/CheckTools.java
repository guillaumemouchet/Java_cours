
package ch.arc.cours.c_stream.c_referencemethode.tools;

import java.util.List;

import org.junit.Assert;

import ch.arc.cours.z_annexe.tools.Int;

public class CheckTools
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * Hyp : same size
	 * check hashCode pour voir si copie profonde ou superficielle
	 */
	public static boolean isDeapCopy(List<Int> list1, Int[] tab2)
		{
		Assert.assertTrue(list1.size() == tab2.length);
		//checkTypeCopy(list, tab);

		int i = 0;
		for(Int e1:list1)
			{
			Int e2 = tab2[i++];

			if (e1.hashCode() == e2.hashCode()) { return false; }
			}

		return true;
		}

	/**
	 * Hyp : same size
	 * check hashCode pour voir si copie profonde ou superficielle
	 */
	public static boolean isSuperficialCopy(List<Int> list1, Int[] tab2)
		{
		Assert.assertTrue(list1.size() == tab2.length);
		//checkTypeCopy(list, tab);

		int i = 0;
		for(Int e1:list1)
			{
			Int e2 = tab2[i++];

			if (e1.hashCode() != e2.hashCode()) { return false; }
			}

		return true;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * Hyp : same size
	 * Affiche hashCode pour voir si copie profonde ou superficielle
	 */
	private static void checkTypeCopy(List<Int> list1, Int[] tab2)
		{
		Assert.assertTrue(list1.size() == tab2.length);
		int i = 0;
		for(Int e1:list1)
			{
			Int e2 = tab2[i++];

			System.out.println(e1.hashCode());
			System.out.println(e2.hashCode());
			System.out.println();
			}
		}

	}
