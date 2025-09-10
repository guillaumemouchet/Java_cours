
package ch.hearc.d_flux.b_object.c_memoire;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class SerializerGZIP
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static byte[] serialize(Serializable serializable) throws IOException
		{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		GZIPOutputStream gaos = new GZIPOutputStream(baos);
		ObjectOutputStream oos = new ObjectOutputStream(gaos);

		oos.writeObject(serializable);

		oos.close();
		gaos.close();
		baos.close();

		return baos.toByteArray();
		}

	public static Serializable unserialize(byte[] tabByte) throws IOException, ClassNotFoundException
		{
		ByteArrayInputStream bais = new ByteArrayInputStream(tabByte);
		GZIPInputStream gais = new GZIPInputStream(bais);
		ObjectInputStream ois = new ObjectInputStream(gais);

		Serializable serializable = (Serializable)ois.readObject();

		ois.close();
		gais.close();
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
