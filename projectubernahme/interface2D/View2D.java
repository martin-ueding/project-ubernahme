package projectubernahme.interface2D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

import projectubernahme.lifeforms.Lifeform;
import projectubernahme.simulator.MainSimulator;

@SuppressWarnings("serial")
public class View2D extends JPanel {
	
	AffineTransform transform;
	
	MainSimulator sim;

	int viewScaling = 100;
	int viewOffsetX = 200, viewOffsetY = 200;
	
	public View2D (MainSimulator sim) {
		this.sim = sim;
		transform = new AffineTransform();
		
		MapPanListener mpl = new MapPanListener(this);
		addMouseMotionListener(mpl);
		addMouseWheelListener(mpl);
		

		transform.setToIdentity();
		transform.translate(viewOffsetX, viewOffsetY);
		transform.scale(viewScaling, viewScaling);
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
			diameter *= Math.sqrt(transform.getDeterminant());			
			Point2D p = transform.transform(l.getPoint2D(), null);
			g.drawOval((int)Math.round(p.getX() - diameter/2), (int)Math.round(p.getY() - diameter/2), (int)diameter, (int)diameter);
		}
		
	
	}

}
