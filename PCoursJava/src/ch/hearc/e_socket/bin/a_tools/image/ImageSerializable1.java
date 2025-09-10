
package ch.hearc.e_socket.bin.a_tools.image;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class ImageSerializable1 implements Serializable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public ImageSerializable1(BufferedImage bimage)
		{
		this.imageIcon = new ImageIcon(bimage);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public Image getImage()
		{
		return imageIcon.getImage();
		}

	public BufferedImage getBimage()
		{
		Image image = imageIcon.getImage();

		BufferedImage bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
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
	private ImageIcon imageIcon;

	}