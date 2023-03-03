
package ch.arc.cours.lamda.algo.b_montecarlo.b_hybride.helper;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.DoubleUnaryOperator;

public class Montecarlo_hybride_static_v5
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	/**
	 * <pre>
	 * on tire un dar et on regarde si en-dessous
	 * 	 - oui   1
	 *   - non   0
	 * <pre>
	 */
	public static int isEnDessous(DoubleUnaryOperator f, double h)
		{
		ThreadLocalRandom current = ThreadLocalRandom.current();
		double x = current.nextDouble();
		double y = current.nextDouble(h);
		return f.applyAsDouble(x) > y ? 1 : 0;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
