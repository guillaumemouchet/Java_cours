
package ch.arc.cours.lamda.algo.c_dice;

import java.util.IntSummaryStatistics;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

import ch.arc.tools.Chrono;

public class UseDice
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
		int nbFace = 6;

		warmup(nbFace);

		exerciceV1(nbFace);
		exerciceV2(nbFace);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void warmup(int nbFace)
		{
		DiceExperience diceExperience = new DiceExperience(nbFace);
		diceExperience.run();

		System.out.println("[warmup] : nbFace=" + nbFace + "\tnbLancer=" + diceExperience.getNbLancer());
		}

	/**
	 * <pre>
	 * nombre de lancer moyen pour obtenir au moins une fois chacune des 6 faces.
	 * sequentiel
	 * </pre>
	 */
	private static void exerciceV1(int nbFace)
		{
		System.out.println("\n[Exercice] : sequentiel :  please wait ...\n");
		Chrono chrono = new Chrono();

		int nbExperience = Integer.MAX_VALUE / 100;

		IntUnaryOperator nbLancerOneExperience = DiceExperience::nbLancer;//
		IntSummaryStatistics stat = IntStream//
				.range(0, nbExperience)//
				.map(i-> nbFace)//
				.map(nbLancerOneExperience)//
				.summaryStatistics();//

		System.out.println(chrono);
		System.out.println(stat);
		System.out.println("nbLancer moyen=" + (int)Math.ceil(stat.getAverage()));
		}

	/**
	 * <pre>
	 * Idem v1 mais parallel
	 *
	 * nombre de lancer moyen pour obtenir au moins une fois chacune des 6 faces
	 * parallel (15x plus rapide)
	 * </pre>
	 */
	private static void exerciceV2(int nbFace)
		{
		System.out.println("\n[Exercice] : parallel : please wait ...\n");
		Chrono chrono = new Chrono();

		int nbExperience = Integer.MAX_VALUE / 100;

		IntUnaryOperator nbLancerOneExperience = DiceExperience::nbLancer;
		IntSummaryStatistics stat = IntStream//
				.range(0, nbExperience)//
				.parallel()//
				.map(i-> nbFace)//
				.map(nbLancerOneExperience)//
				.summaryStatistics();//;

		System.out.println(chrono);
		System.out.println(stat);
		System.out.println("nbLancer moyen=" + (int)Math.ceil(stat.getAverage()));
		}

	}
