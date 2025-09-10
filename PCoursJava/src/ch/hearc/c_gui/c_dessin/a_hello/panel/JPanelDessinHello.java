package ch.hearc.c_gui.c_dessin.a_hello.panel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JButton;
import javax.swing.JPanel;

import ch.hearc.c_gui.c_dessin.a_hello.G2DDessinHello;

public class JPanelDessinHello extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelDessinHello()
		{
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

		Graphics2D g2D = (Graphics2D) g;
		AffineTransform backup = g2D.getTransform();
		this.g2dDessinHello.draw(g2D, this.getSize().width,this.getSize().height);
		g2D.setTransform(backup);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		this.jbutton = new JButton("Bouton possible ici");

		add(this.jbutton);
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
	private JButton jbutton;
	private G2DDessinHello g2dDessinHello;

	}
