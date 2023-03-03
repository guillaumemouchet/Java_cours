
package ch.arc.cours.lamda.image.framework.image;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;

import org.junit.jupiter.api.Assertions;

import ch.arc.cours.lamda.image.framework.animation.Animable_I;
import ch.arc.tools.Chrono;

public abstract class BImage extends BufferedImage implements Animable_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public BImage(int w, int h, String title, Calcul fillType)
		{
		super(w, h, BufferedImage.TYPE_INT_ARGB);

		// Inputs
			{
			this.title = title;
			this.w = w;
			this.h = h;
			this.fillType = fillType;
			}

		// Tools
			{
			// v1
				{
				//this.tabPixels = new int[w * h];
				}

			// v2
				{
				DataBuffer buffer = this.getRaster().getDataBuffer();
				DataBufferInt bufferInt = (DataBufferInt)buffer;
				this.tabPixels = bufferInt.getData();
				}
			}

		}

	public BImage(Dimension dim, String title, Calcul fillType)
		{
		this(dim.width, dim.height, title, fillType);
		}

	public BImage(String title, Calcul fillType)
		{
		this(Toolkit.getDefaultToolkit().getScreenSize(), title, fillType);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Abstract						*|
	\*------------------------------------------------------------------*/

	protected abstract void fillStandard();

	protected abstract void fillStreamParallel();

	protected abstract void fillStreamSequentiel();

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public long animationStep(long iteration)
		{
		Chrono chrono = new Chrono();
		fill();
		chrono.stop();
		return chrono.getTimeMS();
		}

	@Override
	public String toString()
		{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(title);
		stringBuilder.append(" : (w,h)=(");
		stringBuilder.append(getWidth());
		stringBuilder.append(",");
		stringBuilder.append(getHeight());
		stringBuilder.append(") : ");
		stringBuilder.append(fillType);
		return stringBuilder.toString();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public String getTitle()
		{
		return this.title;
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void set(Calcul fillType)
		{
		this.fillType = fillType;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void fill()
		{
		switch(fillType)
			{
			case STANDARD:
				{
				fillStandard();
				break;
				}
			case STREAM_PARALLEL:
				{
				fillStreamParallel();
				break;
				}
			case STREAM_SEQUENTIAL:
				{
				fillStreamSequentiel();
				break;
				}
			default:
				{
				Assertions.fail();
				break;
				}
			}

		// v1 (plus besoin avec la v2 du constructeur
			{
			//setRGB(0, 0, w, h, tabPixels, 0, w);// TODO ralentit le mode parallel! why? thread travaille pas à 100%
			}

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	protected int w;
	protected int h;

	private String title;
	private Calcul fillType;

	// Tools
	protected int[] tabPixels;

	}
