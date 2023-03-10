
package ch.arc.cours.z_annexe.material;

public class Banane
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Banane(int poids, int prix)
		{
		this.poids = poids;
		this.prix = prix;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override public String toString()
		{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Banane [poids=");
		stringBuilder.append(this.poids);
		stringBuilder.append(", prix=");
		stringBuilder.append(this.prix);
		stringBuilder.append("]");
		return stringBuilder.toString();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public int getPoids()
		{
		return this.poids;
		}

	public int getPrix()
		{
		return this.prix;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs/Outputs
	private int poids;
	private int prix;
	}
