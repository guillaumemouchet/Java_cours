
package ch.arc.cours.lamda.image.framework.image;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class JFrameImage extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameImage(JPanelImage jpanelImage, String title)
		{
		this.jComponent = jpanelImage;

		geometry();
		control();
		appearance(jpanelImage.getDimensionImage(), title);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		BorderLayout borderLayout = new BorderLayout();
		setLayout(borderLayout);

		add(jComponent, BorderLayout.CENTER);
		}

	private void control()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	private void appearance(Dimension dim, String title)
		{
		setSize(dim);
		setLocationRelativeTo(null); // frame centrer
		setResizable(false);
		setTitle(title);
		setVisible(true); // last!
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Input
	private JComponent jComponent;

	}
