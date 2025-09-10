
package ch.hearc.b_poo.b_full.a_garage.use;

import org.junit.jupiter.api.Assertions;

import ch.hearc.b_poo.b_full.a_garage.Garage;
import ch.hearc.b_poo.b_full.a_garage.Voiture;

public class UseGarage
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
		use1();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void use1()
		{
		Voiture voiture0 = new Voiture("Peugeot", "bbs", 50);
		Voiture voiture1 = new Voiture("VW", "ozRacing", 100);

		Garage garage = new Garage("Senn");

		Assertions.assertEquals(0, garage.size());

		//V1
			{
//			garage.in(voiture0);
//			garage.in(voiture1);
			}

		//V2
			{
			garage.in(voiture0, voiture1);
			}

		Assertions.assertEquals(2, garage.size());

		System.out.println(garage);

		for(Voiture voiture:garage)
			{
			System.out.println(voiture);
			}

		garage.out(voiture0);

		Assertions.assertEquals(1, garage.size());

		System.out.println(garage);
		}

	}
