
package ch.arc.cours.lamda.image.d_raytracing;

import java.awt.Color;
import java.awt.Dimension;
import java.util.stream.IntStream;

import ch.arc.cours.lamda.image.d_raytracing.tools.Double2;
import ch.arc.cours.lamda.image.d_raytracing.tools.Sphere;
import ch.arc.cours.lamda.image.framework.image.BImage;
import ch.arc.cours.lamda.image.framework.image.Calcul;

public class Raytracing extends BImage // BImage give acces to tabPixel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Raytracing(Dimension dim, Calcul fillType, Sphere[] tabSphere)
		{
		super(dim, "Raytracing", fillType);

		// Input
			{
			this.tabSphere = tabSphere;
			}

		// Tools
			{
			this.t = 0;
			this.lineMode = false;
			}
		}

	public Raytracing(int w, int h, Calcul fillType, Sphere[] tabSphere)
		{
		this(new Dimension(w, h), fillType, tabSphere);
		}

	public Raytracing(int w, int h, Sphere[] tabSphere)
		{
		this(w, h, Calcul.STREAM_PARALLEL, tabSphere);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public long animationStep(long iteration)
		{
		this.t += DT;
		return super.animationStep(iteration);
		}

	/*------------------------------*\
	|*			  Standard			*|
	\*------------------------------*/

	@Override
	protected void fillStandard()
		{
		if (lineMode)
			{
			for(int i = 0; i < h; i++)
				{
				colorLineI(i);
				}
			}
		else
			{
			for(int j = 0; j < w; j++)// Colonnes
				{
				colorLineJ(j);
				}
			}
		}

	/*------------------------------*\
	|*			  Stream			*|
	\*------------------------------*/

	@Override
	protected void fillStreamSequentiel()
		{
		if (lineMode)
			{
			IntStream.range(0, this.h).forEach(this::colorLineI);
			}
		else
			{
			IntStream.range(0, this.w).forEach(this::colorLineJ);
			}

		}

	@Override
	protected void fillStreamParallel()
		{
		if (lineMode)
			{
			IntStream.range(0, this.h).parallel().forEach(this::colorLineI);
			}
		else
			{
			IntStream.range(0, this.w).parallel().forEach(this::colorLineJ);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	private void colorLineI(int i)
		{
		IntStream.range(0, w).forEach(j -> tabPixels[i * w + j] = this.rgb(i, j));
		}

	private void colorLineJ(int j)
		{
		IntStream.range(0, h).forEach(i -> tabPixels[i * w + j] = this.rgb(i, j));

		}
	/*------------------------------*\
	|*			  Algo				*|
	\*------------------------------*/

	/**
	 * <pre>
	 * Fournit la couleur du pixel (i,j)
	 *
	 * 		i = ligne in [0,h[
	 * 		j = colonne in [0,w[
	 *
	 * Format :
	 *
	 * 		"int rgb"
	 * 		ie 4 octet, avec un octet pour chaque cannal couleur (R G B A)
	 *
	 * </pre>
	 */
	private int rgb(int i, int j)
		{
		Double2 xySol = new Double2(i, j);

		Sphere closeSphere = null;
		double minDZ = 0;
		double minDistance = Double.MAX_VALUE;
		for(Sphere sphere:tabSphere)
			{
			double hCarre = sphere.hCarre(xySol);
			if (sphere.isEnDessous(hCarre))
				{
				double dz = sphere.dz(hCarre);
				double distance = sphere.distance(dz);
				if (distance < minDistance)
					{
					minDistance = distance;
					closeSphere = sphere;
					minDZ = dz;
					}
				}
			}

		if (closeSphere == null)
			{ return BLACK; }

		float brightness = closeSphere.brightness(minDZ); //Closest
		float hue = closeSphere.hue(t);

		int color = Color.HSBtoRGB(hue, 1, brightness);
		// Sequence des elements a appeler:
		//				h2 (nCarrer)
		//  			isEndessous
		//  			dz
		//  			distance
		//  			brightnes

		return color;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private Sphere[] tabSphere;

	// Tools
	private float t;
	private boolean lineMode = true;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final float DT = (float)(2 * Math.PI / 100);
	private static final int BLACK = Color.BLACK.getRGB();

	}
