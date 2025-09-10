package ch.hearc.c_gui.tools.decorateur.center;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;

public class JCenter extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JCenter(JComponent jcomponent)
		{
		super(BoxLayout.Y_AXIS);

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
		//V1 why not
//			{
//				Box boxH = Box.createHorizontalBox();
//				boxH.add(Box.createHorizontalGlue());
//				boxH.add(this.jcomponent);
//				boxH.add(Box.createHorizontalGlue());
//
//				add(Box.createVerticalGlue());
//				add(boxH);
//				add(Box.createVerticalGlue());
//			}

		//V2 best
			{
				add(Box.createVerticalGlue());
				add(new JCenterH(this.jcomponent));
				add(Box.createVerticalGlue());
			}
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
