
package ch.hearc.a_kitbase.container.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UseList
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
		List<Double> list = create();
		int n = 3;
		fill(list, n);

		printV1(list);
		printV2(list);
		printV3(list);
		printV4(list);
		printV5(list);
		}
	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static List<Double> create()
		{
		//return  new LinkedList<Double>(); //FACILE A CHANGER l'implémentation -> on a typé avec l'interface "List", liste chainée = bien pour add/remove, mal pour parcours
		return  new ArrayList<Double>(); //bien pour parcours, mal pour add/remove
		}

	private static void fill(List<Double> list, int n)
		{
		for(int i = 0; i < n; i++)
			{
			list.add(i * Math.PI);
			}
		}

	/**
	 * Musee des horreurs, car on emploie un algo de complexité quadratique pour parcourir un contener linéaire
	 * principalement pour une linkedlist
	 */
	private static void printV1(List<Double> list)
		{
		for(int i = 0; i < list.size(); i++)
			{
			System.out.println(list.get(i));
			}
		}

	private static void printV2(List<Double> list)
		{
		//V1
			{
			for(Double element:list)
				{
				System.out.println(element);
				}
			}

		//V2
			{
			for(double element:list) //Autorisé car unboxing automatique
				{
				System.out.println(element);
				}
			}

		//V3
			{
			for(Double element:list)
				{
				System.out.println(element.doubleValue()); //unboxing manuel
				}
			}

		//V4
			{
			for(Double element:list)
				{
				System.out.println(element.toString()); //méthode toString sur un Double -> TOUS les objets sauf les tableaux possèdent un méthode toString(), car les tableaux ne sont pas des objets
				}
			}

		}

	private static void printV3(List<Double> list)
		{
		Iterator<Double> it = list.iterator(); //IMPORTANT POUR LE CP
		while(it.hasNext())
			{
			Double element = it.next();
			System.out.println(element);
			}
		}

	private static void printV4(List<Double> list)
		{
		System.out.println(list.toString());
		}

	private static void printV5(List<Double> list)
		{
		System.out.println(list); //Idem V4 ->toString() appelé automatiquement
		}
	}
