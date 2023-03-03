
package ch.arc.tools;

public class Chrono
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Chrono()
		{
		start();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		return getTimeMS() + " [ms]";
		}

	public void start()
		{
		start = System.currentTimeMillis();
		isRunning = true;
		}

	/**
	 * [ms]
	 */
	public long stop()
		{
		stop = System.currentTimeMillis();
		isRunning = false;

		return stop - start;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public long getTimeMS()
		{
		if (isRunning)
			{
			long now = System.currentTimeMillis();

			return now - start;
			}
		else
			{
			return stop - start;
			}
		}

	public double getTimeS()
		{
		return getTimeMS() / (double)1000;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Tools
	private long start;
	private long stop;

	private boolean isRunning;

	}
