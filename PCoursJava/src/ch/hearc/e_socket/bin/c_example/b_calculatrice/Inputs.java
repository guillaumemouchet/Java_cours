
package ch.hearc.e_socket.bin.c_example.b_calculatrice;

import java.io.Serializable;

public class Inputs implements Serializable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Inputs(double a, double b)
		{
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
		builder.append("Inputs [a=");
		builder.append(this.a);
		builder.append(", b=");
		builder.append(this.b);
		builder.append("]");
		return builder.toString();
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

	// Inputs
	private double a;

	private double b;
	}
