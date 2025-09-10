
package ch.hearc.b_poo.f_derivation.b_generalisation;

import ch.hearc.b_poo.f_derivation.b_generalisation.animal.mammifere.felin.Chat;
import ch.hearc.b_poo.f_derivation.b_generalisation.animal.mammifere.felin.Tigre;
import ch.hearc.b_poo.f_derivation.b_generalisation.animal.mammifere.rongeur.Souris;
import ch.hearc.b_poo.f_derivation.b_generalisation.animal.oiseau.Canard;
import ch.hearc.b_poo.f_derivation.b_generalisation.animal.oiseau.Rapace;

public class UseAnimal
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
		Souris souris = new Souris("Toto");
		System.out.println(souris);
		Chat souris2 = new Chat("Toto");
		System.out.println(souris2);
		Tigre tigres = new Tigre("Toto");
		System.out.println(tigres);
		Canard canards = new Canard("Toto", 2);
		System.out.println(canards);
		Rapace rapaces = new Rapace("Toto", 3);
		System.out.println(rapaces);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
