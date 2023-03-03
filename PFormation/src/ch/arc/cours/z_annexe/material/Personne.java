
package ch.arc.cours.z_annexe.material;

public class Personne
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Personne(int age, int hauteur, boolean isFeminin)
		{
		this.age = age;
		this.hauteur = hauteur;
		this.isFeminin = isFeminin;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void incAge()
		{
		this.age++;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Personne [age=");
		stringBuilder.append(this.age);
		stringBuilder.append(", hauteur=");
		stringBuilder.append(this.hauteur);
		stringBuilder.append(", isFeminin=");
		stringBuilder.append(this.isFeminin);
		stringBuilder.append("]");
		return stringBuilder.toString();
		}

	public int getAge()
		{
		return this.age;
		}

	public int getHauteur()
		{
		return this.hauteur;
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setAge(int age)
		{
		this.age = age;
		}

	public void setHauteur(int hauteur)
		{
		this.hauteur = hauteur;
		}

	/*------------------------------*\
	|*				Is				*|
	\*------------------------------*/

	public boolean isFeminin()
		{
		return isFeminin;
		}

	public boolean isMasculin()
		{
		return !isFeminin;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs/Outputs
	private int age;
	private int hauteur;
	private boolean isFeminin;

	}
