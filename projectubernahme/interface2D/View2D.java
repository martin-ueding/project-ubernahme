package projectubernahme.interface2D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

import projectubernahme.Player;
import projectubernahme.gfx.ConvertedGraphics;
import projectubernahme.lifeforms.Lifeform;
import projectubernahme.simulator.MainSimulator;

@SuppressWarnings("serial")
public class View2D extends JPanel {

	AffineTransform transform;

	MainSimulator sim;

	int viewScaling = 100;
	int viewOffsetX = 200, viewOffsetY = 200;
	
	int frames;
	double measureTime;

	Player player;

	double selectionRoationAngle;



	public View2D (MainSimulator sim, Player player) {
		this.sim = sim;
		this.player = player;

		/* set up the transform */
		transform = new AffineTransform();
		transform.setToIdentity();
		transform.translate(viewOffsetX, viewOffsetY);
		transform.scale(viewScaling, viewScaling);

		/* add the mouse listeners for the map movements */
		MapPanListener mpl = new MapPanListener(this);
		addMouseMotionListener(mpl);
		addMouseWheelListener(mpl);

		/* add mouse listener for lifeform selection */
		addMouseListener(new LifeformSelectionMouseListener(sim, player, transform));


		/* add key listener */
		addKeyListener(new LifeformControlKeyListener(player));

	}

	protected void paintComponent (Graphics h) {
		selectionRoationAngle = (selectionRoationAngle+0.1) % (Math.PI*2);

		double twiceScreenRadius = Math.hypot(getWidth(), getHeight());

		final Graphics2D g = (Graphics2D)h;
		g.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));



		/* clear screen */
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());

		/* draw the map */
		g.drawImage(sim.getEnv().getBackground(getWidth(), getHeight(), transform), 0, 0, null);

		/* draw all the lifeforms */
		for (Lifeform l : sim.getLifeforms()) {
			/* reset the transform */
			g.setTransform(new AffineTransform());

			/* only paint lifeforms that are controlled or are within the reach of some other lifeform
			 * that way, nothing is spoiled */
			if (player.canSee(l)) {
				if (l.isControlled()) {
					g.setColor(Color.GREEN);
				}
				else {
					g.setColor(Color.BLUE);
				}

				double diameter = l.getDiameter();
				double diameterView = diameter * Math.sqrt(transform.getDeterminant());			

				Point2D p = transform.transform(l.getPoint2D(), null);

				/* only draw if the lifeform is within the screen */
				if (p.distance(getWidth()/2, getHeight()/2) < twiceScreenRadius/2) {

					/* draw arc if selected */
					if (player.getSelectedLifeform() == l) {
						g.setColor(new Color(255, 50, 50, 255));
						g.drawArc((int)(p.getX() - diameterView/2), (int)(p.getY() - diameterView/2), (int)diameterView, (int)diameterView, (int)Math.toDegrees(selectionRoationAngle), 90);
						g.drawArc((int)(p.getX() - diameterView/2), (int)(p.getY() - diameterView/2), (int)diameterView, (int)diameterView, (int)Math.toDegrees(selectionRoationAngle+Math.PI), 90);
					}

					if (player.getSecondarySelectedLifeform() == l) {
						g.setColor(new Color(50, 50, 255, 255));
						g.drawArc((int)(p.getX() - diameterView/2), (int)(p.getY() - diameterView/2), (int)diameterView, (int)diameterView, (int)Math.toDegrees(selectionRoationAngle+Math.PI/2), 90);
						g.drawArc((int)(p.getX() - diameterView/2), (int)(p.getY() - diameterView/2), (int)diameterView, (int)diameterView, (int)Math.toDegrees(selectionRoationAngle+3*Math.PI/2), 90);
					}

					if (l.isControlled()) {
						g.setColor(new Color(100, 200, 100, 100));
						g.fillOval((int)(p.getX() - diameterView/2), (int)(p.getY() - diameterView/2), (int)diameterView, (int)diameterView);
					}

					/* if the lifeform can be seen, draw a blue circle below it */
					else if (player.getSelectedLifeform().canSee(l) && l != player.getSelectedLifeform()) {
						g.setColor(new Color(100, 100, 200, 100));
						g.fillOval((int)(p.getX() - diameterView/2), (int)(p.getY() - diameterView/2), (int)diameterView, (int)diameterView);
					}


					/* draw image if available */
					if (l.getConvertedGraphics() != null) {
						
						ConvertedGraphics cg = l.getConvertedGraphics();
						int longerEdge = Math.max(cg.getOrigWidth(), cg.getOrigHeight());
						
						AffineTransform picTransform = new AffineTransform();
						picTransform.setToIdentity();
						picTransform.preConcatenate(transform);
						
						picTransform.translate(l.getX()-diameter/2, l.getY()-diameter/2);
						picTransform.rotate(l.getViewAngle(), diameter/2, diameter/2);
						
						picTransform.scale(diameter/longerEdge / 1, diameter/longerEdge / 1);
						picTransform.translate(-cg.getOrigX(), -cg.getOrigY());
						

						/* translate a rectangular shape into the middle of the square */
						if (cg.getOrigWidth() == longerEdge) {
							/* pic is wider than high */
							picTransform.translate(0, (cg.getOrigWidth()-cg.getOrigHeight()) / 2);
						}
						else {
							/* pic is higher than wide */
							picTransform.translate((cg.getOrigHeight()-cg.getOrigWidth()) / 2, 0);
						}
						
						g.setTransform(picTransform);
						cg.paint(g);
					}

					/* draw a circle */

					else {

						g.drawOval((int)(p.getX() - diameterView/2), (int)(p.getY() - diameterView/2), (int)diameterView, (int)diameterView);
						Point2D nose = new Point2D.Double(l.getX() + diameter*Math.cos(l.getViewAngle())/2, l.getY() + diameter*Math.sin(l.getViewAngle())/2);
						transform.transform(nose, nose);

						g.drawLine((int)p.getX(), (int)p.getY(), (int)nose.getX(), (int)nose.getY());
					}

					if (!l.getName().equals("")) {
						g.setColor(new Color(100, 100, 100, 200));
						g.drawString(l.getName(), (int)(p.getX()+diameterView/2), (int)(p.getY()+diameterView/2));
					}
				}
			}

		}

		frames++;
		
		/* reset the transform */
		g.setTransform(new AffineTransform());
		
		g.setColor(Color.black);
		g.drawString("FPS: "+Math.round(frames/measureTime), 10, 20);
		
		if (measureTime > 10) {
			frames = 0;
			measureTime = 0.0;
		}
		
		
		

	}

}
