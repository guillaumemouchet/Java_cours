
package ch.hearc.c_gui.tools.decorateur.jimage;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

import org.junit.jupiter.api.Assertions;

public class JImage extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JImage(Image image, TypeRendering typeRendering)
		{
		// java2d
			{
			this.image = image;
			this.typeRendering = typeRendering;
			}

		// swing
			{
			geometry();
			control();
			appearance();
			}
		}

	public JImage(TypeRendering typeRendering)
		{
		this(null, typeRendering);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponents(g);

		if (this.image != null)
			{
			Graphics2D g2D = (Graphics2D)g;
			dessiner(g2D);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	public synchronized void update(Image image)
		{
		this.image = image;
		repaint();
		}

	/*------------------------------*\
	|*			  swing				*|
	\*------------------------------*/

	private void geometry()
		{
		// rien
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		// rien
		}

	/*------------------------------*\
	|*			  java2d			*|
	\*------------------------------*/

	private synchronized void dessiner(Graphics2D g2d)
		{
		int wPanel = getWidth();
		int hPanel = getHeight();

		drawImage(g2d, wPanel, hPanel);
		}

	private void drawImage(Graphics2D g2d, int wPanel, int hPanel)
		{
		switch(typeRendering)
			{
			case KEEP_RATIO:
				{
				drawImageKeepRatio(g2d, wPanel, hPanel);
				break;
				}
			case STRETCH:
				{
				drawImageStrecth(g2d, wPanel, hPanel);
				break;
				}

			default:
				{
				Assertions.fail("[JImage] : not yet coded : " + typeRendering);
				break;
				}
			}
		}

	private void drawImageStrecth(Graphics2D g2d, int wPanel, int hPanel)
		{
		g2d.drawImage(image, 0, 0, wPanel, hPanel, null);
		}

	private void drawImageKeepRatio(Graphics2D g2d, int wPanel, int hPanel)
		{
		// original image size
		int wImage = image.getWidth(null);
		int hImage = image.getHeight(null);

		// zoom image
		double zoom = Math.min(wPanel / (double)wImage, hPanel / (double)hImage);
		wImage *= zoom;
		hImage *= zoom;

		// center image
		int px = (wPanel - wImage) / 2;
		int py = (hPanel - hImage) / 2;

		g2d.drawImage(image, px, py, wImage, hImage, null);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private Image image;
	private TypeRendering typeRendering;
	}
