
package ch.hearc.b_poo.f_derivation.a_specialisation.b_indirect.a_publique;

public class UsePE
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
		System.out.println("Use2");
		use2();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void use1()
		{
		System.out.println("Cas publique");
		new P().m();
		new E().m();
		}

	private static void use2()
		{
		E e = new E();
		e.m();
		P p = e;
		p.m();
		}
	}
