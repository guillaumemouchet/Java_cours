
package ch.hearc.e_socket.bin.a_tools.image;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
import java.io.Serializable;

public class ImageSerializable3 implements Serializable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public ImageSerializable3(BufferedImage bimage)
		{
		// simple
			{
			this.w = bimage.getWidth();
			this.h = bimage.getHeight();
			this.type = bimage.getType();
			}

		// tabByte
			{
			Raster raster = bimage.getData();
			DataBufferInt bufferInt = (DataBufferInt)raster.getDataBuffer();
			this.tabInt = bufferInt.getData();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public Image getImage()
		{
		return getBimage();
		}

	public BufferedImage getBimage()
		{
		BufferedImage bimage = new BufferedImage(w, h, type);

		// v1 : ko exception
		//	{
		//	WritableRaster raster = (WritableRaster)bimage.getData();
		//		System.out.println(raster.getDataBuffer().getSize());
		//		System.out.println(w*h);
		//		System.out.println(tabInt.length);
		//raster.setPixels(0, 0, w, h, tabInt); // ko
		//	}

		// v2 : ko noir
		//			{
		//			WritableRaster raster = (WritableRaster)bimage.getData();
		//			DataBufferInt bufferInt = (DataBufferInt)raster.getDataBuffer();
		//			int[] tabIntBimage = bufferInt.getData();
		//			System.arraycopy(this.tabInt, 0, tabIntBimage, 0, this.tabInt.length); //  tabIntBimage <- tabInt
		//			}

		// v3
			{
			Raster raster = Raster.createRaster(bimage.getSampleModel(), new DataBufferInt(tabInt, w * h), null);
			bimage.setData(raster);
			}

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
