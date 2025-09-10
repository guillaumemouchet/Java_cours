package ch.hearc.c_gui.c_dessin.a_hello.bouton;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JButton;

import ch.hearc.c_gui.c_dessin.a_hello.G2DDessinHello;

public class JBoutonDessinHello extends JButton
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JBoutonDessinHello()
		{
		super("Bouton");
		this.g2dDessinHello = new G2DDessinHello(this);
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
		Graphics2D g2d = (Graphics2D)g;

		AffineTransform backup = g2d.getTransform();
		g2dDessinHello.draw(g2d, this.getSize().width, this.getSize().height);
		g2d.setTransform(backup);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

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

	// Tools
	private G2DDessinHello g2dDessinHello;

	}
