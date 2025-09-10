
package ch.hearc.b_poo.f_derivation.b_generalisation.animal.mammifere.felin;

import ch.hearc.b_poo.f_derivation.b_generalisation.animal.mammifere.Felin;

public class Chat extends Felin
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Chat(String name)
		{
		super(name);
		}

	public Chat(Chat source)
		{
		super(source);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String nameHierarchie()
		{
		return super.nameHierarchie() + CLASS_SEPARATOR + Chat.class.getSimpleName();
		}

	@Override
	public String eat()
		{
		return " mouse";
		}

	/*------------------------------*\
	|*				clone			*|
	\*------------------------------*/

	@Override
	public Chat cloneOf()
		{
		return this;
		}

	@Override
	public Chat clone()
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
