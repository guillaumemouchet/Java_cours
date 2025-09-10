
package ch.hearc.e_socket.bin.c_example.c_remotedesktop.c_common.mouse;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ch.hearc.e_socket.bin.b_api.tools.serialization.Serializeur;
import ch.hearc.e_socket.bin.b_api.tools.serialization.SerializeurGZIP;
import ch.hearc.e_socket.bin.b_api.tools.serialization.Serializeur_I;

public class TestMouseAction
	{

	/*------------------------------------------------------------------*\
	 |*							Methodes Public							*|
	 \*-----------------------------------------------------------------*/

	@Test
	public void testSerialization() throws ClassNotFoundException, IOException
		{
		Serializeur_I<MouseAction> serializeur = new Serializeur<MouseAction>();

		for(ClickType clickType:ClickType.values())
			{
			MouseAction mouseAction = new MouseAction(clickType);

			MouseAction mouseActionClone = serializeur.clone(mouseAction);

			Assertions.assertEquals(mouseAction, mouseActionClone);

			//			System.out.println(mouseAction);
			//			System.out.println(mouseActionClone);
			}
		}

	@Test
	public void testSerializationGZIP() throws ClassNotFoundException, IOException
		{
		Serializeur_I<MouseAction> serializeur = new SerializeurGZIP<MouseAction>();

		for(ClickType clickType:ClickType.values())
			{
			MouseAction mouseAction = new MouseAction(clickType);

			MouseAction mouseActionClone = serializeur.clone(mouseAction);

			Assertions.assertEquals(mouseAction, mouseActionClone);

			//			System.out.println(mouseAction);
			//			System.out.println(mouseActionClone);
			}
		}

	@Test
	public void testSerializationMove() throws ClassNotFoundException, IOException
		{
		int dx = 23;
		int dy = 17;

		MouseAction mouseAction = new MouseAction(dx, dy);

		Serializeur_I<MouseAction> serializeur = new Serializeur<MouseAction>();

		MouseAction mouseActionClone = serializeur.clone(mouseAction);

		Assertions.assertEquals(mouseAction, mouseActionClone);

		//					System.out.println(mouseAction);
		//					System.out.println(mouseActionClone);
		}

	@Test
	public void testSerializationGZIPMove() throws ClassNotFoundException, IOException
		{
		int dx = 24;
		int dy = 18;

		MouseAction mouseAction = new MouseAction(dx, dy);

		Serializeur_I<MouseAction> serializeur = new SerializeurGZIP<MouseAction>();

		MouseAction mouseActionClone = serializeur.clone(mouseAction);

		Assertions.assertEquals(mouseAction, mouseActionClone);

		//					System.out.println(mouseAction);
		//					System.out.println(mouseActionClone);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
