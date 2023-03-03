
package ch.arc.cours.lamda.image.c_mandelbrot.tools;

public class DomaineMandelbrot extends Domaine
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public DomaineMandelbrot(Interval intervalX, Interval intervalY, int w, int h)
		{
		super(intervalX, intervalY);

		this.w = w;
		this.h = h;

		// iToY
			{
			// [0,h[ --->  [a,b]
			//   i   --->    y

			Interval intervalI = new Interval(0, h);
			this.calibreurIToY = new Calibreur(intervalI, intervalY );

			}

		// jToX
			{
			// [0,w[ --->  [a,b]
			//   j   --->    x

			Interval intervalJ = new Interval(0, w);
			this.calibreurJToX = new Calibreur(intervalJ, intervalX);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public double iToY(int i)
		{
		return calibreurIToY.calibrer(i);
		}

	public double jToX(int j)
		{
		return calibreurJToX.calibrer(j);
		}

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("DomaineMandelbrot [w=");
		builder.append(this.w);
		builder.append(", h=");
		builder.append(this.h);
		builder.append(", calibreurIToY=");
		builder.append(this.calibreurIToY);
		builder.append(", calibreurJToX=");
		builder.append(this.calibreurJToX);
		builder.append(" ");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public int getW()
		{
		return this.w;
		}

	public int getH()
		{
		return this.h;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Input
	private int w;
	private int h;

	// Tools
	private Calibreur calibreurIToY;
	private Calibreur calibreurJToX;

	}
