package projectubernahme.interface2D;

import java.awt.GraphicsDevice;
import java.awt.Toolkit;

import javax.swing.JFrame;

import projectubernahme.Localizer;
import projectubernahme.Player;
import projectubernahme.ProjectUbernahme;
import projectubernahme.simulator.MainSimulator;

public class Interface2D {
	
	public Interface2D (MainSimulator sim, Player p) {		
		JFrame graphicsPanel = new JFrame(Localizer.get("Project Ubernahme"));
		graphicsPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		View2D view = new View2D(sim, p);
		graphicsPanel.add(view);
		
		
		graphicsPanel.addKeyListener(new LifeformControlKeyListener(p));
		
		GraphicsDevice myDevice = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		if (myDevice.isFullScreenSupported() && ProjectUbernahme.getConfigValue("fullscreen").equals("true")) {
			graphicsPanel.setUndecorated(true);
			graphicsPanel.setSize(Toolkit.getDefaultToolkit().getScreenSize());
			myDevice.setFullScreenWindow(graphicsPanel);

			graphicsPanel.setLocation(0, 0);

			graphicsPanel.setVisible(true);
		}
		else {
			graphicsPanel.setSize(Integer.parseInt(ProjectUbernahme.getConfigValue("initialWindowWidth")), Integer.parseInt(ProjectUbernahme.getConfigValue("initialWindowHeight")));
			graphicsPanel.setVisible(true);
		}

	}

}
