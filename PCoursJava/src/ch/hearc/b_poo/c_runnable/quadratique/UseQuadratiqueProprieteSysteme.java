
package ch.hearc.b_poo.c_runnable.quadratique;

public class UseQuadratiqueProprieteSysteme
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
		System.out.println(System.getProperty("user.name"));

		double a = Double.parseDouble(System.getProperty("a"));
		double b = Double.parseDouble(System.getProperty("b"));
		double c = Double.parseDouble(System.getProperty("c"));

		Quadratique quadratique = new Quadratique(a, b, c);
		quadratique.run();
		System.out.println(quadratique);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
