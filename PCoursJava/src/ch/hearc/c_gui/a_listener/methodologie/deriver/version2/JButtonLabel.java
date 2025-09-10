
package ch.hearc.c_gui.a_listener.methodologie.deriver.version2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class JButtonLabel extends JButton
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JButtonLabel(String title, JLabel jlabel)
		{
		super(title);
		this.jlabel = jlabel;
		this.counter = 0;
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
		// rien
		}

	private void control()
		{
		addActionListener(createActionListenerLocal());
		}

	private ActionListener createActionListenerLocal()
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				counter++;
				jlabel.setText("" + counter);
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

	// Input
	private JLabel jlabel;

	// Tools
	private int counter;
	}
