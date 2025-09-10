
package ch.hearc.e_socket.bin.c_example.c_remotedesktop.c_common.image;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ch.hearc.e_socket.bin.a_tools.image.ImageSerializable;
import ch.hearc.e_socket.bin.b_api.tools.serialization.Serializeur;
import ch.hearc.e_socket.bin.b_api.tools.serialization.SerializeurGZIP;
import ch.hearc.e_socket.bin.b_api.tools.serialization.Serializeur_I;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.d_tools.ScreenService;

public class TestRemoteData
	{

	/*------------------------------------------------------------------*\
	 |*							Methodes Public							*|
	 \*-----------------------------------------------------------------*/

	@Test
	public void testSerialization() throws ClassNotFoundException, IOException
		{
		Serializeur_I<RemoteData> serializeur = new Serializeur<RemoteData>();

		int x = 10;
		int y = 100;

		final int N = 20;
		for(int i = 0; i < N; i++)
			{
			BufferedImage bimage = ScreenService.getInstance().getImage();
			ImageSerializable simage = new ImageSerializable(bimage);

			RemoteData remoteData = new RemoteData(simage, x, y);

			RemoteData remoteDataClone = serializeur.clone(remoteData);

			Assertions.assertNotNull(remoteDataClone);
			Assertions.assertNotNull(remoteDataClone.getImage());
			Assertions.assertNotNull(remoteDataClone.getImageSerializable());

			Assertions.assertEquals(x, remoteDataClone.getMouseX());
			Assertions.assertEquals(y, remoteDataClone.getMouseY());

			Assertions.assertEquals(bimage.getHeight(), remoteDataClone.getImage().getHeight(null));
			Assertions.assertEquals(bimage.getWidth(), remoteDataClone.getImage().getWidth(null));
			}
		}

	@Test
	public void testSerializationGZIP() throws ClassNotFoundException, IOException
		{
		Serializeur_I<RemoteData> serializeur = new SerializeurGZIP<RemoteData>();

		int x = 10;
		int y = 100;

		final int N = 20;
		for(int i = 0; i < N; i++)
			{
			BufferedImage bimage = ScreenService.getInstance().getImage();
			ImageSerializable simage = new ImageSerializable(bimage);

			RemoteData remoteData = new RemoteData(simage, x, y);

			RemoteData remoteDataClone = serializeur.clone(remoteData);

			Assertions.assertNotNull(remoteDataClone);
			Assertions.assertNotNull(remoteDataClone.getImage());
			Assertions.assertNotNull(remoteDataClone.getImageSerializable());

			Assertions.assertEquals(x, remoteDataClone.getMouseX());
			Assertions.assertEquals(y, remoteDataClone.getMouseY());

			Assertions.assertEquals(bimage.getHeight(), remoteDataClone.getImage().getHeight(null));
			Assertions.assertEquals(bimage.getWidth(), remoteDataClone.getImage().getWidth(null));
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
