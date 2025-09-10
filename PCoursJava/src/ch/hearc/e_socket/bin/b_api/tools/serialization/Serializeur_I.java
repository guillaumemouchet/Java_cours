
package ch.hearc.e_socket.bin.b_api.tools.serialization;

import java.io.IOException;
import java.io.Serializable;

public interface Serializeur_I<T  extends Serializable>
	{

	public byte[] serialize(T serializable) throws IOException;

	public T unserialize(byte[] tabByte) throws ClassNotFoundException, IOException;

	/*------------------------------*\
	|*			  degault			*|
	\*------------------------------*/

	public default T clone(T serializable) throws ClassNotFoundException, IOException
		{
		return unserialize(serialize(serializable));
		}
	}
