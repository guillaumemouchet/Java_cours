
package ch.hearc.c_gui.a_listener.a_hello;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class JFrameHello extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameHello()
		{
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
		this.jpanelhello = new JPanelHello(this);
		add(this.jpanelhello); // raccourci syntaxique
		//getContentPane().add(this.jpanelhello); // idem 39
		}

	private void control()
		{
		// V0
		//setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// V1
		//addWindowListener(createWindowListenerV1());

		// V2
		//addWindowListener(createWindowListenerV2());

		// V3
		addWindowListener(createWindowListenerV3());
		}

	private static WindowListener createWindowListenerV1()
		{
		// Pas génial car il y a plein de méthodes dont on a pas besoin, qui allongent inutilement le code et qui rende sa lecture difficile.
		return new WindowListener()
			{

			@Override
			public void windowOpened(WindowEvent e)
				{
				// rien
				}

			@Override
			public void windowIconified(WindowEvent e)
				{
				// rien
				}

			@Override
			public void windowDeiconified(WindowEvent e)
				{
				// rien
				}

			@Override
			public void windowDeactivated(WindowEvent e)
				{
				// rien
				}

			@Override
			public void windowClosing(WindowEvent e)
				{
				System.exit(0); // 0 normal, -1 anormal
				}

			@Override
			public void windowClosed(WindowEvent e)
				{
				// rien
				}

			@Override
			public void windowActivated(WindowEvent e)
				{
				// rien
				}

			};
		}

	private static WindowListener createWindowListenerV2()
		{
		return new WindowAdapteur()
			{

			@Override
			public void windowClosing(WindowEvent e)
				{
				System.exit(0); // 0 normal, -1 anormal
				}
			};
		}

	private WindowListener createWindowListenerV3()
		{
		return new WindowAdapter()
			{

			@Override
			public void windowClosing(WindowEvent e)
				{
				System.out.println("Sauvegarder les données de l'utilisateur par ex");
				System.exit(0); // 0 normal, -1 anormal
				}
			};
		}

	private void appearance()
		{
		setSize(1200, 720);
		//setLocation(330, 50);
		setLocationRelativeTo(null); // centrage automatique
		setTitle("Hello");
		getContentPane().setBackground(Color.RED);
		setVisible(true); // En dernier !
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanelHello jpanelhello;
	}
