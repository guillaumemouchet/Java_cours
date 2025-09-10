
package ch.hearc.b_poo.f_derivation.a_specialisation.a_simple;

import ch.hearc.coursjava.moo.heritage.simple.HmTimes;

public class UseHmsTime
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
		use2();
		use3();
		use4();

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void use1()
		{
		HmsTime hmsTime = new HmsTime(1, 10, 100);
		System.out.println(hmsTime);
		hmsTime.set(2, 20, 200);
		System.out.println(hmsTime);
		}

	private static void use2()
		{
		HmsTime source = new HmsTime(3, 30, 300);
		HmsTime copie = new HmsTime(source);
		source.set(4, 40, 400);
		System.out.println(source);
		System.out.println(copie);
		}

	private static void use3()
		{
		HmsTime hmsTime = new HmsTime(5, 50, 500);
		hmsTime.set(6, 60);
		System.out.println(hmsTime);
		}

	private static void use4()
		{
		HmsTime hmsTime = new HmsTime(6, 60, 600);
		HmTimes hmTime = hmsTime; // pas besoin de casting est autorisé car Hms est un Hm
		Object objet = hmTime;
		System.out.println(hmTime.toString()); // affiche hh mm ss le type effectif (HmsTime) gagne!
		System.out.println(objet.toString()); // affiche hh mm ss car le type effectif gagne

		hmTime.set(55, 66); // évidemment ça marche
		//hmTime.set(55,55,500); // impossible, utilise le type local (compilateur gagne)
		}
	}
