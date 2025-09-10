
package ch.hearc.e_socket.bin.b_api.tools.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class SerializeurGZIP<T extends Serializable> implements Serializeur_I<T>
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public byte[] serialize(T serializable) throws IOException
		{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		//BufferedOutputStream bos = new BufferedOutputStream(baos);
		GZIPOutputStream gos = new GZIPOutputStream(baos);
		ObjectOutputStream oos = new ObjectOutputStream(gos);

		oos.writeObject(serializable);

		oos.close();
		gos.close();
		//bos.close();
		baos.close();

		return baos.toByteArray();
		}

	@Override
	@SuppressWarnings("unchecked")
	public T unserialize(byte[] tabByte) throws ClassNotFoundException, IOException
		{
		ByteArrayInputStream bais = new ByteArrayInputStream(tabByte);
		//BufferedInputStream bis = new BufferedInputStream(bais);
		GZIPInputStream gis = new GZIPInputStream(bais);
		ObjectInputStream ois = new ObjectInputStream(gis);

		Serializable serializable = (Serializable)ois.readObject();

		ois.close();
		gis.close();
		//bis.close();
		bais.close();

		return (T)serializable;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
