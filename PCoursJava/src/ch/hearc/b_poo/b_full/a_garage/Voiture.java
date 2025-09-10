
package ch.hearc.b_poo.b_full.a_garage;

import java.util.Arrays;
import java.util.Iterator;

public class Voiture implements Iterable<Roue> ,Comparable<Voiture>
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	//	public Voiture(String marque, Roue[] tabRoue)
	//		{
	//		this.marque = marque;
	//		this.tabRoue = tabRoue;
	//		}

	/**
	 * Constructeur dominant
	 */
	public Voiture(String marque, Roue... tabRoue) //varag utile pour pas avoir beosin de créer un tableau plus tard
		{
		this.marque = marque;
		this.tabRoue = tabRoue;
		}

	/**
	 * Constructeur secondaire
	 */
	public Voiture(String marqueVoiture, String marqueRoue, int tailleRoue)
		{
		this(marqueVoiture, createTabRoue(marqueRoue, tailleRoue)); //Contrainte 1ere ligne du constructeur. Appelle le constructeur dominant ci-dessus
		//createTabRoues doit être static, car on n'a pas le droit d'appeler une méthode d'instance d'un objet qui n'existe pas encore.
		}

	/**
	 * Constructeur avec marqueVoiture private static final
	 */
	public Voiture(String marqueRoue, int tailleRoue)
		{
		this(Voiture.MARQUE, marqueRoue, tailleRoue);
		}

	/**
	 * Constructeur de copie
	 */
	public Voiture(Voiture voitureSource)
		{
		this(voitureSource.marque, clone(voitureSource.tabRoue));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Voiture [marque=");
		builder.append(this.marque);
		builder.append(", tabRoue=");
		builder.append(Arrays.toString(this.tabRoue));
		builder.append("]");
		return builder.toString();
		}

	@Override
	public Iterator<Roue> iterator()
		{
		//Sac à astuces
		return Arrays.asList(this.tabRoue).iterator();
		}

	/**
	 * voiture1 est this
	 */
	@Override
	public int compareTo(Voiture voiture2)
		{
		return this.marque.compareTo(voiture2.marque);
		}

	/*------------------------------*\
	|*				clone			*|
	\*------------------------------*/

	@Override
	public Voiture clone()
		{
		return this.cloneOf();
		}

	public Voiture cloneOf()
		{
		//return new Voiture(this);

		return this;// optimisation possible car classe inaltérable
		}

	/*------------------------------*\
	|*				equals			*|
	\*------------------------------*/

	/**
	 * <pre>
	 * 2 voitures sont egales ssi (iff):
	 *  - meme marque
	 *  - meme voiture et dans le meme ordre
	 *  </pre>
	 */
	public boolean isEquals(Voiture voiture2)
		{
		if (this == voiture2)
			{
			return true;
			}
		else
			{
			if (!this.marque.equals(voiture2.marque))
				{
				return false;
				}
			else if (this.tabRoue.length != voiture2.tabRoue.length)
				{
				return false;
				}
			else
				{
				for(int i = 0; i < tabRoue.length; i++)
					{
					//	if (this.tabRoue[i] != voiture2.tabRoue[i]) // FAUX : comparaison de references

					if (!this.tabRoue[i].isEquals(voiture2.tabRoue[i])) // JUSTE : comparaison de contenu et sur, car si isEquals compile c'est que isEquals existe
						{ return false; }
					}
				return true;
				}
			}
		}

	@Override
	public boolean equals(Object obj2)
		{
		//if (obj2 instanceof Voiture) //  light mais marche pas dans les hiérarchie de classes
		//if (obj2.getClass().getName().equals(Voiture.class.getName()))
		//if (obj2.getClass().equals(Voiture.class)) //idem ci-dessus, plus light

		if (obj2.getClass().equals(this.getClass())) //marche  dans les hiérarchie de classes
			{
			return isEquals((Voiture)obj2);
			}
		else
			{
			return false;
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static Roue[] clone(Roue[] tabRoueSource)
		{
		int n = tabRoueSource.length;
		Roue[] tabRoueCopie = new Roue[n];

		for(int i = 0; i < n; i++)
			{
			Roue roueSourceI = tabRoueSource[i];

			//V1 : PAS OPTIMUM
			//Roue roueCopieI = new Roue(roueSourceI); // copie profonde

			//V2 : MAUVAIS
			//Roue roueCopieI = roueSourceI;//possible car Roue est inalterable aujourd'hui
			//mais trop dangereux car demain roue ne sera peut-etre plus inalterable a cause d'Emile et son setteur

			//V3 : BEST
			Roue roueCopieI = roueSourceI.cloneOf(); // cloneOf peut eter optimise par le responsable du developpeur de la classe Roue

			tabRoueCopie[i] = roueCopieI;
			}

		return tabRoueCopie;
		}

	private static Roue[] createTabRoue(String marque, int taille)
		{
		Roue roue0 = new Roue(marque + "0", taille);
		Roue roue1 = new Roue(marque + "1", taille);
		Roue roue2 = new Roue(marque + "2", taille);
		Roue roue3 = new Roue(marque + "3", taille);

		Roue[] tabRoues = { roue0, roue1, roue2, roue3 };

		return tabRoues;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//input
	private String marque;
	private Roue[] tabRoue;

	//tools
	private static final String MARQUE = "Peugeot";

	}
