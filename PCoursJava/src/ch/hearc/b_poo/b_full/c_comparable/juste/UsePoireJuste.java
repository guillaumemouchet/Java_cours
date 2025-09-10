
package ch.hearc.b_poo.b_full.c_comparable.juste;

import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Assertions;

public class UsePoireJuste
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
		Set<PoireJuste> set = new TreeSet<PoireJuste>();

		PoireJuste p1 = new PoireJuste(1, "m1");
		PoireJuste p1bis = new PoireJuste(1, "m1");
		PoireJuste p2 = new PoireJuste(2, "m2");
		PoireJuste p3 = new PoireJuste(3, "m3");
		PoireJuste p4 = new PoireJuste(1, "m2");
		PoireJuste p5 = new PoireJuste(3, "m2");

		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);
		set.add(p2);
		set.add(p1bis);
		set.add(p3);
		set.add(p5);
		set.add(p4);

		System.out.println(set);
		Assertions.assertEquals(5, set.size());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
