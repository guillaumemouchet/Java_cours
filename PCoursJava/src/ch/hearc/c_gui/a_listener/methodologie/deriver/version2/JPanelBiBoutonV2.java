
package ch.hearc.c_gui.a_listener.methodologie.deriver.version2;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelBiBoutonV2 extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelBiBoutonV2()
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
		this.label1 = new JLabel("0");
		this.label2 = new JLabel("0");
		this.bouton1 = new JButtonLabel("bouton 1", this.label1);
		this.bouton2 = new JButtonLabel("bouton 2", this.label2);

		add(this.bouton1);
		add(this.label1);
		add(this.bouton2);
		add(this.label2);
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
	private JButtonLabel bouton1;
	private JButtonLabel bouton2;
	private JLabel label1;
	private JLabel label2;

	}
