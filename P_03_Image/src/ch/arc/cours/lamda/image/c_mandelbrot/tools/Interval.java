
package ch.arc.cours.lamda.image.c_mandelbrot.tools;

import org.junit.jupiter.api.Assertions;

public class Interval
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * Hyp : a<=b
	 */
	public Interval(double a, double b)
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
	public double delta()
		{
		return b - a;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public double getA()
		{
		return this.a;
		}

	public double getB()
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
	private double a;
	private double b;
	}
