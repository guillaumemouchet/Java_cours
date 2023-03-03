
package ch.arc.cours.lamda.b_defi.b;

import org.junit.Assert;

public class UseDefiB
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
		System.out.println("defi b");

		exerciceDefaultMethode();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * f(x) = cos(x)*sin(x)+sin(x)*sin(x)
	 */
	private static void exerciceDefaultMethode()
		{
		FunctionDouble cos = x -> Math.cos(x); // TODO
		FunctionDouble sin = x -> Math.sin(x); // TODO

		FunctionDouble f = cos.mult(sin).add(sin.carrer()); // TODO default methode, one line

		Assert.assertTrue(isEquals(f.apply(Math.PI / 4), 1));
		Assert.assertTrue(f.apply(Math.PI / 2) == 1);
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
