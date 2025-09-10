
package ch.hearc.e_socket.bin.c_example.c_remotedesktop.a_client.b_gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import ch.hearc.c_gui.tools.decorateur.jimage.JImage;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.a_client.a_moo.a_image.listener.RemoteDataListenerizable;

public class JRemote extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JRemote(RemoteDataListenerizable remoteDataListenerizable)
		{
		// TODO

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// TODO
		}

	private void control()
		{
		// TODO
		}

	private void appearance()
		{
		// rien
		}

	private void drawMouseInImage(Image image, int mouseX, int mouseY)
		{
		Graphics2D g2d = (Graphics2D)image.getGraphics();

		g2d.setColor(Color.RED);

		g2d.translate(mouseX, mouseY);
		g2d.fill(circleMouse);
		g2d.translate(-mouseX, -mouseY);

		g2d.dispose();
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private RemoteDataListenerizable remoteDataListenerizable;

	// Tools
	private JImage jimage;

	// Tools Java2D
	private Ellipse2D.Double circleMouse;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final int RAYON_MOUSE = 20;

	}
