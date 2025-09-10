
package ch.hearc.b_poo.b_full.c_comparable;

import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Assertions;

public class UseTreeSetWarmUp
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
		Set<String> set = new TreeSet<String>(); //Unicité mais avec un try Alphabetique

		String abele = new String("Abele");
		String serra = "Serra";
		String perrin = "Perrin";

		set.add(abele);
		set.add(serra);
		set.add(abele);
		set.add(perrin);

		System.out.println(set);
		Assertions.assertEquals(3, set.size());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}

