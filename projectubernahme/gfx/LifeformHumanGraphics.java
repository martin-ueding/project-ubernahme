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

public class LifeformHumanGraphics extends ConvertedGraphics {
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

	private void paintShapeNode_0_0_0_0_0(Graphics2D g) {
		GeneralPath shape0 = new GeneralPath();
		shape0.moveTo(361.12845, 537.5939);
		shape0.curveTo(361.12845, 546.209, 351.17874, 553.19293, 338.90515, 553.19293);
		shape0.curveTo(326.63156, 553.19293, 316.68185, 546.209, 316.68185, 537.5939);
		shape0.curveTo(316.68185, 528.97876, 326.63156, 521.9948, 338.90515, 521.9948);
		shape0.curveTo(351.17874, 521.9948, 361.12845, 528.97876, 361.12845, 537.5939);
		shape0.closePath();
		g.setPaint(new Color(0, 0, 128, 255));
		g.fill(shape0);
	}

	private void paintShapeNode_0_0_0_0_1(Graphics2D g) {
		GeneralPath shape1 = new GeneralPath();
		shape1.moveTo(241.03722, 545.9276);
		shape1.curveTo(241.03722, 550.17615, 237.49742, 553.6203, 233.13086, 553.6203);
		shape1.curveTo(228.7643, 553.6203, 225.2245, 550.17615, 225.2245, 545.9276);
		shape1.curveTo(225.2245, 541.6791, 228.7643, 538.2349, 233.13086, 538.2349);
		shape1.curveTo(237.49742, 538.2349, 241.03722, 541.679, 241.03722, 545.9276);
		shape1.closePath();
		g.setPaint(new Color(36, 28, 28, 255));
		g.fill(shape1);
	}

	private void paintShapeNode_0_0_0_0_2(Graphics2D g) {
		GeneralPath shape2 = new GeneralPath();
		shape2.moveTo(334.2041, 597.85315);
		shape2.curveTo(334.2041, 600.3315, 330.6643, 602.3405, 326.29773, 602.3405);
		shape2.curveTo(321.93118, 602.3405, 318.39136, 600.3314, 318.39136, 597.85315);
		shape2.curveTo(318.39136, 595.3748, 321.93115, 593.3657, 326.29773, 593.3657);
		shape2.curveTo(330.66428, 593.3657, 334.2041, 595.3748, 334.2041, 597.85315);
		shape2.closePath();
		g.setPaint(new Color(0, 0, 128, 255));
		g.fill(shape2);
	}

	private void paintShapeNode_0_0_0_0_3(Graphics2D g) {
		GeneralPath shape3 = new GeneralPath();
		shape3.moveTo(334.2041, 597.85315);
		shape3.curveTo(334.2041, 600.3315, 330.6643, 602.3405, 326.29773, 602.3405);
		shape3.curveTo(321.93118, 602.3405, 318.39136, 600.3314, 318.39136, 597.85315);
		shape3.curveTo(318.39136, 595.3748, 321.93115, 593.3657, 326.29773, 593.3657);
		shape3.curveTo(330.66428, 593.3657, 334.2041, 595.3748, 334.2041, 597.85315);
		shape3.closePath();
		g.fill(shape3);
	}

	private void paintCompositeGraphicsNode_0_0_0_0(Graphics2D g) {
		// _0_0_0_0_0
		AffineTransform trans_0_0_0_0_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_0_0(g);
		g.setTransform(trans_0_0_0_0_0);
		// _0_0_0_0_1
		AffineTransform trans_0_0_0_0_1 = g.getTransform();
		g.transform(new AffineTransform(1.7567566633224487f, 0.0f, 0.0f, 2.027777910232544f, -70.43534851074219f, -572.4176025390625f));
		paintShapeNode_0_0_0_0_1(g);
		g.setTransform(trans_0_0_0_0_1);
		// _0_0_0_0_2
		AffineTransform trans_0_0_0_0_2 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -9.829532623291016f, -59.831932067871094f));
		paintShapeNode_0_0_0_0_2(g);
		g.setTransform(trans_0_0_0_0_2);
		// _0_0_0_0_3
		AffineTransform trans_0_0_0_0_3 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 35.8991584777832f, -60.25930404663086f));
		paintShapeNode_0_0_0_0_3(g);
		g.setTransform(trans_0_0_0_0_3);
	}

	private void paintCompositeGraphicsNode_0_0_0(Graphics2D g) {
		// _0_0_0_0
		AffineTransform trans_0_0_0_0 = g.getTransform();
		g.transform(new AffineTransform(0.0f, 1.0f, -1.0f, 0.0f, 875.4306030273438f, 196.76553344726562f));
		paintCompositeGraphicsNode_0_0_0_0(g);
		g.setTransform(trans_0_0_0_0);
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
		return 323;
	}

	/**
	 * Returns the Y of the bounding box of the original SVG image.
	 * @return The Y of the bounding box of the original SVG image.
	 */
	public int getOrigY() {
		return 506;
	}

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * @return The width of the bounding box of the original SVG image.
	 */
	public int getOrigWidth() {
		return 35;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * @return The height of the bounding box of the original SVG image.
	 */
	public int getOrigHeight() {
		return 62;
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
	public LifeformHumanGraphics() {
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
