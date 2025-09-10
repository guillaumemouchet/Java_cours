
package ch.hearc.b_poo.b_full.b_hashcode.juste;

public class UBSJuste
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public UBSJuste(int montant)
		{
		this.montant = montant;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("UBSFaux [montant=");
		builder.append(this.montant);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------*\
	|*				equals			*|
	\*------------------------------*/

	public boolean isEquals(UBSJuste ubs2)
		{
		if (this == ubs2)
			{
			return true;
			}
		else
			{
			return this.montant == ubs2.montant;
			}
		}

	@Override
	public boolean equals(Object object2)
		{
		if (object2.getClass().equals(this.getClass()))
			{
			return this.isEquals((UBSJuste)object2);
			}
		else
			{
			return false;
			}
		}

	/**
	* use dans HashMap/HashSet/HashXXX
	*/
	@Override
	public int hashCode()
		{
		// Rappel :
		//		(R1) 	hashcode : identificant si possible unique, mais pas necessairement (unciter meilleur! donc chercher si possible l'uniciter)
		//		(R2) 	a.equals(b) => a.hashcode()==b.hashcode()	(mais pas reciproque)
		//
		//		Autrement dit : Deux objets egaux doivent avoir meme hashcode,
		//						mais deux objets ayant meme hashcode ne sont pas forcement egaux

		// Tip : return Objects.hash(attribut1, attribut2,...);

		return this.montant;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//inputs
	private int montant;

	}
