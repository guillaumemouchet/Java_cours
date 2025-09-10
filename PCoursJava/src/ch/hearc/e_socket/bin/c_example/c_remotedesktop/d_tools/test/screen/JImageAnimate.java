
package ch.hearc.e_socket.bin.c_example.c_remotedesktop.d_tools.test.screen;

import java.awt.image.BufferedImage;
import java.io.IOException;

import ch.hearc.c_gui.tools.decorateur.jimage.JImage;
import ch.hearc.c_gui.tools.decorateur.jimage.TypeRendering;
import ch.hearc.e_socket.bin.a_tools.image.ImageSerializable;
import ch.hearc.e_socket.bin.b_api.tools.serialization.Serializeur;
import ch.hearc.e_socket.bin.b_api.tools.serialization.Serializeur_I;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.d_tools.ScreenService;

public class JImageAnimate extends JImage
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JImageAnimate()
		{
		super(TypeRendering.KEEP_RATIO);

		new Thread(createRunnable()).start();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private Runnable createRunnable()
		{
		return new Runnable()
			{

			@Override
			public void run()
				{
				while(true)
					{
					try
						{
						BufferedImage bimage = ScreenService.getInstance().getImage();

						// incluons une serialization/deserialization comme se sera le cas sur le socket
						ImageSerializable imageSerializable = new ImageSerializable(bimage);
						ImageSerializable imageSerializableClone = serializeur.clone(imageSerializable);
						BufferedImage bimageClone = imageSerializableClone.getBimage();

						update(bimageClone);
						}
					catch (ClassNotFoundException | IOException e)
						{
						e.printStackTrace();
						}
					}

				}

			private Serializeur_I<ImageSerializable> serializeur = new Serializeur<ImageSerializable>();
			};
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
