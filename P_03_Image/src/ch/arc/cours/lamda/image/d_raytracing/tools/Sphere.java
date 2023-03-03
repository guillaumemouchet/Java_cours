
package ch.arc.cours.lamda.image.d_raytracing.tools;

public class Sphere
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Sphere(Double3 centre, double rayon, float hueStart)
		{
		// Input
			{
			this.centre = centre;
			this.rayon = rayon;
			this.hueStart = hueStart;
			}

		// Tools
			{
			this.r2 = rayon * rayon;
			this.T = Math.asin(2 * hueStart - 1) - 3 * Math.PI / 2;
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Sphere [centre=");
		builder.append(this.centre);
		builder.append(", rayon=");
		builder.append(this.rayon);
		builder.append(", hueStart=");
		builder.append(this.hueStart);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------*\
	|*			  Math				*|
	\*------------------------------*/

	public double hCarre(Double2 xySol) // h²
		{
		double a = (centre.x - xySol.x);
		double b = (centre.y - xySol.y);
		return a * a + b * b;
		}

	public boolean isEnDessous(double h2)
		{
		return h2 < r2;
		}

	public double dz(double h2) // dz
		{
		return Math.sqrt(r2 - h2);
		}

	public float brightness(double dz)
		{
		return (float)(dz / rayon);
		}

	public double distance(double dz) // I
		{
		return centre.z - dz;
		}

	public float hue(float t) //B varie entre 0 et 1
		{
		return (float)(0.5 + 0.5 * Math.sin(t + T + 3 * Math.PI / 2));
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public Double3 getCentre()
		{
		return this.centre;
		}

	public double getRayon()
		{
		return this.rayon;
		}

//	public float getHueStart()
//		{
//		return this.hueStart;
//		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private Double3 centre;
	private double rayon;
	private float hueStart;

	// Tools
	private double r2;
	private double T;
	}
