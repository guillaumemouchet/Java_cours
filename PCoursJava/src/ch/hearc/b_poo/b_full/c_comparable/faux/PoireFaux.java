
package ch.hearc.b_poo.b_full.c_comparable.faux;

public class PoireFaux
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public PoireFaux(int prix, String marque)
		{
		this.prix = prix;
		this.marque = marque;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("PoireFaux [prix=");
		builder.append(this.prix);
		builder.append(", marque=");
		builder.append(this.marque);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// inputs
	private int prix;
	private String marque;
	}
