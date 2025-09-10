
package ch.hearc.a_kitbase.container.tableau.dim2;

public class Tab2D
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static double[][] create(int n, int m)
		{
		double[][] tabExterne = new double[n][];

		for(int i = 0; i < n; i++)
			{
			tabExterne[i] = new double[m];
			}

		return tabExterne;
		}

	public static double[][] createTriangular(int n)
		{
		double[][] tabExterne = new double[n][];

		for(int i = 0; i < n; i++)
			{
			tabExterne[i] = new double[i + 1];
			}

		return tabExterne;
		}

	/**
	 * Permet de stocker une matrice d'adjacence (représentation d'un graph)
	 */
	public static double[][] createHeterogene(int[] tabColonneParLigne)
		{
		int n = tabColonneParLigne.length;
		double[][] tabExterne = new double[n][];

		for(int i = 0; i < n; i++)
			{
			int mi = tabColonneParLigne[i];
			tabExterne[i] = new double[mi];
			}

		return tabExterne;
		}

	/**
	 * <pre>
	 * doit marcher pour tes tableaux 2D:
	 * 		- rectangulaire
	 * 		- triangulaire
	 *      - hétérogène
	 *</pre>
	 */
	public static void printV1(double[][] tab)
		{
		int n = tab.length;

		for(int i = 0; i < n; i++)
			{
			int mi = tab[i].length;
			double[] lignei = tab[i];
			for(int j = 0; j < mi; j++)
				{
				System.out.print(lignei[j] + "\t");
				}
			System.out.println();
			}
		}

	public static void printV2(double[][] tab)
		{
		for(double[] lignei:tab)
			{
			for(double elementij:lignei)
				{
				System.out.print(elementij + "\t");
				}
			System.out.println();
			}
		}
	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
