
package ch.hearc.b_poo.i_classe_interne_anonyme.a_interface.sort.a_maladroit;

import java.util.Arrays;

public class UseBananeMaladroite
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
		BananeMaladroite b1 = new BananeMaladroite(1, 10);
		BananeMaladroite b2 = new BananeMaladroite(2, 20);
		BananeMaladroite b3 = new BananeMaladroite(3, 30);
		BananeMaladroite b4 = new BananeMaladroite(1, 11);
		BananeMaladroite b5 = new BananeMaladroite(1, 12);
		BananeMaladroite b6 = new BananeMaladroite(7, 20);
		BananeMaladroite b7 = new BananeMaladroite(6, 20);

		BananeMaladroite[] tab = { b1, b2, b3, b4, b5, b6, b7 };

		Arrays.sort(tab);

		System.out.println(Arrays.toString(tab));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
