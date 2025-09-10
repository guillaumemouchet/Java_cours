
package ch.hearc.b_poo.f_derivation.b_generalisation;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class Zoo implements Iterable<Animal>
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Zoo(String name, Animal... tabAnimals)
		{
		this.name = name;
		this.tabAnimal = tabAnimals;
		}

	public Zoo(Zoo source)
		{
		this(source.name, Zoo.clone(source.tabAnimal));
		// this(source.name, clone(source.tabAnimal));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public String eat()
		{
		final String SEPARATOR = ", ";
		StringBuilder builder = new StringBuilder();

		for(Animal animal:this)
			{
			builder.append(animal.eat()); // Liaison dynamique, comme avec cloneOf()
			builder.append(SEPARATOR);
			}

		return builder.toString();
		}

	@Override
	public String toString()
		{
		final String ENDOFLINE = "\n";
		final String TABULATION = "\t";
		StringBuilder builder = new StringBuilder();

		builder.append(this.name);
		builder.append("\nAnimals : ");

		for(Animal animal:this)
			{
			builder.append(ENDOFLINE);
			builder.append(TABULATION);
			builder.append(animal); // Liaison dynamique, comme avec cloneOf()
			}

		return builder.toString();
		}

	@Override
	public Iterator<Animal> iterator()
		{
		// v2 après les vacances
		return Arrays.asList(this.tabAnimal).iterator();
		}

	public int size()
		{
		return this.tabAnimal.length;
		}

	/*------------------------------*\
	|*				clone			*|
	\*------------------------------*/

	public Zoo cloneOf()
		{
		return new Zoo(this);
		}

	@Override
	public Zoo clone()
		{
		return this.cloneOf();
		}

	/*------------------------------*\
	|*				equals			*|
	\*------------------------------*/

	public boolean isEquals(Zoo zoo2)
		{
		if (this == zoo2)
			{
			return true;
			}
		else
			{
			if (!this.name.equals(zoo2.name))
				{
				return false;
				}
			else
				{
				if (this.size() != zoo2.size())
					{
					return false;
					}
				else
					{
					Animal[] tabCopie1 = Zoo.copieSuperficielle(this.tabAnimal);
					Animal[] tabCopie2 = Zoo.copieSuperficielle(zoo2.tabAnimal);

					Arrays.sort(tabCopie1); // Animal doit implementer Comparable<Animal>, car il faut un critere de comparaison pour pouvoir trier!
					Arrays.sort(tabCopie2); // Animal doit implementer Comparable<Animal>, car il faut un critere de comparaison pour pouvoir trier!

					return Arrays.equals(tabCopie1, tabCopie2); // marche car equals est implemente dans animal
					}
				}
			}
		}

	@Override
	public boolean equals(Object objet2)
		{
		if (this.getClass().equals(objet2.getClass()))
			{
			return this.isEquals((Zoo)objet2);
			}
		else
			{
			return false;
			}
		}

	@Override
	public int hashCode()
		{
		return Objects.hash(this.name, this.tabAnimal);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public String getName()
		{
		return this.name;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static Animal[] clone(Animal[] tabSource)
		{
		int tabLength = tabSource.length;
		Animal[] tabCopy = new Animal[tabLength];

		int i = 0;
		for(Animal animal:tabSource)
			{
			// tabCopy[i++] = animal; // Faux, car copie superficielle
			tabCopy[i++] = animal.cloneOf(); // Magique ! => Liaison dynamique
			// tabCopy[i++] = new Animal(animal); // On peut pas car Animal est abstraite, on peut pas l'instancier

			// Magique :
			// Problème : Le compilateur ne connaît pas le type effectif de l'Animal réel, se cachant par polymorphisme
			//			  dans la variable animal. Le compilateur ne connaît que le type local de la variable animal
			//			  (c'est-à-dire le type du compilateur)
			//			  Exemple : On imagine un logiciel où l'utilisateur, via un interface graphique, crée et peuple
			//			  			son Zoo. On voit ici qu'à la compilation les animaux du Zoo de cet utilisateur
			//						ne sont pas connus !

			// En langage C, lors de l'appel d'une procédure, le compilateur remplace l'appel par un JUMP suivi de
			// l'adresse de la procédure. Cette technique ne peut pas être utilisée ci-dessus avec la méthode cloneOf(),
			// car la méthode cloneOf() de Animal n'existe PAS ! Elle est ABSTRAITE !
			// Le compilateur devrait utiliser le type effectif de Animal pour faire le branchement vers la méthode cloneOf()
			// du type effectif.

			// Solution :
			// Comme le compilateur ne connaît pas le type effectif, il va remplacer le JUMP par une table
			// contenant les adresses de toutes les méthodes cloneOf() des noeuds non abstraits de la hiérarchie (souvent les
			// feuilles). La liaison définitive sera réalisée par le runtime à l'exécution du programme. Le type effectif
			// est dès lors connu, et grâce à la table laissé par le compilateur, le runtime effectue le JUMP vers la bonne
			// méthode cloneOf().

			// On appelle ça une liaison dynamique. Cette liaison coûte du temps à l'exécution. Un programme objet sera
			// donc toujours plus lent qu'un programme procédural (comme le C).
			}

		return tabCopy;
		}

	private static Animal[] copieSuperficielle(Animal[] tabSource)
		{
		Animal[] tabCopie = new Animal[tabSource.length];

		int i = 0;
		for(Animal animal:tabSource)
			{
			tabCopie[i] = animal; // copie superficielle
			i++;
			}

		return tabCopie;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// input
	private Animal[] tabAnimal;

	// input et output
	private String name;
	}
