// Copyright (c) 2011 Martin Ueding <dev@martin-ueding.de>

package projectubernahme.gfx;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;


public class LifeformZombieGraphics extends ConvertedGraphics {

	private float origAlpha = 1.0f;

	/**
	 * Paints the transcoded SVG image on the specified graphics context. You
	 * can install a custom transformation on the graphics context to scale the
	 * image.
	 * 
	 * @param g
	 *            Graphics context.
	 */
	public void paint(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        origAlpha = 1.0f;
        Composite origComposite = g.getComposite();
        if (origComposite instanceof AlphaComposite) {
            AlphaComposite origAlphaComposite = 
                (AlphaComposite)origComposite;
            if (origAlphaComposite.getRule() == AlphaComposite.SRC_OVER) {
                origAlpha = origAlphaComposite.getAlpha();
            }
        }
        
		// _0
		AffineTransform trans_0 = g.getTransform();
		paintRootGraphicsNode_0(g);
		g.setTransform(trans_0);

	}

	private void paintShapeNode_0_0_0_0(Graphics2D g) {
		GeneralPath shape0 = new GeneralPath();
		shape0.moveTo(361.12845, 537.5939);
		shape0.curveTo(361.13504, 543.1699, 356.90073, 548.32446, 350.02213, 551.11383);
		shape0.curveTo(343.14352, 553.9032, 334.6668, 553.9032, 327.7882, 551.11383);
		shape0.curveTo(320.9096, 548.32446, 316.6753, 543.1699, 316.6819, 537.5939);
		shape0.curveTo(316.6819, 528.97876, 326.6316, 521.9948, 338.90518, 521.9948);
		shape0.curveTo(351.17877, 521.9948, 361.12848, 528.97876, 361.12848, 537.5939);
		shape0.closePath();
		g.setPaint(new Color(255, 0, 0, 255));
		g.fill(shape0);
	}

	private void paintShapeNode_0_0_0_1(Graphics2D g) {
		GeneralPath shape1 = new GeneralPath();
		shape1.moveTo(241.03722, 545.9276);
		shape1.curveTo(241.04062, 548.67816, 239.53442, 551.2211, 237.08679, 552.59735);
		shape1.curveTo(234.63916, 553.9736, 231.62256, 553.9736, 229.17493, 552.59735);
		shape1.curveTo(226.7273, 551.2211, 225.2211, 548.67816, 225.2245, 545.9276);
		shape1.curveTo(225.2211, 543.17706, 226.7273, 540.6341, 229.17493, 539.2579);
		shape1.curveTo(231.62256, 537.88165, 234.63916, 537.88165, 237.08679, 539.2579);
		shape1.curveTo(239.53442, 540.6341, 241.04062, 543.17706, 241.03722, 545.9276);
		shape1.closePath();
		g.setPaint(new Color(36, 28, 28, 255));
		g.fill(shape1);
	}

	private void paintShapeNode_0_0_0_2(Graphics2D g) {
		GeneralPath shape2 = new GeneralPath();
		shape2.moveTo(334.2041, 597.85315);
		shape2.curveTo(334.2075, 599.45764, 332.7013, 600.94104, 330.25366, 601.74384);
		shape2.curveTo(327.80603, 602.54663, 324.78946, 602.54663, 322.34183, 601.74384);
		shape2.curveTo(319.8942, 600.94104, 318.388, 599.45764, 318.3914, 597.85315);
		shape2.curveTo(318.388, 596.24866, 319.8942, 594.76526, 322.34183, 593.96246);
		shape2.curveTo(324.78946, 593.15967, 327.80603, 593.15967, 330.25366, 593.96246);
		shape2.curveTo(332.7013, 594.76526, 334.2075, 596.24866, 334.2041, 597.85315);
		shape2.closePath();
		g.setPaint(new Color(255, 0, 0, 255));
		g.fill(shape2);
	}

	private void paintShapeNode_0_0_0_3(Graphics2D g) {
		GeneralPath shape3 = new GeneralPath();
		shape3.moveTo(334.2041, 597.85315);
		shape3.curveTo(334.2075, 599.45764, 332.7013, 600.94104, 330.25366, 601.74384);
		shape3.curveTo(327.80603, 602.54663, 324.78946, 602.54663, 322.34183, 601.74384);
		shape3.curveTo(319.8942, 600.94104, 318.388, 599.45764, 318.3914, 597.85315);
		shape3.curveTo(318.388, 596.24866, 319.8942, 594.76526, 322.34183, 593.96246);
		shape3.curveTo(324.78946, 593.15967, 327.80603, 593.15967, 330.25366, 593.96246);
		shape3.curveTo(332.7013, 594.76526, 334.2075, 596.24866, 334.2041, 597.85315);
		shape3.closePath();
		g.fill(shape3);
	}

	private void paintCompositeGraphicsNode_0_0_0(Graphics2D g) {
		// _0_0_0_0
		AffineTransform trans_0_0_0_0 = g.getTransform();
		g.transform(new AffineTransform(0.0f, 1.0f, -1.0f, 0.0f, 875.4306030273438f, 196.76553344726562f));
		paintShapeNode_0_0_0_0(g);
		g.setTransform(trans_0_0_0_0);
		// _0_0_0_1
		AffineTransform trans_0_0_0_1 = g.getTransform();
		g.transform(new AffineTransform(0.0f, 1.7567566633224487f, -2.027777910232544f, 0.0f, 1447.84814453125f, 126.3301773071289f));
		paintShapeNode_0_0_0_1(g);
		g.setTransform(trans_0_0_0_1);
		// _0_0_0_2
		AffineTransform trans_0_0_0_2 = g.getTransform();
		g.transform(new AffineTransform(-1.817752480506897f, 0.2958768308162689f, -0.5715018510818481f, -0.9410832524299622f, 1287.8731689453125f, 980.971435546875f));
		paintShapeNode_0_0_0_2(g);
		g.setTransform(trans_0_0_0_2);
		// _0_0_0_3
		AffineTransform trans_0_0_0_3 = g.getTransform();
		g.transform(new AffineTransform(-1.817752480506897f, -0.2958768308162689f, -0.5715018510818481f, 0.9410832524299622f, 1287.4766845703125f, 91.48832702636719f));
		paintShapeNode_0_0_0_3(g);
		g.setTransform(trans_0_0_0_3);
	}

	private void paintCanvasGraphicsNode_0_0(Graphics2D g) {
		// _0_0_0
		AffineTransform trans_0_0_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintCompositeGraphicsNode_0_0_0(g);
		g.setTransform(trans_0_0_0);
	}

	private void paintRootGraphicsNode_0(Graphics2D g) {
		// _0_0
		g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
		AffineTransform trans_0_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintCanvasGraphicsNode_0_0(g);
		g.setTransform(trans_0_0);
	}



    /**
     * Returns the X of the bounding box of the original SVG image.
     * @return The X of the bounding box of the original SVG image.
     */
    public int getOrigX() {
        return 322;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * @return The Y of the bounding box of the original SVG image.
     */
    public int getOrigY() {
        return 509;
    }

    /**
     * Returns the width of the bounding box of the original SVG image.
     * @return The width of the bounding box of the original SVG image.
     */
    public int getOrigWidth() {
        return 49;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     * @return The height of the bounding box of the original SVG image.
     */
    public int getOrigHeight() {
        return 57;
    }
    
    
	/**
	 * The current width of this resizable icon.
	 */
	int width;

	/**
	 * The current height of this resizable icon.
	 */
	int height;

	/**
	 * Creates a new transcoded SVG image.
	 */
	public LifeformZombieGraphics() {
        this.width = getOrigWidth();
        this.height = getOrigHeight();
	}


	public int getIconHeight() {
		return height;
	}


	public int getIconWidth() {
		return width;
	}

	/*
	 * Set the dimension of the icon.
	 */

	public void setDimension(Dimension newDimension) {
		this.width = newDimension.width;
		this.height = newDimension.height;
	}


	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.translate(x, y);

		double coef1 = (double) this.width / (double) getOrigWidth();
		double coef2 = (double) this.height / (double) getOrigHeight();
		double coef = Math.min(coef1, coef2);
		g2d.scale(coef, coef);
		paint(g2d);
		g2d.dispose();
	}
}
