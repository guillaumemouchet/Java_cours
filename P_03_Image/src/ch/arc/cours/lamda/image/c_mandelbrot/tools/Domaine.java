
package ch.arc.cours.lamda.image.c_mandelbrot.tools;

public class Domaine
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Domaine(Interval intervalX, Interval intervalY)
		{
		this.intervalX = intervalX;
		this.intervalY = intervalY;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Domaine [intervalX=");
		builder.append(this.intervalX);
		builder.append(", intervalY=");
		builder.append(this.intervalY);
		builder.append("]");
		return builder.toString();
		}



	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public Interval getIntervalX()
		{
		return this.intervalX;
		}

	public Interval getIntervalY()
		{
		return this.intervalY;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	protected Interval intervalX;
	protected Interval intervalY;
	}
