
package ch.hearc.b_poo.f_derivation.a_specialisation.b_indirect.b_prive;

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
		System.out.println("Cas privé");
		use1();
		System.out.println("Use2");
		use2();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void use1()
		{
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
