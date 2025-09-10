
package ch.hearc.b_poo.h_enum.a_simple;

public class UseJours
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
		simple();
		System.out.println();
		advanced();
		System.out.println();
		conversion();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void simple()
		{
		Jours mardi = Jours.MARDI;

		System.out.println(mardi);
		System.out.println(mardi.toString());
		System.out.println(mardi.name());
		}

	private static void advanced()
		{
		Jours[] tabJours = Jours.values();
		for(Jours jour:tabJours)
			{
			System.out.println(jour);
			}
		}

	private static void conversion()
		{
		// String to Enum
			{
			String lundiString = "lundi";

			Jours lundi = Jours.valueOf(lundiString.toUpperCase());
			System.out.println(lundi);
			}

		// Enum to String
			{
			Jours mardi = Jours.MARDI;

			String mardiString = mardi.name();
			System.out.println(mardiString);
			}
		}
	}
