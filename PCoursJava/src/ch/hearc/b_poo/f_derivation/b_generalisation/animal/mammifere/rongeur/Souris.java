
package ch.hearc.b_poo.f_derivation.b_generalisation.animal.mammifere.rongeur;

import ch.hearc.b_poo.f_derivation.b_generalisation.animal.mammifere.Rongeur;

public class Souris extends Rongeur
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Souris(String name)
		{
		super(name);
		}

	public Souris(Souris source)
		{
		super(source);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String eat()
		{
		return "cheese";
		}

	@Override
	public String nameHierarchie()
		{
		return super.nameHierarchie() + CLASS_SEPARATOR + Souris.class.getSimpleName();
		}

	/*------------------------------*\
	|*				clone			*|
	\*------------------------------*/

	@Override
	public Souris cloneOf()
		{
		return this;
		}

	@Override
	public Souris clone()
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
