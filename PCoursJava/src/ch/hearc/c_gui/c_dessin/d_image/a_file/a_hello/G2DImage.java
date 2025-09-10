
package ch.hearc.c_gui.c_dessin.d_image.a_file.a_hello;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

import ch.hearc.c_gui.c_dessin.d_image.a_file.MagasinImage;
import ch.hearc.c_gui.tools.G2D_I;

public class G2DImage implements G2D_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public G2DImage(JComponent jcomponent)
		{
		this.jcomponent = jcomponent;

		//tools
			{
			this.cervin = MagasinImage.CERVIN.getImage();
			this.warning = MagasinImage.WARNING.getImage();

			this.pClickX = -1;
			this.pClickY = -1;
			}

		control();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void draw(Graphics2D g2d, int w, int h)
		{
		//v1
			{
			//g2d.drawImage(cervin, 0, 0, null); //image,posX,posY,observer
			}

		//v2
			{
			//g2d.drawImage(cervin, 0, 0, 100, 100, null); //image,posX,posY,w,h,observer
			}

		//v3
			{
			g2d.scale(0.5, 1);
			g2d.drawImage(cervin, 0, 0, null);
			g2d.scale(2, 1);
			}

		//dynamique
			{
			if (this.pClickX != -1)
				{
				g2d.drawImage(cervin, pClickX, pClickY, null);
				}
			}
		}

	private MouseListener createMouseListener()
		{
		return new MouseAdapter()
			{

			@Override
			public void mouseClicked(MouseEvent e)
				{
				pClickX = e.getX() - warning.getWidth(null)/2;
				pClickY = e.getY() - warning.getHeight(null)/2;
				jcomponent.repaint();
				}
			};
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void control()
		{
		this.jcomponent.addMouseListener(createMouseListener());
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//input
	private JComponent jcomponent;

	//tools
	private Image cervin;
	private Image warning;
	private int pClickX;
	private int pClickY;
	}
