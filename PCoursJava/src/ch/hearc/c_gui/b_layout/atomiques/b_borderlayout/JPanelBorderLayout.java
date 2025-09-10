
package ch.hearc.c_gui.b_layout.atomiques.b_borderlayout;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelBorderLayout extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelBorderLayout()
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
		this.bouton1 = new JButton("b1");
		this.bouton2 = new JButton("b2");
		this.bouton3 = new JButton("b3");
		this.bouton4 = new JButton("b4");
		this.bouton5 = new JButton("b5");

		this.borderlayout = new BorderLayout();
		setLayout(this.borderlayout);

		add(this.bouton1, BorderLayout.NORTH);
		add(this.bouton2, BorderLayout.SOUTH);
		add(this.bouton3, BorderLayout.EAST);
		add(this.bouton4, BorderLayout.WEST);
		add(this.bouton5, BorderLayout.CENTER);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		//setBorder(BorderFactory.createTitledBorder("Border Layout"));
		this.borderlayout.setHgap(50);
		this.borderlayout.setVgap(50);
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
	private BorderLayout borderlayout;
	}
