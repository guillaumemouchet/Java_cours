package ch.hearc.a_kitbase.container.list.exercice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Assertions;

public class UseBiList
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
		int n = 3;

		List<Double> listX = createX(n);//les wrapper permettent de mettre des objects simple dans les collections
		List<Double> listY = createY(n);

		printV1(listX, listY);
		System.out.println();
		printV2(listX, listY);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void printV1(List<Double> listX, List<Double> listY)
		{
		Assertions.assertEquals(listX.size(), listY.size());

		int n = listX.size();
		Iterator<Double> itX = listX.iterator();
		Iterator<Double> itY = listY.iterator();

		for(int i = 0; i < n; i++)
			{
			double x = itX.next();// unboxing auto in double
			double y = itY.next();// unboxing auto in double

			System.out.println("(" + x + "," + y + ")");
			}
		}

	private static void printV2(List<Double> listX, List<Double> listY)
		{
		Assertions.assertEquals(listX.size(), listY.size());

		Iterator<Double> itY = listY.iterator();

		for(double x:listX) // unboxing en double auto
			{
			double y = itY.next();// unboxing auto in double
			System.out.println("(" + x + "," + y + ")");
			}
		}

	private static List<Double> createX(int n)
		{
		return create(n, 1);
		}

	private static List<Double> createY(int n)
		{
		return create(n, 10);
		}

	private static List<Double> create(int n, double factor)
		{
		List<Double> list = new ArrayList<Double>(n); // n facultatif, for best performance only ; polymorphisme orienté interface -->Examen
		//toutes les classes Java dérivent de la classe "Object"
		for(int i = 1; i <= n; i++)
			{
			list.add(factor  * i);// boxing en Double automatique
			}

		return list;
		}

	}
