
package ch.hearc.b_poo.i_classe_interne_anonyme.a_interface.sort.b_adroit;

public class Banane
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Banane(int price, int weight)
		{
		this.price = price;
		this.weight = weight;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Banane [price=");
		builder.append(this.price);
		builder.append(", weight=");
		builder.append(this.weight);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public int getPrice()
		{
		return price;
		}

	public int getWeight()
		{
		return weight;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//input output
	private int price;
	private int weight;

	}
