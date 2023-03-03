
package ch.arc.cours.lamda.image.d_raytracing;

import org.junit.jupiter.api.Assertions;

import ch.arc.cours.lamda.image.d_raytracing.tools.Sphere;
import ch.arc.cours.lamda.image.d_raytracing.tools.SphereCreator;
import ch.arc.cours.lamda.image.framework.image.Calcul;
import ch.arc.cours.lamda.image.framework.use.Mode;
import ch.arc.cours.lamda.image.framework.use.Player;
import ch.arc.cours.lamda.image.framework.use.SpeedUP;

public class UseRaytracing
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
		int nbSpheres = 1600;
		int w = 1200;
		int h = 720;
		Sphere[] tabSphere = SphereCreator.createSpheres(nbSpheres, w, h);

		Raytracing raytracing = new Raytracing(w, h, Calcul.STREAM_PARALLEL, tabSphere);

		long durationMS = 1000 * 10 * 4;

		Player player = new Player(raytracing, durationMS);
		player.playGUI();
		//player.playModel();
		}

	/*------------------------------*\
	|*			  SpeedUP			*|
	\*------------------------------*/

	private static void speedupModel()
		{
		int w = 1200;
		int h = 720;
		int nbSpheres = 1600;
		Sphere[] tabSphere = SphereCreator.createSpheres(nbSpheres, w, h);

		Raytracing raytracing = new Raytracing(w, h, tabSphere);

		long durationMS = 1000 * 10 * 4;

		SpeedUP.process(raytracing, durationMS, MODE);
		}

	/**
	 * speedup
	 */
	private static void speedupRendering()
		{
		int nbSpheres = 1600;
		int w = 1200;
		int h = 720;
		Sphere[] tabSphere = SphereCreator.createSpheres(nbSpheres, w, h);

		Raytracing raytracing = new Raytracing(w, h, tabSphere);

		long durationMS = 1000 * 10 * 4;

		SpeedUP.process(raytracing, durationMS, MODE);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final Mode MODE = Mode.RENDERING;//Mode.valueOf(System.getProperty("mode"));

	}
