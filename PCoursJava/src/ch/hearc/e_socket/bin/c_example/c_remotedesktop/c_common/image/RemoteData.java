
package ch.hearc.e_socket.bin.c_example.c_remotedesktop.c_common.image;

import java.awt.Image;
import java.io.Serializable;

import ch.hearc.e_socket.bin.a_tools.image.ImageSerializable;

public class RemoteData implements Serializable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public RemoteData(ImageSerializable imageSerializable, int mouseX, int mouseY)
		{
		this.imageSerializable = imageSerializable;
		this.mouseX = mouseX;
		this.mouseY = mouseY;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("RemoteData [imageSerializable=");
		builder.append(this.imageSerializable);
		builder.append(", mouseX=");
		builder.append(this.mouseX);
		builder.append(", mouseY=");
		builder.append(this.mouseY);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public ImageSerializable getImageSerializable()
		{
		return this.imageSerializable;
		}

	public Image getImage()
		{
		return this.imageSerializable.getImage();
		}

	public int getMouseX()
		{
		return this.mouseX;
		}

	public int getMouseY()
		{
		return this.mouseY;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs/Outputs
	private ImageSerializable imageSerializable;
	private int mouseX;
	private int mouseY;
	}
