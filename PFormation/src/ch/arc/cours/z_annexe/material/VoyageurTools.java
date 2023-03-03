
package ch.arc.cours.z_annexe.material;

public class VoyageurTools
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static Voyageur[] create()
		{
		Voyageur[] tab = new Voyageur[5];

		tab[0] = new Voyageur("bob", "ne", 1000);
		tab[1] = new Voyageur("alice", "vd", 2000);
		tab[2] = new Voyageur("marc", "ne", 3000);
		tab[3] = new Voyageur("alice", "vs", 4000);
		tab[4] = new Voyageur("bob", "vd", 5000);

		return tab;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	}
