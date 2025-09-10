
package ch.hearc.c_gui.a_listener.dynamique;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelDynamique extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelDynamique()
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
		setLayout(null);
		}

	private void control()
		{
		addMouseListener(createMouseListener());
		}

	private MouseListener createMouseListener()
		{
		return new MouseAdapter()
			{

			@Override
			public void mouseClicked(MouseEvent e)
				{
				JButton jbutton = new JButton("b" + counter++);
				jbutton.setSize(50, 20);
				jbutton.setLocation(e.getPoint());
				jbutton.addActionListener(createActionListener(jbutton));

				add(jbutton);
				revalidate(); // Force les layouts (s'ils y en a) à tout recalculer
				repaint(); // Force le dessin du panel
				// Les deux méthodes sont asynchrone.
				// L'ordre est posté dans la file du AWTQueueEvent.
				// L'ordre sera honoré lorsque son tour sera venu.
				}

			private int counter = 0;
			};
		}

	private ActionListener createActionListener(JButton jbutton)
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				System.out.println("Click du bouton " + jbutton.getText());
				}
			};
		}

	private void appearance()
		{
		setBackground(Color.PINK);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools

	}
