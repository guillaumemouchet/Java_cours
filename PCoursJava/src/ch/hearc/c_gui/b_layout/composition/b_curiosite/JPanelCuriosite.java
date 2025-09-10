package ch.hearc.c_gui.b_layout.composition.b_curiosite;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelCuriosite extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelCuriosite()
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
		this.bouton2 = new JButton("Bouton 2");

		BorderLayout borderLayout = new BorderLayout();
		setLayout(borderLayout);

		FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
		bouton1.setLayout(flowLayout);

		this.bouton1.add(bouton2);
		add(this.bouton1);
		}

	private void control()
		{
		this.bouton1.addActionListener(createActionListener(this.bouton1));
		this.bouton2.addActionListener(createActionListener(this.bouton2));
		}

	private void appearance()
		{
		this.bouton1.setBackground(Color.RED);
		this.bouton2.setBackground(Color.BLUE);
		}

	private ActionListener createActionListener(JButton button)
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				System.out.println("Click :" + button.getText());
				}
			};
		}
	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private JButton bouton1;
	private JButton bouton2;

	}
