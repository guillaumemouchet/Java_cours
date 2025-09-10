
package ch.hearc.c_gui.b_layout.atomiques.a_sanslayout;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelSansLayout extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelSansLayout()
		{
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		this.button = new JButton("bouton");
		setLayout(null);
		add(this.button);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		setBackground(Color.PINK);
		//setBorder(BorderFactory.createTitledBorder("Sans Layout"));
		this.button.setSize(100, 50);
		this.button.setLocation(100, 100);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private JButton button;

	}
