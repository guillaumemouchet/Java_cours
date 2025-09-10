
package ch.hearc.a_kitbase.container.tableau.dim1;

import java.util.Arrays;

public class UseTableau // UseX = classe avec un main, classe exécutable
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
		int n = 3;
		double[] tab = new double[n];
		// en C++	 double* tab = new double[n];

		fill(tab);
		printV1(tab);
		printV2(tab);
		printV3(tab);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void fill(double[] tab)
		{
		tab[0] = Math.PI;	// PI est : public static final de la classe Math
		tab[1] = Math.PI*2;
		tab[2] = Math.PI*3;
		}

	private static void printV1(double[] tab) // bien
		{
		for(double element:tab)
			{
			System.out.println(element);
			}
		}

	private static void printV2(double[] tab) // bien mais pas le choix de la mise en forme
		{
		System.out.println(Arrays.toString(tab));
		}

	private static void printV3(double[] tab) // indice = risque d'erreurs
		{
		for(int i = 0; i < tab.length; i++)
			{
			System.out.println(tab[i]);
			}
		}
	}

