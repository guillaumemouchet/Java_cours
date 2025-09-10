package ch.hearc.c_gui.c_dessin.d_image.b_custom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JCustom extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JCustom()
		{
		this.g2dCustom = new G2DCustom(this);
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g);

		Graphics2D g2D = (Graphics2D)g;

		AffineTransform transform = g2D.getTransform(); //sauvegarde
		Color color = g2D.getColor(); //sauvegarde
		Font font = g2D.getFont(); //sauvegarde

		this.g2dCustom.draw(g2D, this.getSize().width, this.getSize().height);

		g2D.setFont(font); //restore
		g2D.setColor(color); //restore
		g2D.setTransform(transform); //restore
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		this.buttonStart = new JButton("Start");
		this.buttonStop = new JButton("Stop");


		add(this.buttonStart);
		add(this.buttonStop);
		}

	private void appearance()
		{
		// rien
		}

	private void control()
		{
		this.buttonStop.setEnabled(false);
		this.buttonStart.setEnabled(true);
		this.buttonStart.addActionListener(createActionListenerStart());
		this.buttonStop.addActionListener(createActionListenerStop());


		}


	private ActionListener createActionListenerStart()
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				inverserEtatButton();
				g2dCustom.start();
				}
			};
		}

	private ActionListener createActionListenerStop()
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				inverserEtatButton();
				g2dCustom.stop();
				}
			};
		}

	private void inverserEtatButton()
		{
		this.buttonStart.setEnabled(!this.buttonStart.isEnabled());
		this.buttonStop.setEnabled(!this.buttonStop.isEnabled());
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private G2DCustom g2dCustom;
	private JButton buttonStart;
	private JButton buttonStop;

	}
