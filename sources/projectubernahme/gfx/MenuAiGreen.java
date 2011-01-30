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

/**
 * This class has been automatically generated using svg2java
 * 
 */
public class MenuAiGreen extends ConvertedGraphics {
	
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
		shape0.moveTo(525.7143, 363.79074);
		shape0.curveTo(525.7143, 504.22888, 411.8667, 618.0765, 271.4286, 618.0765);
		shape0.curveTo(130.99045, 618.0765, 17.142853, 504.22888, 17.142853, 363.79074);
		shape0.curveTo(17.142853, 223.35262, 130.99045, 109.50502, 271.42856, 109.50502);
		shape0.curveTo(411.8667, 109.50502, 525.7143, 223.35262, 525.7143, 363.79074);
		shape0.closePath();
		g.setPaint(new Color(0, 0, 0, 255));
		g.setStroke(new BasicStroke(1.0f,0,0,4.0f,null,0.0f));
		g.draw(shape0);
	}

	private void paintShapeNode_0_0_0_1(Graphics2D g) {
		g.setPaint(new Color(90, 160, 44, 255));
		Rectangle2D.Double shape1 = new Rectangle2D.Double(220.29368591308594, 298.3701477050781, 302.2697448730469, 302.2697448730469);
		g.fill(shape1);
	}

	private void paintShapeNode_0_0_0_2_0(Graphics2D g) {
		GeneralPath shape2 = new GeneralPath();
		shape2.moveTo(219.7832, 313.23938);
		shape2.lineTo(177.45459, 313.23938);
		g.setPaint(new Color(255, 255, 255, 255));
		g.draw(shape2);
	}

	private void paintShapeNode_0_0_0_2_1(Graphics2D g) {
		GeneralPath shape3 = new GeneralPath();
		shape3.moveTo(219.7832, 334.19717);
		shape3.lineTo(177.45459, 334.19717);
		g.draw(shape3);
	}

	private void paintShapeNode_0_0_0_2_2(Graphics2D g) {
		GeneralPath shape4 = new GeneralPath();
		shape4.moveTo(219.7832, 355.15494);
		shape4.lineTo(177.45459, 355.15494);
		g.draw(shape4);
	}

	private void paintShapeNode_0_0_0_2_3(Graphics2D g) {
		GeneralPath shape5 = new GeneralPath();
		shape5.moveTo(219.7832, 376.1127);
		shape5.lineTo(177.45459, 376.1127);
		g.draw(shape5);
	}

	private void paintShapeNode_0_0_0_2_4(Graphics2D g) {
		GeneralPath shape6 = new GeneralPath();
		shape6.moveTo(219.7832, 397.07047);
		shape6.lineTo(177.45459, 397.07047);
		g.draw(shape6);
	}

	private void paintShapeNode_0_0_0_2_5(Graphics2D g) {
		GeneralPath shape7 = new GeneralPath();
		shape7.moveTo(219.7832, 418.02823);
		shape7.lineTo(177.45459, 418.02823);
		g.draw(shape7);
	}

	private void paintShapeNode_0_0_0_2_6(Graphics2D g) {
		GeneralPath shape8 = new GeneralPath();
		shape8.moveTo(219.7832, 438.986);
		shape8.lineTo(177.45459, 438.986);
		g.draw(shape8);
	}

	private void paintShapeNode_0_0_0_2_7(Graphics2D g) {
		GeneralPath shape9 = new GeneralPath();
		shape9.moveTo(219.7832, 459.94376);
		shape9.lineTo(177.45459, 459.94376);
		g.draw(shape9);
	}

	private void paintShapeNode_0_0_0_2_8(Graphics2D g) {
		GeneralPath shape10 = new GeneralPath();
		shape10.moveTo(219.7832, 480.90152);
		shape10.lineTo(177.45459, 480.90152);
		g.draw(shape10);
	}

	private void paintShapeNode_0_0_0_2_9(Graphics2D g) {
		GeneralPath shape11 = new GeneralPath();
		shape11.moveTo(219.7832, 501.85928);
		shape11.lineTo(177.45459, 501.85928);
		g.draw(shape11);
	}

	private void paintShapeNode_0_0_0_2_10(Graphics2D g) {
		GeneralPath shape12 = new GeneralPath();
		shape12.moveTo(219.7832, 522.817);
		shape12.lineTo(177.45459, 522.817);
		g.draw(shape12);
	}

	private void paintShapeNode_0_0_0_2_11(Graphics2D g) {
		GeneralPath shape13 = new GeneralPath();
		shape13.moveTo(219.7832, 543.7748);
		shape13.lineTo(177.45459, 543.7748);
		g.draw(shape13);
	}

	private void paintShapeNode_0_0_0_2_12(Graphics2D g) {
		GeneralPath shape14 = new GeneralPath();
		shape14.moveTo(219.7832, 564.73254);
		shape14.lineTo(177.45459, 564.73254);
		g.draw(shape14);
	}

	private void paintShapeNode_0_0_0_2_13(Graphics2D g) {
		GeneralPath shape15 = new GeneralPath();
		shape15.moveTo(219.7832, 585.6903);
		shape15.lineTo(177.45459, 585.6903);
		g.draw(shape15);
	}

	private void paintCompositeGraphicsNode_0_0_0_2(Graphics2D g) {
		// _0_0_0_2_0
		AffineTransform trans_0_0_0_2_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_2_0(g);
		g.setTransform(trans_0_0_0_2_0);
		// _0_0_0_2_1
		AffineTransform trans_0_0_0_2_1 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_2_1(g);
		g.setTransform(trans_0_0_0_2_1);
		// _0_0_0_2_2
		AffineTransform trans_0_0_0_2_2 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_2_2(g);
		g.setTransform(trans_0_0_0_2_2);
		// _0_0_0_2_3
		AffineTransform trans_0_0_0_2_3 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_2_3(g);
		g.setTransform(trans_0_0_0_2_3);
		// _0_0_0_2_4
		AffineTransform trans_0_0_0_2_4 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_2_4(g);
		g.setTransform(trans_0_0_0_2_4);
		// _0_0_0_2_5
		AffineTransform trans_0_0_0_2_5 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_2_5(g);
		g.setTransform(trans_0_0_0_2_5);
		// _0_0_0_2_6
		AffineTransform trans_0_0_0_2_6 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_2_6(g);
		g.setTransform(trans_0_0_0_2_6);
		// _0_0_0_2_7
		AffineTransform trans_0_0_0_2_7 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_2_7(g);
		g.setTransform(trans_0_0_0_2_7);
		// _0_0_0_2_8
		AffineTransform trans_0_0_0_2_8 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_2_8(g);
		g.setTransform(trans_0_0_0_2_8);
		// _0_0_0_2_9
		AffineTransform trans_0_0_0_2_9 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_2_9(g);
		g.setTransform(trans_0_0_0_2_9);
		// _0_0_0_2_10
		AffineTransform trans_0_0_0_2_10 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_2_10(g);
		g.setTransform(trans_0_0_0_2_10);
		// _0_0_0_2_11
		AffineTransform trans_0_0_0_2_11 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_2_11(g);
		g.setTransform(trans_0_0_0_2_11);
		// _0_0_0_2_12
		AffineTransform trans_0_0_0_2_12 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_2_12(g);
		g.setTransform(trans_0_0_0_2_12);
		// _0_0_0_2_13
		AffineTransform trans_0_0_0_2_13 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_2_13(g);
		g.setTransform(trans_0_0_0_2_13);
	}

	private void paintShapeNode_0_0_0_3_0(Graphics2D g) {
		GeneralPath shape16 = new GeneralPath();
		shape16.moveTo(219.7832, 313.23938);
		shape16.lineTo(177.45459, 313.23938);
		g.draw(shape16);
	}

	private void paintShapeNode_0_0_0_3_1(Graphics2D g) {
		GeneralPath shape17 = new GeneralPath();
		shape17.moveTo(219.7832, 334.19717);
		shape17.lineTo(177.45459, 334.19717);
		g.draw(shape17);
	}

	private void paintShapeNode_0_0_0_3_2(Graphics2D g) {
		GeneralPath shape18 = new GeneralPath();
		shape18.moveTo(219.7832, 355.15494);
		shape18.lineTo(177.45459, 355.15494);
		g.draw(shape18);
	}

	private void paintShapeNode_0_0_0_3_3(Graphics2D g) {
		GeneralPath shape19 = new GeneralPath();
		shape19.moveTo(219.7832, 376.1127);
		shape19.lineTo(177.45459, 376.1127);
		g.draw(shape19);
	}

	private void paintShapeNode_0_0_0_3_4(Graphics2D g) {
		GeneralPath shape20 = new GeneralPath();
		shape20.moveTo(219.7832, 397.07047);
		shape20.lineTo(177.45459, 397.07047);
		g.draw(shape20);
	}

	private void paintShapeNode_0_0_0_3_5(Graphics2D g) {
		GeneralPath shape21 = new GeneralPath();
		shape21.moveTo(219.7832, 418.02823);
		shape21.lineTo(177.45459, 418.02823);
		g.draw(shape21);
	}

	private void paintShapeNode_0_0_0_3_6(Graphics2D g) {
		GeneralPath shape22 = new GeneralPath();
		shape22.moveTo(219.7832, 438.986);
		shape22.lineTo(177.45459, 438.986);
		g.draw(shape22);
	}

	private void paintShapeNode_0_0_0_3_7(Graphics2D g) {
		GeneralPath shape23 = new GeneralPath();
		shape23.moveTo(219.7832, 459.94376);
		shape23.lineTo(177.45459, 459.94376);
		g.draw(shape23);
	}

	private void paintShapeNode_0_0_0_3_8(Graphics2D g) {
		GeneralPath shape24 = new GeneralPath();
		shape24.moveTo(219.7832, 480.90152);
		shape24.lineTo(177.45459, 480.90152);
		g.draw(shape24);
	}

	private void paintShapeNode_0_0_0_3_9(Graphics2D g) {
		GeneralPath shape25 = new GeneralPath();
		shape25.moveTo(219.7832, 501.85928);
		shape25.lineTo(177.45459, 501.85928);
		g.draw(shape25);
	}

	private void paintShapeNode_0_0_0_3_10(Graphics2D g) {
		GeneralPath shape26 = new GeneralPath();
		shape26.moveTo(219.7832, 522.817);
		shape26.lineTo(177.45459, 522.817);
		g.draw(shape26);
	}

	private void paintShapeNode_0_0_0_3_11(Graphics2D g) {
		GeneralPath shape27 = new GeneralPath();
		shape27.moveTo(219.7832, 543.7748);
		shape27.lineTo(177.45459, 543.7748);
		g.draw(shape27);
	}

	private void paintShapeNode_0_0_0_3_12(Graphics2D g) {
		GeneralPath shape28 = new GeneralPath();
		shape28.moveTo(219.7832, 564.73254);
		shape28.lineTo(177.45459, 564.73254);
		g.draw(shape28);
	}

	private void paintShapeNode_0_0_0_3_13(Graphics2D g) {
		GeneralPath shape29 = new GeneralPath();
		shape29.moveTo(219.7832, 585.6903);
		shape29.lineTo(177.45459, 585.6903);
		g.draw(shape29);
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
		// _0_0_0_3_2
		AffineTransform trans_0_0_0_3_2 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_3_2(g);
		g.setTransform(trans_0_0_0_3_2);
		// _0_0_0_3_3
		AffineTransform trans_0_0_0_3_3 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_3_3(g);
		g.setTransform(trans_0_0_0_3_3);
		// _0_0_0_3_4
		AffineTransform trans_0_0_0_3_4 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_3_4(g);
		g.setTransform(trans_0_0_0_3_4);
		// _0_0_0_3_5
		AffineTransform trans_0_0_0_3_5 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_3_5(g);
		g.setTransform(trans_0_0_0_3_5);
		// _0_0_0_3_6
		AffineTransform trans_0_0_0_3_6 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_3_6(g);
		g.setTransform(trans_0_0_0_3_6);
		// _0_0_0_3_7
		AffineTransform trans_0_0_0_3_7 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_3_7(g);
		g.setTransform(trans_0_0_0_3_7);
		// _0_0_0_3_8
		AffineTransform trans_0_0_0_3_8 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_3_8(g);
		g.setTransform(trans_0_0_0_3_8);
		// _0_0_0_3_9
		AffineTransform trans_0_0_0_3_9 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_3_9(g);
		g.setTransform(trans_0_0_0_3_9);
		// _0_0_0_3_10
		AffineTransform trans_0_0_0_3_10 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_3_10(g);
		g.setTransform(trans_0_0_0_3_10);
		// _0_0_0_3_11
		AffineTransform trans_0_0_0_3_11 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_3_11(g);
		g.setTransform(trans_0_0_0_3_11);
		// _0_0_0_3_12
		AffineTransform trans_0_0_0_3_12 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_3_12(g);
		g.setTransform(trans_0_0_0_3_12);
		// _0_0_0_3_13
		AffineTransform trans_0_0_0_3_13 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_3_13(g);
		g.setTransform(trans_0_0_0_3_13);
	}

	private void paintShapeNode_0_0_0_4_0(Graphics2D g) {
		GeneralPath shape30 = new GeneralPath();
		shape30.moveTo(219.7832, 313.23938);
		shape30.lineTo(177.45459, 313.23938);
		g.draw(shape30);
	}

	private void paintShapeNode_0_0_0_4_1(Graphics2D g) {
		GeneralPath shape31 = new GeneralPath();
		shape31.moveTo(219.7832, 334.19717);
		shape31.lineTo(177.45459, 334.19717);
		g.draw(shape31);
	}

	private void paintShapeNode_0_0_0_4_2(Graphics2D g) {
		GeneralPath shape32 = new GeneralPath();
		shape32.moveTo(219.7832, 355.15494);
		shape32.lineTo(177.45459, 355.15494);
		g.draw(shape32);
	}

	private void paintShapeNode_0_0_0_4_3(Graphics2D g) {
		GeneralPath shape33 = new GeneralPath();
		shape33.moveTo(219.7832, 376.1127);
		shape33.lineTo(177.45459, 376.1127);
		g.draw(shape33);
	}

	private void paintShapeNode_0_0_0_4_4(Graphics2D g) {
		GeneralPath shape34 = new GeneralPath();
		shape34.moveTo(219.7832, 397.07047);
		shape34.lineTo(177.45459, 397.07047);
		g.draw(shape34);
	}

	private void paintShapeNode_0_0_0_4_5(Graphics2D g) {
		GeneralPath shape35 = new GeneralPath();
		shape35.moveTo(219.7832, 418.02823);
		shape35.lineTo(177.45459, 418.02823);
		g.draw(shape35);
	}

	private void paintShapeNode_0_0_0_4_6(Graphics2D g) {
		GeneralPath shape36 = new GeneralPath();
		shape36.moveTo(219.7832, 438.986);
		shape36.lineTo(177.45459, 438.986);
		g.draw(shape36);
	}

	private void paintShapeNode_0_0_0_4_7(Graphics2D g) {
		GeneralPath shape37 = new GeneralPath();
		shape37.moveTo(219.7832, 459.94376);
		shape37.lineTo(177.45459, 459.94376);
		g.draw(shape37);
	}

	private void paintShapeNode_0_0_0_4_8(Graphics2D g) {
		GeneralPath shape38 = new GeneralPath();
		shape38.moveTo(219.7832, 480.90152);
		shape38.lineTo(177.45459, 480.90152);
		g.draw(shape38);
	}

	private void paintShapeNode_0_0_0_4_9(Graphics2D g) {
		GeneralPath shape39 = new GeneralPath();
		shape39.moveTo(219.7832, 501.85928);
		shape39.lineTo(177.45459, 501.85928);
		g.draw(shape39);
	}

	private void paintShapeNode_0_0_0_4_10(Graphics2D g) {
		GeneralPath shape40 = new GeneralPath();
		shape40.moveTo(219.7832, 522.817);
		shape40.lineTo(177.45459, 522.817);
		g.draw(shape40);
	}

	private void paintShapeNode_0_0_0_4_11(Graphics2D g) {
		GeneralPath shape41 = new GeneralPath();
		shape41.moveTo(219.7832, 543.7748);
		shape41.lineTo(177.45459, 543.7748);
		g.draw(shape41);
	}

	private void paintShapeNode_0_0_0_4_12(Graphics2D g) {
		GeneralPath shape42 = new GeneralPath();
		shape42.moveTo(219.7832, 564.73254);
		shape42.lineTo(177.45459, 564.73254);
		g.draw(shape42);
	}

	private void paintShapeNode_0_0_0_4_13(Graphics2D g) {
		GeneralPath shape43 = new GeneralPath();
		shape43.moveTo(219.7832, 585.6903);
		shape43.lineTo(177.45459, 585.6903);
		g.draw(shape43);
	}

	private void paintCompositeGraphicsNode_0_0_0_4(Graphics2D g) {
		// _0_0_0_4_0
		AffineTransform trans_0_0_0_4_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_4_0(g);
		g.setTransform(trans_0_0_0_4_0);
		// _0_0_0_4_1
		AffineTransform trans_0_0_0_4_1 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_4_1(g);
		g.setTransform(trans_0_0_0_4_1);
		// _0_0_0_4_2
		AffineTransform trans_0_0_0_4_2 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_4_2(g);
		g.setTransform(trans_0_0_0_4_2);
		// _0_0_0_4_3
		AffineTransform trans_0_0_0_4_3 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_4_3(g);
		g.setTransform(trans_0_0_0_4_3);
		// _0_0_0_4_4
		AffineTransform trans_0_0_0_4_4 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_4_4(g);
		g.setTransform(trans_0_0_0_4_4);
		// _0_0_0_4_5
		AffineTransform trans_0_0_0_4_5 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_4_5(g);
		g.setTransform(trans_0_0_0_4_5);
		// _0_0_0_4_6
		AffineTransform trans_0_0_0_4_6 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_4_6(g);
		g.setTransform(trans_0_0_0_4_6);
		// _0_0_0_4_7
		AffineTransform trans_0_0_0_4_7 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_4_7(g);
		g.setTransform(trans_0_0_0_4_7);
		// _0_0_0_4_8
		AffineTransform trans_0_0_0_4_8 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_4_8(g);
		g.setTransform(trans_0_0_0_4_8);
		// _0_0_0_4_9
		AffineTransform trans_0_0_0_4_9 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_4_9(g);
		g.setTransform(trans_0_0_0_4_9);
		// _0_0_0_4_10
		AffineTransform trans_0_0_0_4_10 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_4_10(g);
		g.setTransform(trans_0_0_0_4_10);
		// _0_0_0_4_11
		AffineTransform trans_0_0_0_4_11 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_4_11(g);
		g.setTransform(trans_0_0_0_4_11);
		// _0_0_0_4_12
		AffineTransform trans_0_0_0_4_12 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_4_12(g);
		g.setTransform(trans_0_0_0_4_12);
		// _0_0_0_4_13
		AffineTransform trans_0_0_0_4_13 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_4_13(g);
		g.setTransform(trans_0_0_0_4_13);
	}

	private void paintShapeNode_0_0_0_5_0(Graphics2D g) {
		GeneralPath shape44 = new GeneralPath();
		shape44.moveTo(219.7832, 313.23938);
		shape44.lineTo(177.45459, 313.23938);
		g.draw(shape44);
	}

	private void paintShapeNode_0_0_0_5_1(Graphics2D g) {
		GeneralPath shape45 = new GeneralPath();
		shape45.moveTo(219.7832, 334.19717);
		shape45.lineTo(177.45459, 334.19717);
		g.draw(shape45);
	}

	private void paintShapeNode_0_0_0_5_2(Graphics2D g) {
		GeneralPath shape46 = new GeneralPath();
		shape46.moveTo(219.7832, 355.15494);
		shape46.lineTo(177.45459, 355.15494);
		g.draw(shape46);
	}

	private void paintShapeNode_0_0_0_5_3(Graphics2D g) {
		GeneralPath shape47 = new GeneralPath();
		shape47.moveTo(219.7832, 376.1127);
		shape47.lineTo(177.45459, 376.1127);
		g.draw(shape47);
	}

	private void paintShapeNode_0_0_0_5_4(Graphics2D g) {
		GeneralPath shape48 = new GeneralPath();
		shape48.moveTo(219.7832, 397.07047);
		shape48.lineTo(177.45459, 397.07047);
		g.draw(shape48);
	}

	private void paintShapeNode_0_0_0_5_5(Graphics2D g) {
		GeneralPath shape49 = new GeneralPath();
		shape49.moveTo(219.7832, 418.02823);
		shape49.lineTo(177.45459, 418.02823);
		g.draw(shape49);
	}

	private void paintShapeNode_0_0_0_5_6(Graphics2D g) {
		GeneralPath shape50 = new GeneralPath();
		shape50.moveTo(219.7832, 438.986);
		shape50.lineTo(177.45459, 438.986);
		g.draw(shape50);
	}

	private void paintShapeNode_0_0_0_5_7(Graphics2D g) {
		GeneralPath shape51 = new GeneralPath();
		shape51.moveTo(219.7832, 459.94376);
		shape51.lineTo(177.45459, 459.94376);
		g.draw(shape51);
	}

	private void paintShapeNode_0_0_0_5_8(Graphics2D g) {
		GeneralPath shape52 = new GeneralPath();
		shape52.moveTo(219.7832, 480.90152);
		shape52.lineTo(177.45459, 480.90152);
		g.draw(shape52);
	}

	private void paintShapeNode_0_0_0_5_9(Graphics2D g) {
		GeneralPath shape53 = new GeneralPath();
		shape53.moveTo(219.7832, 501.85928);
		shape53.lineTo(177.45459, 501.85928);
		g.draw(shape53);
	}

	private void paintShapeNode_0_0_0_5_10(Graphics2D g) {
		GeneralPath shape54 = new GeneralPath();
		shape54.moveTo(219.7832, 522.817);
		shape54.lineTo(177.45459, 522.817);
		g.draw(shape54);
	}

	private void paintShapeNode_0_0_0_5_11(Graphics2D g) {
		GeneralPath shape55 = new GeneralPath();
		shape55.moveTo(219.7832, 543.7748);
		shape55.lineTo(177.45459, 543.7748);
		g.draw(shape55);
	}

	private void paintShapeNode_0_0_0_5_12(Graphics2D g) {
		GeneralPath shape56 = new GeneralPath();
		shape56.moveTo(219.7832, 564.73254);
		shape56.lineTo(177.45459, 564.73254);
		g.draw(shape56);
	}

	private void paintShapeNode_0_0_0_5_13(Graphics2D g) {
		GeneralPath shape57 = new GeneralPath();
		shape57.moveTo(219.7832, 585.6903);
		shape57.lineTo(177.45459, 585.6903);
		g.draw(shape57);
	}

	private void paintCompositeGraphicsNode_0_0_0_5(Graphics2D g) {
		// _0_0_0_5_0
		AffineTransform trans_0_0_0_5_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_5_0(g);
		g.setTransform(trans_0_0_0_5_0);
		// _0_0_0_5_1
		AffineTransform trans_0_0_0_5_1 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_5_1(g);
		g.setTransform(trans_0_0_0_5_1);
		// _0_0_0_5_2
		AffineTransform trans_0_0_0_5_2 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_5_2(g);
		g.setTransform(trans_0_0_0_5_2);
		// _0_0_0_5_3
		AffineTransform trans_0_0_0_5_3 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_5_3(g);
		g.setTransform(trans_0_0_0_5_3);
		// _0_0_0_5_4
		AffineTransform trans_0_0_0_5_4 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_5_4(g);
		g.setTransform(trans_0_0_0_5_4);
		// _0_0_0_5_5
		AffineTransform trans_0_0_0_5_5 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_5_5(g);
		g.setTransform(trans_0_0_0_5_5);
		// _0_0_0_5_6
		AffineTransform trans_0_0_0_5_6 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_5_6(g);
		g.setTransform(trans_0_0_0_5_6);
		// _0_0_0_5_7
		AffineTransform trans_0_0_0_5_7 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_5_7(g);
		g.setTransform(trans_0_0_0_5_7);
		// _0_0_0_5_8
		AffineTransform trans_0_0_0_5_8 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_5_8(g);
		g.setTransform(trans_0_0_0_5_8);
		// _0_0_0_5_9
		AffineTransform trans_0_0_0_5_9 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_5_9(g);
		g.setTransform(trans_0_0_0_5_9);
		// _0_0_0_5_10
		AffineTransform trans_0_0_0_5_10 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_5_10(g);
		g.setTransform(trans_0_0_0_5_10);
		// _0_0_0_5_11
		AffineTransform trans_0_0_0_5_11 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_5_11(g);
		g.setTransform(trans_0_0_0_5_11);
		// _0_0_0_5_12
		AffineTransform trans_0_0_0_5_12 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_5_12(g);
		g.setTransform(trans_0_0_0_5_12);
		// _0_0_0_5_13
		AffineTransform trans_0_0_0_5_13 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_5_13(g);
		g.setTransform(trans_0_0_0_5_13);
	}

	private void paintShapeNode_0_0_0_6_0(Graphics2D g) {
		GeneralPath shape58 = new GeneralPath();
		shape58.moveTo(219.7832, 313.23938);
		shape58.lineTo(177.45459, 313.23938);
		g.draw(shape58);
	}

	private void paintShapeNode_0_0_0_6_1(Graphics2D g) {
		GeneralPath shape59 = new GeneralPath();
		shape59.moveTo(219.7832, 334.19717);
		shape59.lineTo(177.45459, 334.19717);
		g.draw(shape59);
	}

	private void paintShapeNode_0_0_0_6_2(Graphics2D g) {
		GeneralPath shape60 = new GeneralPath();
		shape60.moveTo(219.7832, 355.15494);
		shape60.lineTo(177.45459, 355.15494);
		g.draw(shape60);
	}

	private void paintShapeNode_0_0_0_6_3(Graphics2D g) {
		GeneralPath shape61 = new GeneralPath();
		shape61.moveTo(219.7832, 376.1127);
		shape61.lineTo(177.45459, 376.1127);
		g.draw(shape61);
	}

	private void paintShapeNode_0_0_0_6_4(Graphics2D g) {
		GeneralPath shape62 = new GeneralPath();
		shape62.moveTo(219.7832, 397.07047);
		shape62.lineTo(177.45459, 397.07047);
		g.draw(shape62);
	}

	private void paintShapeNode_0_0_0_6_5(Graphics2D g) {
		GeneralPath shape63 = new GeneralPath();
		shape63.moveTo(219.7832, 418.02823);
		shape63.lineTo(177.45459, 418.02823);
		g.draw(shape63);
	}

	private void paintShapeNode_0_0_0_6_6(Graphics2D g) {
		GeneralPath shape64 = new GeneralPath();
		shape64.moveTo(219.7832, 438.986);
		shape64.lineTo(177.45459, 438.986);
		g.draw(shape64);
	}

	private void paintShapeNode_0_0_0_6_7(Graphics2D g) {
		GeneralPath shape65 = new GeneralPath();
		shape65.moveTo(219.7832, 459.94376);
		shape65.lineTo(177.45459, 459.94376);
		g.draw(shape65);
	}

	private void paintShapeNode_0_0_0_6_8(Graphics2D g) {
		GeneralPath shape66 = new GeneralPath();
		shape66.moveTo(219.7832, 480.90152);
		shape66.lineTo(177.45459, 480.90152);
		g.draw(shape66);
	}

	private void paintShapeNode_0_0_0_6_9(Graphics2D g) {
		GeneralPath shape67 = new GeneralPath();
		shape67.moveTo(219.7832, 501.85928);
		shape67.lineTo(177.45459, 501.85928);
		g.draw(shape67);
	}

	private void paintShapeNode_0_0_0_6_10(Graphics2D g) {
		GeneralPath shape68 = new GeneralPath();
		shape68.moveTo(219.7832, 522.817);
		shape68.lineTo(177.45459, 522.817);
		g.draw(shape68);
	}

	private void paintShapeNode_0_0_0_6_11(Graphics2D g) {
		GeneralPath shape69 = new GeneralPath();
		shape69.moveTo(219.7832, 543.7748);
		shape69.lineTo(177.45459, 543.7748);
		g.draw(shape69);
	}

	private void paintShapeNode_0_0_0_6_12(Graphics2D g) {
		GeneralPath shape70 = new GeneralPath();
		shape70.moveTo(219.7832, 564.73254);
		shape70.lineTo(177.45459, 564.73254);
		g.draw(shape70);
	}

	private void paintShapeNode_0_0_0_6_13(Graphics2D g) {
		GeneralPath shape71 = new GeneralPath();
		shape71.moveTo(219.7832, 585.6903);
		shape71.lineTo(177.45459, 585.6903);
		g.draw(shape71);
	}

	private void paintCompositeGraphicsNode_0_0_0_6(Graphics2D g) {
		// _0_0_0_6_0
		AffineTransform trans_0_0_0_6_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_6_0(g);
		g.setTransform(trans_0_0_0_6_0);
		// _0_0_0_6_1
		AffineTransform trans_0_0_0_6_1 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_6_1(g);
		g.setTransform(trans_0_0_0_6_1);
		// _0_0_0_6_2
		AffineTransform trans_0_0_0_6_2 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_6_2(g);
		g.setTransform(trans_0_0_0_6_2);
		// _0_0_0_6_3
		AffineTransform trans_0_0_0_6_3 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_6_3(g);
		g.setTransform(trans_0_0_0_6_3);
		// _0_0_0_6_4
		AffineTransform trans_0_0_0_6_4 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_6_4(g);
		g.setTransform(trans_0_0_0_6_4);
		// _0_0_0_6_5
		AffineTransform trans_0_0_0_6_5 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_6_5(g);
		g.setTransform(trans_0_0_0_6_5);
		// _0_0_0_6_6
		AffineTransform trans_0_0_0_6_6 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_6_6(g);
		g.setTransform(trans_0_0_0_6_6);
		// _0_0_0_6_7
		AffineTransform trans_0_0_0_6_7 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_6_7(g);
		g.setTransform(trans_0_0_0_6_7);
		// _0_0_0_6_8
		AffineTransform trans_0_0_0_6_8 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_6_8(g);
		g.setTransform(trans_0_0_0_6_8);
		// _0_0_0_6_9
		AffineTransform trans_0_0_0_6_9 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_6_9(g);
		g.setTransform(trans_0_0_0_6_9);
		// _0_0_0_6_10
		AffineTransform trans_0_0_0_6_10 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_6_10(g);
		g.setTransform(trans_0_0_0_6_10);
		// _0_0_0_6_11
		AffineTransform trans_0_0_0_6_11 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_6_11(g);
		g.setTransform(trans_0_0_0_6_11);
		// _0_0_0_6_12
		AffineTransform trans_0_0_0_6_12 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_6_12(g);
		g.setTransform(trans_0_0_0_6_12);
		// _0_0_0_6_13
		AffineTransform trans_0_0_0_6_13 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_6_13(g);
		g.setTransform(trans_0_0_0_6_13);
	}

	private void paintCompositeGraphicsNode_0_0_0(Graphics2D g) {
		// _0_0_0_0
		AffineTransform trans_0_0_0_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 100.0f, 85.71428680419922f));
		paintShapeNode_0_0_0_0(g);
		g.setTransform(trans_0_0_0_0);
		// _0_0_0_1
		AffineTransform trans_0_0_0_1 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		paintShapeNode_0_0_0_1(g);
		g.setTransform(trans_0_0_0_1);
		// _0_0_0_2
		AffineTransform trans_0_0_0_2 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.010475910268723965f, 0.04018013924360275f));
		paintCompositeGraphicsNode_0_0_0_2(g);
		g.setTransform(trans_0_0_0_2);
		// _0_0_0_3
		AffineTransform trans_0_0_0_3 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 345.60882568359375f, 0.04018013924360275f));
		paintCompositeGraphicsNode_0_0_0_3(g);
		g.setTransform(trans_0_0_0_3);
		// _0_0_0_4
		AffineTransform trans_0_0_0_4 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.010475910268723965f, 0.04018013924360275f));
		paintCompositeGraphicsNode_0_0_0_4(g);
		g.setTransform(trans_0_0_0_4);
		// _0_0_0_5
		AffineTransform trans_0_0_0_5 = g.getTransform();
		g.transform(new AffineTransform(0.0f, 1.0f, -1.0f, 0.0f, 820.8933715820312f, 78.0869369506836f));
		paintCompositeGraphicsNode_0_0_0_5(g);
		g.setTransform(trans_0_0_0_5);
		// _0_0_0_6
		AffineTransform trans_0_0_0_6 = g.getTransform();
		g.transform(new AffineTransform(0.0f, 1.0f, -1.0f, 0.0f, 820.8933715820312f, 423.685302734375f));
		paintCompositeGraphicsNode_0_0_0_6(g);
		g.setTransform(trans_0_0_0_6);
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
	public MenuAiGreen() {
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

