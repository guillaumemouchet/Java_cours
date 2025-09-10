package ch.hearc.c_gui.b_layout.composition.c_exercices.exercice1.atome;

import java.awt.Color;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class JTopBar extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JTopBar()
		{
		super(BoxLayout.X_AXIS);

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
		this.labelGauche = new JLabel("Demo layout atomique");
		this.labelDroite = new JLabel("He-arc");

		final int DX=15;
		add(Box.createHorizontalStrut(DX));
		add(labelGauche);
		add(Box.createHorizontalGlue());
		add(labelDroite);
		add(Box.createHorizontalStrut(DX));
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		// Debug
			{
			setOpaque(true);
			setBackground(Color.CYAN);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private JLabel labelGauche;
	private JLabel labelDroite;
	}
