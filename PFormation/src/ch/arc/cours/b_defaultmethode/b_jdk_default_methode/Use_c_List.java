
package ch.arc.cours.b_defaultmethode.b_jdk_default_methode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

import ch.arc.cours.z_annexe.tools.Int;

public class Use_c_List
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
		System.out.println("List Default Methode : ");

		foreachList();
		foreachArray();

		limite();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  list				*|
	\*------------------------------*/

	/**
	 * 1 2 3  -> 1 4 9   elever au carrer
	 */
	private static void foreachList()
		{
		List<Integer> list = Arrays.asList(1, 2, 3);
		System.out.println("Before = " + list);

		// standard
			{
			List<Integer> listCarrer = new ArrayList<Integer>(list.size());

			for(Integer x:list)
				{
				listCarrer.add(x * x);
				}

			System.out.println("After = " + listCarrer);
			}

		// list.foreach, lamda
			{
			List<Integer> listCarrer = new ArrayList<Integer>(list.size());

			list.forEach(x -> listCarrer.add(x * x));

			System.out.println("After = " + listCarrer);
			}
		}

	/*------------------------------*\
	|*			  tab				*|
	\*------------------------------*/

	/**
	 * foreachArray existe pas!
	 *
	 * Solution :  voir un array comme une liste !
	 */
	private static void foreachArray()
		{
		Integer[] tab = { 1, 2, 3 };
		//List<Integer> list = Arrays.asList(tab);

		// list.foreach, lamda
			{
			List<Integer> listCarrer = new ArrayList<Integer>(tab.length);

			Arrays.asList(tab).forEach(x -> listCarrer.add(x * x));

			System.out.println("After = " + listCarrer);
			}
		}

	/*------------------------------*\
	|*			  limite			*|
	\*------------------------------*/

	/**
	 * Defi : compter le nombre d'élément de la liste
	 *
	 * Contrainte :
	 *
	 * 		(C1) 	sans utiliser size
	 * 		(C2) 	avec list.foreach
	 */
	private static void limite()
		{
		List<Integer> list = Arrays.asList(1, 2, 3);

		// version naive: compile pas!
		// Une variable de type simple utuiliser dans une classe interne anonyme doit etre final!
		// Mais si on met count, en final, count++ ne compile plus!
			{
			//						final int count = 0;
			//						list.forEach(i -> count++);
			}

		// version avec classe custom Int (comme Integer mais alterable)
			{
			Int count = new Int(0);

			list.forEach(x -> count.inc());

			Assert.assertTrue(count.intvalue() == list.size());
			}
		}

	}
