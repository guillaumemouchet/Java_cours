
package ch.hearc.d_flux.b_object.a_materiel;

import java.io.Serializable;
import java.util.Objects;

public class Joueur implements Serializable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Joueur(String nom, int salaire)
		{
		this.nom = nom;
		this.salaire = salaire;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Joueur [nom=");
		builder.append(this.nom);
		builder.append(", salaire=");
		builder.append(this.salaire);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------*\
	|*				equals			*|
	\*------------------------------*/

	public boolean isEquals(Joueur j2)
		{
		if (this == j2)
			{
			return true;
			}
		else
			{
			return this.nom.equals(j2.nom) && this.salaire == j2.salaire;
			}
		}

	@Override
	public boolean equals(Object object2)
		{
		if (object2.getClass().equals(this.getClass()))
			{
			return isEquals((Joueur)object2);
			}
		else
			{
			return false;
			}
		}

	@Override
	public int hashCode()
		{
		return Objects.hash(this.nom, this.salaire);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Input
	//private transient String nom; // attribut non-sérializé
	private String nom;
	private int salaire;

	}

