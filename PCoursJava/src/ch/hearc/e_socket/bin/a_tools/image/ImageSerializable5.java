
package ch.hearc.e_socket.bin.a_tools.image;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.MemoryImageSource;
import java.awt.image.Raster;
import java.io.Serializable;

public class ImageSerializable5 implements Serializable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public ImageSerializable5(BufferedImage bimage)
		{
		Raster raster = bimage.getData();
		DataBufferInt buffer = (DataBufferInt)raster.getDataBuffer();
		this.tabInt = buffer.getData();

		this.w = bimage.getWidth();
		this.h = bimage.getHeight();
		this.type = bimage.getType();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public Image getImage()
		{
		MemoryImageSource memoryImageSource = new MemoryImageSource(w, h, tabInt, 0, w);

		return Toolkit.getDefaultToolkit().createImage(memoryImageSource);
		}

	public BufferedImage getBimage()
		{
		Image image = getImage();

		BufferedImage bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
		Graphics2D g2d = bimage.createGraphics();
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();

		return bimage;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// inputs
	private int[] tabInt;
	private int w;
	private int h;
	private int type;

	}
