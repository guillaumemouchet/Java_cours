
package ch.hearc.b_poo.d_template;

import ch.hearc.b_poo.b_full.a_garage.Voiture;

public class UsePile
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
		usePileString();
		System.out.println();
		usePileVoiture();
		}

	private static void usePileString()
		{
		Pile<String> pile = new Pile<String>();

		pile.push("Bonjour");
		pile.push("Comment");

		System.out.println(pile);

		pile.push("Ca");
		pile.push("Va");

		System.out.println(pile);

		String element1 = pile.pop();
		pile.push("?");

		System.out.println(element1);
		System.out.println(pile);

		String element2 = pile.pop();
		String element3 = pile.pop();

		System.out.println(element2);
		System.out.println(element3);
		System.out.println(pile);
		}

	private static void usePileVoiture()
		{
		Pile<Voiture> pile = new Pile<Voiture>();

		Voiture voiture1 = new Voiture("Peugeot", "xxx", 50);

		pile.push(voiture1);

		System.out.println(pile);
		System.out.println(pile.pop());
		System.out.println(pile);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
