
package ch.hearc.a_kitbase.container.tableau.dim2;

public class UseTab2D
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
		useRectangulaire();

		System.out.println();

		useTriangulaire();

		System.out.println();

		useHeterogene();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void useRectangulaire()
		{
		// v1
			{
			int n = 3;
			int m = 4;
			double[][] tab2D = Tab2D.create(n, m);
			fill(tab2D);
			Tab2D.printV1(tab2D);
			}

		System.out.println();

		// v2
			{
			int n = 3;
			int m = 4;
			double[][] tab2D = new double[n][m];
			fill(tab2D);
			Tab2D.printV1(tab2D);
			}
		}

	private static void useTriangulaire()
		{
		int n = 3;
		double[][] tab2D = Tab2D.createTriangular(n);
		fill(tab2D);
		Tab2D.printV1(tab2D);
		}

	private static void useHeterogene()
		{
		int[] tabColonneParLigne = { 4, 3, 2, 4, 3, 2 };
		double[][] tab2D = Tab2D.createHeterogene(tabColonneParLigne);
		fill(tab2D);
		Tab2D.printV1(tab2D);
		}

	/**
	 * <pre>
	 * Difficulte : On ne sait pas si derriere tab se cache un tableau rectangulaire, triangulaire ou heterogene
	 * Contrainte : Methode fill doit marcher dans les trois cas!!!
	 * Objectif   : Remplire sous forme row major avec 0,1,2,3,4,5,...
	 * </pre>
	 */
	private static void fill(double[][] tab)
		{
		int n = tab.length;
		int s = 0;
		for(int i = 0; i < n; i++)
			{
			int mi = tab[i].length;
			for(int j = 0; j < mi; j++)
				{
				tab[i][j] = s;
				s++;
				}
			}
		}
	}
