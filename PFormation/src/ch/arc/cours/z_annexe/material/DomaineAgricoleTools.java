
package ch.arc.cours.z_annexe.material;

public class DomaineAgricoleTools
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static DomaineAgricole[] create1()
		{
		DomaineAgricole[] tab = new DomaineAgricole[3];

		DomaineAgricole domaineAgricoleA = null;
		DomaineAgricole domaineAgricoleB = null;
		DomaineAgricole domaineAgricoleC = null;

		// DomaineAgricoleA
			{
			Champ[] tabChamp = new Champ[3];

			tabChamp[0] = new Champ(1, true);
			tabChamp[1] = new Champ(10, true);
			tabChamp[2] = new Champ(100, true);

			domaineAgricoleA = new DomaineAgricole(tabChamp);
			}

		// DomaineAgricoleB
			{
			Champ[] tabChamp = new Champ[3];

			tabChamp[0] = new Champ(2, true);
			tabChamp[1] = new Champ(20, true);
			tabChamp[2] = new Champ(200, true);

			domaineAgricoleB = new DomaineAgricole(tabChamp);
			}

		// DomaineAgricoleC
			{
			Champ[] tabChamp = new Champ[3];

			tabChamp[0] = new Champ(3, true);
			tabChamp[1] = new Champ(30, true);
			tabChamp[2] = new Champ(300, true);

			domaineAgricoleC = new DomaineAgricole(tabChamp);
			}

		tab[0] = domaineAgricoleA;
		tab[1] = domaineAgricoleB;
		tab[1] = domaineAgricoleC;

		return tab;
		}

	public static DomaineAgricole[] create2()
		{
		DomaineAgricole[] tab = new DomaineAgricole[3];

		DomaineAgricole domaineAgricoleA = null;
		DomaineAgricole domaineAgricoleB = null;
		DomaineAgricole domaineAgricoleC = null;

		// DomaineAgricoleA
			{
			Champ[] tabChamp = new Champ[3];

			tabChamp[0] = new Champ(1, false);
			tabChamp[1] = new Champ(10, false);
			tabChamp[2] = new Champ(100, false);

			domaineAgricoleA = new DomaineAgricole(tabChamp);
			}

		// DomaineAgricoleB
			{
			Champ[] tabChamp = new Champ[3];

			tabChamp[0] = new Champ(2, false);
			tabChamp[1] = new Champ(20, false);
			tabChamp[2] = new Champ(200, false);

			domaineAgricoleB = new DomaineAgricole(tabChamp);
			}

		// DomaineAgricoleC
			{
			Champ[] tabChamp = new Champ[3];

			tabChamp[0] = new Champ(3, false);
			tabChamp[1] = new Champ(30, false);
			tabChamp[2] = new Champ(300, false);

			domaineAgricoleC = new DomaineAgricole(tabChamp);
			}

		tab[0] = domaineAgricoleA;
		tab[1] = domaineAgricoleB;
		tab[1] = domaineAgricoleC;

		return tab;
		}

	public static DomaineAgricole[] create3()
		{
		DomaineAgricole[] tab = new DomaineAgricole[3];

		DomaineAgricole domaineAgricoleA = null;
		DomaineAgricole domaineAgricoleB = null;
		DomaineAgricole domaineAgricoleC = null;

		// DomaineAgricoleA
			{
			Champ[] tabChamp = new Champ[1];

			tabChamp[0] = new Champ(1, false);

			domaineAgricoleA = new DomaineAgricole(tabChamp);
			}

		// DomaineAgricoleB
			{
			Champ[] tabChamp = new Champ[3];

			tabChamp[0] = new Champ(2, false);
			tabChamp[1] = new Champ(20, false);
			tabChamp[2] = new Champ(200, false);

			domaineAgricoleB = new DomaineAgricole(tabChamp);
			}

		// DomaineAgricoleC
			{
			Champ[] tabChamp = new Champ[3];

			tabChamp[0] = new Champ(3, false);
			tabChamp[1] = new Champ(30, false);
			tabChamp[2] = new Champ(300, false);

			domaineAgricoleC = new DomaineAgricole(tabChamp);
			}

		tab[0] = domaineAgricoleA;
		tab[1] = domaineAgricoleB;
		tab[1] = domaineAgricoleC;

		return tab;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
