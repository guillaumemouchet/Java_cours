
package ch.hearc.c_gui.c_dessin.b_repere;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ch.hearc.c_gui.tools.Sizes;

public class JControl extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JControl(G2DBidule g2dBidule)
		{
		this.g2dBidule = g2dBidule;
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
		this.labelError = new JLabel("Error");

		this.sliderTime = new JSlider(1, 100);
		this.sliderTime.setValue(5);

		SpinnerNumberModel model1 = new SpinnerNumberModel(500, 0, 10000, 1); //valeur par défault, min, max,step
		this.spinnerDeltaAnimation = new JSpinner(model1);
		this.textfieldNumberCharriot = new JTextField("16");

		add(this.sliderTime);
		add(this.spinnerDeltaAnimation);
		add(this.textfieldNumberCharriot);
		}

	private void control()
		{
		this.spinnerDeltaAnimation.addChangeListener(createChangeListenerSpinner());
		this.sliderTime.addChangeListener(createChangeListenerSlider());
		this.textfieldNumberCharriot.getDocument().addDocumentListener(createDocumentListener());

		this.spinnerDeltaAnimation.setToolTipText("permet de changer le delta animation Pi / X represant le nb");
		this.sliderTime.setToolTipText("permet de changer le temps sleep");
		this.textfieldNumberCharriot.setToolTipText("permet de changer le nombre de charriots");
		}

	private void appearance()
		{
		Sizes.setHorizontal(this.textfieldNumberCharriot, 20);
		Sizes.setVertical(this.textfieldNumberCharriot,  20);
		setOpaque(false);
		}

	private DocumentListener createDocumentListener()
		{
		return new DocumentListener()
			{

			@Override
			public void insertUpdate(DocumentEvent e)
				{
				try
					{
					remove(labelError);
					revalidate();
					int number = Integer.parseInt(textfieldNumberCharriot.getText());
					g2dBidule.setNbCharriot(Math.min(99, Math.max(0, number)));
					}
				catch (Exception exception)
					{
					add(labelError);
					revalidate();
					}
				}

			@Override
			public void removeUpdate(DocumentEvent e)
				{
				//rien
				}

			@Override
			public void changedUpdate(DocumentEvent e)
				{
				//rien
				}

			};
		}

	private ChangeListener createChangeListenerSlider()
		{
		return new ChangeListener()
			{

			@Override
			public void stateChanged(ChangeEvent e)
				{
				g2dBidule.setTimeSleep(Math.max(0, sliderTime.getValue()));
				}
			};
		}

	private ChangeListener createChangeListenerSpinner()
		{
		return new ChangeListener()
			{

			@Override
			public void stateChanged(ChangeEvent e)
				{
				g2dBidule.setDeltaAlphaAnimation(Math.PI / (Math.max(0, Integer.parseInt(spinnerDeltaAnimation.getValue().toString()))));
				}
			};
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private G2DBidule g2dBidule;

	// Tools
	private JSlider sliderTime;
	private JSpinner spinnerDeltaAnimation;
	private JTextField textfieldNumberCharriot;
	private JLabel labelError;

	}
