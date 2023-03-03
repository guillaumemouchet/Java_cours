
package ch.arc.cours.z_annexe.material;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class DomaineAgricole implements Iterable<Champ>
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public DomaineAgricole(Champ... tabChamp)
		{
		this.tabChamp = tabChamp;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public Stream<Champ> stream()
		{
		return Arrays.stream(tabChamp);
		}

	@Override
	public Iterator<Champ> iterator()
		{
		return Arrays.asList(tabChamp).iterator();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public Champ[] getTabChamp()
		{
		return this.tabChamp;
		}

	/*------------------------------*\
	|*				Is				*|
	\*------------------------------*/

	public boolean isMonoChamp()
		{
		return tabChamp.length == 1;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs/outputs
	private Champ[] tabChamp;

	}
