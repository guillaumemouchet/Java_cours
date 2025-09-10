
package ch.hearc.b_poo.h_enum.b_advanced;

public class UseContinents
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
		System.out.print("Population totale : ");
		populationTotale();
		System.out.print("Superficie totale : ");
		superficieTotale();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void populationTotale()
		{
		Continents[] tabContinents = Continents.values();

		long totalPopulation = 0;
		for(Continents continent:tabContinents)
			{
			totalPopulation += continent.getNbHabitants();
			}

		System.out.println(totalPopulation);
		}

	private static void superficieTotale()
		{
		Continents[] tabContinents = Continents.values();

		long totalSuperficie = 0;
		for(Continents continent:tabContinents)
			{
			totalSuperficie += continent.getSuperficie();
			}

		System.out.println(totalSuperficie);
		}

	}
