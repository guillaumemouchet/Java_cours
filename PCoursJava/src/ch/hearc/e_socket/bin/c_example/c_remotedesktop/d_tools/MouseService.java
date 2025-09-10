
package ch.hearc.e_socket.bin.c_example.c_remotedesktop.d_tools;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

/**
 * singleton
 */
public class MouseService
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private MouseService()
		{
		this.w = Toolkit.getDefaultToolkit().getScreenSize().width;
		this.h = Toolkit.getDefaultToolkit().getScreenSize().height;

		try
			{
			this.robot = new Robot();
			}
		catch (AWTException e)
			{
			e.printStackTrace();
			}
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static synchronized MouseService getInstance()
		{
		if (instance == null)
			{
			instance = new MouseService();
			}

		return instance;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * (x,y) "safe"
	 */
	public void move(int x, int y)
		{
		x = Math.min(x, w); // x<=w
		x = Math.max(0, x); // x>=0

		y = Math.min(y, h);
		y = Math.max(0, y);

		//System.out.println("move("+x+","+y+")");

		this.robot.mouseMove(x, y);
		}

	public void press(int idButton)
		{
		this.robot.mousePress(idButton);
		}

	public void release(int idButton)
		{
		this.robot.mouseRelease(idButton);
		}

	public void translate(int dx, int dy)
		{
		Point p = location();
		int x = (int)p.getX();
		int y = (int)p.getY();

		move(x + dx, y + dy);
		}

	public Point location()
		{
		return MouseInfo.getPointerInfo().getLocation();
		}

	/*------------------------------*\
	|*	helper /Left				*|
	\*------------------------------*/

	public void doubleClickLeft()
		{
		clickLeft();
		clickLeft();
		}

	public void clickLeft()
		{
		press(BUTTON_LEFT);
		release(BUTTON_LEFT);
		}

	public void pressLeft()
		{
		press(BUTTON_LEFT);
		}

	public void releaseLeft()
		{
		release(BUTTON_LEFT);
		}

	/*------------------------------*\
	|*	helper /Right				*|
	\*------------------------------*/

	public void clickRight()
		{
		press(BUTTON_RIGHT);
		release(BUTTON_RIGHT);
		}

	public void pressRight()
		{
		press(BUTTON_RIGHT);
		}

	public void releaseRight()
		{
		release(BUTTON_RIGHT);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Outputs

	// Tools
	private Robot robot;
	private int w;
	private int h;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static MouseService instance = null;

	private int BUTTON_LEFT = MouseEvent.BUTTON1_DOWN_MASK;
	//private int BUTTON_WHEEL = MouseEvent.BUTTON2_DOWN_MASK;
	private int BUTTON_RIGHT = MouseEvent.BUTTON3_DOWN_MASK;

	}
