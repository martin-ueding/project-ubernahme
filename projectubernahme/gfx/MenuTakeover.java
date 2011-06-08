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

/**
 * This class has been automatically generated using svg2java
 *
 */
public class MenuTakeover extends ConvertedGraphics {

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
		GeneralPath shape0 = new GeneralPath();
		shape0.moveTo(525.7143, 363.79074);
		shape0.curveTo(525.7143, 504.22888, 411.8667, 618.0765, 271.4286,
				618.0765);
		shape0.curveTo(130.99045, 618.0765, 17.142853, 504.22888, 17.142853,
				363.79074);
		shape0.curveTo(17.142853, 223.35262, 130.99045, 109.50502, 271.42856,
				109.50502);
		shape0.curveTo(411.8667, 109.50502, 525.7143, 223.35262, 525.7143,
				363.79074);
		shape0.closePath();
		g.setPaint(new Color(0, 0, 0, 255));
		g.setStroke(new BasicStroke(1.0f, 0, 0, 4.0f, null, 0.0f));
		g.draw(shape0);
	}

	private void paintShapeNode_0_0_0_1(Graphics2D g) {
		GeneralPath shape1 = new GeneralPath();
		shape1.moveTo(187.41275, 601.7208);
		shape1.curveTo(187.41275, 601.7208, 195.7242, 482.15768, 241.14369,
				457.7835);
		shape1.curveTo(274.80014, 439.72192, 319.76263, 432.21555, 379.3881,
				454.83856);
		shape1.curveTo(430.48108, 474.2242, 435.351, 601.7208, 435.351,
				601.7208);
		shape1.closePath();
		g.setPaint(new Color(153, 153, 153, 255));
		g.fill(shape1);
		g.setPaint(new Color(0, 0, 0, 255));
		g.setStroke(new BasicStroke(2.7f, 0, 0, 4.0f, null, 0.0f));
		g.draw(shape1);
	}

	private void paintShapeNode_0_0_0_2(Graphics2D g) {
		GeneralPath shape2 = new GeneralPath();
		shape2.moveTo(399.70792, 436.01044);
		shape2.curveTo(399.7141, 455.94662, 392.23126, 474.3722, 380.07956,
				484.34283);
		shape2.curveTo(367.92786, 494.31348, 352.9546, 494.31348, 340.8029,
				484.34283);
		shape2.curveTo(328.65118, 474.3722, 321.16833, 455.94662, 321.17453,
				436.01044);
		shape2.curveTo(321.16833, 416.07425, 328.65118, 397.64868, 340.8029,
				387.67804);
		shape2.curveTo(352.9546, 377.7074, 367.92786, 377.7074, 380.07956,
				387.67804);
		shape2.curveTo(392.23126, 397.64868, 399.7141, 416.07425, 399.70792,
				436.01044);
		shape2.closePath();
		g.setPaint(new Color(230, 230, 230, 255));
		g.fill(shape2);
		g.setPaint(new Color(0, 0, 0, 255));
		g.setStroke(new BasicStroke(2.9011173f, 0, 0, 4.0f, null, 0.0f));
		g.draw(shape2);
	}

	private void paintShapeNode_0_0_0_3_0(Graphics2D g) {
		GeneralPath shape3 = new GeneralPath();
		shape3.moveTo(518.3011, 422.6875);
		shape3.curveTo(521.6942, 339.08295, 489.794, 286.61047, 450.1875,
				265.65625);
		shape3.curveTo(437.81046, 259.10806, 424.7277, 255.71152, 411.90625,
				255.40625);
		shape3.curveTo(383.6991, 254.73466, 356.77316, 269.06458, 341.40625,
				297.9375);
		g.setPaint(new Color(255, 255, 255, 255));
		g.setStroke(new BasicStroke(12.2f, 0, 0, 4.0f, null, 0.0f));
		g.draw(shape3);
	}

	private void paintShapeNode_0_0_0_3_1(Graphics2D g) {
		GeneralPath shape4 = new GeneralPath();
		shape4.moveTo(328.89456, 325.85962);
		shape4.lineTo(320.88837, 274.82275);
		shape4.lineTo(376.3745, 301.1689);
		shape4.closePath();
		g.fill(shape4);
		g.setStroke(new BasicStroke(3.6266668f, 0, 0, 4.0f, null, 0.0f));
		g.draw(shape4);
	}

	private void paintCompositeGraphicsNode_0_0_0_3(Graphics2D g) {
		// _0_0_0_3_0
		AffineTransform trans_0_0_0_3_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_3_0(g);
		g.setTransform(trans_0_0_0_3_0);
		// _0_0_0_3_1
		AffineTransform trans_0_0_0_3_1 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_3_1(g);
		g.setTransform(trans_0_0_0_3_1);
	}

	private void paintShapeNode_0_0_0_4(Graphics2D g) {
		GeneralPath shape5 = new GeneralPath();
		shape5.moveTo(435.43384, 433.68497);
		shape5.curveTo(461.24966, 433.34274, 486.17892, 435.0453, 506.33032,
				447.767);
		shape5.curveTo(506.33032, 447.767, 489.1576, 475.00146, 468.54886,
				455.74554);
		shape5.curveTo(449.21533, 437.68112, 435.53546, 433.6396, 435.43384,
				433.68494);
		shape5.closePath();
		g.fill(shape5);
	}

	private void paintShapeNode_0_0_0_5(Graphics2D g) {
		GeneralPath shape6 = new GeneralPath();
		shape6.moveTo(592.3303, 433.68497);
		shape6.curveTo(566.51447, 433.34274, 541.5852, 435.0453, 521.43384,
				447.767);
		shape6.curveTo(521.43384, 447.767, 538.60657, 475.00146, 559.2153,
				455.74554);
		shape6.curveTo(578.5488, 437.68112, 592.2287, 433.6396, 592.33026,
				433.68494);
		shape6.closePath();
		g.fill(shape6);
	}

	private void paintCompositeGraphicsNode_0_0_0(Graphics2D g) {
		// _0_0_0_0
		AffineTransform trans_0_0_0_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 100.0f,
					85.71428680419922f));
		paintShapeNode_0_0_0_0(g);
		g.setTransform(trans_0_0_0_0);
		// _0_0_0_1
		AffineTransform trans_0_0_0_1 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_1(g);
		g.setTransform(trans_0_0_0_1);
		// _0_0_0_2
		AffineTransform trans_0_0_0_2 = g.getTransform();
		g.transform(new AffineTransform(1.1832237243652344f, 0.0f, 0.0f,
					1.301390290260315f, -112.27828216552734f,
					-166.61273193359375f));
		paintShapeNode_0_0_0_2(g);
		g.setTransform(trans_0_0_0_2);
		// _0_0_0_3
		AffineTransform trans_0_0_0_3 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintCompositeGraphicsNode_0_0_0_3(g);
		g.setTransform(trans_0_0_0_3);
		// _0_0_0_4
		AffineTransform trans_0_0_0_4 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_4(g);
		g.setTransform(trans_0_0_0_4);
		// _0_0_0_5
		AffineTransform trans_0_0_0_5 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_5(g);
		g.setTransform(trans_0_0_0_5);
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
		return 117;
	}

	/**
	 * Returns the Y of the bounding box of the original SVG image.
	 * @return The Y of the bounding box of the original SVG image.
	 */
	public int getOrigY() {
		return 195;
	}

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * @return The width of the bounding box of the original SVG image.
	 */
	public int getOrigWidth() {
		return 510;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * @return The height of the bounding box of the original SVG image.
	 */
	public int getOrigHeight() {
		return 510;
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
	public MenuTakeover() {
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

