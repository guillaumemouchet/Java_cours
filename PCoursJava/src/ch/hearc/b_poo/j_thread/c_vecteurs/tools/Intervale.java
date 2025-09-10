
package ch.hearc.b_poo.j_thread.c_vecteurs.tools;

import java.util.Iterator;

import org.junit.jupiter.api.Assertions;

public class Intervale implements Iterable<Integer>
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * [a,b[
	 */
	public Intervale(int a, int b)
		{
		Assertions.assertTrue(a<b);
		this.a = a;
		this.b = b;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Intervale [a=");
		builder.append(this.a);
		builder.append(", b=");
		builder.append(this.b);
		builder.append("]");
		return builder.toString();
		}

	@Override
	public Iterator<Integer> iterator()
		{

		return new Iterator<Integer>()
			{

			@Override
			public Integer next()
				{
				return counter++;
				}

			@Override
			public boolean hasNext()
				{
				return counter<b;
				}

			// Attributs
			private int counter = a;
			};
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public int getA()
		{
		return this.a;
		}

	public int getB()
		{
		return this.b;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Input & Output
	private int a;
	private int b;

	}
