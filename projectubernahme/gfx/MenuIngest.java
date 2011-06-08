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
public class MenuIngest extends ConvertedGraphics {

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

	private void paintShapeNode_0_0_0_1_0(Graphics2D g) {
		GeneralPath shape1 = new GeneralPath();
		shape1.moveTo(243.41275, 601.7208);
		shape1.curveTo(243.41275, 601.7208, 251.7242, 482.15768, 297.14368,
				457.7835);
		shape1.curveTo(330.8001, 439.72192, 375.76263, 432.21555, 435.38806,
				454.83856);
		shape1.curveTo(486.48105, 474.2242, 491.35098, 601.7208, 491.35098,
				601.7208);
		shape1.closePath();
		g.setPaint(new Color(153, 153, 153, 255));
		g.fill(shape1);
		g.setPaint(new Color(0, 0, 0, 255));
		g.setStroke(new BasicStroke(2.7f, 0, 0, 4.0f, null, 0.0f));
		g.draw(shape1);
	}

	private void paintShapeNode_0_0_0_1_1(Graphics2D g) {
		GeneralPath shape2 = new GeneralPath();
		shape2.moveTo(399.70792, 436.01044);
		shape2.curveTo(399.70792, 466.82007, 382.12762, 491.79623, 360.44122,
				491.79623);
		shape2.curveTo(338.75482, 491.79623, 321.17453, 466.82007, 321.17453,
				436.01044);
		shape2.curveTo(321.17453, 405.20078, 338.75482, 380.22464, 360.44122,
				380.22464);
		shape2.curveTo(382.12762, 380.22464, 399.70792, 405.2008, 399.70792,
				436.01044);
		shape2.closePath();
		g.setPaint(new Color(230, 230, 230, 255));
		g.fill(shape2);
		g.setPaint(new Color(0, 0, 0, 255));
		g.setStroke(new BasicStroke(2.9011173f, 0, 0, 4.0f, null, 0.0f));
		g.draw(shape2);
	}

	private void paintCompositeGraphicsNode_0_0_0_1(Graphics2D g) {
		// _0_0_0_1_0
		AffineTransform trans_0_0_0_1_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_1_0(g);
		g.setTransform(trans_0_0_0_1_0);
		// _0_0_0_1_1
		AffineTransform trans_0_0_0_1_1 = g.getTransform();
		g.transform(new AffineTransform(1.1832237243652344f, 0.0f, 0.0f,
					1.301390290260315f, -56.27827835083008f,
					-166.61273193359375f));
		paintShapeNode_0_0_0_1_1(g);
		g.setTransform(trans_0_0_0_1_1);
	}

	private void paintShapeNode_0_0_0_2(Graphics2D g) {
		GeneralPath shape3 = new GeneralPath();
		shape3.moveTo(209.06688, 276.37952);
		shape3.lineTo(248.96931, 445.3753);
		shape3.lineTo(290.2477, 321.6482);
		shape3.lineTo(331.06744, 379.32388);
		shape3.lineTo(368.67667, 321.6482);
		shape3.lineTo(413.1656, 379.32388);
		shape3.lineTo(447.1056, 321.6482);
		shape3.lineTo(495.2637, 445.3753);
		shape3.lineTo(533.7902, 276.37952);
		shape3.closePath();
		g.setPaint(new Color(255, 255, 255, 255));
		g.fill(shape3);
		g.setPaint(new Color(0, 0, 0, 255));
		g.setStroke(new BasicStroke(1.7701435f, 0, 0, 4.0f, null, 0.0f));
		g.draw(shape3);
	}

	private void paintShapeNode_0_0_0_3_0(Graphics2D g) {
		GeneralPath shape4 = new GeneralPath();
		shape4.moveTo(447.33826, 226.60912);
		shape4.curveTo(421.52243, 226.2669, 396.59317, 227.96942, 376.44177,
				240.69115);
		shape4.curveTo(376.44177, 240.69115, 393.6145, 267.9256, 414.22324,
				248.66971);
		shape4.curveTo(433.55676, 230.60532, 447.23663, 226.56375, 447.33826,
				226.60912);
		shape4.closePath();
		g.setPaint(new Color(255, 255, 255, 255));
		g.fill(shape4);
	}

	private void paintShapeNode_0_0_0_3_1(Graphics2D g) {
		GeneralPath shape5 = new GeneralPath();
		shape5.moveTo(294.4418, 226.60912);
		shape5.curveTo(320.25763, 226.2669, 345.1869, 227.96942, 365.33826,
				240.69115);
		shape5.curveTo(365.33826, 240.69115, 348.16553, 267.9256, 327.5568,
				248.66971);
		shape5.curveTo(308.22327, 230.60532, 294.5434, 226.56375, 294.44177,
				226.60912);
		shape5.closePath();
		g.fill(shape5);
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

	private void paintCompositeGraphicsNode_0_0_0(Graphics2D g) {
		// _0_0_0_0
		AffineTransform trans_0_0_0_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 100.0f,
					85.71428680419922f));
		paintShapeNode_0_0_0_0(g);
		g.setTransform(trans_0_0_0_0);
		// _0_0_0_1
		AffineTransform trans_0_0_0_1 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f,
					4.04667329788208f, 52.0f));
		paintCompositeGraphicsNode_0_0_0_1(g);
		g.setTransform(trans_0_0_0_1);
		// _0_0_0_2
		AffineTransform trans_0_0_0_2 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_2(g);
		g.setTransform(trans_0_0_0_2);
		// _0_0_0_3
		AffineTransform trans_0_0_0_3 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f,
					0.5385333299636841f, 0.0f));
		paintCompositeGraphicsNode_0_0_0_3(g);
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
	public MenuIngest() {
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
