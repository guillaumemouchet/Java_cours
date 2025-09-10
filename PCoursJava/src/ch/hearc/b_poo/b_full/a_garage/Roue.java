
package ch.hearc.b_poo.b_full.a_garage;

public class Roue
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * Constructeur dominant
	 */
	public Roue(String marque, int taille)
		{
		this.marque = marque;
		this.taille = taille;
		}

	/**
	 * Constructeur de copie
	 */
	public Roue(Roue roueSource)//On reçoit une copie de la référence roueSource
		{
		//this(new String(roueSource.marque), roueSource.taille);//Appel au constructeur dominant, ne pas oublier ;)
		//Pas besoin de new pour des types simples
		this(roueSource.marque, roueSource.taille); //Copie superficielle authorisée pour la marque car la classe String est inaltérable.
		//Le passage de taille au constructeur dominant se fait par valeur, donc par copie. La taille est donc copiée !
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Roue [marque=");
		builder.append(this.marque);
		builder.append(", taille=");
		builder.append(this.taille);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------*\
	|*				equals			*|
	\*------------------------------*/

	/**
	 * Roue1 c'est this
	 */
	public boolean isEquals(Roue roue2)
		{
		if (roue2 == this)
			{
			return true;
			}
		else
			{
			// roue2.marque == this.marque //erreur classique TE
			return roue2.taille == this.taille && roue2.marque.equals(this.marque); //equals pour les String (Inalterable) malgré type simple
			}
		}

	@Override
	public boolean equals(Object obj2)
		{
		//if (obj2 instanceof Roue) //  light mais marche pas dans les hiérarchie de classes
		//if (obj2.getClass().getName().equals(Roue.class.getName()))
		//if (obj2.getClass().equals(Roue.class)) //idem ci-dessus, plus light

		if (obj2.getClass().equals(this.getClass())) //marche  dans les hiérarchie de classes
			{
			return this.isEquals((Roue)obj2);
			}
		else
			{
			return false;
			}
		}

	/*------------------------------*\
	|*				clone			*|
	\*------------------------------*/

	public Roue cloneOf()
		{
		return new Roue(this);
		//return this;// car inaltérable today. Si quelqu'un rend la classe altérable demain avec un "setter" il est de sa responsabilité de conserver une classe roue intégre et donc d'enlever cette optimisation
		}

	@Override
	public Roue clone()
		{
		return this.cloneOf();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//input
	private String marque;
	private int taille;

	}
