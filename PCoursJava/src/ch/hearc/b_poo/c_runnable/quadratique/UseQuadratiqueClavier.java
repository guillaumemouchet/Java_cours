
package ch.hearc.b_poo.c_runnable.quadratique;

import com.bilat.tools.io.console.Clavier;

public class UseQuadratiqueClavier
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
		double a;
		do
			{
			a = Clavier.lireDouble("a = ");
			} while(a == 0);

		double b = Clavier.lireDouble("b = ");
		double c = Clavier.lireDouble("c = ");

		Quadratique quadratique = new Quadratique(a, b, c);
		quadratique.run();
		System.out.println(quadratique);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
