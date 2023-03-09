
package ch.arc.cours.lamda.image.a_uniforme;

import org.junit.jupiter.api.Assertions;

import ch.arc.cours.lamda.image.framework.image.Calcul;
import ch.arc.cours.lamda.image.framework.use.Mode;
import ch.arc.cours.lamda.image.framework.use.Player;
import ch.arc.cours.lamda.image.framework.use.SpeedUP;

public class UseUniforme
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
		Uniforme uniforme = new Uniforme(Calcul.STREAM_PARALLEL);

		long durationMS = 1000 * 10;

		Player player = new Player(uniforme, durationMS);
		player.playGUI();
		//player.playModel();
		}

	/*------------------------------*\
	|*			  SpeedUP			*|
	\*------------------------------*/

	private static void speedupModel()
		{
		int w = 2500 * 6;
		int h = 3600;

		Uniforme uniforme = new Uniforme(w, h);

		long durationMS = 1000 * 20;

		SpeedUP.process(uniforme, durationMS, MODE);
		}

	private static void speedupRendering()
		{
		Uniforme uniforme = new Uniforme();

		long durationMS = 1000 * 10;

		SpeedUP.process(uniforme, durationMS, MODE);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final Mode MODE = Mode.SPEEDUP_MODEL;//Mode.valueOf(System.getProperty("mode"));

	}
