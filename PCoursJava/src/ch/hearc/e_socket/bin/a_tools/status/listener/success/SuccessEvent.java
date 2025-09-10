
package ch.hearc.e_socket.bin.a_tools.status.listener.success;

public class SuccessEvent
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public SuccessEvent(Object source, String information, SuccessType sucessType)
		{
		this.source = source;
		this.information = information;
		this.sucessType = sucessType;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		return information + " : " + sucessType.name();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public Object getSource()
		{
		return this.source;
		}

	public String getInformation()
		{
		return this.information;
		}

	public SuccessType getSucessType()
		{
		return this.sucessType;
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
	private SuccessType sucessType;
	}
