
package ch.arc.cours.z_annexe.material;

public class Joueur
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Joueur(String name, int gain)
		{
		this.name = name;
		this.gain = gain;
		}

	public Joueur(String name)
		{
		this(name, 0);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Joueur [name=");
		builder.append(this.name);
		builder.append(", gain=");
		builder.append(this.gain);
		builder.append("]");
		return builder.toString();
		}

	public void incrementerGain(int gain)
		{
		this.gain += gain;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public int getGain()
		{
		return this.gain;
		}

	public String getName()
		{
		return this.name;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs/Outputs
	private String name;
	private int gain;

	}
