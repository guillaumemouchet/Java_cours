
package ch.hearc.a_kitbase.container.set.exercice;

public class UseDice
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
		useDice();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void useDice()
		{
		System.out.println("Dice : Please wait ...\n");

		int nbFace = 6;
		int nbExperience = Integer.MAX_VALUE / 1000; // Cette technique garantit de ne pas deborder le type int (Wrapper : plein de methodes utiles!)
		//int nbExperience = Integer.MAX_VALUE; // pour voir l'effet du GC dans VisualVM


		long start = System.currentTimeMillis(); // chronometre

		int nbLancerMoyen = Dice.run(nbExperience, nbFace);

		long stop=System.currentTimeMillis();	// chronometre
		long deltaMS=stop-start;				// chronometre


		System.out.println("nbFace        = " + nbFace);
		System.out.println("nbExperience  = " + nbExperience);
		System.out.println("nbLancerMoyen = " + nbLancerMoyen);
		System.out.println("deltaMS       = " + deltaMS+ " [ms]");
		}

	}
