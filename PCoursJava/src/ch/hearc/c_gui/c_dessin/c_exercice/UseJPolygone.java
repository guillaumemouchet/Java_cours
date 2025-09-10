
package ch.hearc.c_gui.c_dessin.c_exercice;

import ch.hearc.c_gui.tools.decorateur.JFrameBaseLine;
import ch.hearc.c_gui.tools.decorateur.JG2D;

public class UseJPolygone
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
		new JFrameBaseLine(new JG2D(new G2DPolygoneV1(100,8)));
		new JFrameBaseLine(new JG2D(new G2DPolygoneV2(50,6)));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}

