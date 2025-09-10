
package ch.hearc.e_socket.bin.c_example.c_remotedesktop.a_client.a_moo.a_image.listener;

import java.util.ArrayList;
import java.util.List;

public class RemoteDataListenerizable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	protected RemoteDataListenerizable()
		{
		this.listRemoteDataListener = new ArrayList<RemoteDataListener>();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  listener			*|
	\*------------------------------*/

	public synchronized void addRemoteDataListener(RemoteDataListener imageListener)
		{
		this.listRemoteDataListener.add(imageListener);
		}

	public synchronized void removeRemoteDataListener(RemoteDataListener imageListener)
		{
		this.listRemoteDataListener.remove(imageListener);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	protected synchronized void avertirRemoteDataListener(RemoteDataEvent imageEvent)
		{
		for(RemoteDataListener imageListener:listRemoteDataListener)
			{
			imageListener.remoteDataPerformed(imageEvent);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private List<RemoteDataListener> listRemoteDataListener;

	}
