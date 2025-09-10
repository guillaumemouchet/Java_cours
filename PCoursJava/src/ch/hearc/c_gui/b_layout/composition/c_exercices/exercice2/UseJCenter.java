
package ch.hearc.c_gui.b_layout.composition.c_exercices.exercice2;

import javax.swing.JButton;

import ch.hearc.c_gui.tools.decorateur.JFrameBaseLine;
import ch.hearc.c_gui.tools.decorateur.center.JCenter;
import ch.hearc.c_gui.tools.decorateur.center.JCenterH;
import ch.hearc.c_gui.tools.decorateur.center.JCenterV;

public class UseJCenter
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		new JFrameBaseLine(new JCenter(new JButton("Button")));
		new JFrameBaseLine(new JCenterH(new JButton("Button")));
		new JFrameBaseLine(new JCenterV(new JButton("Button")));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
