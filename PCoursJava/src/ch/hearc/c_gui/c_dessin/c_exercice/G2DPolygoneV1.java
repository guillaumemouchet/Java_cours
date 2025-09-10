
package ch.hearc.c_gui.c_dessin.c_exercice;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import ch.hearc.c_gui.tools.G2D_I;

public class G2DPolygoneV1 implements G2D_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public G2DPolygoneV1(int rayon, int n)
		{
		this.rayon = rayon;
		this.n = n;
		forme();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void draw(Graphics2D g2d, int w, int h)
		{
		g2d.translate(w / 2, h / 2);
		drawHexagon(g2d);
		g2d.translate(-w / 2, -h / 2);
		}

	private void forme()
		{
		this.line = new Line2D.Double(0, -this.rayon * Math.sin(Math.PI / this.n), 0, this.rayon * Math.sin(Math.PI / this.n));
		}

	private void drawHexagon(Graphics2D g2d)
		{
		double apothem = this.rayon * Math.cos(Math.PI / this.n);
		double dalpha = Math.PI*2/this.n;
		for(int i = 0; i < this.n; i++)
			{
			g2d.translate(apothem, 0);
			g2d.draw(line);
			g2d.translate(-apothem, 0);
			g2d.rotate(dalpha);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//input
	private int rayon;
	private int n;

	//tools
	private Line2D.Double line;
	}

