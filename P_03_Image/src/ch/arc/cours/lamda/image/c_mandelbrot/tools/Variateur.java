
package ch.arc.cours.lamda.image.c_mandelbrot.tools;

import org.junit.jupiter.api.Assertions;

public class Variateur
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Variateur(IntervalInt interval)
		{
		Assertions.assertTrue(a <= b);
		this.a = interval.getA();
		this.b = interval.getB();

		// Tools
		this.i = a;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public int varier()
		{
		i++;

		if (i > b)
			{
			i = a;
			}

		return i;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private int a;
	private int b;

	// outputs
	private int i;

	}
