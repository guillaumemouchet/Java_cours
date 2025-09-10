
package ch.hearc.b_poo.f_derivation.b_generalisation.animal;

import ch.hearc.b_poo.f_derivation.b_generalisation.Animal;

public abstract class Mammifere extends Animal
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	protected Mammifere(String name, int tempSang)
		{
		super(name);
		this.tempSang = tempSang;
		}

	protected Mammifere(Mammifere source)
		{
		super(source);
		this.tempSang = source.tempSang;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String nameHierarchie()
		{
		return super.nameHierarchie() + CLASS_SEPARATOR + Mammifere.class.getSimpleName();
		}

	@Override
	public String toString()
		{
		return super.toString() + SEPARATOR + "temperature of blood" + SEPARATOR + this.tempSang;
		}

	/*------------------------------*\
	|*				equals			*|
	\*------------------------------*/

	@Override
	public boolean equals(Object object2)
		{
		boolean isEgalSuper = super.equals(object2);

		if (!isEgalSuper)
			{
			return false;
			}
		else
			{
			return this.tempSang == ((Mammifere)object2).tempSang;
			}
		}

	@Override
	public int hashcode()
		{
		return super.hashcode() + this.tempSang;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public int getTempSang()
		{
		return this.tempSang;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// input et output
	private int tempSang;

	}
