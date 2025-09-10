
package ch.hearc.e_socket.bin.a_tools.image;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ImageSerializable4 implements Serializable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public ImageSerializable4(BufferedImage bimage)
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
		return getBimage();
		}

	public BufferedImage getBimage()
		{
		BufferedImage bimage = new BufferedImage(w, h, type);

		// v1 : ko
			{
			//		WritableRaster raster = (WritableRaster)bimage.getData();
			//		raster.setPixels(0, 0, w, h, tabInt);
			}

		// v2
			{
			Raster raster = Raster.createRaster(bimage.getSampleModel(), new DataBufferInt(tabInt, w * h), null);
			bimage.setData(raster);
			}

		return bimage;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*		Serialisation			*|
	\*------------------------------*/

	private void writeObject(ObjectOutputStream oos0) throws IOException
		{
		GZIPOutputStream gzos = new GZIPOutputStream(oos0, true);
		ObjectOutputStream oos = new ObjectOutputStream(gzos);

		// w h type
			{
			oos.writeInt(w);
			oos.writeInt(h);
			oos.writeInt(type);
			}

		// tabInt
			{
			// To Byte
			ByteBuffer byteBuffer = ByteBuffer.allocate(tabInt.length * SIZE_INT);
			IntBuffer intBuffer = byteBuffer.asIntBuffer();
			intBuffer.put(tabInt);

			byte[] tabByte = byteBuffer.array();

			// header
			oos.writeInt(tabByte.length);

			// corps
			oos.write(tabByte);
			}

		oos.flush(); // utile avec GZIPOutputStream
		}

	private void readObject(ObjectInputStream ois0) throws IOException, ClassNotFoundException
		{
		GZIPInputStream gzos = new GZIPInputStream(ois0);
		ObjectInputStream ois = new ObjectInputStream(gzos);

		// w h type
			{
			this.w = ois.readInt();
			this.h = ois.readInt();
			this.type = ois.readInt();
			}

		// tabInt
			{
			// header
			int nbByte = ois.readInt();

			// corps
			byte[] tabByte = new byte[nbByte];
			ois.readFully(tabByte);

			// to Int
			ByteBuffer byteBuffer = ByteBuffer.wrap(tabByte);
			IntBuffer intBuffer = byteBuffer.asIntBuffer();

			// v1 ; ko
			//this.tabInt = intBuffer.array(); // KO

			// v2
			this.tabInt = new int[intBuffer.limit()];
			intBuffer.get(this.tabInt);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// inputs (transient inutile car custom seria)
	private transient int[] tabInt;
	private transient int w;
	private transient int h;
	private transient int type;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final int SIZE_INT = Integer.BYTES;// 4

	}
