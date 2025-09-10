
package ch.hearc.c_gui.c_dessin.d_image.b_custom;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.util.TimerTask;

import javax.swing.JComponent;

import ch.hearc.b_poo.j_thread.Threads;
import ch.hearc.c_gui.tools.G2D_I;

public class G2DCustom implements G2D_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public G2DCustom(JComponent jcomponent)
		{
		this.jcomponent = jcomponent;
		//tools animation
			{
			this.hueAnimation01 = 0;
			}
		control();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void draw(Graphics2D g2d, int w, int h)
		{
		g2d.drawImage(bufferedImage, 0, 0, null);
		}

	public void start()
		{
		//startV1();
		//startV2();
		startV3();
		}

	public void stop()
		{
		//stopV1();
		//stopV2();
		stopV3();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * idem V3 sauf qu'on manage nous même le thread du timer timerEvent
	 */
	private void startV1()
		{
		this.threadAnimation = new Thread(createRunnable());
		this.threadAnimation.setName("thread animation");
		this.threadAnimation.start();
		}

	/**
	 * avantage :
	 * 				- version la plus simple à mettre en place;
	 * 				- Aucun problème de concurrence car le timer swing est déclenché par le thread awtQEvent;
	 * 				 (FillImage et createImage n'ont pas besoin d'être syncronisé car elles peuvent jamais être appeler par des threads
	 * 				  différent puisque dans cette version il n'y a plus qu'un thread qui fait tout : AWTQEvent);
	 *
	 * Incovenient:
	 * 				- Si AnimationStep() prend du temps le GUI est gelé et l'utilisateur perds le contrôle;
	 */
	private void startV2()
		{
		this.timerAnimationSwing = new javax.swing.Timer(10, createActionListener());
		this.timerAnimationSwing.start();
		}

	/**
	 * Contrairement au timer swing, le timer Util possède son propre thread.
	 * Les problèmes de concurrences réaparraissent et doivent être résolu avec syncronized sur createImage et fillImage,
	 * Car dans cette version il y a 2 threads en concurrence awtWevent et le thread associé au timer Util qui sont en
	 * concurrence avec l'attribut image
	 */
	private void startV3()
		{
		this.timerAnimationUtil = new java.util.Timer("TimerAnimationUtil");
		this.timerAnimationUtil.scheduleAtFixedRate(createTimerTask(), 0, 10);
		}

	private void stopV1()
		{
		this.threadAnimation.stop();
		}

	private void stopV2()
		{
		this.timerAnimationSwing.stop();
		}

	private void stopV3()
		{
		this.timerAnimationUtil.cancel();
		}

	private synchronized void createImage(int w, int h)
		{
		this.bufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		}

	private synchronized void fillImage()
		{
		int w = this.bufferedImage.getWidth();
		int h = this.bufferedImage.getHeight();

		float hue01 = this.hueAnimation01;
		float dhue = 1 / (float)h;

		for(int i = 0; i < h; i++) // parcours les lignes
			{
			int colorInt = Color.HSBtoRGB(hue01, 1, 1);
			for(int j = 0; j < w; j++) // parcours les colonnes
				{
				this.bufferedImage.setRGB(j, i, colorInt);
				}
			hue01 += dhue;
			}
		//Threads.sleep(3000); //Simulation d'un calcul long
		}

	private void control()
		{
		jcomponent.addComponentListener(createComponentListener());
		}

	private TimerTask createTimerTask()
		{
		return new TimerTask()
			{

			@Override
			public void run()
				{
				animationStep();
				}
			};
		}

	private ActionListener createActionListener()
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				animationStep();
				}
			};
		}

	private ComponentListener createComponentListener()
		{
		return new ComponentAdapter()
			{

			@Override
			public void componentResized(ComponentEvent e)
				{
				int w = jcomponent.getSize().width;
				int h = jcomponent.getSize().height;
				deltaHueAnimation = 1 / (float)h;
				createImage(w, h);
				fillImage();
				}
			};
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
					animationStep();
					Threads.sleep(10);
					}
				}
			};
		}

	private void animationStep()
		{
		this.hueAnimation01 += this.deltaHueAnimation;
		//System.out.println(Thread.currentThread().getName());
		fillImage();
		this.jcomponent.repaint();
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//tools
	private BufferedImage bufferedImage;
	private JComponent jcomponent;

	//tools animation
	private float hueAnimation01;
	private float deltaHueAnimation;
	private Thread threadAnimation;
	private javax.swing.Timer timerAnimationSwing;
	private java.util.Timer timerAnimationUtil;

	}
