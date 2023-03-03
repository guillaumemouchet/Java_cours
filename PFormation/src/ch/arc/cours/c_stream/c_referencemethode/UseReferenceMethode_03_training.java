
package ch.arc.cours.c_stream.c_referencemethode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import ch.arc.cours.z_annexe.material.Joueur;
import ch.arc.tools.stream.Streams;

public class UseReferenceMethode_03_training
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		System.out.println("reference methode : training 1");

		list();
		array();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * Construire une list de joueur depuis un tableau de nom
	 */
	private static void list()
		{
		String[] tabName = { "bob", "marc", "alice", "claire" };

		// reference methode si possible
			{
			List<Joueur> listJoueur = Arrays//
					.stream(tabName)//
					.map(Joueur::new)//
					.collect(Collectors.toList());

			incrementerGain(listJoueur, 99);
			System.out.println(listJoueur);
			}
		}

	/**
	 * Construire un tableau de joueur depuis un tableau de nom
	 */
	private static void array()
		{
		String[] tabName = { "bob", "marc", "alice", "claire" };

		// reference methode si possible
			{
			Joueur[] tabJoueur = Arrays//
					.stream(tabName)//
					.map(Joueur::new)//
					.toArray(Joueur[]::new);

			incrementerGain(Arrays.asList(tabJoueur), 99);
			System.out.println(Arrays.toString(tabJoueur));
			}
		}

	/*------------------------------*\
	|*			  Tools				*|
	\*------------------------------*/

	/**
	 * incremente le gain de chaque joueur par l'input gain
	 */
	private static void incrementerGain(Iterable<Joueur> iterableJoueur, int gain)
		{
		// Contraintes: en parallel!

		// Indication : Streams
		Streams//
				.parallelStream(iterableJoueur)//
				.forEach(j -> j.incrementerGain(gain));
		}

	}
