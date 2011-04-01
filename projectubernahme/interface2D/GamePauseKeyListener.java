// Copyright (c) 2011 Martin Ueding <dev@martin-ueding.de>

package projectubernahme.interface2D;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import projectubernahme.Localizer;
import projectubernahme.MessageTypes;
import projectubernahme.ProjectUbernahme;
import projectubernahme.simulator.MainSimulator;

public class GamePauseKeyListener implements KeyListener {
	private MainSimulator sim;

	public GamePauseKeyListener (MainSimulator sim) {
		this.sim = sim;
	}

	public void keyPressed(KeyEvent e) {
		//ProjectUbernahme.log(Localizer.get("GamePauseKeyListener keyPressed(KeyEvent e) evoked"), MessageTypes.INFO);
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			ProjectUbernahme.log(Localizer.get("Game paused/resumed"), MessageTypes.INFO);
			sim.toggleGamePause();
		}
	}

	public void keyReleased(KeyEvent arg0) {
		//ProjectUbernahme.log(Localizer.get("GamePauseKeyListener keyReleased(KeyEvent e) evoked"), MessageTypes.INFO);
	}

	public void keyTyped(KeyEvent arg0) {
		//ProjectUbernahme.log(Localizer.get("GamePauseKeyListener keyTyped(KeyEvent e) evoked"), MessageTypes.INFO);
	}
}
