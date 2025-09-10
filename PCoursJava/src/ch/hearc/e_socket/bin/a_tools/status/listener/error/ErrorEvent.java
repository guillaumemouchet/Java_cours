
package ch.hearc.e_socket.bin.a_tools.status.listener.error;

public class ErrorEvent
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public ErrorEvent(Object source, String information, ErrorType errorType, Exception exception)
		{
		this.source = source;
		this.information = information;
		this.errorType = errorType;
		this.exception = exception;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		return information + " : " + errorType.name() + " : " + exception;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public Object getSource()
		{
		return this.source;
		}

	public Exception getException()
		{
		return this.exception;
		}

	public String getInformation()
		{
		return this.information;
		}

	public ErrorType getSucessType()
		{
		return this.errorType;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs/Outputs
	private Object source;
	private String information;
	private ErrorType errorType;
	private Exception exception;
	}
