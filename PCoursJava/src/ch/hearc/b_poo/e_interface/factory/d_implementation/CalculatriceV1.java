
package ch.hearc.b_poo.e_interface.factory.d_implementation;

import ch.hearc.b_poo.e_interface.factory.a_specification.Calculatrice_I;

public class CalculatriceV1 implements Calculatrice_I
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public double add(double x, double y)
		{
		return x + y;
		}

	@Override
	public double multiply(double x, double y)
		{
		return x * y;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}

