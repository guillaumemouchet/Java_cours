
package ch.hearc.c_gui.tools;

import java.awt.Dimension;

import javax.swing.JComponent;

public class Sizes
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void setHorizontal(JComponent jcomponent, int width)
		{
		jcomponent.setMinimumSize(new Dimension(width, jcomponent.getMinimumSize().height));
		jcomponent.setMaximumSize(new Dimension(width, jcomponent.getMaximumSize().height));
		jcomponent.setPreferredSize(new Dimension(width, jcomponent.getPreferredSize().height));
		}

	public static void setVertical(JComponent jcomponent, int height)
		{
		jcomponent.setMinimumSize(new Dimension(jcomponent.getMinimumSize().width,height));
		jcomponent.setMaximumSize(new Dimension(jcomponent.getMaximumSize().width,height));
		jcomponent.setPreferredSize(new Dimension(jcomponent.getPreferredSize().width,height));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	}
