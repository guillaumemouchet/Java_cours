
package ch.hearc.b_poo.b_full.a_garage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Garage implements Iterable<Voiture>
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Garage(String nom)
		{
		//input
		this.nom = nom;

		//tools
		this.listVoitures = new LinkedList<Voiture>();
		}

	/**
	 * Constructeur de copie
	 */
	public Garage(Garage garageSource)
		{
		this(garageSource.nom); // Copie superficielle de nom autorisée car la classe String est inaltérable.
		//marque est partagé entre la source et la copie, pas grave car la String nom contiendra toujours le même contrenu jusqu'à la fin du programme.
		//C'est donc inutile d'avoir plusieurs fois cette même data en mémoire

		//		for(Voiture voitureSource:garageSource.listVoitures)
		for(Voiture voitureSource:garageSource) // possible car Garage implement Iteravable<Voiture>
			{
			// V1 : FAUX
				{
				// this.listVoitures.add(voitureSource);

				// voiture est partagé entre le garage source et le garage copie,
				// ce qui est interdit car voiture est inaltérable pour le moment, certes,
				// mais pourrait devneir altérable demain sans que l'on ne le sache
				// fausse bonne optimisation!
				}

			// V2 : PAS OPTIMUM
				{
				// Voiture voitureCopie = new Voiture(voitureSource);

				// On appelle le constructeur de copie de la voiture, donc la voiture est copiée
				// mais ne n'utilise aucune optimisation si la classe Voiture est inaltérable
				}

			// V3 : BEST
			Voiture voitureCopie = voitureSource.cloneOf();
			// delegue la responsabiliter du clone a la classe Voiture, logique!,
			// qui est-elle seule sait si la classe voiture est inlatérable ou non et faire les optimisations nécessaires

			this.listVoitures.add(voitureCopie);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();

		builder.append("Nom : ");
		builder.append(this.nom);
		builder.append("\n");

		//for(Voiture voiture:this.listVoitures)
		for(Voiture voiture:this) // possible car Garage implements Iterable<Voiture>
			{
			builder.append("\t");
			builder.append(voiture);
			builder.append("\n");
			}

		return builder.toString();
		}

	@Override
	public Iterator<Voiture> iterator()
		{
		return this.listVoitures.iterator();
		}

	public int size()
		{
		return this.listVoitures.size();
		}

	public void in(Voiture... tabVoiture)
		{
		//V1
			{
//			for(Voiture voiture:tabVoiture)
//				{
//				this.listVoitures.add(voiture);
//				}
			}

		//V2
			{
			this.listVoitures.addAll(Arrays.asList(tabVoiture));
			}
		}

	public boolean out(Voiture voiture)
		{
		return listVoitures.remove(voiture);
		}

	/*------------------------------*\
	|*				clone			*|
	\*------------------------------*/

	public Garage cloneOf()
		{
		return new Garage(this);
		}

	@Override
	public Garage clone()
		{
		return this.cloneOf();
		}

	/*------------------------------*\
	|*				equals			*|
	\*------------------------------*/

	/**
	 * <pre>
	 * but : comparaison de contenu!
	 * Warning: independament de l'orde des voitures
	 * </pre>
	 */
	public boolean isEquals(Garage garage2)
		{
		if (this == garage2) // le contenu est forcement le meme!
			{
			return true;
			}
		else
			{
			//if (this.nom !=garage2.nom) // comparaison de reference! Faux!
			if (!this.nom.equals(garage2.nom)) // comparaison de contenu!
				{
				return false;
				}
			else if (this.size() != garage2.size())
				{
				return false;
				}
			else
				{
				List<Voiture> list1 = copySuperficialVoitures(this.listVoitures); // superfical suffit !
				List<Voiture> list2 = copySuperficialVoitures(garage2.listVoitures); // superfical suffit !

				Collections.sort(list1); // in place, possible car Voiture implements Comparable<Voiture>
				Collections.sort(list2); // in place, possible car Voiture implements Comparable<Voiture>

				// on a copier les list, car on va les trier,
				// et on ne veut pas changer l'odre original des voitures dans les garages!

				Iterator<Voiture> it1 = list1.iterator();
				Iterator<Voiture> it2 = list2.iterator();

				while(it1.hasNext())
					{
					Voiture voiture1 = it1.next();
					Voiture voiture2 = it2.next();

					//if(!voiture1.equals(voiture2)) // on tremble
					if (!voiture1.isEquals(voiture2)) // on est sure!
						{ return false; }
					}

				return true;
				}
			}
		}

	@Override
	public boolean equals(Object obj2)
		{
		//if (obj2 instanceof Garage) //  light mais marche pas dans les hiérarchie de classes
		//if (obj2.getClass().getName().equals(Garage.class.getName()))
		//if (obj2.getClass().equals(Garage.class)) //idem ci-dessus, plus light

		if (obj2.getClass().equals(this.getClass())) //marche  dans les hiérarchie de classes
			{
			return isEquals((Garage)obj2);
			}
		else
			{
			return false;
			}
		}


	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * </pre>
	 * deep list
	 * superficial voiture
	 * <pre>
	 */
	private static List<Voiture> copySuperficialVoitures(List<Voiture> listeVoitureSource)
		{
		List<Voiture> listVoituresCopy = new ArrayList<Voiture>(listeVoitureSource.size());

		for(Voiture voiture:listeVoitureSource)
			{
			listVoituresCopy.add(voiture); // copie superficielle
			}

		return listVoituresCopy;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//input
	private String nom;

	//tools
	private List<Voiture> listVoitures;

	}
