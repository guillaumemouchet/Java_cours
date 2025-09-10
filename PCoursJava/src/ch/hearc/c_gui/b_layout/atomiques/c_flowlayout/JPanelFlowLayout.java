
package ch.hearc.c_gui.b_layout.atomiques.c_flowlayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelFlowLayout extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelFlowLayout()
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

		this.flowlayout = new FlowLayout(FlowLayout.CENTER);
		setLayout(this.flowlayout);

		add(this.bouton1);
		add(this.bouton2);
		add(this.bouton3);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		//setBorder(BorderFactory.createTitledBorder("Flow Layout"));
		this.flowlayout.setHgap(20);
		this.flowlayout.setVgap(10);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private JButton bouton1;
	private JButton bouton2;
	private JButton bouton3;
	private FlowLayout flowlayout;

	}
