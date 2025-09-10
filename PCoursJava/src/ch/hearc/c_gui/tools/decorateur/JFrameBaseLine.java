
package ch.hearc.c_gui.tools.decorateur;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class JFrameBaseLine extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameBaseLine(JComponent jcomponent, ImageIcon imageIcon)
		{
		this.jcomponent = jcomponent;
		this.imageIcon = imageIcon;
		geometry();
		control();
		appearance();
		}

	public JFrameBaseLine(JComponent jcomponent)
		{
		this(jcomponent, null);
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
		add(this.jcomponent);
		}

	private void control()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	private void appearance()
		{
		if (this.imageIcon != null)
			{
			setIconImage(this.imageIcon.getImage());
			}
		setSize(600, 400);
		setLocationRelativeTo(null); // frame centrer
		setVisible(true); // last!
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private JComponent jcomponent;
	private ImageIcon imageIcon;

	}
