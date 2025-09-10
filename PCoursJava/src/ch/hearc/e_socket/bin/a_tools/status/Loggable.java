
package ch.hearc.e_socket.bin.a_tools.status;

import java.util.ArrayList;
import java.util.List;

import ch.hearc.e_socket.bin.a_tools.status.listener.StatusListener;
import ch.hearc.e_socket.bin.a_tools.status.listener.error.ErrorEvent;
import ch.hearc.e_socket.bin.a_tools.status.listener.error.ErrorType;
import ch.hearc.e_socket.bin.a_tools.status.listener.success.SuccessEvent;
import ch.hearc.e_socket.bin.a_tools.status.listener.success.SuccessType;

public class Loggable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Loggable(String prefixeMessage)
		{
		// Input
		this.prefixeMessage = prefixeMessage;

		// Tools
		this.listStatusListeners = new ArrayList<StatusListener>();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public synchronized void addStatusListener(StatusListener statustListener)
		{
		this.listStatusListeners.add(statustListener);
		}

	public synchronized void removeStatusListener(StatusListener statustListener)
		{
		this.listStatusListeners.remove(statustListener);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	protected synchronized void avertirListener(ErrorType errorType, Exception exception)
		{
		ErrorEvent errorEvent = new ErrorEvent(this, prefixeMessage, errorType, exception);
		for(StatusListener clientSocketListener:listStatusListeners)
			{
			clientSocketListener.onError(errorEvent);
			}
		}

	protected synchronized void avertirListener(SuccessType sucessType)
		{
		SuccessEvent successEvent = new SuccessEvent(this, prefixeMessage, sucessType);
		for(StatusListener clientSocketListener:listStatusListeners)
			{
			clientSocketListener.onSuccess(successEvent);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	protected String prefixeMessage;

	// Tools
	protected List<StatusListener> listStatusListeners;
	}
