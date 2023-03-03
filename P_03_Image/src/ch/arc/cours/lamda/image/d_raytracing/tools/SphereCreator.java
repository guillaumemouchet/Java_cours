
package ch.arc.cours.lamda.image.d_raytracing.tools;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;

public class SphereCreator implements Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * nbSpheres >=4
	 */
	public SphereCreator(int nbSpheres, int w, int h, int bord)
		{
		Assertions.assertTrue(nbSpheres>=4);

		// Inputs
			{
			this.nbSpheres = nbSpheres;
			this.w = w;
			this.h = h;
			this.bord = bord;
			}

		// Outputs
		this.tabSphere = new Sphere[nbSpheres];
		}

	public SphereCreator(int nbSpheres, int w, int h)
		{
		this(nbSpheres, w, h, BORD);
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static Sphere[] createSpheres(int nbSpheres, int w, int h)
		{
		SphereCreator sphereCreator = new SphereCreator(nbSpheres, w, h);
		sphereCreator.run();
		return sphereCreator.getTabSphere();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		createSphereBack();
		createSphereFront();
		createAllSphereAlea();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public Sphere[] getTabSphere()
		{
		return this.tabSphere;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void createSphereBack()
		{
		Double3 centre = new Double3();

		centre.x = h / 2;
		centre.y = w / 2;
		centre.z = ZMAX * 2; // plus grand que ZMAX

		double rayon = Math.min(w / 2, h / 2);
		float hue01 = 1;

		tabSphere[0] = new Sphere(centre, rayon, hue01);
		}

	private void createSphereFront()
		{
		float hue01 = 1;
		double rayon = Math.min(w / 10, h / 10); // disons
		double z = ZMIN - (rayon + rayonMax());

		float dhue = 0.2f;
		double dz = 40;
		double drayon = dz / 2;

		for(int i = nbSpheres - 3; i < nbSpheres; i++)
			{
			Double3 centre = new Double3();

			z -= dz;
			rayon -= drayon;
			hue01 -= dhue;

			centre.x = h / 2;
			centre.y = w / 2;
			centre.z = z;

			tabSphere[i] = new Sphere(centre, rayon, hue01);
			}
		}

	private void createAllSphereAlea()
		{
		IntStream.range(1, nbSpheres - 3).parallel().forEach(i -> tabSphere[i] = createOneSphereAlea());
		}

	private Sphere createOneSphereAlea()
		{
		ThreadLocalRandom random01 = ThreadLocalRandom.current();

		Double3 centre = new Double3();

		centre.x = random01.nextDouble(0 + bord, h - bord);
		centre.y = random01.nextDouble(0 + bord, w - bord);
		centre.z = random01.nextDouble(ZMIN, ZMAX);

		double rayon = random01.nextDouble(20, rayonMax());
		float hue01 = random01.nextFloat();

		return new Sphere(centre, rayon, hue01);
		}

	private int rayonMax()
		{
		return w / 10;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private int nbSpheres;
	private int w;
	private int h;
	private int bord;

	// Outputs
	private Sphere[] tabSphere;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final int BORD = 200;
	private static final int ZMIN = 2000;
	private static final int ZMAX = 3000;

	}
