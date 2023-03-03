
package ch.arc.cours.z_annexe.material;

public class Champ
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Champ(double surface, boolean isCultivable)
		{
		this.surface = surface;
		this.isCultivable = isCultivable;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Champ [surface=");
		builder.append(this.surface);
		builder.append(", isCultivable=");
		builder.append(this.isCultivable);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public double getSurface()
		{
		return this.surface;
		}

	public boolean isCultivable()
		{
		return this.isCultivable;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Input/Output
	private double surface;
	private boolean isCultivable;

	}
