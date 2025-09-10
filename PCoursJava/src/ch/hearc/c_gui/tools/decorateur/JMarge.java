
package ch.hearc.c_gui.tools.decorateur;

import java.awt.BorderLayout;
import java.util.Optional;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;

import ch.hearc.c_gui.tools.Sizes;

public class JMarge extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private JMarge(JComponent jcomponent, int dx, int dy,Optional<String> optionalTitle)
		{
		this.jcomponent = jcomponent;
		this.dx = dx;
		this.dy = dy;
		this.optionalTitle = optionalTitle;

		geometry();
		control();
		appearance();
		}

	public JMarge(JComponent jcomponent, int dx, int dy,String title)
		{
		this(jcomponent, dx, dy, Optional.of(title));
		}

	public JMarge(JComponent jcomponent, int marge,String title)
		{
		this(jcomponent, marge, marge, title);
		}

	public JMarge(JComponent jcomponent, int dx, int dy)
		{
		this(jcomponent, dx, dy, Optional.empty());
		}

	public JMarge(JComponent jcomponent, int marge)
		{
		this(jcomponent, marge, marge, Optional.empty());
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
		this.jpanelEast = new JPanel();
		this.jpanelWest = new JPanel();
		this.jpanelNorth = new JPanel();
		this.jpanelSouth = new JPanel();

		setLayout(new BorderLayout());

		add(this.jcomponent, BorderLayout.CENTER);
		add(this.jpanelEast,BorderLayout.EAST);
		add(this.jpanelWest,BorderLayout.WEST);
		add(this.jpanelNorth,BorderLayout.NORTH);
		add(this.jpanelSouth,BorderLayout.SOUTH);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		Sizes.setVertical(jpanelNorth, dy);
		Sizes.setVertical(jpanelSouth, dy);
		Sizes.setHorizontal(jpanelEast, dx);
		Sizes.setHorizontal(jpanelWest, dx);

		if(this.optionalTitle.isPresent())
			{
			setBorder(BorderFactory.createTitledBorder(this.optionalTitle.get()));
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private JComponent jcomponent;
	private int dx;
	private int dy;
	private Optional<String> optionalTitle;

	// Tools
	private JPanel jpanelNorth;
	private JPanel jpanelSouth;
	private JPanel jpanelEast;
	private JPanel jpanelWest;
	}
