
package ch.hearc.b_poo.j_thread;

public class Threads
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void sleep(long delaiMs)
		{
		try
			{
			Thread.sleep(delaiMs);
			}
		catch (InterruptedException e)
			{
			e.printStackTrace();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	}
