
package ch.hearc.c_gui.a_listener.methodologie.deriver.version1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelBiBoutonV1 extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelBiBoutonV1()
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
		this.bouton1 = new JButton("Bouton 1");
		this.label1 = new JLabel("0");
		this.bouton2 = new JButton("Bouton 2");
		this.label2 = new JLabel("0");

		add(this.bouton1);
		add(this.label1);
		add(this.bouton2);
		add(this.label2);
		}

	private void control()
		{
		this.bouton1.addActionListener(createActionListener(this.label1));
		this.bouton2.addActionListener(createActionListener(this.label2));
		}

	private void appearance()
		{
		// rien
		}

	private ActionListener createActionListener(JLabel label)
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				counter++;
				label.setText("" + this.counter);
				}

			// Tools
			private int counter = 0;
			};
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private JButton bouton1;
	private JButton bouton2;
	private JLabel label1;
	private JLabel label2;

	}
