
package ch.arc.cours.lamda.algo.b_montecarlo.x_tools;

import org.junit.jupiter.api.Assertions;

import ch.arc.tools.Chrono;
import ch.arc.tools.Maths;

public class MontecarloTools
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void performance(String title, Chrono chrono, int nbDar, int sizeDarOctet)
		{
		long darSeconde = (long)Math.ceil(nbDar / chrono.getTimeS());

		double poidsFlechetteO = (long)nbDar * (long)sizeDarOctet * 2;
		double poidsFlechetteGO = poidsFlechetteO / (1024 * 1024 * 1024);
		double GoS = poidsFlechetteGO / chrono.getTimeS();

		System.out.println(title);
		System.out.println("#dar   = " + nbDar);
		System.out.println("#dar/s = " + darSeconde);
		System.out.println(chrono);
		System.out.println(String.format("%.2f", GoS) + " [GO/s]");
		}

	public static void check(double pihat)
		{
		System.out.println("Pi Hat = " + String.format("%.5f", pihat));
		System.out.println("Pi     = " + String.format("%.5f", Math.PI));
		System.out.println();

		Assertions.assertTrue(Maths.isEquals(Math.PI, pihat, 1e-3));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
