
package ch.arc.cours.lamda.image.a_uniforme;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.stream.IntStream;

import ch.arc.cours.lamda.image.framework.image.BImage;
import ch.arc.cours.lamda.image.framework.image.Calcul;

/**
 * warm up
 */
public class Uniforme extends BImage
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Uniforme(Dimension dim, Calcul fillType)
		{
		super(dim, "Uniforme", fillType);

		// Tools
			{
			this.levelGray = 0;
			}
		}

	public Uniforme(int w, int h, Calcul fillType)
		{
		this(new Dimension(w, h), fillType);
		}

	public Uniforme(int w, int h)
		{
		this(w,h, Calcul.STREAM_PARALLEL);
		}

	public Uniforme(Calcul fillType)
		{
		this(Toolkit.getDefaultToolkit().getScreenSize(), fillType);
		}

	public Uniforme()
		{
		this(Calcul.STREAM_PARALLEL);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public long animationStep(long iteration)
		{
		this.levelGray = (levelGray + 1) % 255;

		return super.animationStep(iteration);
		}

	/*------------------------------*\
	|*			  Standard			*|
	\*------------------------------*/

	@Override
	protected void fillStandard()
		{
		final int rgb = rgb(levelGray); // le meme pour toute l'image uniforme

		for(int i = 0; i < h; i++)// lignes
			{
			colorLineI(i, rgb);
			}
		}

	/*------------------------------*\
	|*			  Stream			*|
	\*------------------------------*/

	@Override
	protected void fillStreamSequentiel()
		{
		final int rgb = rgb(levelGray); // le meme pour toute l'image uniforme

		IntStream.range(0, h).forEach(i -> colorLineI(i, rgb));
		}

	@Override
	protected void fillStreamParallel()
		{
		final int rgb = rgb(levelGray); // le meme pour toute l'image uniforme

		IntStream.range(0, h).parallel().forEach(i -> colorLineI(i, rgb));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void colorLineI(int i, int rgb)
		{
		for(int j = 0; j < w; j++)// colonnes
			{
			tabPixels[i * w + j] = rgb;
			}
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static int rgb(int levelGray)
		{
		return new Color(levelGray, levelGray, levelGray).getRGB();
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private int levelGray;
	}
