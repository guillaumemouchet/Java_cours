
package ch.arc.cours.lamda.algo.c_dice;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class DiceExperience implements Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public DiceExperience(int nbFace)
		{
		// Input
		this.nbFace = nbFace;

		// Output
		this.nbLancer = 0;

		// Tools
		this.setFaceObtenu = new HashSet<Integer>(nbFace);
		}

	public DiceExperience()
		{
		this(6);
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static int nbLancer(int nbFace)
		{

		// instancier
		DiceExperience dice = new DiceExperience(nbFace);
		// runner
		dice.run();
		// exporter resultat
		return dice.nbLancer;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		nbLancer = 0;
		setFaceObtenu.clear();

		while(setFaceObtenu.size() != nbFace)
			{
			setFaceObtenu.add(ThreadLocalRandom.current().nextInt(nbFace));
			nbLancer++;
			}
		// contrainte : use ThreadLocalRandom
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public int getNbLancer()
		{
		return this.nbLancer;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Input
	private int nbFace;

	// output
	private int nbLancer;

	// Tools
	private Set<Integer> setFaceObtenu;

	}
