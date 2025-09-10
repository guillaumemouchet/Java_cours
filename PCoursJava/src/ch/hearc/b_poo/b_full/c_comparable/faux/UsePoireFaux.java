
package ch.hearc.b_poo.b_full.c_comparable.faux;

import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Assertions;

public class UsePoireFaux
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
			Set<PoireFaux> set = new TreeSet<PoireFaux>();

			PoireFaux p1 = new PoireFaux(1, "m1");
			PoireFaux p1bis = new PoireFaux(1, "m1");
			PoireFaux p2 = new PoireFaux(2, "m2");
			PoireFaux p3 = new PoireFaux(3, "m3");
			PoireFaux p4 = new PoireFaux(1, "m2");
			PoireFaux p5 = new PoireFaux(3, "m2");

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

