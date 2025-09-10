
package ch.hearc.c_gui.b_layout.composition.d_sizecustom.gauche.atome;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import ch.hearc.c_gui.b_layout.composition.d_sizecustom.Settings;
import ch.hearc.c_gui.b_layout.composition.d_sizecustom.droite.JDisplay;
import ch.hearc.c_gui.tools.Sizes;
import ch.hearc.c_gui.tools.decorateur.center.JCenterH;

public class JColor extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JColor(JDisplay jdisplay)
		{
		super(BoxLayout.Y_AXIS);

		this.jdisplay = jdisplay;

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
		this.buttonPink = new JButton("Pink");
		this.buttonYellow = new JButton("Yellow");

		add(Box.createVerticalStrut(Settings.MARGE));
		add(new JCenterH(this.buttonPink));
		add(Box.createVerticalStrut(Settings.MARGE));
		add(new JCenterH(this.buttonYellow));
		add(Box.createVerticalStrut(Settings.MARGE));
		}

	private void control()
		{
		this.buttonPink.addActionListener(createActionListener(Color.PINK));
		this.buttonYellow.addActionListener(createActionListener(Color.YELLOW));
		}

	private void appearance()
		{
		setBorder(BorderFactory.createTitledBorder("Color"));
		Sizes.setHorizontal(buttonPink, Settings.BUTTON_WIDTH);
		Sizes.setHorizontal(buttonYellow, Settings.BUTTON_WIDTH);
		Sizes.setHorizontal(this, Settings.GROUP_WIDTH);
		}

	private ActionListener createActionListener(Color color)
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				jdisplay.setBackground(color);
				}
			};
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private JDisplay jdisplay;

	// Tools
	private JButton buttonPink;
	private JButton buttonYellow;

	}
