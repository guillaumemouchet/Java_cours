
package ch.hearc.c_gui.c_dessin.d_image.a_file.a_hello;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JButton;
import javax.swing.JPanel;

import ch.hearc.c_gui.c_dessin.d_image.a_file.MagasinImage;

public class JButtonImage extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JButtonImage()
		{
		this.g2dImage = new G2DImage(this);
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

		AffineTransform transform = g2D.getTransform(); //sauvegarde
		Color color = g2D.getColor(); //sauvegarde
		Font font = g2D.getFont(); //sauvegarde

		this.g2dImage.draw(g2D, this.getSize().width, this.getSize().height);

		g2D.setFont(font); //restore
		g2D.setColor(color); //restore
		g2D.setTransform(transform); //restore
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		this.buttonImage = new JButton("Button Image");

		add(this.buttonImage);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		this.buttonImage.setIcon(MagasinImage.WARNING);
		//Sizes.setVertical(this.buttonImage, 100); // l'image grandit jusqu'a sa taille réel
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private JButton buttonImage;
	private G2DImage g2dImage;

	}
