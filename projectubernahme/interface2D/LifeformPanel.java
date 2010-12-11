package projectubernahme.interface2D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

import projectubernahme.lifeforms.Lifeform;
import projectubernahme.simulator.MainSimulator;

@SuppressWarnings("serial")
public class LifeformPanel extends JPanel {
	
	AffineTransform transform;
	
	MainSimulator sim;

	private static final int SCALING = 100;
	private static final int OFFSET = 200;
	
	public LifeformPanel (MainSimulator sim) {
		this.sim = sim;
		transform = new AffineTransform();
		transform.setToIdentity();
		transform.translate(OFFSET, OFFSET);
		transform.scale(SCALING, SCALING);
	}
	
	protected void paintComponent (Graphics h) {
		final Graphics2D g = (Graphics2D)h;
		g.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
		
		/* clear screen */
		g.clearRect(0, 0, getWidth(), getHeight());
		
		/* draw the map */
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
			
			int diameter = (int) Math.max(Math.sqrt(l.getBiomass()), 1.0);
			g.drawOval((int)Math.round(l.getX()*SCALING+OFFSET) - diameter/2, (int)Math.round(l.getY()*SCALING+OFFSET) - diameter/2, diameter, diameter);
		}
	
	}

}
