
package ch.hearc.e_socket.bin.c_example.c_remotedesktop.a_client.a_moo.a_image.listener;

import ch.hearc.e_socket.bin.c_example.c_remotedesktop.c_common.image.RemoteData;

public class RemoteDataEvent
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public RemoteDataEvent(Object source, RemoteData remoteData)
		{
		this.source = source;
		this.remoteData = remoteData;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("RemoteDataEvent [source=");
		builder.append(this.source);
		builder.append(", remoteData=");
		builder.append(this.remoteData);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public Object getSource()
		{
		return this.source;
		}

	public RemoteData getRemoteData()
		{
		return this.remoteData;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private Object source;
	private RemoteData remoteData;
	}
