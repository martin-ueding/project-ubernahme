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
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;


/**
 * This class has been automatically generated using svg2java
 *
 */
public class TileCrosswalkHorizontal extends ConvertedGraphics implements Icon {

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
		g.setPaint(new Color(102, 102, 102, 255));
		Rectangle2D.Double shape0 = new Rectangle2D.Double(1012.3621826171875, -40.0, 40.0, 40.0);
		g.fill(shape0);
	}

	private void paintShapeNode_0_0_0_1(Graphics2D g) {
		g.setPaint(new Color(0, 0, 0, 255));
		Rectangle2D.Double shape1 = new Rectangle2D.Double(1012.3621826171875, -10.0, 40.0, 10.0);
		g.fill(shape1);
	}

	private void paintShapeNode_0_0_0_2(Graphics2D g) {
		Rectangle2D.Double shape2 = new Rectangle2D.Double(1012.3621826171875, -30.0, 40.0, 10.0);
		g.fill(shape2);
	}

	private void paintCompositeGraphicsNode_0_0_0(Graphics2D g) {
		// _0_0_0_0
		AffineTransform trans_0_0_0_0 = g.getTransform();
		g.transform(new AffineTransform(0.0f, 1.0f, -1.0f, 0.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_0(g);
		g.setTransform(trans_0_0_0_0);
		// _0_0_0_1
		AffineTransform trans_0_0_0_1 = g.getTransform();
		g.transform(new AffineTransform(0.0f, 1.0f, -1.0f, 0.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_1(g);
		g.setTransform(trans_0_0_0_1);
		// _0_0_0_2
		AffineTransform trans_0_0_0_2 = g.getTransform();
		g.transform(new AffineTransform(0.0f, 1.0f, -1.0f, 0.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_2(g);
		g.setTransform(trans_0_0_0_2);
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
		return 0;
	}

	/**
	 * Returns the Y of the bounding box of the original SVG image.
	 * @return The Y of the bounding box of the original SVG image.
	 */
	public int getOrigY() {
		return 1013;
	}

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * @return The width of the bounding box of the original SVG image.
	 */
	public int getOrigWidth() {
		return 40;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * @return The height of the bounding box of the original SVG image.
	 */
	public int getOrigHeight() {
		return 40;
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
	public TileCrosswalkHorizontal() {
		this.width = getOrigWidth();
		this.height = getOrigHeight();
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.Icon#getIconHeight()
	 */
	@Override
	public int getIconHeight() {
		return height;
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.Icon#getIconWidth()
	 */
	@Override
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

