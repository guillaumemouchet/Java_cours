
package ch.hearc.b_poo.b_full.b_hashcode.juste;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;

public class UseUBSJuste
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
		Set<UBSJuste> set = new HashSet<UBSJuste>();

		UBSJuste u1 = new UBSJuste(1000000);
		UBSJuste u1bis = new UBSJuste(1000000);
		UBSJuste u2 = new UBSJuste(50);

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
