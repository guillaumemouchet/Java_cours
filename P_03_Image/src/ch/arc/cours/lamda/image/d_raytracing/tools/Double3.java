
package ch.arc.cours.lamda.image.d_raytracing.tools;

public class Double3
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Double3(double x, double y, double z)
		{
		this.x = x;
		this.y = y;
		this.z = z;
		}

	public Double3()
		{
		this(0, 0, 0);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("double3 [x=");
		builder.append(this.x);
		builder.append(", y=");
		builder.append(this.y);
		builder.append(", z=");
		builder.append(this.z);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	public double x;
	public double y;
	public double z;

	}
