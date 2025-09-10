package ch.hearc.c_gui.b_layout.composition.d_sizecustom.gauche;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import ch.hearc.c_gui.b_layout.composition.d_sizecustom.Settings;
import ch.hearc.c_gui.b_layout.composition.d_sizecustom.droite.JDisplay;
import ch.hearc.c_gui.b_layout.composition.d_sizecustom.gauche.atome.JColor;
import ch.hearc.c_gui.b_layout.composition.d_sizecustom.gauche.atome.JStudent;
import ch.hearc.c_gui.tools.Sizes;
import ch.hearc.c_gui.tools.decorateur.center.JCenterH;

public class JControl extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JControl(JDisplay jdisplay)
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
		this.jcolor = new JColor(this.jdisplay);
		this.jstudent = new JStudent(this.jdisplay);
		this.buttonExit = new JButton("Exit");

		add(Box.createVerticalStrut(Settings.MARGE));
		add(new JCenterH(this.jcolor));
		add(Box.createVerticalStrut(Settings.MARGE));
		add(new JCenterH(this.jstudent));
		add(Box.createVerticalGlue());
		add(new JCenterH(this.buttonExit));
		add(Box.createVerticalStrut(Settings.MARGE));
		}

	private void control()
		{
		this.buttonExit.addActionListener(createActionListener());
		}

	private void appearance()
		{
		Sizes.setHorizontal(buttonExit, Settings.BUTTON_WIDTH);
		Sizes.setHorizontal(this, Settings.CONTROL_WIDTH);
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
	private JDisplay jdisplay;

	// Tools
	private JColor jcolor;
	private JStudent jstudent;
	private JButton buttonExit;

	}
