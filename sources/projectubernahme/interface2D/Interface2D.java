package projectubernahme.interface2D;

import java.util.Timer;

import javax.swing.JFrame;

import projectubernahme.Localizer;
import projectubernahme.Player;
import projectubernahme.ProjectUbernahme;
import projectubernahme.simulator.MainSimulator;

public class Interface2D {
	
	MainSimulator sim;
	Player player;
	
	public Interface2D (MainSimulator sim, Player p) {		
		JFrame graphicsPanel = new JFrame(Localizer.get("Project Ubernahme"));
		graphicsPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		View2D view = new View2D(sim, p);
		graphicsPanel.add(view);
		graphicsPanel.setSize(Integer.parseInt(ProjectUbernahme.getConfigValue("initialWindowWidth")), Integer.parseInt(ProjectUbernahme.getConfigValue("initialWindowHeight")));
		graphicsPanel.setVisible(true);
		
		graphicsPanel.addKeyListener(new LifeformControlKeyListener(p));
	}

}
