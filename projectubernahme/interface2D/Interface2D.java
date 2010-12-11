package projectubernahme.interface2D;

import javax.swing.JFrame;

import projectubernahme.Player;
import projectubernahme.simulator.MainSimulator;

public class Interface2D {
	
	MainSimulator sim;
	Player player;
	
	public Interface2D (MainSimulator sim, Player p) {
		JFrame lifeformFrame = new LifeformFrame(sim, p);
	}

}
