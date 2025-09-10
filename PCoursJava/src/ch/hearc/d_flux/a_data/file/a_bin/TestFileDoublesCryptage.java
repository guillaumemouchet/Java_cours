
package ch.hearc.d_flux.a_data.file.a_bin;

import static java.lang.Math.PI;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.NoSuchPaddingException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFileDoublesCryptage
	{

	/*------------------------------------------------------------------*\
	 |*							Methodes Public							*|
	 \*-----------------------------------------------------------------*/

	@Test
	public void testClone() throws IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException
		{
		double[] tab = { 10 * PI, 20 * PI, 30 * PI }; // import static ligne 4

		double[] tabClone = FileDoublesCryptage.clone(tab);

//		System.out.println(Arrays.toString(tab));
//		System.out.println(Arrays.toString(tabClone));

		Assertions.assertTrue(Arrays.equals(tab, tabClone));
		Assertions.assertArrayEquals(tab, tabClone);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
