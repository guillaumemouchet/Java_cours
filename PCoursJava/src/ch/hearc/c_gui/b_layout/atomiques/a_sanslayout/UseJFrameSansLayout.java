
package ch.hearc.c_gui.b_layout.atomiques.a_sanslayout;

import ch.hearc.c_gui.a_listener.methodologie.deriver.version2.JPanelBiBoutonV2;
import ch.hearc.c_gui.tools.decorateur.JFrameBaseLine;

public class UseJFrameSansLayout
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
		new JFrameBaseLine(new JPanelSansLayout());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
