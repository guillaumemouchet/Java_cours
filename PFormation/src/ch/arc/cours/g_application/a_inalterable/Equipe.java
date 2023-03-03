
package ch.arc.cours.g_application.a_inalterable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ch.arc.cours.z_annexe.material.Joueur;

public class Equipe implements Iterable<Joueur>
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Equipe(String name, Joueur... tabJoueur)
		{
		this.name = name;

		this.listJoueur = Arrays.stream(tabJoueur).collect(Collectors.toList());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Equipe [name=");
		builder.append(this.name);
		builder.append(", listJoueur=");
		builder.append(this.listJoueur);
		builder.append("]");
		return builder.toString();
		}

	@Override
	public Iterator<Joueur> iterator()
		{
		return listJoueur.iterator();
		}

	public Stream<Joueur> stream()
		{
		return listJoueur.stream();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public String getName()
		{
		return this.name;
		}

	public List<Joueur> getListJoueurInalterable()
		{
		return Collections.unmodifiableList(listJoueur);
		}

	/**
	 * <pre>
	 * Musee des horeurs, rend la classe alterable
	 * </pre>
	 */
	//	public List<Joueur> getListJoueur()
	//		{
	//		return this.listJoueur;
	//		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Input
	private String name;

	// Tools
	private List<Joueur> listJoueur;

	}
