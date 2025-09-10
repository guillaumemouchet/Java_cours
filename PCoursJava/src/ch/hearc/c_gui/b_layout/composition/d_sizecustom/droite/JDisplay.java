
package ch.hearc.c_gui.b_layout.composition.d_sizecustom.droite;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.hearc.c_gui.tools.decorateur.center.JCenter;

public class JDisplay extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JDisplay()
		{
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void setMessage(String message)
		{
		this.jlabelMessage.setText(message);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		this.jlabelMessage = new JLabel();
		setLayout(new BorderLayout());
		add(new JCenter(this.jlabelMessage),BorderLayout.CENTER);
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
	private JLabel jlabelMessage;

	}
