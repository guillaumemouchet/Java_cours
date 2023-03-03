
package ch.arc.cours.lamda.image.c_mandelbrot;

import org.junit.jupiter.api.Assertions;

import ch.arc.cours.lamda.image.c_mandelbrot.tools.IntervalInt;
import ch.arc.cours.lamda.image.framework.image.Calcul;
import ch.arc.cours.lamda.image.framework.use.Mode;
import ch.arc.cours.lamda.image.framework.use.Player;
import ch.arc.cours.lamda.image.framework.use.SpeedUP;

public class UseMandelbrot
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
		IntervalInt intervalN = new IntervalInt(20, 100);

		Mandelbrot mandelbrot = new Mandelbrot(Calcul.STREAM_PARALLEL, intervalN);

		long durationMS = 1000 * 10 * 2;

		Player player = new Player(mandelbrot, durationMS);
		player.playGUI();
		//player.playModel();
		}

	/*------------------------------*\
	|*			  SpeedUP			*|
	\*------------------------------*/

	private static void speedupModel()
		{
		int w = 2500 * 4;
		int h = 3600;

		IntervalInt intervalN = new IntervalInt(60, 60);

		Mandelbrot mandelbrot = new Mandelbrot(w, h, intervalN);

		long durationMS = 1000 * 20;

		SpeedUP.process(mandelbrot, durationMS, MODE);
		}

	private static void speedupRendering()
		{
		int w = 1920;
		int h = 1200;

		IntervalInt intervalN = new IntervalInt(20, 100); // speedup varie selon la valeur de n, car plus n est grand plus les calculs sont long!

		Mandelbrot mandelbrot = new Mandelbrot(w, h, intervalN);

		long durationMS = 1000 * 10;

		SpeedUP.process(mandelbrot, durationMS, MODE);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final Mode MODE = Mode.RENDERING;//Mode.valueOf(System.getProperty("mode"));

	}
