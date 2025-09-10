
package ch.hearc.d_flux.b_object.a_materiel;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Equipe implements Serializable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Equipe(String nom, List<Joueur> listJoueurs)
		{
		this.nom = nom;
		this.listJoueurs = listJoueurs;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Equipe [nom=");
		builder.append(this.nom);
		builder.append(", listJoueurs=");
		builder.append(this.listJoueurs);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------*\
	|*				equals			*|
	\*------------------------------*/

	public boolean isEquals(Equipe e2)
		{
		if (this == e2)
			{
			return true;
			}
		else
			{
			if (!this.nom.equals(e2.nom))
				{
				return false;
				}
			else
				{
				return this.listJoueurs.equals(e2.listJoueurs);
				}
			}
		}

	@Override
	public boolean equals(Object object2)
		{
		if (object2.getClass().equals(this.getClass()))
			{
			return isEquals((Equipe)object2);
			}
		else
			{
			return false;
			}
		}

	@Override
	public int hashCode()
		{
		return Objects.hash(this.nom, this.listJoueurs);
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static Equipe createEquipe()
		{
		Joueur joueur1 = new Joueur("joueur1", 1);
		Joueur joueur2 = new Joueur("joueur2", 2);
		Joueur joueur3 = new Joueur("joueur3", 3);
		Joueur joueur4 = new Joueur("joueur4", 4);

		List<Joueur> listJoueurs = List.of(joueur1, joueur2, joueur3, joueur4);

		return new Equipe("equipe1", listJoueurs);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Input
	private String nom;
	private List<Joueur> listJoueurs;
	}
