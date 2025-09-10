
package ch.hearc.c_gui.b_layout.atomiques.e_boxlayout.mieux;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class BoxVertical extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public BoxVertical()
		{
		super(BoxLayout.Y_AXIS);//spécifications pour un box vertical

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
		this.bouton1 = new JButton("Bouton1");
		this.bouton2 = new JButton("Bouton2");
		this.bouton3 = new JButton("Bouton3");
		this.bouton4 = new JButton("Bouton4");
		this.bouton5 = new JButton("Bouton5");

		final int DY = 15;

		add(Box.createVerticalStrut(DY));
		add(this.bouton1);
		add(Box.createVerticalGlue());
		add(this.bouton2);
		add(Box.createVerticalStrut(DY));
		add(this.bouton3);
		add(Box.createVerticalStrut(DY));
		add(this.bouton4);
		add(Box.createVerticalGlue());
		add(Box.createVerticalGlue());
		add(this.bouton5);
		add(Box.createVerticalStrut(DY));
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		//setBorder(BorderFactory.createTitledBorder("Box Layout"));
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private JButton bouton1;
	private JButton bouton2;
	private JButton bouton3;
	private JButton bouton4;
	private JButton bouton5;
	}
