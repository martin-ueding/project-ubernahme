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


public class LifeformTreeGraphics extends ConvertedGraphics {

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
		shape0.moveTo(325.7143, 376.6479);
		shape0.curveTo(325.7203, 387.36908, 318.64224, 397.27798, 307.14774, 402.63998);
		shape0.curveTo(295.65323, 408.00198, 281.48965, 408.00198, 269.99515, 402.63998);
		shape0.curveTo(258.50064, 397.27798, 251.42258, 387.36908, 251.42859, 376.6479);
		shape0.curveTo(251.42258, 365.9267, 258.50064, 356.0178, 269.99515, 350.6558);
		shape0.curveTo(281.48965, 345.2938, 295.65323, 345.2938, 307.14774, 350.6558);
		shape0.curveTo(318.64224, 356.0178, 325.7203, 365.9267, 325.7143, 376.6479);
		shape0.closePath();
		g.setPaint(new Color(0, 128, 0, 255));
		g.fill(shape0);
		g.setPaint(new Color(0, 0, 0, 255));
		g.setStroke(new BasicStroke(1.4f,0,0,4.0f,null,0.0f));
		g.draw(shape0);
	}

	private void paintShapeNode_0_0_0_1(Graphics2D g) {
		GeneralPath shape1 = new GeneralPath();
		shape1.moveTo(377.14285, 415.21933);
		shape1.curveTo(377.14285, 434.15482, 359.23425, 449.50504, 337.14285, 449.50504);
		shape1.curveTo(315.05145, 449.50504, 297.14285, 434.15482, 297.14285, 415.21933);
		shape1.curveTo(297.14285, 396.28384, 315.05145, 380.93362, 337.14285, 380.93362);
		shape1.curveTo(359.23425, 380.93362, 377.14285, 396.28384, 377.14285, 415.21933);
		shape1.closePath();
		g.setPaint(new Color(0, 128, 0, 255));
		g.fill(shape1);
		g.setPaint(new Color(0, 0, 0, 255));
		g.draw(shape1);
	}

	private void paintShapeNode_0_0_0_2(Graphics2D g) {
		GeneralPath shape2 = new GeneralPath();
		shape2.moveTo(322.85715, 426.6479);
		shape2.curveTo(322.85715, 450.31723, 302.39017, 469.50504, 277.14285, 469.50504);
		shape2.curveTo(251.89555, 469.50504, 231.42857, 450.31723, 231.42857, 426.6479);
		shape2.curveTo(231.42857, 402.97855, 251.89555, 383.79074, 277.14285, 383.79074);
		shape2.curveTo(302.39017, 383.79074, 322.85715, 402.97855, 322.85715, 426.6479);
		shape2.closePath();
		g.setPaint(new Color(0, 128, 0, 255));
		g.fill(shape2);
		g.setPaint(new Color(0, 0, 0, 255));
		g.draw(shape2);
	}

	private void paintShapeNode_0_0_0_3(Graphics2D g) {
		GeneralPath shape3 = new GeneralPath();
		shape3.moveTo(277.14285, 390.93362);
		shape3.curveTo(277.14285, 407.50217, 261.7926, 420.93362, 242.85715, 420.93362);
		shape3.curveTo(223.92166, 420.93362, 208.57143, 407.50217, 208.57143, 390.93362);
		shape3.curveTo(208.57143, 374.36508, 223.92166, 360.93362, 242.85715, 360.93362);
		shape3.curveTo(261.7926, 360.93362, 277.14285, 374.36508, 277.14285, 390.93362);
		shape3.closePath();
		g.setPaint(new Color(0, 128, 0, 255));
		g.fill(shape3);
		g.setPaint(new Color(0, 0, 0, 255));
		g.draw(shape3);
	}

	private void paintShapeNode_0_0_0_4(Graphics2D g) {
		GeneralPath shape4 = new GeneralPath();
		shape4.moveTo(262.85715, 462.36218);
		shape4.curveTo(262.8628, 471.0414, 256.6015, 479.06314, 246.43315, 483.404);
		shape4.curveTo(236.26479, 487.7448, 223.73523, 487.7448, 213.56686, 483.404);
		shape4.curveTo(203.39851, 479.06314, 197.1372, 471.0414, 197.14287, 462.36218);
		shape4.curveTo(197.1372, 453.68295, 203.39851, 445.66122, 213.56686, 441.32037);
		shape4.curveTo(223.73523, 436.97955, 236.26479, 436.97955, 246.43315, 441.32037);
		shape4.curveTo(256.6015, 445.66122, 262.8628, 453.68295, 262.85715, 462.36218);
		shape4.closePath();
		g.setPaint(new Color(0, 128, 0, 255));
		g.fill(shape4);
		g.setPaint(new Color(0, 0, 0, 255));
		g.draw(shape4);
	}

	private void paintShapeNode_0_0_0_5(Graphics2D g) {
		GeneralPath shape5 = new GeneralPath();
		shape5.moveTo(371.42856, 465.21933);
		shape5.curveTo(371.42856, 484.9438, 353.51996, 500.93362, 331.42856, 500.93362);
		shape5.curveTo(309.33716, 500.93362, 291.42856, 484.9438, 291.42856, 465.21933);
		shape5.curveTo(291.42856, 445.49487, 309.33716, 429.50504, 331.42856, 429.50504);
		shape5.curveTo(353.51996, 429.50504, 371.42856, 445.49487, 371.42856, 465.21933);
		shape5.closePath();
		g.setPaint(new Color(0, 128, 0, 255));
		g.fill(shape5);
		g.setPaint(new Color(0, 0, 0, 255));
		g.draw(shape5);
	}

	private void paintShapeNode_0_0_0_6(Graphics2D g) {
		GeneralPath shape6 = new GeneralPath();
		shape6.moveTo(322.85715, 472.36218);
		shape6.curveTo(322.86642, 484.6161, 314.42767, 495.94223, 300.7218, 502.07126);
		shape6.curveTo(287.01593, 508.2003, 270.12695, 508.2003, 256.42108, 502.07126);
		shape6.curveTo(242.71523, 495.94223, 234.27644, 484.6161, 234.28574, 472.36218);
		shape6.curveTo(234.27644, 460.10828, 242.71523, 448.78214, 256.42108, 442.6531);
		shape6.curveTo(270.12695, 436.52408, 287.01593, 436.52408, 300.7218, 442.6531);
		shape6.curveTo(314.42767, 448.78214, 322.86642, 460.10828, 322.85715, 472.36218);
		shape6.closePath();
		g.setPaint(new Color(0, 128, 0, 255));
		g.fill(shape6);
		g.setPaint(new Color(0, 0, 0, 255));
		g.draw(shape6);
	}

	private void paintShapeNode_0_0_0_7(Graphics2D g) {
		GeneralPath shape7 = new GeneralPath();
		shape7.moveTo(394.2857, 638.0765);
		shape7.curveTo(394.29248, 656.4551, 385.3086, 673.44073, 370.71976, 682.63214);
		shape7.curveTo(356.13092, 691.8236, 338.1548, 691.8236, 323.56595, 682.63214);
		shape7.curveTo(308.9771, 673.44073, 299.99323, 656.4551, 300.0, 638.0765);
		shape7.curveTo(299.99323, 619.6979, 308.9771, 602.7122, 323.56595, 593.5208);
		shape7.curveTo(338.1548, 584.32935, 356.13092, 584.32935, 370.71976, 593.5208);
		shape7.curveTo(385.3086, 602.7122, 394.29248, 619.6979, 394.2857, 638.0765);
		shape7.closePath();
		g.setPaint(new Color(0, 128, 0, 255));
		g.fill(shape7);
		g.setPaint(new Color(0, 0, 0, 255));
		g.draw(shape7);
	}

	private void paintShapeNode_0_0_0_8(Graphics2D g) {
		GeneralPath shape8 = new GeneralPath();
		shape8.moveTo(342.85715, 608.0765);
		shape8.curveTo(342.85715, 632.5348, 322.39017, 652.3622, 297.14285, 652.3622);
		shape8.curveTo(271.89557, 652.3622, 251.42857, 632.5348, 251.42857, 608.0765);
		shape8.curveTo(251.42857, 583.61816, 271.89557, 563.7908, 297.14285, 563.7908);
		shape8.curveTo(322.39017, 563.7908, 342.85715, 583.61816, 342.85715, 608.0765);
		shape8.closePath();
		g.setPaint(new Color(0, 128, 0, 255));
		g.fill(shape8);
		g.setPaint(new Color(0, 0, 0, 255));
		g.draw(shape8);
	}

	private void paintCompositeGraphicsNode_0_0_0(Graphics2D g) {
		// _0_0_0_0
		AffineTransform trans_0_0_0_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_0(g);
		g.setTransform(trans_0_0_0_0);
		// _0_0_0_1
		AffineTransform trans_0_0_0_1 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_1(g);
		g.setTransform(trans_0_0_0_1);
		// _0_0_0_2
		AffineTransform trans_0_0_0_2 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_2(g);
		g.setTransform(trans_0_0_0_2);
		// _0_0_0_3
		AffineTransform trans_0_0_0_3 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_3(g);
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
		// _0_0_0_6
		AffineTransform trans_0_0_0_6 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_6(g);
		g.setTransform(trans_0_0_0_6);
		// _0_0_0_7
		AffineTransform trans_0_0_0_7 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -37.14285659790039f, -200.0f));
		paintShapeNode_0_0_0_7(g);
		g.setTransform(trans_0_0_0_7);
		// _0_0_0_8
		AffineTransform trans_0_0_0_8 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -34.28572082519531f, -180.0f));
		paintShapeNode_0_0_0_8(g);
		g.setTransform(trans_0_0_0_8);
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
        return 197;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * @return The Y of the bounding box of the original SVG image.
     */
    public int getOrigY() {
        return 345;
    }

    /**
     * Returns the width of the bounding box of the original SVG image.
     * @return The width of the bounding box of the original SVG image.
     */
    public int getOrigWidth() {
        return 182;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     * @return The height of the bounding box of the original SVG image.
     */
    public int getOrigHeight() {
        return 165;
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
	public LifeformTreeGraphics() {
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
