package projectubernahme.interface2D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

import projectubernahme.Player;
import projectubernahme.lifeforms.Lifeform;
import projectubernahme.simulator.MainSimulator;

@SuppressWarnings("serial")
public class View2D extends JPanel {
	
	AffineTransform transform;
	
	MainSimulator sim;

	int viewScaling = 100;
	int viewOffsetX = 200, viewOffsetY = 200;
	
	public View2D (MainSimulator sim, Player player) {
		this.sim = sim;
		transform = new AffineTransform();

		transform.setToIdentity();
		transform.translate(viewOffsetX, viewOffsetY);
		transform.scale(viewScaling, viewScaling);
		
		MapPanListener mpl = new MapPanListener(this);
		addMouseMotionListener(mpl);
		addMouseWheelListener(mpl);

		
		/* add key listener */
		addKeyListener(new LifeformControlKeyListener(player));
	}
	
	protected void paintComponent (Graphics h) {
		final Graphics2D g = (Graphics2D)h;
		g.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
		

		
		/* clear screen */
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		/* draw the map */
		g.setColor(Color.BLACK);
		for (Line2D line : sim.getEnv().get2DWalls()) {
			g.draw(transform.createTransformedShape(line));
		}
		
		/* draw all the lifeforms */
		for (Lifeform l : sim.getLifeforms()) {
			if (l.isControlled()) {
				g.setColor(Color.GREEN);
			}
			else {
				g.setColor(Color.BLUE);
			}
			
			double diameter = Math.max(Math.sqrt(l.getBiomass())/100, .1);
			double diameterView = diameter * Math.sqrt(transform.getDeterminant());			

			Point2D p = transform.transform(l.getPoint2D(), null);
			/* draw image if available */
			if (l.image != null) {
				if (l.isControlled()) {
					g.setColor(new Color(100, 200, 100, 100));
					g.fillOval((int)(p.getX() - diameterView/2), (int)(p.getY() - diameterView/2), (int)diameterView, (int)diameterView);
				}
				
				AffineTransform picTransform = new AffineTransform();
				picTransform.setToIdentity();
				picTransform.preConcatenate(transform);
				picTransform.translate(l.getX()-diameter/2, l.getY()-diameter/2);
				picTransform.rotate(l.getViewAngle(), diameter/2, diameter/2);
				picTransform.scale(diameter/l.image.getWidth(), diameter/l.image.getWidth());
				g.drawImage(l.image, picTransform, null);
			}
			
			/* draw a circle */
			else {

				g.drawOval((int)(p.getX() - diameterView/2), (int)(p.getY() - diameterView/2), (int)diameterView, (int)diameterView);
				Point2D nose = new Point2D.Double(l.getX() + diameter*Math.cos(l.getViewAngle())/2, l.getY() + diameter*Math.sin(l.getViewAngle())/2);
				transform.transform(nose, nose);
				
				g.drawLine((int)p.getX(), (int)p.getY(), (int)nose.getX(), (int)nose.getY());
			}
			
		}
		
	
	}

}
