
package ch.arc.cours.g_application.a_inalterable;

import java.util.List;

import ch.arc.cours.z_annexe.material.Joueur;

public class UseEquipe
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	/**
	 * <pre>
	 * Etape 1:	Alterable
	 *
	 * 		Implementer le TODO v0 ci-dessous, en l'état de la classe Equipe actuel (sans rien changer dans celle-ci)
	 *
	 * Etape 2:	Inalterable
	 *
	 * 		Transformer la classe Equipe pour la rendre inalterable
	 * 		Trois versions possibles!
	 *
	 * 	 	Indications:
	 * 			(I1)  Dans Equipe: mettez en commentaire getListJoueur qui rend la classe alterable
	 * 			(I2)  Dans Equipe: implementer iterable
	 * 			(I3)  Dans Equipe: implementer une methode stream retournant une stream de Joueur
	 * 			(I4)  Dans Equipe: implementer la methode getListJoueurInalterable (Collections.unmodifiableList(list)	Version 3
	 *
	 *			(I5)  Updater le code ci-dessous
	 *</pre>
	 */
	public static void main()
		{
		System.out.println("Inalterable");

		int n = 5;
		Equipe equipe = createEquipe(n);

		// Afficher le nom des joueurs
			{
			// v0 : musee de horeurs
			//				{
			//				List<Joueur> listJoueurs = equipe.getListJoueur();
			//				for(Joueur joueur : listJoueurs)
			//					{
			//					System.out.println(joueur);
			//					}
			//				}

			// v1 : iterable : why not
				{
				for(Joueur joueur:equipe)
					{
					System.out.println(joueur);
					}
				}

			// v2 : stream : best
				{
				equipe//
						.stream()//
						.map(Joueur::getName)//
						.forEach(System.out::println);
				}

			//v3 : getListJoueurInalterable : bad
				{
				List<Joueur> listJoueurs = equipe.getListJoueurInalterable();

				// Try to remove, or add , or clean
				listJoueurs.remove(0);

				// Bad version, car aucune erreur a la compilation!
				// Il faut attendre l'execution pour voir l'erreur, ce qui n'est pas satisfaisant!
				}
			}

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static Equipe createEquipe(int n)
		{
		Joueur joueur1 = new Joueur("java1");
		Joueur joueur2 = new Joueur("java2");
		Joueur joueur3 = new Joueur("java3");

		return new Equipe("He-Arc", joueur1, joueur2, joueur3); // regarder le constructeur!
		}

	}
