
package ch.arc.cours.lamda.algo.b_montecarlo.c_pure_fonctionelle;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;

import ch.arc.cours.lamda.algo.b_montecarlo.x_tools.MontecarloTools;
import ch.arc.tools.Chrono;

public class UseMontecarlo_03
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
		int n = Integer.MAX_VALUE / 10;

		final double H = 4; // Hauteur Cible
		Assertions.assertTrue(H >= 4); // car max(f)=4 sur [01]

		System.out.println("[Montecarlo] : Please wait ...\n");

		// pure fonctionelle
			{
			MontecarloTools.check(montecarloV6(n, H));
			MontecarloTools.check(montecarloV7(n, H));
			}

		System.out.println("[Montecarlo] : end");
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*	Fonctionelle only			*|
	\*------------------------------*/

	/**
	 * <pre>
	 * Meme idee que v4 et v5,mais sans employer une classe separer.
	 *
	 * On cree dans la stream une flechette aleatoire sous la forme d'un tableau a 2 cases
	 *
	 * 			i ---->  {x01,y0H}  -----> isEndessous ---> .....
	 *
	 * Performance:
	 * 		x01 et y0H sont tirés les 2 en parallel donc plus performant que precedent
	 *
	 * </pre>
	 */
	private static double montecarloV6(int n, double H)
		{
		Chrono chrono = new Chrono();

		DoubleUnaryOperator f = x -> 4 / (1 + x * x);//
		IntFunction<double[]> dareAlea = i -> new double[]{ThreadLocalRandom.current().nextDouble(), ThreadLocalRandom.current().nextDouble(H)};
		Predicate<double[]> isEndessous = array -> f.applyAsDouble(array[0])> array[1];//

		long nSousCourbe = IntStream//
				.range(0, n)//
				.parallel()//
				.mapToObj(dareAlea)//
				.filter(isEndessous)//
				.count();//

		chrono.stop();
		MontecarloTools.performance("v6 tab XY", chrono, n, Double.BYTES);

		return H * nSousCourbe / n;
		}

	/**
	 * <pre>
	 * Meme idee que v6 ,mais sans employer de tableau
	 *
	 * Indication:
	 * 		(I1) Dans le filter on fait plus de chose: 3 Actions
	 *				(A1) On tire x01
	 *				(A2) On tire y0H
	 *				(A3) on regarde si dar sous courbe ou pas
	 *
	 * Performance:
	 * 		Plus performant que V5, car pas d'instanciation de tableau
	 * </pre>
	 */
	private static double montecarloV7(int n, double H)
		{
		Chrono chrono = new Chrono();

		DoubleUnaryOperator f = x -> 4 / (1 + x * x);// TODO
		IntPredicate isEndessous = i-> {
			double x = ThreadLocalRandom.current().nextDouble();
			double y = ThreadLocalRandom.current().nextDouble(H);
			return f.applyAsDouble(x) > y;
		};

		long nSousCourbe = IntStream//
				.range(0, n)//
				.parallel()//
				.filter(isEndessous)//
				.count();

		chrono.stop();
		MontecarloTools.performance("v7 sans tab XY", chrono, n, Double.BYTES);

		return H * nSousCourbe / n;
		}

	}
