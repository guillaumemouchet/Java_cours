
package ch.arc.tools;

public class Threads
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void sleepMS(long durationMS)
		{
		try
			{
			Thread.sleep(durationMS);
			}
		catch (InterruptedException e)
			{
			// rien
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
