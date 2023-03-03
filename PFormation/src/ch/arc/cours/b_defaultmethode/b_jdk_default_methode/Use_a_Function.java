
package ch.arc.cours.b_defaultmethode.b_jdk_default_methode;

import java.util.function.Function;

import org.junit.Assert;

public class Use_a_Function
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
		System.out.println("Function Default Methode : ");

		evaluer();
		andThen();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*		Function<T1,T2>			*|
	\*------------------------------*/

	/**
	 * f(x)=sqrt(x)
	 * Calculer f(9)
	 */
	private static void evaluer()
		{
		Function<Double, Double> f = x -> Math.sqrt(x);

		double f9 = f.apply(9d);//Indication : 9d pour double

		Assert.assertTrue(f9 == Math.sqrt(9));
		}

	/**
	 * f(x) = sqrt(cos(x))
	 */
	private static void andThen()
		{
		// lamda dans variable
			{
			Function<Double, Double> h = x -> Math.cos(x);// TODO Lambda
			Function<Double, Double> g = Math::sqrt;// TODO Lambda

			Function<Double, Double> f = h.andThen(g);// TODO use Default methode

			Assert.assertTrue(isEquals(f.apply(2 * Math.PI), 1));
			}

		// reference methode
			{
			Function<Double, Double> h = Math::cos;// TODO reference methode
			Function<Double, Double> g = Math::sqrt;// TODO reference methode

			Function<Double, Double> f = h.andThen(g);// TODO use Default methode

			Assert.assertTrue(isEquals(f.apply(2 * Math.PI), 1));
			}
		}

	/*------------------------------*\
	|*				tools			*|
	\*------------------------------*/

	private static boolean isEquals(double x1, double x2)
		{
		final double epsilon = 1e-6;
		return Math.abs(x1 - x2) < epsilon;
		}

	}
