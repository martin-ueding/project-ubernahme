// Copyright (c) 2011 Martin Ueding <dev@martin-ueding.de>

package projectubernahme.interface2D;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import projectubernahme.player.Player;

public class LifeformControlKeyListener implements KeyListener {

	private Player player;

	public LifeformControlKeyListener(Player player) {
		this.player = player;
	}

	public void keyPressed(KeyEvent e) {
		/* do something with the key */

		/* pass it on to the player */
		player.handleKeyPressed(e);

		if (e.getKeyChar() == 'q') {
			System.exit(0);
		}
	}

	public void keyReleased(KeyEvent e) {
		/* do something with the key */

		/* pass it on to the player */
		player.handleKeyReleased(e);
	}

	public void keyTyped(KeyEvent e) {
	}

}
