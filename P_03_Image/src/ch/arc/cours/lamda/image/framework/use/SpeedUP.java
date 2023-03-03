
package ch.arc.cours.lamda.image.framework.use;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;

import ch.arc.cours.lamda.image.framework.image.BImage;
import ch.arc.cours.lamda.image.framework.image.Calcul;

public class SpeedUP implements Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public SpeedUP(BImage bimage, long durationMS, Mode mode)
		{
		this.bimage = bimage;
		this.durationMS = durationMS;
		this.mode = mode;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		switch(mode)
			{
			case SPEEDUP_RENDERING:
				{
				printTitle("GUI");

				double[] tabFps = Arrays.stream(Calcul.values()).mapToDouble(this::playGUI).toArray();
				speedUp(tabFps);
				break;
				}
			case SPEEDUP_MODEL:
				{
				printTitle("Model");

				double[] tabFps = Arrays.stream(Calcul.values()).mapToDouble(this::playModel).toArray();
				speedUp(tabFps);
				break;
				}
			default:
				{
				Assertions.fail();
				break;
				}
			}
		}

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("\n");
		builder.append(this.bimage);
		builder.append("\n");
		builder.append("Duration     = " + this.durationMS + "[ms]");
		builder.append("\n");
		builder.append("speedUP      = " + String.format("%.1f", this.speedUP) + "x");
		builder.append("\n");
		builder.append("#nbProcessor = " + Runtime.getRuntime().availableProcessors());
		builder.append("\n");

		return builder.toString();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/**
	 * sequentiel vs parallel
	 */
	public double getSpeedUp()
		{
		return speedUP;
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static void process(BImage bimage, long durationMS, Mode mode)
		{
		SpeedUP speedUP = new SpeedUP(bimage, durationMS, mode);
		speedUP.run();

		System.out.println(speedUP);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private double playModel(Calcul fillType)
		{
		bimage.set(fillType);

		Player player = new Player(bimage, durationMS);
		return player.playModel();
		}

	private double playGUI(Calcul fillType)
		{
		bimage.set(fillType);

		Player player = new Player(bimage, durationMS);
		return player.playGUI();
		}

	/*------------------------------*\
	|*			  Tools				*|
	\*------------------------------*/

	private void printTitle(String title)
		{
		System.out.println("-----------");
		System.out.println(title);
		System.out.println("-----------\n");
		}

	private void speedUp(double[] tabFps)
		{
		Assertions.assertTrue(tabFps[2] >= tabFps[0], "Vous avez demarrer l'animation, en clickant sur start?");// sinon on est nul (vous avez demarrer l'animation, en clickant sur start?)

		this.speedUP = tabFps[2] / tabFps[0];
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Input
	private BImage bimage;
	private long durationMS;
	private Mode mode;

	// Outputs
	private double speedUP;

	}
