
package ch.hearc.e_socket.bin.a_tools.image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public class Images
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * <pre>
	 * compressionQuality01 in [01]
	 *
	 * 0 compression max
	 * 1 compression min
	 * </pre>
	 */
	public static BufferedImage compressionJPEG(BufferedImage bimage, float compressionQuality01) throws IOException
		{
		ImageWriter imagewriter = ImageIO.getImageWritersByFormatName(JPEG).next();

		// Settings
		ImageWriteParam settings = imagewriter.getDefaultWriteParam();
		settings.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		settings.setCompressionQuality(compressionQuality01);

		// Flux
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageOutputStream ios = ImageIO.createImageOutputStream(baos);
		imagewriter.setOutput(ios);
		imagewriter.write(null, new IIOImage(bimage, null, null), settings);

		byte[] tabBytes = baos.toByteArray();

		ios.close();
		baos.close();

		return ImageIO.read(new ByteArrayInputStream(tabBytes));
		}

	public static void writeJPEG(OutputStream os, BufferedImage bimage, float compressionQuality01) throws IOException
		{
		ImageWriter imagewriter = ImageIO.getImageWritersByFormatName(JPEG).next();

		// Settings
		ImageWriteParam settings = imagewriter.getDefaultWriteParam();
		settings.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		settings.setCompressionQuality(compressionQuality01);

		// Flux
		ImageOutputStream ios = ImageIO.createImageOutputStream(os);
		imagewriter.setOutput(ios);
		imagewriter.write(null, new IIOImage(bimage, null, null), settings);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static final String JPEG = "jpeg";

	}
