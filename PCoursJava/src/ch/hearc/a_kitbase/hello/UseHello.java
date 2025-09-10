
package ch.hearc.a_kitbase.hello;



public class UseHello
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		// alternative	 UseHello.main();
		// this->main	marche pas car on est pas dans une instance de la classe [QUESTION DE TE]
		}

	public static void main() // 2ème main sans arg pour faciliter la prog en groupe
		{
		System.out.println("HelloB");
		Secoundary.hello();
		// en C++ 	Secondaire::bonjour();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}

