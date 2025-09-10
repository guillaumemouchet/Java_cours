
package ch.hearc.a_kitbase.container.tableau.dim1.exercice;

import org.junit.jupiter.api.Assertions;

public class Quadratique
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * <pre>
	 * axx+bx+c=0
	 * hyp : <b>a!=0</b>
	 * </pre>
	 */
	public static double[] solve(double a, double b, double c)
		{
		Assertions.assertTrue(a != 0); //Vérifie que quelque chose qu'on croit vrai est vraiment vrai

		double discriminant = discriminant(a, b, c);

		if (discriminant > 0)
			{
			double[] tabX = new double[2];

			tabX[0] = (-b - Math.sqrt(discriminant)) / (2 * a);
			tabX[1] = (-b + Math.sqrt(discriminant)) / (2 * a);

			return tabX;
			}
		else if (discriminant == 0)
			{
			return new double[] { -b / (2 * a) }; //Syntaxe "Light" pour retourner un tableau
			}
		else
			{
			return new double[0]; //Mieux que de retourner null
			}
		}

	public static void print(double a, double b, double c, double[] tabX)
		{
		System.out.println("\n" + a + " x*x  +" + b + " x + " + c + "  = 0");// a ameliorer, mais pas but exercice

		for(int i = 0; i < tabX.length; i++) //Facile à prendre la longueur d'un tableau en java
			{
			System.out.println("x" + i + "=" + tabX[i]);
			}
		}

	/**
	 * Evaluation de la fonction quadratique axx + bx + c en x
	 */
	public static double f(double a, double b, double c, double x)
		{
		return a * x * x + b * x + c;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static double discriminant(double a, double b, double c)
		{
		return b * b - 4 * a * c;
		}

	}
