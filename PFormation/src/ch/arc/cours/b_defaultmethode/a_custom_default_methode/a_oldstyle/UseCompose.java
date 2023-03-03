
package ch.arc.cours.b_defaultmethode.a_custom_default_methode.a_oldstyle;

import org.junit.Assert;

public class UseCompose
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
		System.out.println("Compose");

		useComposition1();
		useComposition2();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * x -> x*x+1
	 *
	 * h(x)= x+1
	 * g(x)= x*x
	 * (h o g) (x)= h(g(x))
	 *
	 * Classe interne anonyme dans variable
	 */
	private static void useComposition1()
		{
		Function_I h = new Function_I()
			{

			@Override
			public double value(double x)
				{
				return x + 1;
				}
			};

		Function_I g = new Function_I()
			{

			@Override
			public double value(double x)
				{
				return x * x;
				}
			};

		Function_I u1 = FunctionAlgebra.composition1(h, g);
		Function_I u2 = FunctionAlgebra.composition2(h, g);

		check(u1, u2);
		}

	/**
	 * x -> x*x+1
	 *
	 * h(x)= x+1
	 * g(x)= x*x
	 *
	 * (h o g) (x)= h(g(x))
	 *
	 * lamda dans variable
	 */
	private static void useComposition2()
		{
		Function_I h = x -> x + 1;
		Function_I g = x -> x * x;

		Function_I u1 = FunctionAlgebra.composition1(h, g);
		Function_I u2 = FunctionAlgebra.composition2(h, g);

		check(u1, u2);
		}

	/*------------------------------*\
	|*				Tools			*|
	\*------------------------------*/

	private static void check(Function_I u1, Function_I u2)
		{
		//		System.out.println(u1.value(2));
		//		System.out.println(u2.value(2));

		Assert.assertTrue(u1.value(2) == 2 * 2 + 1);
		Assert.assertTrue(u2.value(2) == 2 * 2 + 1);
		}

	}
