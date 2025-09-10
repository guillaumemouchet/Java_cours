
package ch.hearc.b_poo.b_full.a_garage.use;

import ch.hearc.b_poo.b_full.a_garage.Roue;
import ch.hearc.b_poo.b_full.a_garage.Voiture;

public class UseVoiture
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
		//V1
			{
			Roue roue0 = new Roue("bbs0", 10);
			Roue roue1 = new Roue("bbs1", 10);
			Roue roue2 = new Roue("bbs2", 10);
			Roue roue3 = new Roue("bbs3", 10);
			Roue[] tabRoue = { roue0, roue1, roue2, roue3 };

			Voiture voiture = new Voiture("Peugot", tabRoue);

			System.out.println(voiture);
			}

		//V2
			{
			Roue roue0 = new Roue("bbs0", 10);
			Roue roue1 = new Roue("bbs1", 10);
			Roue roue2 = new Roue("bbs2", 10);
			Roue roue3 = new Roue("bbs3", 10);

			Voiture voiture = new Voiture("Peugot", roue0, roue1, roue2, roue3);

			System.out.println(voiture);

			for(Roue roue:voiture)
				{
				System.out.println(roue);
				}
			}


		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
