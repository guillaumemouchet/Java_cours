package ch.hearc.c_gui.b_layout.composition.d_sizecustom;

import javax.swing.JSplitPane;

import ch.hearc.c_gui.b_layout.composition.d_sizecustom.droite.JDisplay;
import ch.hearc.c_gui.b_layout.composition.d_sizecustom.gauche.JControl;

public class JSizeCustom extends JSplitPane
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JSizeCustom()
		{
		super(JSplitPane.HORIZONTAL_SPLIT);

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
		this.jdisplay = new JDisplay();
		this.jcontrol = new JControl(this.jdisplay);

		setRightComponent(this.jdisplay);
		setLeftComponent(this.jcontrol);
		}

	private void control()
		{
		setOneTouchExpandable(true);
		}

	private void appearance()
		{
		//setDividerLocation(200); plus besoin car une taille min sur JControl
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private JControl jcontrol;
	private JDisplay jdisplay;

	}
