
package ch.arc.cours.a_lamda.b_neu_interfacefonctionelle.d_function;

import java.util.List;
import java.util.function.Function;

import ch.arc.cours.z_annexe.material.Maison;
import ch.arc.cours.z_annexe.material.MaisonTools;

public class Use_a_Map
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
		System.out.println("map : Function");

		mapping();
		}

	private static void mapping()
		{
		int n = 3;
		List<Maison> list = MaisonTools.create(n);

		System.out.println(list);

		printSurface(list);
		printPrix(list);
		printPiece(list);

		printSurfaceInt(list);
		printPrixInt(list);
		printPieceInt(list);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			Function<T1,T2>		*|
	\*------------------------------*/

	private static void printSurface(List<Maison> list)
		{
		// version : classe interne anonyme dans variable
			{
			Function<Maison, Integer> function = new Function<Maison, Integer>()
				{

				@Override
				public Integer apply(Maison m)
					{
					return m.getSurface();
					}
				};
			MaisonManipulator.mapPrint(list, function);
			}

		// Version : lamda dans variable
			{
			Function<Maison, Integer> function = m -> m.getSurface();
			MaisonManipulator.mapPrint(list, function);
			}

		// Version : reference methode dans variable
			{
			Function<Maison, Integer> function = Maison::getSurface;
			MaisonManipulator.mapPrint(list, function);
			}
		}

	private static void printPiece(List<Maison> list)
		{
		// Version : reference methode dans variable
			{
			// TODO
			}
		}

	private static void printPrix(List<Maison> list)
		{
		// Version : reference methode sans variable
			{
			// TODO
			}
		}

	/*------------------------------*\
	|*		ToIntFunction<T>		*|
	\*------------------------------*/

	private static void printSurfaceInt(List<Maison> list)
		{
		// Version : lamda dans variable
			{
			// TODO
			}

		// Version : reference methode dans variable
			{
			// TODO
			}
		}

	private static void printPieceInt(List<Maison> list)
		{
		// Version : reference methode dans variable
			{
			// TODO
			}
		}

	private static void printPrixInt(List<Maison> list)
		{
		// Version : reference methode sans variable
			{
			// TODO
			}
		}

	}
