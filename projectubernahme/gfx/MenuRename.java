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
public class MenuRename extends ConvertedGraphics {

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
		g.setStroke(new BasicStroke(1.0f, 0, 0, 4.0f, null, 0.0f));
		g.draw(shape0);
	}

	private void paintShapeNode_0_0_0_1(Graphics2D g) {
		GeneralPath shape1 = new GeneralPath();
		shape1.moveTo(195.85954, 607.3836);
		shape1.curveTo(195.85954, 607.3836, 202.71799, 508.7223, 240.19734, 488.60916);
		shape1.curveTo(267.97003, 473.70508, 305.07227, 467.51096, 354.2741, 486.17905);
		shape1.curveTo(396.43512, 502.17572, 400.4537, 607.3836, 400.4537, 607.3836);
		shape1.closePath();
		g.setPaint(new Color(153, 153, 153, 255));
		g.fill(shape1);
		g.setPaint(new Color(0, 0, 0, 255));
		g.setStroke(new BasicStroke(2.227991f, 0, 0, 4.0f, null, 0.0f));
		g.draw(shape1);
	}

	private void paintShapeNode_0_0_0_2(Graphics2D g) {
		GeneralPath shape2 = new GeneralPath();
		shape2.moveTo(399.70792, 436.01044);
		shape2.curveTo(399.7141, 455.94662, 392.23126, 474.3722, 380.07956, 484.34283);
		shape2.curveTo(367.92786, 494.31348, 352.9546, 494.31348, 340.8029, 484.34283);
		shape2.curveTo(328.65118, 474.3722, 321.16833, 455.94662, 321.17453, 436.01044);
		shape2.curveTo(321.16833, 416.07425, 328.65118, 397.64868, 340.8029, 387.67804);
		shape2.curveTo(352.9546, 377.7074, 367.92786, 377.7074, 380.07956, 387.67804);
		shape2.curveTo(392.23126, 397.64868, 399.7141, 416.07425, 399.70792, 436.01044);
		shape2.closePath();
		g.setPaint(new Color(230, 230, 230, 255));
		g.fill(shape2);
		g.setPaint(new Color(0, 0, 0, 255));
		g.setStroke(new BasicStroke(2.9011173f, 0, 0, 4.0f, null, 0.0f));
		g.draw(shape2);
	}

	private void paintShapeNode_0_0_0_3(Graphics2D g) {
		GeneralPath shape3 = new GeneralPath();
		shape3.moveTo(373.5089, 459.94275);
		shape3.lineTo(429.83148, 391.36905);
		shape3.curveTo(429.83148, 391.36905, 303.32568, 399.28195, 304.82367, 316.91547);
		shape3.curveTo(306.32162, 234.54898, 557.5125, 237.77103, 553.9545, 320.40768);
		shape3.curveTo(550.39655, 403.04437, 444.35043, 391.79272, 444.35043, 391.79272);
		shape3.closePath();
		g.setPaint(new Color(255, 255, 255, 255));
		g.fill(shape3);
		g.setPaint(new Color(0, 0, 0, 255));
		g.setStroke(new BasicStroke(1.0548552f, 0, 0, 4.0f, null, 0.0f));
		g.draw(shape3);
	}

	private void paintTextNode_0_0_0_4(Graphics2D g) {
		g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
		g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
		g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
		GeneralPath shape4 = new GeneralPath();
		shape4.moveTo(327.28003, 312.71683);
		shape4.quadTo(327.28003, 312.07672, 327.28003, 311.46484);
		shape4.quadTo(327.28003, 310.85297, 327.35532, 310.28818);
		shape4.quadTo(327.58124, 307.2759, 328.68262, 304.3201);
		shape4.quadTo(329.78397, 301.3643, 331.3466, 298.8227);
		shape4.lineTo(335.5073, 300.1594);
		shape4.quadTo(334.28357, 302.701, 333.68112, 305.3085);
		shape4.quadTo(333.07864, 307.91602, 333.07864, 310.15637);
		shape4.quadTo(333.07864, 310.74002, 333.1069, 311.40836);
		shape4.quadTo(333.13513, 312.07672, 333.19162, 312.71683);
		shape4.lineTo(327.28003, 312.71683);
		shape4.closePath();
		shape4.moveTo(338.1242, 312.71683);
		shape4.quadTo(338.1242, 312.07672, 338.1242, 311.46484);
		shape4.quadTo(338.1242, 310.85297, 338.19952, 310.28818);
		shape4.quadTo(338.42545, 307.2759, 339.52682, 304.3201);
		shape4.quadTo(340.62817, 301.3643, 342.1908, 298.8227);
		shape4.lineTo(346.3515, 300.1594);
		shape4.quadTo(345.12778, 302.701, 344.5253, 305.3085);
		shape4.quadTo(343.92285, 307.91602, 343.92285, 310.15637);
		shape4.quadTo(343.92285, 310.74002, 343.95108, 311.40836);
		shape4.quadTo(343.97934, 312.07672, 344.03583, 312.71683);
		shape4.lineTo(338.1242, 312.71683);
		shape4.closePath();
		shape4.moveTo(386.03824, 322.7138);
		shape4.quadTo(386.03824, 327.91, 384.41916, 331.76007);
		shape4.quadTo(382.80005, 335.61014, 379.85367, 338.1235);
		shape4.quadTo(376.9073, 340.63687, 372.80304, 341.87943);
		shape4.quadTo(368.69882, 343.12198, 363.78503, 343.12198);
		shape4.quadTo(361.35638, 343.12198, 358.42883, 342.92432);
		shape4.quadTo(355.50128, 342.72662, 353.12912, 342.143);
		shape4.lineTo(353.12912, 303.28464);
		shape4.quadTo(355.50128, 302.701, 358.42883, 302.50333);
		shape4.quadTo(361.35638, 302.30563, 363.78503, 302.30563);
		shape4.quadTo(368.69882, 302.30563, 372.80304, 303.5482);
		shape4.quadTo(376.9073, 304.79077, 379.85367, 307.30414);
		shape4.quadTo(382.80005, 309.8175, 384.41916, 313.66757);
		shape4.quadTo(386.03824, 317.51764, 386.03824, 322.7138);
		shape4.closePath();
		shape4.moveTo(364.23688, 338.20822);
		shape4.quadTo(372.21942, 338.20822, 376.1542, 334.13223);
		shape4.quadTo(380.089, 330.05624, 380.089, 322.7138);
		shape4.quadTo(380.089, 315.3714, 376.1542, 311.2954);
		shape4.quadTo(372.21942, 307.21942, 364.23688, 307.21942);
		shape4.quadTo(361.86472, 307.21942, 360.56567, 307.2759);
		shape4.quadTo(359.26663, 307.33237, 358.73947, 307.38885);
		shape4.lineTo(358.73947, 338.0388);
		shape4.quadTo(359.26663, 338.09525, 360.56567, 338.15173);
		shape4.quadTo(361.86472, 338.20822, 364.23688, 338.20822);
		shape4.closePath();
		shape4.moveTo(404.43198, 338.90482);
		shape4.quadTo(406.33347, 338.90482, 407.81137, 338.8201);
		shape4.quadTo(409.28928, 338.73535, 410.26828, 338.50943);
		shape4.lineTo(410.26828, 329.5479);
		shape4.quadTo(409.68463, 329.2467, 408.3856, 329.049);
		shape4.quadTo(407.08655, 328.85132, 405.24152, 328.85132);
		shape4.quadTo(404.0178, 328.85132, 402.66226, 329.02078);
		shape4.quadTo(401.30673, 329.19022, 400.17712, 329.73618);
		shape4.quadTo(399.04755, 330.28217, 398.29446, 331.2423);
		shape4.quadTo(397.54138, 332.20248, 397.54138, 333.7651);
		shape4.quadTo(397.54138, 336.6456, 399.39584, 337.7752);
		shape4.quadTo(401.25027, 338.90482, 404.43198, 338.90482);
		shape4.closePath();
		shape4.moveTo(403.9613, 311.96375);
		shape4.quadTo(407.19952, 311.96375, 409.43048, 312.80154);
		shape4.quadTo(411.66144, 313.63934, 413.01697, 315.1737);
		shape4.quadTo(414.3725, 316.7081, 414.94672, 318.81668);
		shape4.quadTo(415.52094, 320.92526, 415.52094, 323.4669);
		shape4.lineTo(415.52094, 342.25595);
		shape4.quadTo(414.84317, 342.36893, 413.5912, 342.57602);
		shape4.quadTo(412.3392, 342.7831, 410.786, 342.95255);
		shape4.quadTo(409.2328, 343.12198, 407.40662, 343.2726);
		shape4.quadTo(405.5804, 343.42322, 403.79187, 343.42322);
		shape4.quadTo(401.25027, 343.42322, 399.104, 342.89606);
		shape4.quadTo(396.95776, 342.36893, 395.39514, 341.24872);
		shape4.quadTo(393.83252, 340.12854, 392.9665, 338.2741);
		shape4.quadTo(392.10046, 336.41968, 392.10046, 333.8216);
		shape4.quadTo(392.10046, 331.33646, 393.11713, 329.5385);
		shape4.quadTo(394.13376, 327.74054, 395.8658, 326.6486);
		shape4.quadTo(397.59787, 325.55664, 399.91357, 325.0295);
		shape4.quadTo(402.22925, 324.50235, 404.77087, 324.50235);
		shape4.quadTo(405.5804, 324.50235, 406.44644, 324.58707);
		shape4.quadTo(407.31247, 324.67178, 408.09378, 324.82242);
		shape4.quadTo(408.8751, 324.97302, 409.4587, 325.08597);
		shape4.quadTo(410.04236, 325.19894, 410.26828, 325.25543);
		shape4.lineTo(410.26828, 323.7493);
		shape4.quadTo(410.26828, 322.43143, 409.97644, 321.12296);
		shape4.quadTo(409.68463, 319.81448, 408.93158, 318.80728);
		shape4.quadTo(408.1785, 317.80005, 406.87946, 317.18817);
		shape4.quadTo(405.5804, 316.5763, 403.49063, 316.5763);
		shape4.quadTo(400.83606, 316.5763, 398.84045, 316.95282);
		shape4.quadTo(396.84482, 317.32938, 395.8658, 317.74356);
		shape4.lineTo(395.2257, 313.28162);
		shape4.quadTo(396.26117, 312.82977, 398.68982, 312.39676);
		shape4.quadTo(401.11847, 311.96375, 403.9613, 311.96375);
		shape4.closePath();
		shape4.moveTo(424.67072, 313.58286);
		shape4.quadTo(426.51572, 313.11218, 429.58447, 312.59445);
		shape4.quadTo(432.65323, 312.07672, 436.6445, 312.07672);
		shape4.quadTo(440.2216, 312.07672, 442.59375, 313.08395);
		shape4.quadTo(444.9659, 314.0912, 446.38733, 315.91736);
		shape4.quadTo(447.80875, 317.74356, 448.38297, 320.28516);
		shape4.quadTo(448.95718, 322.82678, 448.95718, 325.89554);
		shape4.lineTo(448.95718, 342.7831);
		shape4.lineTo(443.57275, 342.7831);
		shape4.lineTo(443.57275, 327.04398);
		shape4.quadTo(443.57275, 324.27643, 443.20563, 322.30905);
		shape4.quadTo(442.8385, 320.34164, 441.96304, 319.12732);
		shape4.quadTo(441.08762, 317.913, 439.64737, 317.36703);
		shape4.quadTo(438.20712, 316.82104, 436.06088, 316.82104);
		shape4.quadTo(435.19485, 316.82104, 434.27234, 316.87753);
		shape4.quadTo(433.34982, 316.93402, 432.51202, 317.01874);
		shape4.quadTo(431.67426, 317.10345, 431.0059, 317.2164);
		shape4.quadTo(430.33755, 317.32938, 430.05515, 317.38586);
		shape4.lineTo(430.05515, 342.7831);
		shape4.lineTo(424.67072, 342.7831);
		shape4.lineTo(424.67072, 313.58286);
		shape4.closePath();
		shape4.moveTo(463.49142, 342.7831);
		shape4.lineTo(458.107, 342.7831);
		shape4.lineTo(458.107, 312.71683);
		shape4.lineTo(463.49142, 312.71683);
		shape4.lineTo(463.49142, 342.7831);
		shape4.closePath();
		shape4.moveTo(460.76154, 307.2759);
		shape4.quadTo(459.3119, 307.2759, 458.30466, 306.31573);
		shape4.quadTo(457.29742, 305.35556, 457.29742, 303.73648);
		shape4.quadTo(457.29742, 302.11737, 458.30466, 301.16663);
		shape4.quadTo(459.3119, 300.21588, 460.76154, 300.21588);
		shape4.quadTo(462.2112, 300.21588, 463.22784, 301.16663);
		shape4.quadTo(464.2445, 302.11737, 464.2445, 303.73648);
		shape4.quadTo(464.2445, 305.35556, 463.22784, 306.31573);
		shape4.quadTo(462.2112, 307.2759, 460.76154, 307.2759);
		shape4.closePath();
		shape4.moveTo(471.28568, 327.79703);
		shape4.quadTo(471.28568, 323.80576, 472.4435, 320.83115);
		shape4.quadTo(473.60138, 317.8565, 475.50287, 315.88913);
		shape4.quadTo(477.40436, 313.92172, 479.8989, 312.94275);
		shape4.quadTo(482.39346, 311.96375, 484.99155, 311.96375);
		shape4.quadTo(491.05374, 311.96375, 494.30136, 315.74792);
		shape4.quadTo(497.54898, 319.5321, 497.54898, 327.2887);
		shape4.quadTo(497.54898, 327.6276, 497.54898, 328.18298);
		shape4.quadTo(497.54898, 328.73837, 497.47366, 329.19022);
		shape4.lineTo(476.89606, 329.19022);
		shape4.quadTo(477.23492, 333.87808, 479.6071, 336.3067);
		shape4.quadTo(481.97925, 338.73535, 487.006, 338.73535);
		shape4.quadTo(489.84885, 338.73535, 491.788, 338.24588);
		shape4.quadTo(493.72714, 337.75638, 494.70615, 337.2857);
		shape4.lineTo(495.4592, 341.8041);
		shape4.quadTo(494.48022, 342.31244, 492.02332, 342.89606);
		shape4.quadTo(489.56644, 343.4797, 486.4412, 343.4797);
		shape4.quadTo(482.5064, 343.4797, 479.64474, 342.2936);
		shape4.quadTo(476.78308, 341.10754, 474.92865, 339.0272);
		shape4.quadTo(473.07422, 336.94684, 472.17996, 334.08517);
		shape4.quadTo(471.28568, 331.2235, 471.28568, 327.79703);
		shape4.closePath();
		shape4.moveTo(491.9386, 324.86008);
		shape4.quadTo(491.9951, 321.20767, 490.1124, 318.86374);
		shape4.quadTo(488.22974, 316.5198, 484.93506, 316.5198);
		shape4.quadTo(483.09003, 316.5198, 481.6686, 317.24466);
		shape4.quadTo(480.2472, 317.96948, 479.26822, 319.12732);
		shape4.quadTo(478.2892, 320.28516, 477.73383, 321.7913);
		shape4.quadTo(477.17844, 323.29745, 477.009, 324.86008);
		shape4.lineTo(491.9386, 324.86008);
		shape4.closePath();
		shape4.moveTo(514.5495, 343.36673);
		shape4.quadTo(509.57925, 343.25378, 507.4989, 341.22992);
		shape4.quadTo(505.41855, 339.20602, 505.41855, 334.91354);
		shape4.lineTo(505.41855, 298.8227);
		shape4.lineTo(510.78418, 297.90018);
		shape4.lineTo(510.78418, 334.04752);
		shape4.quadTo(510.78418, 335.38422, 511.0195, 336.25024);
		shape4.quadTo(511.25485, 337.11627, 511.77258, 337.634);
		shape4.quadTo(512.29034, 338.15173, 513.1564, 338.4153);
		shape4.quadTo(514.0224, 338.6789, 515.3026, 338.84833);
		shape4.lineTo(514.5495, 343.36673);
		shape4.closePath();
		shape4.moveTo(527.0505, 299.4063);
		shape4.quadTo(527.0505, 300.04642, 527.0505, 300.6489);
		shape4.quadTo(527.0505, 301.25134, 526.99396, 301.83496);
		shape4.quadTo(526.7492, 304.84726, 525.6573, 307.76538);
		shape4.quadTo(524.5653, 310.68353, 523.0027, 313.28162);
		shape4.lineTo(518.842, 311.96375);
		shape4.quadTo(520.04694, 309.34683, 520.6588, 306.77698);
		shape4.quadTo(521.2706, 304.20712, 521.2706, 301.94794);
		shape4.quadTo(521.2706, 301.3643, 521.23303, 300.70535);
		shape4.quadTo(521.1954, 300.04642, 521.13885, 299.4063);
		shape4.lineTo(527.0505, 299.4063);
		shape4.closePath();
		shape4.moveTo(537.89465, 299.4063);
		shape4.quadTo(537.89465, 300.04642, 537.89465, 300.6489);
		shape4.quadTo(537.89465, 301.25134, 537.8382, 301.83496);
		shape4.quadTo(537.59344, 304.84726, 536.50146, 307.76538);
		shape4.quadTo(535.40955, 310.68353, 533.8469, 313.28162);
		shape4.lineTo(529.6862, 311.96375);
		shape4.quadTo(530.8911, 309.34683, 531.503, 306.77698);
		shape4.quadTo(532.11487, 304.20712, 532.11487, 301.94794);
		shape4.quadTo(532.11487, 301.3643, 532.0772, 300.70535);
		shape4.quadTo(532.03955, 300.04642, 531.9831, 299.4063);
		shape4.lineTo(537.89465, 299.4063);
		shape4.closePath();
		g.fill(shape4);
		g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
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
		g.transform(new AffineTransform(0.9763748049736023f, 0.0f, 0.0f, 1.0738836526870728f, -51.44007873535156f, -26.631372451782227f));
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
		paintTextNode_0_0_0_4(g);
		g.setTransform(trans_0_0_0_4);
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
	public MenuRename() {
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

