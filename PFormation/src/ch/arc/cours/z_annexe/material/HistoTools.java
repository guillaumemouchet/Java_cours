
package ch.arc.cours.z_annexe.material;

import java.util.concurrent.atomic.AtomicLong;

import org.junit.Assert;

public class HistoTools
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * droite a 45 degre
	 * example 1 2 2 3 3 3 4 4 4 4
	 */
	public static int[] createDataInput(int limite)
		{
		int n = limite - 1;
		int size = size(n);
		int[] tab = new int[size];

		int s = 0;
		for(int i = 1; i <= n; i++)
			{
			for(int j = 0; j < i; j++)
				{
				tab[s] = i;
				Assert.assertTrue(i <= limite);
				s++;
				}

			}

		return tab;
		}

	public static void check(int[] histo)
		{
		int i = 0;
		for(int frequence:histo)
			{
			Assert.assertTrue(i == frequence);
			i++;
			}
		}

	public static void check(long[] histo)
		{
		long i = 0;
		for(long frequence:histo)
			{
			Assert.assertTrue(i == frequence);
			i++;
			}
		}

	public static void check(AtomicLong[] histo)
		{
		long i = 0;
		for(AtomicLong frequence:histo)
			{
			Assert.assertTrue(i == frequence.get());
			i++;
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static int size(int n)
		{
		return n * (n + 1) / 2;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	}
