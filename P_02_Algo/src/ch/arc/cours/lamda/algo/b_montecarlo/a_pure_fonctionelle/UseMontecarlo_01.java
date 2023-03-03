
package ch.arc.cours.lamda.algo.b_montecarlo.a_pure_fonctionelle;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.DoublePredicate;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntToDoubleFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;

import ch.arc.cours.lamda.algo.b_montecarlo.x_tools.MontecarloTools;
import ch.arc.tools.Chrono;

public class UseMontecarlo_01
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
			MontecarloTools.check(montecarloV0(n, H));
			MontecarloTools.check(montecarloV1(n, H));
			MontecarloTools.check(montecarloV2(n, H)); // catastrophique
			MontecarloTools.check(montecarloV3(n, H));
			}

		System.out.println("[Montecarlo] : end");
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*	Fonctionelle only			*|
	\*------------------------------*/

	private static double montecarloV0(int n, double H)
		{
		Chrono chrono = new Chrono();

		Random random01 = new Random();

		DoubleUnaryOperator f = x -> 4 / (1 + x * x); //
		IntToDoubleFunction x01 = i -> random01.nextDouble(); // in [01[
		DoublePredicate isEndessousCourbe = y -> H * random01.nextDouble() < y;

		long nSousCourbe = IntStream//
				.range(0, n)//
				.mapToDouble(x01)//
				.map(f)//
				.filter(isEndessousCourbe)//
				.count();

		chrono.stop();
		MontecarloTools.performance("v0", chrono, n, Double.BYTES);

		return H * nSousCourbe / n;
		}

	/**
	 * <pre>
	 * Idem V0, mais avec
	 * Stream de nombre aleatoires native
	 * </pre>
	 */
	private static double montecarloV1(int n, double H)
		{
		Chrono chrono = new Chrono();

		Random random01 = new Random();

		DoubleUnaryOperator f = x -> 4 / (1 + x * x); //
		DoublePredicate isEndessousCourbe = y -> H * random01.nextDouble() < y; //

		DoubleStream streamRandomx01 = random01.doubles(n);// stream de nombre aleatoires in [01[
		long nSousCourbe = streamRandomx01//
				.map(f)//
				.filter(isEndessousCourbe)//
				.count(); //

		chrono.stop();
		MontecarloTools.performance("v1", chrono, n, Double.BYTES);

		return H * nSousCourbe / n;
		}

	/**
	 * <pre>
	 * idem V1 mais en parallel
	 *
	 * Pas mieux, meme pire et catastrophique (10x plus lent que v0 et v1)
	 * car si vous pister random01.nextDouble() vous trouverez une barrier de synchronisation!
	 * Logique: un unique generator de nombre aleatoire est paratager par tous les threads
	 * </pre>
	 */
	private static double montecarloV2(int n, double H)
		{
		Chrono chrono = new Chrono();

		Random random01 = new Random();

		DoubleUnaryOperator f = x -> 4 / (1 + x * x); //
		DoublePredicate isEndessousCourbe = y -> H * random01.nextDouble() < y; //

		long nSousCourbe = random01//
				.doubles(n)//
				.parallel()//
				.map(f)//
				.filter(isEndessousCourbe)//
				.count(); //

		chrono.stop();
		MontecarloTools.performance("v2 worst", chrono, n, Double.BYTES);

		return H * nSousCourbe / n;
		}

	/**
	 * <pre>
	 * en parallel, mais avec ThreadLocalRandom
	 *
	 * Indication:
	 * 		use ThreadLocalRandom.current() // generator de nombre aleatoire rattacher a un thread
	 * 			- pour x sous la forme d'une stream
	 * 			- pour y
	 *
	 * On explose le chrono! (10x plus rapide que v1 et v2)
	 * </pre>
	 */
	private static double montecarloV3(int n, double H)
		{
		Chrono chrono = new Chrono();

		DoubleUnaryOperator f = x -> 4 / (1 + x * x);
		DoublePredicate isEndessousCourbe = y -> ThreadLocalRandom.current().nextDouble(H) < y; //

		long nSousCourbe = IntStream//
				.range(0, n)//
				.parallel()//
				.mapToDouble(i -> ThreadLocalRandom.current().nextDouble())//
				.map(f)//
				.filter(isEndessousCourbe)//
				.count();
		chrono.stop();
		MontecarloTools.performance("v3 ThreadLocalRandom", chrono, n, Double.BYTES);

		return H * nSousCourbe / n;
		}

	}
