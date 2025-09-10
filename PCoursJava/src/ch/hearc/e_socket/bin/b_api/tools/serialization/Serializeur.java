
package ch.hearc.e_socket.bin.b_api.tools.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serializeur<T extends Serializable> implements Serializeur_I<T>

	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public byte[] serialize(T serializable) throws IOException
		{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		//BufferedOutputStream bos = new BufferedOutputStream(baos);
		ObjectOutputStream oos = new ObjectOutputStream(baos);

		oos.writeObject(serializable);

		oos.close();
		//bos.close();
		baos.close();

		return baos.toByteArray();
		}

	@SuppressWarnings("unchecked")
	@Override
	public T unserialize(byte[] tabByte) throws ClassNotFoundException, IOException
		{
		ByteArrayInputStream bais = new ByteArrayInputStream(tabByte);
		//BufferedInputStream bis = new BufferedInputStream(bais);
		ObjectInputStream ois = new ObjectInputStream(bais);

		Serializable serializable = (Serializable)ois.readObject();

		ois.close();
		//bis.close();
		bais.close();

		return (T)serializable;
		}



	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
