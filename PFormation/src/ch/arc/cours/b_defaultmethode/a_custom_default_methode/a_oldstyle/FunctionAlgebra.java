
package ch.arc.cours.b_defaultmethode.a_custom_default_methode.a_oldstyle;

public class FunctionAlgebra
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  add			*|
	\*------------------------------*/

	/**
	 * (h + g)(x) = h(x)+g(x)
	 *
	 * classe interne anonyme sans variable
	 */
	public static Function_I add1(Function_I h, Function_I g)
		{
		return new Function_I()
			{

			@Override
			public double value(double x)
				{
				return g.value(x) + h.value(x);
				}
			};
		}

	/**
	 * (h + g)(x) = h(x)+g(x)
	 *
	 * lamda dans variable
	 */
	public static Function_I add2(Function_I h, Function_I g)
		{
		Function_I f = x -> g.value(x) + h.value(x);
		return f;
		}

	/**
	 * (h + g)(x) = h(x)+g(x)
	 *
	 * lamda
	 */
	public static Function_I add3(Function_I h, Function_I g)
		{
		return x -> g.value(x) + h.value(x);
		}

	/*------------------------------*\
	|*			  compose			*|
	\*------------------------------*/

	/**
	 * (h 0 g)(x) = h(g(x))
	 *
	 * classe interne anonyme sans variable
	 */
	public static Function_I composition1(Function_I h, Function_I g)
		{
		return new Function_I()
			{

			@Override
			public double value(double x)
				{
				return h.value(g.value(x));
				}
			};
		}

	/**
	 * (h 0 g)(x) = h(g(x))
	 *
	 * lamda sans variable
	 */
	public static Function_I composition2(Function_I h, Function_I g)
		{
		return x -> h.value(g.value(x));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
