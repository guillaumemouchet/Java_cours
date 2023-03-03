
package ch.arc.cours.lamda.algo.b_montecarlo.b_hybride.helper;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.DoubleUnaryOperator;

public class Montecarlo_hybride_objet_v4
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Montecarlo_hybride_objet_v4(DoubleUnaryOperator f, double h)
		{
		this.f = f;
		this.h = h;
		}

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
		Montecarlo_hybride_objet_v4 diceLancer = new Montecarlo_hybride_objet_v4(f, h);

		return diceLancer.isEndessous() ? 1 : 0;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * on tire un dar et on regarde si en-dessous
	 */
	public boolean isEndessous()
		{
		ThreadLocalRandom current = ThreadLocalRandom.current();
		double x = current.nextDouble();
		double y = current.nextDouble(this.h);
		return f.applyAsDouble(x) > y;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private DoubleUnaryOperator f;
	private double h; // hauteur cible

	}
