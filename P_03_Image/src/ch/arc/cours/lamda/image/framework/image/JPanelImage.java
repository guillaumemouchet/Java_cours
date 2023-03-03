
package ch.arc.cours.lamda.image.framework.image;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JPanel;

import ch.arc.cours.lamda.image.framework.animation.Animator_I;
import ch.arc.cours.lamda.image.framework.animation.DessinListener;
import ch.arc.cours.lamda.image.framework.animation.Dessinable_I;
import ch.arc.cours.lamda.image.framework.animation.JAnimator;

public class JPanelImage extends JPanel implements Dessinable_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelImage(BufferedImage bimage, Animator_I animator)
		{
		// Input
			{
			this.bimage = bimage;
			}

		// Tools
			{
			this.janimator = new JAnimator(animator);
			this.listDessinListener = new ArrayList<DessinListener>();
			}

		geometry();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void geometry()
		{
		Box boxV = Box.createVerticalBox();
		boxV.add(Box.createVerticalGlue());
		boxV.add(janimator);
		boxV.add(Box.createVerticalGlue());

		setLayout(new BorderLayout());
		add(boxV, BorderLayout.CENTER);
		}

	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D)g;

		AffineTransform t = g2d.getTransform();
		dessiner(g2d);
		g2d.setTransform(t);

		avertirDessinListener();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public Dimension getDimensionImage()
		{
		return new Dimension(this.bimage.getWidth(), this.bimage.getHeight());
		}

	/*------------------------------*\
	|*			  listener			*|
	\*------------------------------*/

	@Override
	public synchronized void addDessinListener(DessinListener dessinListener)
		{
		listDessinListener.add(dessinListener);
		}

	@Override
	public synchronized void removeDesssinListener(DessinListener dessinListener)
		{
		listDessinListener.remove(dessinListener);
		}

	private synchronized void avertirDessinListener()
		{
		listDessinListener.forEach(DessinListener::repaintPerformed);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void dessiner(Graphics2D g2d)
		{
		g2d.drawImage(bimage, 0, 0, null);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private BufferedImage bimage;

	// Tools
	private List<DessinListener> listDessinListener;
	private JAnimator janimator;

	}
