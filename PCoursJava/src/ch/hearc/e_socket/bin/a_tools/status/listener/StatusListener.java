
package ch.hearc.e_socket.bin.a_tools.status.listener;

import ch.hearc.e_socket.bin.a_tools.status.listener.error.ErrorEvent;
import ch.hearc.e_socket.bin.a_tools.status.listener.success.SuccessEvent;

public interface StatusListener
	{

	public void onSuccess(SuccessEvent successEvent);

	public void onError(ErrorEvent errorEvent);

	}
