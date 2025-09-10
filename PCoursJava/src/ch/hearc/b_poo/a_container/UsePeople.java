
package ch.hearc.b_poo.a_container;



public class UsePeople
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
		 People people = new People("Serra", 20);
		 System.out.println(people.toString());
		 System.out.println(people); // Appel implicite du toString()
		 //Si le toString n'est pas Override ça print le nom de la classe (avec un @)


		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}

