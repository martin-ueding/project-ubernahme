package projectubernahme.interface2D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import projectubernahme.lifeforms.Lifeform;
import projectubernahme.simulator.MainSimulator;

public class LifeformPanel extends JPanel {
	
	MainSimulator sim;
	
	private static final int CIRCLE_RADIUS = 3;
	private static final int SCALING = 20;
	private static final int OFFSET = 200;
	
	public LifeformPanel (MainSimulator sim) {
		this.sim = sim;
	}
	
	protected void paintComponent (Graphics h) {
		final Graphics2D g = (Graphics2D)h;
		g.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
		
		/* clear screen */
		g.clearRect(0, 0, getWidth(), getHeight());
		
		for (Lifeform l : sim.npcLifeforms) {
			if (l.isControlled()) {
				g.setColor(Color.GREEN);
			}
			else {
				g.setColor(Color.BLUE);
			}
			
			g.drawOval((int)Math.round(l.getX()*SCALING+OFFSET) - CIRCLE_RADIUS/2, (int)Math.round(l.getY()*SCALING+OFFSET) - CIRCLE_RADIUS/2, CIRCLE_RADIUS, CIRCLE_RADIUS);
		}
	
	}

}
