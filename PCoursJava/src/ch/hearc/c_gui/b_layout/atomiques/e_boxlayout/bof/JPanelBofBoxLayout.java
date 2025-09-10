
package ch.hearc.c_gui.b_layout.atomiques.e_boxlayout.bof;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelBofBoxLayout extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelBofBoxLayout()
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
		this.bouton1 = new JButton("Bouton1");
		this.bouton2 = new JButton("Bouton2");
		this.bouton3 = new JButton("Bouton3");
		this.bouton4 = new JButton("Bouton4");
		this.bouton5 = new JButton("Bouton5");

		Box boxV = Box.createVerticalBox();

		final int DY = 15;

		boxV.add(Box.createVerticalStrut(DY));
		boxV.add(this.bouton1);
		boxV.add(Box.createVerticalGlue());
		boxV.add(this.bouton2);
		boxV.add(Box.createVerticalStrut(DY));
		boxV.add(this.bouton3);
		boxV.add(Box.createVerticalStrut(DY));
		boxV.add(this.bouton4);
		boxV.add(Box.createVerticalGlue());
		boxV.add(Box.createVerticalGlue());
		boxV.add(this.bouton5);
		boxV.add(Box.createVerticalStrut(DY));

		setLayout(new BorderLayout());

		add(boxV,BorderLayout.CENTER);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		//setBorder(BorderFactory.createTitledBorder("Bof Box Layout"));
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
