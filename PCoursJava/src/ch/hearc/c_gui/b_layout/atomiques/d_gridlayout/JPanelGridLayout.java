
package ch.hearc.c_gui.b_layout.atomiques.d_gridlayout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelGridLayout extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelGridLayout()
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

		this.gridlayout = new GridLayout(-1, 3); // si -1 le nombre de lignes est calculé automatiquement
		setLayout(this.gridlayout);
		// Row major : d'abord les lignes
		add(this.bouton1);
		add(this.bouton2);
		add(this.bouton3);
		add(this.bouton4);
		add(this.bouton5);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		//setBorder(BorderFactory.createTitledBorder("Grid Layout"));
		this.gridlayout.setHgap(10);
		this.gridlayout.setVgap(20);
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
	private GridLayout gridlayout;
	}
