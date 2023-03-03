
package ch.arc.cours.lamda.image.framework.animation;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JAnimator extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JAnimator(Animator_I animator)
		{
		this.animator = animator;

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		this.buttonStart = new JButton("Start");
		this.buttonStop = new JButton("Stop");

		setLayout(new FlowLayout(FlowLayout.CENTER));

		add(buttonStart);
		add(buttonStop);
		}

	private void control()
		{
		buttonStart.addActionListener(e -> start());
		buttonStop.addActionListener(e -> stop());

		String message="Calcul parallel don't freeze GUI, oh!";
		buttonStart.setToolTipText(message);
		buttonStop.setToolTipText(message);
		}

	private void appearance()
		{
		buttonStart.setEnabled(!animator.isStarted());
		buttonStop.setEnabled(animator.isStarted());

		this.setOpaque(false);
		//setBackground(Color.GREEN);

		setPreferredSize(new Dimension(200, 40));
		setMinimumSize(new Dimension(200, 40));
		setMaximumSize(new Dimension(200, 40));
		}

	private void inverserEnable()
		{
		buttonStart.setEnabled(!buttonStart.isEnabled());
		buttonStop.setEnabled(!buttonStop.isEnabled());
		}

	private void start()
		{
		animator.start();
		inverserEnable();
		}

	private void stop()
		{
		animator.stop();
		inverserEnable();
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private Animator_I animator;

	// Tools
	private JButton buttonStart;
	private JButton buttonStop;

	}
