package ch.hearc.c_gui.tools.decorateur.center;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;

public class JCenterH extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JCenterH(JComponent jcomponent)
		{
		super(BoxLayout.X_AXIS);

		this.jcomponent = jcomponent;

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
		add(Box.createHorizontalGlue());
		add(this.jcomponent);
		add(Box.createHorizontalGlue());
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		// rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private JComponent jcomponent;


	}
