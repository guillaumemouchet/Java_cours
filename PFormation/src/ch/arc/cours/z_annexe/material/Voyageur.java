
package ch.arc.cours.z_annexe.material;

public class Voyageur
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Voyageur(String name, String city, int money)
		{
		this.name = name;
		this.city = city;
		this.money = money;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Voyageurs [name=");
		builder.append(this.name);
		builder.append("\t, city=");
		builder.append(this.city);
		builder.append("\t, money=");
		builder.append(this.money);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public String getName()
		{
		return this.name;
		}

	public String getCity()
		{
		return this.city;
		}

	public int getMoney()
		{
		return this.money;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs / Outputs
	private String name;
	private String city;
	private int money;

	}
