
package ch.hearc.b_poo.b_full.b_hashcode.faux;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;

public class UseUBSFaux
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
		Set<UBSFaux> set = new HashSet<UBSFaux>();

		UBSFaux u1 = new UBSFaux(1000000);
		UBSFaux u1bis = new UBSFaux(1000000);
		UBSFaux u2 = new UBSFaux(50);

		set.add(u1);
		set.add(u1bis);
		set.add(u2);
		set.add(u1bis);

		System.out.println(set);
		Assertions.assertEquals(2, set.size());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
