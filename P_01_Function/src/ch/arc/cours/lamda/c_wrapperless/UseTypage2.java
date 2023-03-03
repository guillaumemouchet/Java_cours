
package ch.arc.cours.lamda.c_wrapperless;

import java.util.Arrays;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;

public class UseTypage2
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
		System.out.println("typage 2 : sans wrapper");

		avecWrapper();
		System.out.println();
		sansWrapper();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Avec wrapper		*|
	\*------------------------------*/

	private static void avecWrapper()
		{
		System.out.println("\nAvec wrapper");

		double[] tab = { 4, 9, 16, 25 };

		System.out.println("Before : " + Arrays.toString(tab));

		Function<Double, Double> racine = Math::sqrt; // 2 wrapper,lent!

		double[] tab2 = work(tab, racine);

		System.out.println("After : " + Arrays.toString(tab2));
		}

	private static double[] work(double[] tab, Function<Double, Double> f)
		{
		double[] tabOut = new double[tab.length];

		int i = 0;
		for(double element:tab)
			{
			tabOut[i++] = f.apply(element);
			}

		return tabOut;
		}

	/*------------------------------*\
	|*			  sans wrapper		*|
	\*------------------------------*/

	/**
	 * idem ci-dessus, mais sans wrapper et avec interface fonctionelle
	 */
	private static void sansWrapper()
		{
		System.out.println("Sans wrapper");

		double[] tab = { 4, 9, 16, 25 };

		System.out.println("Before : " + Arrays.toString(tab));

		//Function<Double, Double> racine = Math::sqrt; // 2 wrapper,lent!

		DoubleUnaryOperator f = x -> Math.sqrt(x);

		double[] tab2 = work2(tab,f);

		System.out.println("Before : " + Arrays.toString(tab2));
		}

	private static double[] work2(double[] tab, DoubleUnaryOperator f)
		{
		double[] tabOut = new double[tab.length];

		int i = 0;
		for(double element:tab)
			{
			tabOut[i++] = f.applyAsDouble(element);
			}

		return tabOut;
		}

	}
