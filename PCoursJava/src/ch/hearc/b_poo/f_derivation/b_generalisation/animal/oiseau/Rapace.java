
package ch.hearc.b_poo.f_derivation.b_generalisation.animal.oiseau;

import ch.hearc.b_poo.f_derivation.b_generalisation.animal.Oiseau;

public class Rapace extends Oiseau
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Rapace(String name, int nbPlumes)
		{
		super(name, nbPlumes);
		}

	public Rapace(Rapace source)
		{
		super(source);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String nameHierarchie()
		{
		return super.nameHierarchie() + CLASS_SEPARATOR + Rapace.class.getSimpleName();
		}

	@Override
	public String eat()
		{
		return "marmot";
		}

	/*------------------------------*\
	|*				clone			*|
	\*------------------------------*/

	@Override
	public Rapace cloneOf()
		{
		return this;
		}

	@Override
	public Rapace clone()
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
