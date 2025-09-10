
package ch.hearc.b_poo.f_derivation.a_specialisation.a_simple;

import ch.hearc.coursjava.moo.heritage.simple.HmTimes;

public class HmsTime extends HmTimes
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public HmsTime(int heure, int minute, int seconde)
		{
		// super c'est comme this mais fait r�f�rence � la classe parente
		super(heure, minute); // appel le constructeur dominant de la classe parente
		this.seconde = seconde;
		}

	public HmsTime(HmsTime source)
		{
		//this(source.heure, source.minute, source.seconde); // Attributs sont privés
		//this(source.getHeure(), source.getMinute(), source.getSeconde()); // Il n'y a pas de getters
		//Mus�e des horreurs ^^^^ (les deux.)

		super(source); // Hms est un Hm donc on peut déléguer le travail de copie au constructeur de copie de la classe parent
		this.seconde = source.seconde;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	// soit on fait un re-définition (on jette l'ancienne méthode), soit on fait une sur-définition (on définit au-dessus de)
	@Override // sécurité permettant au compilateur de vérifier pendant la phase de compilation qu'on ait pas fait d'erreur de frappe par exemple
	public String toString()
		{
		return super.toString() + " " + this.seconde + "s"; // super.toString() évite la récursivité et fait un branchement à la classe toString() de la classe parent
		}

	public void set(int heure, int minute, int seconde)
		{
		// V1 : Musée des horreurs parce que le super.set fait un branchement dur vers la classe parent
			{
			//			super.set(heure, minute); // branchement dur, pas bon. Ici aucun risque de récursivité.
			//			this.seconde = seconde;
			// Un branchement dur est immuable.
			// Si demain on redéfinit dans cette classe ou une classe enfant la méthode set(heure, minute),
			// le branchement en dur ci-dessus, va nous empêcher d'en bénéficier: pas bon!
			}

		// V2
			{
			set(heure, minute); // on a le droit d'utiliser les méthodes publiques héritées
			this.seconde = seconde;
			}

		// V3
			{
//			this.set(heure, minute); // même chose que set de la V2
//			this.seconde = seconde;
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Input
	private int seconde;

	}
