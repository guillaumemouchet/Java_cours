
package ch.arc.cours.lamda.a_bifunction;

import org.junit.Assert;

public class UseBiFunction
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
		System.out.println("BiFunction");

		biFunction();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void biFunction()
		{
		evaluer();

		//add();
		}

	/*------------------------------*\
	|*		BiFunction<T1,T2,T3>	*|
	\*------------------------------*/

	/**
	 * f(x1,x2)= (x1-x2) + (x1*x2)
	 * Calculer f(3,2)
	 */
	private static void evaluer()
		{
		BiFunctionDouble f = (x, y) -> (x - y) + (x * y);// TODO

		double f32 = f.apply(3d, 2d);//TODO Indication : (3d,2d) pour double

		Assert.assertTrue(f32 == 7);
		}

	/**
	 * h(x1,x2)= x1 - x2
	 * g(x1,x2)= x1 * x2
	 *
	 * f(x1,x2) =  h(x1,x2) + g(x1,x2)
	 */
	private static void add()
		{
		BiFunctionDouble h = (x, y) -> x - y;// TODO
		BiFunctionDouble g = (x, y) -> x * y;// TODO

		BiFunctionDouble f = h.add(g);// TODO (use defautl methode only)

		Assert.assertTrue(f.apply(3d, 2d) == 7);
		}

	}
