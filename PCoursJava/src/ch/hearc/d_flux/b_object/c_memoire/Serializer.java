
package ch.hearc.d_flux.b_object.c_memoire;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serializer
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static byte[] serialize(Serializable serializable) throws IOException
		{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);

		oos.writeObject(serializable);

		oos.close();
		baos.close();

		return baos.toByteArray();
		}

	public static Serializable unserialize(byte[] tabByte) throws IOException, ClassNotFoundException
		{
		ByteArrayInputStream bais = new ByteArrayInputStream(tabByte);
		ObjectInputStream ois = new ObjectInputStream(bais);

		Serializable serializable = (Serializable)ois.readObject();

		ois.close();
		bais.close();

		return serializable;
		}

	public static Serializable clone(Serializable serializable) throws IOException, ClassNotFoundException
		{
		byte[] tabByte = serialize(serializable);
		return unserialize(tabByte);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	}
