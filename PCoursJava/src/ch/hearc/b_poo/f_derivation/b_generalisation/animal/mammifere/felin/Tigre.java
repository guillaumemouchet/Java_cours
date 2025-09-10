
package ch.hearc.b_poo.f_derivation.b_generalisation.animal.mammifere.felin;

import ch.hearc.b_poo.f_derivation.b_generalisation.animal.mammifere.Felin;

public class Tigre extends Felin
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Tigre(String name)
		{
		super(name);
		}

	public Tigre(Tigre source)
		{
		super(source);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String nameHierarchie()
		{
		return super.nameHierarchie() + CLASS_SEPARATOR + Tigre.class.getSimpleName();
		}

	@Override
	public String eat()
		{
		return " gazelle";
		}

	/*------------------------------*\
	|*				clone			*|
	\*------------------------------*/

	@Override
	public Tigre cloneOf()
		{
		return this;
		}

	@Override
	public Tigre clone()
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
