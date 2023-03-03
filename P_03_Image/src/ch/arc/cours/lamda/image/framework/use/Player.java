
package ch.arc.cours.lamda.image.framework.use;

import ch.arc.cours.lamda.image.framework.animation.Animator;
import ch.arc.cours.lamda.image.framework.image.BImage;
import ch.arc.cours.lamda.image.framework.image.JFrameImage;
import ch.arc.cours.lamda.image.framework.image.JPanelImage;

public class Player
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Player(BImage bimage, long durationMS)
		{
		this.bimage = bimage;
		this.durationMS = durationMS;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * return fps median
	 */
	public double playGUI()
		{
		Animator animator = new Animator(bimage);

		// gui
		JPanelImage jpanelImage = new JPanelImage(bimage, animator);
		animator.registry(jpanelImage);
		JFrameImage jframe = new JFrameImage(jpanelImage, bimage.toString());

		printTitle();

		// animation
			{
			sleep(durationMS);
			animator.stop();
			jframe.dispose();
			}

		return animator.getFps();
		}

	/**
	 * return fps median
	 */
	public double playModel()
		{
		Animator animator = new Animator(bimage);

		printTitle();

		// animation
			{
			animator.start();
			sleep(durationMS);
			animator.stop();
			}

		return animator.getFps();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void printTitle()
		{
		System.out.println("-----------------------------------------------");
		System.out.println(bimage);
		System.out.println("-----------------------------------------------");
		}

	/*------------------------------*\
	|*			  Tools				*|
	\*------------------------------*/

	private static void sleep(long delayMS)
		{
		try
			{
			Thread.sleep(delayMS);
			}
		catch (InterruptedException e)
			{
			// rien
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Input
	private BImage bimage;
	private long durationMS;

	}
