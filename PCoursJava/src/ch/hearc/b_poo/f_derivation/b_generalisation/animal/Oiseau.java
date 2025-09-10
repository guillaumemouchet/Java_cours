
package ch.hearc.b_poo.f_derivation.b_generalisation.animal;

import ch.hearc.b_poo.f_derivation.b_generalisation.Animal;

public abstract class Oiseau extends Animal
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	protected Oiseau(String name, int nbPlumes)
		{
		super(name);
		this.nbPlumes = nbPlumes;
		}

	protected Oiseau(Oiseau source)
		{
		super(source);
		this.nbPlumes = source.nbPlumes;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String nameHierarchie()
		{
		return super.nameHierarchie() + CLASS_SEPARATOR + Oiseau.class.getSimpleName();
		}

	@Override
	public String toString()
		{
		return super.toString() + SEPARATOR + "number of plumes " + SEPARATOR + this.nbPlumes;
		}

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
			return this.nbPlumes == ((Oiseau)object2).nbPlumes;
			}
		}

	@Override
	public int hashcode()
		{
		return super.hashcode() + this.nbPlumes;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public int getNbPlumes()
		{
		return this.nbPlumes;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private int nbPlumes;
	}
