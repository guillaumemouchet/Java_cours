
package ch.hearc.b_poo.e_interface.factory.c_use;

import ch.hearc.b_poo.e_interface.factory.a_specification.Calculatrice_I;
import ch.hearc.b_poo.e_interface.factory.d_implementation.FactoryCalculatrice;

public class UseCalculatrice
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		Calculatrice_I calculatrice = FactoryCalculatrice.create();

		double x = 3;
		double y = 5;

		System.out.println(calculatrice.add(x, y));
		System.out.println(calculatrice.multiply(x, y));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
