
package ch.arc.cours.b_defaultmethode.b_jdk_default_methode;

import java.util.Arrays;
import java.util.Comparator;

public class Use_d_Comparator
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
		System.out.println("Comparator Default Methode :");

		triCroissant();
		triDecroissant();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * <pre>
	 * Probleme :	tri croissant
	 *
	 * Rappel : Comparator:
	 *
	 * 			x>y  return 1
	 * 			x==y return 0
	 * 			x<y	 return -1
	 * </pre>
	 */
	private static void triCroissant()
		{
		Integer[] tab = { 9, 5, 7, 2, 4, 3, 1, 6, 8 };

		Comparator<Integer> comparator = Integer::compare;//TODO
		Arrays.sort(tab, comparator);// sur place

		System.out.println("tri croissant : " + Arrays.toString(tab));
		}

	private static void triDecroissant()
		{
		// Version 1 : lamda for comparator and multiply by -1
			{
			Integer[] tab = { 9, 5, 7, 2, 4, 3, 1, 6, 8 };

			Comparator<Integer> decroissant = (x, y) -> -Integer.compare(x, y);// TODO

			Arrays.sort(tab, decroissant);// sur place

			System.out.println("tri decroissant : " + Arrays.toString(tab));
			}

		// Version 2 : switch x,y instead multiply by -1
			{
			Integer[] tab = { 9, 5, 7, 2, 4, 3, 1, 6, 8 };

			Comparator<Integer> decroissant = (x, y) -> Integer.compare(y, x);// TODO

			Arrays.sort(tab, decroissant);// sur place

			System.out.println("tri decroissant : " + Arrays.toString(tab));
			}

		// Version 3 : default methode : reverse (of comparator)
			{
			Integer[] tab = { 9, 5, 7, 2, 4, 3, 1, 6, 8 };

			Comparator<Integer> croissant = Integer::compare;// TODO
			Comparator<Integer> decroissant = croissant.reversed();// TODO

			Arrays.sort(tab, decroissant);// sur place

			System.out.println("tri decroissant : " + Arrays.toString(tab));
			}
		}

	}
