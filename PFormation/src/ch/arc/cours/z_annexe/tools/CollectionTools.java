
package ch.arc.cours.z_annexe.tools;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CollectionTools
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static <T> void println(String title,Iterable<T> iterable)
		{
		System.out.println();
		System.out.println(title);
		System.out.println();
		for(T element:iterable)
			{
			System.out.println(element);
			}
		System.out.println();
		}

	public static <T> void println(String title,T[] tab)
		{
		println(title,Arrays.asList(tab));
		}

	public static <T1, T2> void println(String title,Map<T1, List<T2>> map)
		{
		System.out.println();
		System.out.println(title);
		System.out.println();

		for(Entry<T1, List<T2>> entry:map.entrySet())
			{
			System.out.println(entry.getKey());
			for(T2 value:entry.getValue())
				{
				System.out.print("\n" + value);
				}
			System.out.println("\n");
			}
		System.out.println();
		}

	public static <T1, T2> void print(String title,Map<T1, T2> map)
		{
		System.out.println();
		System.out.println(title);
		System.out.println();

		for(Entry<T1, T2> entry:map.entrySet())
			{
			System.out.println(entry.getKey()+"\t"+entry.getValue());
			}
		System.out.println();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
