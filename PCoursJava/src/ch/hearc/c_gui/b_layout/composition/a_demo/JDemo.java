
package ch.hearc.c_gui.b_layout.composition.a_demo;

import java.awt.GridLayout;

import javax.swing.JPanel;

import ch.hearc.c_gui.b_layout.atomiques.a_sanslayout.JPanelSansLayout;
import ch.hearc.c_gui.b_layout.atomiques.b_borderlayout.JPanelBorderLayout;
import ch.hearc.c_gui.b_layout.atomiques.c_flowlayout.JPanelFlowLayout;
import ch.hearc.c_gui.b_layout.atomiques.d_gridlayout.JPanelGridLayout;
import ch.hearc.c_gui.b_layout.atomiques.e_boxlayout.bof.JPanelBofBoxLayout;
import ch.hearc.c_gui.b_layout.atomiques.e_boxlayout.mieux.BoxVertical;
import ch.hearc.c_gui.tools.decorateur.JMarge;

public class JDemo extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JDemo()
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
		this.jpanelsanslayout = new JPanelSansLayout();
		this.jpanelborderlayout = new JPanelBorderLayout();
		this.jpanelflowlayout = new JPanelFlowLayout();
		this.jpanelgridlayout = new JPanelGridLayout();
		this.jpanelbofboxlayout = new JPanelBofBoxLayout();
		this.boxvertical = new BoxVertical();

		this.gridlayout = new GridLayout(-1, 3);
		setLayout(this.gridlayout);

		final int MARGE = 20;

		add(new JMarge(this.jpanelsanslayout,MARGE,"Sans Layout"));
		add(new JMarge(this.jpanelborderlayout,MARGE,"Border Layout"));
		add(new JMarge(this.jpanelflowlayout,MARGE,"Flow Layout"));
		add(new JMarge(this.jpanelgridlayout,MARGE,"Grid Layout"));
		add(new JMarge(this.jpanelbofboxlayout,MARGE,"Bof Box Layout"));
		add(new JMarge(this.boxvertical,MARGE,"Box Vertical"));
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		//setBackground(Color.GREEN); //debug
		this.gridlayout.setHgap(20);
		this.gridlayout.setVgap(20);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private JPanelSansLayout jpanelsanslayout;
	private JPanelBorderLayout jpanelborderlayout;
	private JPanelFlowLayout jpanelflowlayout;
	private JPanelGridLayout jpanelgridlayout;
	private JPanelBofBoxLayout jpanelbofboxlayout;
	private BoxVertical boxvertical;

	private GridLayout gridlayout;


	}
