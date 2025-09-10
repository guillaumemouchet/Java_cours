
package ch.hearc.b_poo.b_full.c_comparable.juste;

public class PoireJuste implements Comparable<PoireJuste>
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public PoireJuste(int prix, String marque)
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
		builder.append("PoireJuste [prix=");
		builder.append(this.prix);
		builder.append(", marque=");
		builder.append(this.marque);
		builder.append("]");
		return builder.toString();
		}

	/**
	 * Poire 1 > Poire 2 -> 1
	 * Poire 1 == Poire 2 -> 0
	 * Poire 1 < Poire 2 -> -1
	 */
	@Override
	public int compareTo(PoireJuste poire2)
		{
		if (!this.marque.equals(poire2.marque))
			{
			return this.marque.compareTo(poire2.marque);
			}
		else
			{
			return Integer.compare(this.prix, poire2.prix);
			}
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
