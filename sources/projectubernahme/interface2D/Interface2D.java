package projectubernahme.interface2D;

import java.util.Timer;

import javax.swing.JFrame;

import projectubernahme.Player;
import projectubernahme.ProjectUbernahme;
import projectubernahme.simulator.MainSimulator;

public class Interface2D {
	
	MainSimulator sim;
	Player player;
	
	public Interface2D (MainSimulator sim, Player p) {		
		JFrame graphicsPanel = new JFrame();
		graphicsPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		View2D view = new View2D(sim, p);
		graphicsPanel.add(view);
		graphicsPanel.setSize(Integer.parseInt(ProjectUbernahme.getConfigValue("initialWindowWidth")), Integer.parseInt(ProjectUbernahme.getConfigValue("initialWindowHeight")));
		graphicsPanel.setVisible(true);
		
		graphicsPanel.addKeyListener(new LifeformControlKeyListener(p));
		
		Timer timer = new Timer();
		timer.schedule(new JPanelRepaintTimerTask(view), 1000, 40);
	}

}
