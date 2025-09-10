
package ch.hearc.b_poo.f_derivation.b_generalisation.animal.oiseau;

import ch.hearc.b_poo.f_derivation.b_generalisation.animal.Oiseau;

public class Canard extends Oiseau
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Canard(String name, int nbPlumes)
		{
		super(name, nbPlumes);
		}

	public Canard(Canard source)
		{
		super(source);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String nameHierarchie()
		{
		return super.nameHierarchie() + CLASS_SEPARATOR + Canard.class.getSimpleName();
		}

	@Override
	public String eat()
		{
		return " bread";
		}

	/*------------------------------*\
	|*				clone			*|
	\*------------------------------*/

	@Override
	public Canard cloneOf()
		{
		return this;
		}

	@Override
	public Canard clone()
		{
		return cloneOf();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
