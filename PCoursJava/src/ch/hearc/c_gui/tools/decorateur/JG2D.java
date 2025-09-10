
package ch.hearc.c_gui.tools.decorateur;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

import ch.hearc.c_gui.tools.G2D_I;

public class JG2D extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JG2D(G2D_I g2d_I)
		{
		this.g2d_I = g2d_I;
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D)g;

		AffineTransform backup = g2D.getTransform();
		g2d_I.draw(g2D, this.getSize().width, this.getSize().height);
		g2D.setTransform(backup);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

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

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private G2D_I g2d_I;

	// Tools

	}
