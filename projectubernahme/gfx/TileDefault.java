// Copyright (c) 2011 Martin Ueding <dev@martin-ueding.de>

package projectubernahme.gfx;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

public class TileDefault extends ConvertedGraphics {

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
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
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
		Rectangle2D.Double shape0 = new Rectangle2D.Double(185.7142791748047,
				255.21932983398438, 262.8571472167969, 262.8571472167969);
		g.setPaint(new Color(255, 230, 213, 255));
		g.fill(shape0);
		g.setPaint(new Color(0, 0, 0, 255));
		g.setStroke(new BasicStroke(1.0f, 0, 0, 4.0f, null, 0.0f));
		g.draw(shape0);
	}

	private void paintTextNode_0_0_0_1(Graphics2D g) {
		g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
		g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
		g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
		GeneralPath shape1 = new GeneralPath();
		shape1.moveTo(-87.949165, 609.9237);
		shape1.lineTo(-87.949165, 581.87415);
		shape1.lineTo(-59.8996, 581.87415);
		shape1.lineTo(-59.8996, 609.9237);
		shape1.closePath();
		shape1.moveTo(-87.949165, 553.8246);
		shape1.lineTo(-87.949165, 544.47473);
		shape1.quadTo(-87.949165, 516.4252, -69.24946, 493.0505);
		shape1.lineTo(-59.8996, 479.02573);
		shape1.quadTo(-36.524963, 455.6511, -36.524963, 436.9514);
		shape1.quadTo(-36.524963, 422.9266, -45.874817, 415.9142);
		shape1.quadTo(-55.224674, 408.90182, -73.924385, 408.90182);
		shape1.quadTo(-92.62409, 408.90182, -120.67366, 422.9266);
		shape1.lineTo(-120.67366, 394.87704);
		shape1.quadTo(-92.62409, 390.20212, -69.24946, 390.20212);
		shape1.quadTo(-41.19989, 390.20212, -22.50018, 401.88943);
		shape1.quadTo(-3.8004696, 413.57675, -3.8004696, 436.9514);
		shape1.quadTo(-3.8004696, 450.97617, -8.475397, 460.32602);
		shape1.quadTo(-13.150325, 469.67587, -27.175108, 483.70065);
		shape1.lineTo(-36.524963, 493.0505);
		shape1.quadTo(-50.549744, 502.40036, -55.224674, 511.7502);
		shape1.quadTo(-59.8996, 521.1001, -59.8996, 535.1249);
		shape1.lineTo(-59.8996, 553.8246);
		shape1.closePath();
		g.setPaint(new Color(255, 102, 0, 255));
		g.fill(shape1);
		g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
	}

	private void paintCompositeGraphicsNode_0_0_0(Graphics2D g) {
		// _0_0_0_0
		AffineTransform trans_0_0_0_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_0(g);
		g.setTransform(trans_0_0_0_0);
		// _0_0_0_1
		AffineTransform trans_0_0_0_1 = g.getTransform();
		g.transform(new AffineTransform(0.7102301120758057f,
					-0.7039696574211121f, 0.7039696574211121f,
					0.7102301120758057f, 0.0f, 0.0f));
		paintTextNode_0_0_0_1(g);
		g.setTransform(trans_0_0_0_1);
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
		return 186;
	}

	/**
	 * Returns the Y of the bounding box of the original SVG image.
	 * @return The Y of the bounding box of the original SVG image.
	 */
	public int getOrigY() {
		return 255;
	}

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * @return The width of the bounding box of the original SVG image.
	 */
	public int getOrigWidth() {
		return 264;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * @return The height of the bounding box of the original SVG image.
	 */
	public int getOrigHeight() {
		return 264;
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
	public TileDefault() {
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
