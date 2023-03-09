
package ch.arc.cours.lamda.image.b_rippling;

import org.junit.jupiter.api.Assertions;

import ch.arc.cours.lamda.image.framework.image.Calcul;
import ch.arc.cours.lamda.image.framework.use.Mode;
import ch.arc.cours.lamda.image.framework.use.Player;
import ch.arc.cours.lamda.image.framework.use.SpeedUP;

public class UseRippling
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
		switch(MODE)
			{
			case RENDERING:
				{
				rendering();
				break;
				}
			case SPEEDUP_MODEL:
				{
				speedupModel();
				break;
				}
			case SPEEDUP_RENDERING:
				{
				speedupRendering();
				break;
				}
			default:
				{
				Assertions.fail("not yet coded" + MODE.name());
				break;
				}
			}

		System.exit(0); // 0 normal, -1 anormal
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Rendering			*|
	\*------------------------------*/

	/**
	 * warmup
	 */
	private static void rendering()
		{
		Rippling rippling = new Rippling(800, 800, Calcul.STREAM_PARALLEL);

		long durationMS = 1000 * 10;

		Player player = new Player(rippling, durationMS);
		player.playGUI();
		//player.playModel();
		}

	/*------------------------------*\
	|*			  SpeedUP			*|
	\*------------------------------*/

	private static void speedupModel()
		{
		// Taille utile pour comparaison future avec GPU
		//
		//		int w = 16 * 60;
		//		int h = 16 * 60;

		// Taille interessante
		int w = 2500 * 6;
		int h = 3600;

		Rippling rippling = new Rippling(w, h);

		long durationMS = 1000 * 20;

		SpeedUP.process(rippling, durationMS, MODE);
		}

	private static void speedupRendering()
		{
		//int w = 16 * 60;
		//int h = 16 * 60;
		//Rippling rippling = new Rippling(w, h, fillType);

		Rippling rippling = new Rippling();

		long durationMS = 1000 * 10;

		SpeedUP.process(rippling, durationMS, MODE);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final Mode MODE = Mode.SPEEDUP_MODEL;//Mode.valueOf(System.getProperty("mode"));

	}
