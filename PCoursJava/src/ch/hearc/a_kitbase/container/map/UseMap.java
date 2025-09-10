
package ch.hearc.a_kitbase.container.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UseMap
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
		//systeme clé valeur avec clé unique
		int n = 3;
		Map<Integer, String> map = create(); //Que des objects, d'ou les Wrappers
		fill(map, n);

		printKeys(map);
		System.out.println();
		printValues(map);
		System.out.println();
		printV1(map);
		System.out.println();
		printV2(map);
		System.out.println();
		printV3(map);
		System.out.println();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static Map<Integer, String> create()
		{
		return new HashMap<Integer,String>();
		//return new TreeMap<Integer, String>();
		}

	private static void fill(Map<Integer, String> map, int n)
		{
		for(int i = n - 1; i >= 0; i--)
			{
			map.put(i, "nom" + i);
			}
		}

	private static void printKeys(Map<Integer, String> map)
		{
		Set<Integer> keySet = map.keySet(); //clé dans un set car il y a unicité!

		//V1
			{
			for(Integer element:keySet)
				{
				System.out.println(element);
				//System.out.println(element.toString());
				//System.out.println(element.intValue());
				}
			}

		//		//V2
		//			{
		//			Iterator<Integer> it = keySet.iterator();
		//			while(it.hasNext())
		//				{
		//				System.out.println(it.next());
		//				}
		//			}
		//
		//		//V3
		//			{
		//			System.out.println(keySet.toString());
		//			}
		//
		//		//V4
		//			{
		//			System.out.println(keySet);
		//			}
		}

	private static void printValues(Map<Integer, String> map)
		{
		Collection<String> values = map.values();

		for(String element:values)
			{
			System.out.println(element);
			}
		}

	private static void printV1(Map<Integer, String> map)
		{
		Set<Entry<Integer, String>> entrySet = map.entrySet();

		for(Entry<Integer, String> entry:entrySet)
			{
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println("(" + key + "," + value + ")");
			}
		}

	private static void printV2(Map<Integer, String> map)
		{
		System.out.println(map.toString());
		}

	private static void printV3(Map<Integer, String> map)
		{
		System.out.println(map);
		}

	}
