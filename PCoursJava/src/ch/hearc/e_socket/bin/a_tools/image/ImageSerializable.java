


package ch.hearc.e_socket.bin.a_tools.image;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.imageio.ImageIO;

public class ImageSerializable implements Serializable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * <pre>
	 * compressionQuality01 in [01]
	 *
	 * 0 compression max
	 * 1 compression min
	 * </pre>
	 */
	public ImageSerializable(BufferedImage bimage, float compressionQuality01)
		{
		this.bimage = bimage;
		this.compressionQuality01 = compressionQuality01;
		}

	public ImageSerializable(BufferedImage bimage)
		{
		this(bimage, NO_COMPRESSION);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public BufferedImage getBimage()
		{
		return this.bimage;
		}

	public Image getImage()
		{
		return this.bimage;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*		Serialisation			*|
	\*------------------------------*/

	private void writeObject(ObjectOutputStream oos) throws IOException
		{
		//writeObjectV0(oos); 	// peu memoire rank1
		//writeObjectV1(oos); 	// peu memoire rank3

		writeObjectV2(oos);	// peu memoire rank2
		}

	private void writeObjectV0(ObjectOutputStream oos) throws IOException
		{
		ImageIO.write(this.bimage, Images.JPEG, oos); // compress? quantity?
		}

	private void writeObjectV1(ObjectOutputStream oos) throws IOException
		{
		// compression jpeg
		BufferedImage bcompress = Images.compressionJPEG(this.bimage, compressionQuality01);

		// Serialization
		ImageIO.write(bcompress, Images.JPEG, oos); // recompress? quantity?
		}

	private void writeObjectV2(ObjectOutputStream oos) throws IOException
		{
		Images.writeJPEG(oos, this.bimage, compressionQuality01);
		}

	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException
		{
		this.bimage = ImageIO.read(ois); // désérialise l'image
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// inputs
	private transient float compressionQuality01;

	// Inputs/outputs
	private transient BufferedImage bimage;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static float NO_COMPRESSION = 1;

	}

