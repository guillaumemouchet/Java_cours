
package ch.hearc.b_poo.j_thread.c_vecteurs.tools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestIntervale
	{

	/*------------------------------------------------------------------*\
	 |*							Methodes Public							*|
	 \*-----------------------------------------------------------------*/

	@Test
	public void test1()
		{
		Intervale intervale = new Intervale(5, 10);
		int elementExpected = 5;
		for(Integer element:intervale)
			{
			// System.out.println(elementExpected);
			Assertions.assertEquals(elementExpected++, element);
			}
		Assertions.assertEquals(10, elementExpected);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
