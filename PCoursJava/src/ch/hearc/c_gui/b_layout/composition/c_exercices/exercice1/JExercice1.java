package ch.hearc.c_gui.b_layout.composition.c_exercices.exercice1;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import ch.hearc.c_gui.b_layout.composition.a_demo.JDemo;
import ch.hearc.c_gui.b_layout.composition.c_exercices.exercice1.atome.JBottomBar;
import ch.hearc.c_gui.b_layout.composition.c_exercices.exercice1.atome.JTopBar;

public class JExercice1 extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JExercice1()
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
		this.jtopbar = new JTopBar();
		this.jbottombar = new JBottomBar();
		this.jdemo = new JDemo();

		setLayout(new BorderLayout());

		add(this.jtopbar,BorderLayout.NORTH);
		add(this.jdemo, BorderLayout.CENTER);
		add(this.jbottombar, BorderLayout.SOUTH);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		setBackground(Color.MAGENTA);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private JTopBar jtopbar;
	private JDemo jdemo;
	private JBottomBar jbottombar;

	}
