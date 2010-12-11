package projectubernahme.interface2D;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import projectubernahme.Player;

public class LifeformControlKeyListener implements KeyListener {
	
	Player player;

	public LifeformControlKeyListener(Player player) {
		this.player = player;
	}

	public void keyPressed(KeyEvent e) {
		/* do something with the key */
		System.out.println("KeyEvent in Listener");
		
		/* pass it on to the player */
		player.handleKeyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		/* do something with the key */
		
		/* pass it on to the player */
		player.handleKeyReleased(e);
	}

	public void keyTyped(KeyEvent e) {
	}

}
