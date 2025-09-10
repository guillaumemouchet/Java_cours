
package ch.hearc.b_poo.f_derivation.b_generalisation.animal.mammifere;

import ch.hearc.b_poo.f_derivation.b_generalisation.animal.Mammifere;

public abstract class Rongeur extends Mammifere
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	protected Rongeur(String name)
		{
		super(name, TEMP_SANG);
		}

	protected Rongeur(Rongeur source)
		{
		super(source);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String nameHierarchie()
		{
		return super.nameHierarchie() + CLASS_SEPARATOR + Rongeur.class.getSimpleName();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final int TEMP_SANG = 33;
	}
