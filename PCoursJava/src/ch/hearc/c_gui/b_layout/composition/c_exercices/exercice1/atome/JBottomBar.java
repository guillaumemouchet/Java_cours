
package ch.hearc.c_gui.b_layout.composition.c_exercices.exercice1.atome;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JBottomBar extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JBottomBar()
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
		this.buttonExit = new JButton("Exit");

		setLayout(new FlowLayout(FlowLayout.RIGHT));

		add(this.buttonExit);
		}

	private void control()
		{
		this.buttonExit.addActionListener(createActionListener());
		}

	private void appearance()
		{
		setBackground(Color.PINK); // debug
		}

	private static ActionListener createActionListener()
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				System.exit(0); // 0 normal, -1 anormal
				}
			};
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private JButton buttonExit;

	}
