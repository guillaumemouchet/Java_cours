
package ch.hearc.b_poo.i_classe_interne_anonyme.a_interface.sort.a_maladroit;

/**
 * On implémente comparable pour pouvoir employer la méthode sort.
 * Malheureusement, une fois la méthode compareTo implémentée, elle est rigide, fixe et ne changera plus.
 * Or, la plus part du temps, nous souhaiterions pouvoir facilement changer le critère de tri.
 */
public class BananeMaladroite implements Comparable<BananeMaladroite>
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public BananeMaladroite(int price, int weight)
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
		builder.append("BananeMaladroite [price=");
		builder.append(this.price);
		builder.append(", weight=");
		builder.append(this.weight);
		builder.append("]");
		return builder.toString();
		}

	/**
	 * Compare par rapport au poids et si le poids est égale, départage par rapport au prix
	 * Pour un tri décroissant, grâce au "-1"
	 */
	@Override
	public int compareTo(BananeMaladroite b2)
		{
		//V1 Version la plus simple
			{
			if (this.weight == b2.weight)
				{
				return -Integer.compare(this.price, b2.price);
				}
			else
				{
				return -Integer.compare(this.weight, b2.weight);
				}
			}

		//V2
//			{
//			if (this.weight == b2.weight)
//				{
//				return Integer.compare(b2.price, this.price);
//				}
//			else
//				{
//				return Integer.compare(b2.weight, this.weight);
//				}
//			}
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
