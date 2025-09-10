
package ch.hearc.b_poo.b_full.b_hashcode;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;

public class UseHashSetWarmUp
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
		Set<String> set = new HashSet<String>(); //Unicité dans les sets

		String abele = new String("Abele");
		String serra = "Serra";
		String perrin = "Perrin";

		set.add(abele);
		set.add(serra);
		set.add(perrin);
		set.add(abele);

		System.out.println(set);
		Assertions.assertEquals(3, set.size());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
