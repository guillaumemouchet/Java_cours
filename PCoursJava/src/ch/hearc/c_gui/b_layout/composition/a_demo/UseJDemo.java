
package ch.hearc.c_gui.b_layout.composition.a_demo;

import ch.hearc.c_gui.c_dessin.d_image.a_file.MagasinImage;
import ch.hearc.c_gui.tools.decorateur.JFrameBaseLine;
import ch.hearc.c_gui.tools.decorateur.JMarge;

public class UseJDemo
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
		new JFrameBaseLine(new JMarge(new JDemo(),20),MagasinImage.WARNING);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
