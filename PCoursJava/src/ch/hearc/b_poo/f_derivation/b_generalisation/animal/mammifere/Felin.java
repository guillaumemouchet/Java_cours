
package ch.hearc.b_poo.f_derivation.b_generalisation.animal.mammifere;

import ch.hearc.b_poo.f_derivation.b_generalisation.animal.Mammifere;

public abstract class Felin extends Mammifere
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	protected Felin(String name)
		{
		super(name, TEMP_SANG);
		}

	protected Felin(Felin source)
		{
		super(source);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String nameHierarchie()
		{
		return super.nameHierarchie() + CLASS_SEPARATOR + Felin.class.getSimpleName();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private static final int TEMP_SANG = 36;

	}
