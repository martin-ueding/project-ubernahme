package projectubernahme.interface2D;

import javax.swing.JFrame;

import projectubernahme.simulator.MainSimulator;

public class LifeformFrame extends JFrame {
	
	public LifeformFrame (MainSimulator sim) {
		super("Lifeform Frame");
		add(new LifeformPanel(sim));
		setSize(400, 400);
		setVisible(true);
	}

}
