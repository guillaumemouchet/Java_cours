
package ch.hearc.c_gui.c_dessin.a_hello;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

public class G2DDessinHello
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public G2DDessinHello(JComponent jcomponent)
		{
		this.jcomponent = jcomponent;

		this.listPetitCercles = new ArrayList<Ellipse2D.Double>();

		forme();
		control();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void draw(Graphics2D g2d, int w, int h)
		{

		g2d.draw(rectangle1);
		g2d.setColor(Color.RED); //opengl -> changer d'état

		g2d.drawString(text, 200, 200); //coin en haut à gauche du texte (cx,cy)
		g2d.setFont(font1);

		g2d.draw(line1);

		g2d.fill(ellipse1); //rempli aussi
		g2d.setColor(Color.BLUE);

		g2d.fill(arc2d1);

		g2d.drawString(text, 300, 300); //coin en haut à gauche du texte (cx,cy)

		g2d.translate(40, 40); //déplace le repair orthonormé
		g2d.rotate(Math.PI / 10); //rotation par rapport à l'origine

		g2d.draw(rectangle1);

		g2d.rotate(-Math.PI / 10); //faites le toujours
		g2d.translate(-40, -40);

		g2d.setColor(Color.BLACK);
		for(Ellipse2D.Double petitCercle:listPetitCercles)
			{
			g2d.draw(petitCercle);
			}

		System.out.println("Dessine : " + Thread.currentThread().getName());

		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void forme()
		{
		this.rectangle1 = new Rectangle2D.Double(15, 10, 80, 120); //px,py,w,h
		this.line1 = new Line2D.Double(15, 10, 50, 70); //x1,y1,x2,y2
		this.ellipse1 = new Ellipse2D.Double(100, 100, 100, 150); //cx,cy,r1,r2  c=coin,r=rayon
		this.arc2d1 = new Arc2D.Double(200, 200, 100, 100, 0, 270, Arc2D.PIE); //cx,cy,r1,r2,alpha1,alpha2,constante (angle en degre)
		this.text = "Java2D";
		this.font1 = new Font("Helvetica", Font.BOLD + Font.ITALIC, 80); //police, gras,italique,souligné , taille
		}

	private void control()
		{
		this.jcomponent.addMouseListener(createMouseListener());
		}

	private MouseListener createMouseListener()
		{
		return new MouseAdapter()
			{

			@Override
			public void mouseClicked(MouseEvent e)
				{
				int x = e.getX();
				int y = e.getY();
				Ellipse2D.Double petitCercle = new Ellipse2D.Double(x, y, 10, 10);
				listPetitCercles.add(petitCercle);

				jcomponent.repaint(); //Attention : n'est pas forcement honoré directement : asynchrone (quand il a le temps, il repaint())
				//rappel en Swing, c'est le thread AWT_QUEUE_EVENT qui s'occupe de dessiner les composents swing et qui s'occupe de gérer toute la partie évenementielle.
				//Comme son nom l'indique c'est une file d'attente : Premier arrivé, premier servi.
				//Repaint() est posté dans cette file d'attente.
				//Repaint doit attendre son tour !
				System.out.println(Thread.currentThread().getName());
				}
			};
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Inputs
	private JComponent jcomponent;

	//Tools
	private Rectangle2D.Double rectangle1;
	private Line2D.Double line1;
	private Ellipse2D.Double ellipse1;
	private Arc2D.Double arc2d1;
	private String text;
	private Font font1;

	private List<Ellipse2D.Double> listPetitCercles;
	}
