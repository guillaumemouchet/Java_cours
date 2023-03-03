
package ch.arc.cours.lamda.image.c_mandelbrot.tools;

import org.junit.jupiter.api.Assertions;

public class Calibreur
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * <pre>
	 * Transformation affine  [x1,x2] -> [t1,t2]
	 * 						  start   -> stop
	 * </pre>
	 */
	public Calibreur(Interval start, Interval stop)
		{
		Assertions.assertTrue(start.delta() != 0 && stop.delta() != 0);

		this.start = start;
		this.stop = stop;

		// pente
			{
			this.pente = stop.delta() / start.delta();
			}

		// Translation
			{
			// y=ax+b
			//
			// a= pente
			// b=translation
			//
			// b=y-ax

			this.translation = stop.getA() - pente * start.getA();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public double calibrer(double x)
		{
		return x * pente + translation;
		}

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Calibreur [start=");
		builder.append(this.start);
		builder.append(", stop=");
		builder.append(this.stop);
		builder.append(", pente=");
		builder.append(this.pente);
		builder.append(", translation=");
		builder.append(this.translation);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private Interval start;
	private Interval stop;

	// Tools
	private double pente;
	private double translation;

	}
