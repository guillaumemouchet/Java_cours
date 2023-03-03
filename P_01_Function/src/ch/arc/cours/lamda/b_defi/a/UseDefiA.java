
package ch.arc.cours.lamda.b_defi.a;

import org.junit.Assert;

public class UseDefiA
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
		System.out.println("defi a");

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

		// v1
			{
			FunctionDouble cosSin = cos.mult(sin); // TODO default methode
			FunctionDouble sin2 = sin.square(); // TODO default methode
			FunctionDouble f = cosSin.add(sin2); // TODO default methode

			Assert.assertTrue(isEquals(f.apply(Math.PI / 4), 1));
			Assert.assertTrue(f.apply(Math.PI / 2) == 1);
			}

		// v2
			{
			FunctionDouble f = (cos.mult(sin)).add(sin.square()); // TODO default methode, one line

			Assert.assertTrue(isEquals(f.apply(Math.PI / 4), 1));
			Assert.assertTrue(f.apply(Math.PI / 2) == 1);
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
