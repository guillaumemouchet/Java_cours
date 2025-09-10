
package ch.hearc.d_flux.a_data.file.b_text;

import java.io.IOException;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFileCsv
	{

	/*------------------------------------------------------------------*\
	 |*							Methodes Public							*|
	 \*-----------------------------------------------------------------*/

	@Test
	public void testClone() throws NumberFormatException, IOException
		{
		double[][] tabSource = { { 1, 2, 3 }, { 10, 20, 30 }, { Math.PI, 2 * Math.PI, 3 * Math.PI } };

		double[][] tabClone = FileCsvs.clone(tabSource);

		//		print(tabSource);
		//		System.out.println();
		//		print(tabClone);

		Assertions.assertTrue(isEquals(tabSource, tabClone));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static boolean isEquals(double[][] tab1, double[][] tab2)
		{
		if (tab1.length != tab2.length)
			{
			return false;
			}
		else
			{
			int n = tab1.length;
			for(int i = 0; i < n; i++)
				{
				double[] line1 = tab1[i];
				double[] line2 = tab2[i];

				if (!Arrays.equals(line1, line2))
					{ return false; }
				}
			return true;
			}
		}

	private static void print(double[][] tab)
	{
	for(int i = 0; i < tab.length; i++)
		{
		int mj=tab[i].length;
		for(int j = 0; j < mj; j++)
			{
			System.out.print(tab[i][j]+"\t");
			}
		System.out.println();
		}
	}

	}
