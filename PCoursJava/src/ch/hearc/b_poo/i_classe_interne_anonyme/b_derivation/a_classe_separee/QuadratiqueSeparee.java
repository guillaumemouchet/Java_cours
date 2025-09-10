
package ch.hearc.b_poo.i_classe_interne_anonyme.b_derivation.a_classe_separee;

import ch.hearc.b_poo.c_runnable.quadratique.Quadratique;

public class QuadratiqueSeparee extends Quadratique
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public QuadratiqueSeparee(double a, double b, double c)
		{
		super(a, b, c);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		super.run();
		System.out.println("Vive la dérivation !");
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
