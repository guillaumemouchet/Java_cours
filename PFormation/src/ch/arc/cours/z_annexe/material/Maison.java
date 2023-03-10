
package ch.arc.cours.z_annexe.material;

public class Maison
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Maison(int prix, int nbPiece, int surface)
		{
		this.prix = prix;
		this.nbPiece = nbPiece;
		this.surface = surface;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Maisons [prix=");
		builder.append(this.prix);
		builder.append(", nbPiece=");
		builder.append(this.nbPiece);
		builder.append(", surface=");
		builder.append(this.surface);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setPrix(int prix)
		{
		this.prix = prix;
		}

	public void setNbPiece(int nbPiece)
		{
		this.nbPiece = nbPiece;
		}

	public void setSurface(int surface)
		{
		this.surface = surface;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public int getPrix()
		{
		return this.prix;
		}

	public int getNbPiece()
		{
		return this.nbPiece;
		}

	public int getSurface()
		{
		return this.surface;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs/Outputs
	private int prix;
	private int nbPiece;
	private int surface;
	}
