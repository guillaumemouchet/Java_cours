
package ch.hearc.e_socket.bin.a_tools.status.listener;

import ch.hearc.e_socket.bin.a_tools.status.listener.error.ErrorEvent;
import ch.hearc.e_socket.bin.a_tools.status.listener.success.SuccessEvent;

public class StatusAdapter implements StatusListener
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void onError(ErrorEvent errorEvent)
		{
		// rien
		}

	@Override
	public void onSuccess(SuccessEvent successEvent)
		{
		// rien
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
