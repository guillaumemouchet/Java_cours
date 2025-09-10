
package ch.hearc.b_poo.f_derivation.b_generalisation;

import ch.hearc.b_poo.f_derivation.b_generalisation.animal.mammifere.felin.Chat;
import ch.hearc.b_poo.f_derivation.b_generalisation.animal.mammifere.felin.Tigre;
import ch.hearc.b_poo.f_derivation.b_generalisation.animal.mammifere.rongeur.Souris;
import ch.hearc.b_poo.f_derivation.b_generalisation.animal.oiseau.Canard;
import ch.hearc.b_poo.f_derivation.b_generalisation.animal.oiseau.Rapace;

public class UseZoo
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
		Chat chat = new Chat("Felix");
		Tigre tigre = new Tigre("Tigrou");
		Souris souris = new Souris("Mickey");
		Canard canard = new Canard("Donald", 100);
		Rapace rapace = new Rapace("Aigle", 500);

		Zoo zoo = new Zoo("ISC2il-ab", chat, tigre, souris, canard, rapace);

		System.out.println(zoo);
		System.out.println();
		System.out.println(zoo.eat());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
