package ch.hearc.c_gui.b_layout.composition.d_sizecustom.gauche.atome;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import ch.hearc.c_gui.b_layout.composition.d_sizecustom.Settings;
import ch.hearc.c_gui.b_layout.composition.d_sizecustom.droite.JDisplay;
import ch.hearc.c_gui.tools.Sizes;

public class JStudent extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JStudent(JDisplay jdisplay)
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
		this.radioinfo = new JRadioButton("Info");
		this.radiomedecine = new JRadioButton("Medecine");

		add(Box.createVerticalStrut(Settings.MARGE));
		add(this.radioinfo);
		add(Box.createVerticalStrut(Settings.MARGE));
		add(this.radiomedecine);
		add(Box.createVerticalStrut(Settings.MARGE));
		}

	private void control()
		{
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(this.radioinfo);
		buttonGroup.add(this.radiomedecine);

		this.radioinfo.addActionListener(createActionListener("Info"));
		this.radiomedecine.addActionListener(createActionListener("Medecine"));

		this.radioinfo.setSelected(true);
		}

	private void appearance()
		{
		setBorder(BorderFactory.createTitledBorder("Student"));
		Sizes.setHorizontal(this, Settings.GROUP_WIDTH);
		}

	private ActionListener createActionListener(String message)
	{
		return new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				jdisplay.setMessage(message);
				}

		};
	}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private JDisplay jdisplay;

	// Tools
	private JRadioButton radioinfo;
	private JRadioButton radiomedecine;
	}

