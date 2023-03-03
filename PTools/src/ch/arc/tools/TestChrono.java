
package ch.arc.tools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestChrono
	{

	/*------------------------------------------------------------------*\
	 |*							Methodes Public							*|
	 \*-----------------------------------------------------------------*/

	@Test
	public void test1()
		{
		for(long durationExpected = 222; durationExpected < 800; durationExpected += 50)
			{
			Chrono chrono = new Chrono();

			Threads.sleepMS(durationExpected);
			long durationEmpirique = chrono.stop();

			Assertions.assertTrue(isEquals(durationExpected, durationEmpirique));
			}
		}

	@Test
	public void test2()
		{
		for(long durationExpected = 222; durationExpected < 800; durationExpected += 50)
			{
			Chrono chrono = new Chrono();

			Threads.sleepMS(1000);
			chrono.start();

			Threads.sleepMS(durationExpected);
			long durationEmpirique = chrono.stop();

			Assertions.assertTrue(isEquals(durationExpected, durationEmpirique));
			}
		}

	@Test
	public void test3()
		{
		for(long durationExpected = 222; durationExpected < 800; durationExpected += 50)
			{
			Chrono chrono = new Chrono();

			Threads.sleepMS(durationExpected);

			chrono.stop();
			long durationEmpirique = chrono.getTimeMS();

			Assertions.assertTrue(isEquals(durationExpected, durationEmpirique));
			}
		}

	@Test
	public void test4()
		{
		for(long durationExpected = 222; durationExpected < 800; durationExpected += 50)
			{
			Chrono chrono = new Chrono();

			Threads.sleepMS(1000);
			chrono.start();

			Threads.sleepMS(durationExpected);

			chrono.stop();
			long durationEmpirique = chrono.getTimeMS();

			Assertions.assertTrue(isEquals(durationExpected, durationEmpirique));
			}
		}

	@Test
	public void test5()
		{
		for(long durationExpected = 222; durationExpected < 800; durationExpected += 50)
			{
			Chrono chrono = new Chrono();

			Threads.sleepMS(durationExpected);

			long durationEmpirique = chrono.getTimeMS();

			Assertions.assertTrue(isEquals(durationExpected, durationEmpirique));

			chrono.stop();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static boolean isEquals(long a, long b, int epsilon)
		{
		Assertions.assertTrue(epsilon >= 0);

		return Math.abs(a - b) <= epsilon;
		}

	private static boolean isEquals(long a, long b)
		{
		return isEquals(a, b, 10);
		}

	}
