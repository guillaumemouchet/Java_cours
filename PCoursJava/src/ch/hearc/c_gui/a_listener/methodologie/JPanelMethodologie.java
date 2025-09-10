
package ch.hearc.c_gui.a_listener.methodologie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelMethodologie extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelMethodologie()
		{
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		this.bouton1 = new JButton("Bouton1");
		this.bouton2 = new JButton("Bouton2");

		add(this.bouton1);
		add(this.bouton2);
		}

	private void control()
		{
		v1();
		v2();
		v3();
		v4();
		}

	private void v1()
		{
		ActionListener actionListener1 = new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				System.out.println(bouton1.getText());
				}
			};

		ActionListener actionListener2 = new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				System.out.println(bouton2.getText());
				}
			};

		this.bouton1.addActionListener(actionListener1);
		this.bouton2.addActionListener(actionListener2);
		}

	private void v2() // BEST - Universelle
		{
		this.bouton1.addActionListener(createActionListener(this.bouton1));
		this.bouton2.addActionListener(createActionListener(this.bouton2));
		}

	private ActionListener createActionListener(JButton jbutton)
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				System.out.println(jbutton.getText());
				}
			};
		}

	private void v3()
		{
		ActionListener actionListener = createActionListener(); // Une seule instance
		this.bouton1.addActionListener(actionListener);
		this.bouton2.addActionListener(actionListener);
		}

	private ActionListener createActionListener()
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				JButton jbutton = (JButton)e.getSource(); // Emploiement API
				System.out.println(jbutton.getText());
				}
			};
		}

	private void v4()
		{
		ActionListener actionListener = createActionListenerMuseeDesHorreurs(); // Une seule instance
		this.bouton1.addActionListener(actionListener);
		this.bouton2.addActionListener(actionListener);
		}

	private ActionListener createActionListenerMuseeDesHorreurs()
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				JButton jbutton = (JButton)e.getSource();

				// v1 MDH
					{
					if (jbutton.getText().equals(bouton1.getText()))
						{
						System.out.println(bouton1.getText());
						}
					else if (jbutton.getText().equals(bouton2.getText()))
						{
						System.out.println(bouton2.getText());
						}
					}
				// v2 MDH
					{
					if (jbutton == bouton1)
						{
						System.out.println(bouton1.getText());
						}
					else if (jbutton == bouton2)
						{
						System.out.println(bouton2.getText());
						}
					}
				// v3 MDH
					{
					if (jbutton.getText().equals("Bouton1"))
						{
						System.out.println(bouton1.getText());
						}
					else if (jbutton.getText().equals("Bouton2"))
						{
						System.out.println(bouton2.getText());
						}
					}
				}
			};
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
	private JButton bouton1;
	private JButton bouton2;

	}
