
package ch.arc.cours.b_defaultmethode.a_custom_default_methode.b_newstyle;

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
		System.out.println("Default methode");

		useCompose();
		useAndThen();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * x -> x*x+1
	 *
	 * h(x)= x+1
	 * g(x)= x*x
	 *
	 * (h o g) (x)= h(g(x))
	 *
	 * lamda dans variable & Default Methode
	 */
	private static void useCompose()
		{
		Function_I h = null; // TODO lambda
		Function_I g = null; // TODO lambda

		Function_I h0g = null;// TODO Warning : sans lambda ! use default methode!

		Assert.assertTrue(h0g.value(2) == 5);
		}

	/**
	 * x -> x*x+1
	 *
	 * h(x)= x+1
	 * g(x)= x*x
	 *
	 * (g o h) (x)= g(h(x))
	 *
	 * lamda dans variable & Default Methode
	 */
	private static void useAndThen()
		{
		Function_I h = null;// TODO lambda
		Function_I g = null;// TODO lambda

		Function_I hAndthenG = null;// TODO Warning : sans lambda ! use default methode!

		Assert.assertTrue(hAndthenG.value(2) == 9);
		}

	}
