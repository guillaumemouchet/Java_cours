
package ch.hearc.c_gui.c_dessin.c_exercice;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import ch.hearc.c_gui.tools.G2D_I;

public class G2DPolygoneV2 implements G2D_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public G2DPolygoneV2(int cote, int n)
		{
		this.cote = cote;
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
		this.line = new Line2D.Double(0, 0, cote, 0);
		}

	private void drawHexagon(Graphics2D g2d)
		{
		double dAlpha = Math.PI * 2 / this.n;
		for(int i = 0; i < this.n; i++)
			{
			g2d.draw(this.line);
			g2d.translate(cote, 0);
			g2d.rotate(dAlpha);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//input
	private int cote;
	private int n;

	//tools
	private Line2D.Double line;
	}
