
package ch.hearc.e_socket.bin.c_example.c_remotedesktop.d_tools;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

/**
 * singleton
 */
public class ScreenService
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private ScreenService()
		{
		this.rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

		//this.rectangle = new Rectangle(500,600);
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

	public static synchronized ScreenService getInstance()
		{
		if (instance == null)
			{
			instance = new ScreenService();
			}

		return instance;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public BufferedImage getImage()
		{
		return robot.createScreenCapture(this.rectangle);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Outputs

	// Tools
	private Rectangle rectangle;
	private Robot robot;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static ScreenService instance = null;

	}
