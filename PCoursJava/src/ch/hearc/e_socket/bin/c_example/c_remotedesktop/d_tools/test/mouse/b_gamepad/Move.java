
package ch.hearc.e_socket.bin.c_example.c_remotedesktop.d_tools.test.mouse.b_gamepad;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Assertions;

import ch.hearc.b_poo.j_thread.Threads;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.d_tools.MouseService;

public class Move
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Move()
		{
		// Input
			{
			this.mouseService = MouseService.getInstance();
			}

		// tools
			{
			this.dx = new AtomicInteger(0);
			this.dy = new AtomicInteger(0);

			this.isRunning = false;
			this.thread = null;

			this.runnable = createRunnable();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void updateDX(double deltaX)
		{
		update(deltaX, this.dx);
		}

	public void updateDY(double deltaY)
		{
		update(deltaY, this.dy);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private synchronized void update(double valueInput, AtomicInteger valueOutput)
		{
		int valueReal = (int)(valueInput * AMPLIFICATION);
		valueOutput.set(valueReal);

		//System.out.println("[Move] : " + title + " update : valueReal = " + valueReal);

		if (valueReal != 0)
			{
			if (!isRunning)
				{
				startThread();
				}
			}
		else
			{
			if (isRunning)
				{
				if (dx.get() == 0 && dy.get() == 0)
					{
					stopThread();
					}
				}
			}
		}

	private void startThread()
		{
		//System.out.println("[Move] : " + title + " thread start");

		Assertions.assertTrue(!this.isRunning);
		Assertions.assertTrue(this.thread == null);

		this.isRunning = true;
		this.thread = new Thread(runnable);
		this.thread.start();
		}

	private void stopThread()
		{
		//System.out.println("[Move] : " + title + " thread stop");

		if (this.thread != null)
			{
			this.thread.stop();

			this.isRunning = false;
			this.thread = null;
			}
		}

	private Runnable createRunnable()
		{
		return new Runnable()
			{

			@Override
			public void run()
				{
				while(true)
					{
					mouseService.translate(dx.get(), dy.get());
					Threads.sleep(SLEEP_MS);
					}

				}
			};
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private MouseService mouseService;

	// Tools
	private AtomicInteger dx;
	private AtomicInteger dy;
	private boolean isRunning;

	private Runnable runnable;
	private Thread thread;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final double AMPLIFICATION = 10;
	private static final long SLEEP_MS = 8;

	}
