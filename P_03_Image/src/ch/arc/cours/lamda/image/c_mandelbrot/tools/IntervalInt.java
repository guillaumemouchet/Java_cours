
package ch.arc.cours.lamda.image.c_mandelbrot.tools;

import org.junit.jupiter.api.Assertions;

public class IntervalInt
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * Hyp : a<=b
	 */
	public IntervalInt(int a, int b)
		{
		Assertions.assertTrue(a <= b);

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
		builder.append("Interval [a=");
		builder.append(this.a);
		builder.append(", b=");
		builder.append(this.b);
		builder.append("]");
		return builder.toString();
		}

	/**
	 * <pre>
	 *  [a,b] -> b-a
	 *
	 * Example :
	 * 		[3,4] -> 1
	 * 		[0,1] -> 1
	 * 		[-1,0] -> 1
	 * </pre>
	 */
	public int delta()
		{
		return b - a;
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

	// Inputs/Outputs
	private int a;
	private int b;
	}
