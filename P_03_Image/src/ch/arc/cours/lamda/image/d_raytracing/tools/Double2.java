
package ch.arc.cours.lamda.image.d_raytracing.tools;

public class Double2
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Double2(double x, double y)
		{
		this.x = x;
		this.y = y;
		}

	public Double2()
		{
		this(0, 0);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Double2 [x=");
		builder.append(this.x);
		builder.append(", y=");
		builder.append(this.y);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs/Outputs
	public double x;
	public double y;

	}
