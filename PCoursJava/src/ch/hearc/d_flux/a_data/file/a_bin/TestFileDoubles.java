
package ch.hearc.d_flux.a_data.file.a_bin;

import static java.lang.Math.PI;

import java.io.IOException;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFileDoubles
	{

	/*------------------------------------------------------------------*\
	 |*							Methodes Public							*|
	 \*-----------------------------------------------------------------*/

	@Test
	public void testClone() throws IOException
		{
		double[] tab = { PI, 2 * PI, 3 * PI }; // import static ligne 4

		double[] tabClone = FileDoubles.clone(tab);

//		System.out.println(Arrays.toString(tab));
//		System.out.println(Arrays.toString(tabClone));

		Assertions.assertTrue(Arrays.equals(tab, tabClone));
		Assertions.assertArrayEquals(tab, tabClone);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
