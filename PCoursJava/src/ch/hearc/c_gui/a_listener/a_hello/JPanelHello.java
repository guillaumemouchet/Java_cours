
package ch.hearc.c_gui.a_listener.a_hello;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelHello extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelHello(JFrameHello jframehello)
		{
		this.jframehello = jframehello;
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
		this.button = new JButton("b1");
		this.label = new JLabel("l1");
		add(this.button); // Permet de mettre un JComponent dans le JPanel
		add(this.label);
		}

	private void appearance()
		{
		this.button.setBackground(Color.RED);
		this.button.setForeground(Color.BLUE);
		this.label.setForeground(Color.GREEN);
		}

	private void control()
		{
		this.button.addActionListener(createActionListener());
		this.addMouseListener(createMouseListener("Panel click "));
		this.label.addMouseListener(createMouseListener("Label click "));
		addComponentListener(createComponentListener());
		}

	private ComponentListener createComponentListener() // pas de static ici
		{
		return new ComponentAdapter()
			{

			@Override
			public void componentResized(ComponentEvent e)
				{
				//System.out.println("resized window to " + this.getSize()); // ne compile pas car this référencie la cia et non la classe englobante
				//System.out.println("resized window to " + JPanelHello.this.getSize()); // this est celui de la classe JPanelHello
				System.out.println("resized window to " + getSize()); // Le compilateur ne trouve pas la méthode getSize() dans la classe interne anonyme dans ce cas il la cherche dans la classe englobante.
				JPanelHello.this.jframehello.setTitle(getSize().toString());
				//jframehello.setTitle(getSize().toString());
				}
			};
		}

	private static ActionListener createActionListener()
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				System.out.println("Click!");
				}
			};
		}

	private static MouseListener createMouseListener(String message)
		{
		return new MouseAdapter()
			{

			@Override
			public void mouseClicked(MouseEvent e)
				{
				System.out.println(message + e.getPoint());
				}
			};
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JButton button;
	private JLabel label;

	// Input
	private JFrameHello jframehello;
	}
