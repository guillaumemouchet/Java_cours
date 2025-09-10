
package ch.hearc.b_poo.c_runnable.quadratique;

import org.junit.jupiter.api.Assertions;

public class Quadratique implements Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * Hyp: a != 0
	 */
	public Quadratique(double a, double b, double c)
		{
		Assertions.assertTrue(a != 0);

		this.a = a;
		this.b = b;
		this.c = c;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		discriminant();

		if (this.discriminant > 0)
			{
			this.tabX = new double[2];
			this.tabX[0] = (-this.b + Math.sqrt(this.discriminant)) / (2 * this.a);
			this.tabX[1] = (-this.b - Math.sqrt(this.discriminant)) / (2 * this.a);
			}
		else if (this.discriminant == 0)
			{
			this.tabX = new double[] { -this.b / (2 * this.a) };
			}
		else
			{
			this.tabX = new double[0];
			}
		}

	@Override
	public String toString()
		{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\n");
		stringBuilder.append(a);
		stringBuilder.append(" x*x  +");
		stringBuilder.append(b);
		stringBuilder.append(" x + ");
		stringBuilder.append(c);
		stringBuilder.append(" = 0");
		stringBuilder.append(" -> ");

		if (tabX.length >= 1)
			{
			for(int i = 0; i < tabX.length; i++)
				{
				stringBuilder.append("x");
				stringBuilder.append(i);
				stringBuilder.append(" = ");
				stringBuilder.append(tabX[i]);
				stringBuilder.append(" ");
				}
			}
		else
			{
			stringBuilder.append(" no solution");
			}

		return stringBuilder.toString();
		}

	/**
	 * Evalue en x la fonction quadrqtique
	 */
	public double f(double x)
		{
		return a * x * x + b * x + c;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/**
	 * 0 case si aucune solution
	 */
	public double[] getTabX()
		{
		return this.tabX;
		}

	public int nbSolution()
		{
		return this.tabX.length;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void discriminant()
		{
		this.discriminant = Math.pow(this.b, 2) - 4 * this.a * this.c;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//input
	private double a;
	private double b;
	private double c;

	//output
	private double[] tabX;

	//tools
	private double discriminant;

	}
