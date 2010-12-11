package projectubernahme.simulator;

import java.util.ArrayList;

import projectubernahme.Player;
import projectubernahme.lifeforms.Lifeform;
import projectubernahme.lifeforms.LifeformFly;
import projectubernahme.lifeforms.LifeformHuman;

/** simulates all the lifeforms and the map, has a thread that moves everything around */
public class MainSimulator {

	/** list of all lifeforms in the whole game which are not controlled by the player */
	public ArrayList<Lifeform> lifeforms;
	public ArrayList<Player> players;
	
	public MainSimulator () {
		lifeforms = new ArrayList<Lifeform>();
		players = new ArrayList<Player>();

		/* add some NPCs to the game */
		for (int i = 0; i < 5; i++) {
			lifeforms.add(new LifeformHuman(this));
		}
		
		/* start thread */
		Thread SimulatorThread = new SimulatorThread(this);
		SimulatorThread.start();
		
	}

	public ArrayList<Lifeform> getNpcLifeforms() {
		return lifeforms;
	}

	/** generates a lifeform and return is. The player then can add it to its list of controlled lifeforms */
	public Lifeform giveLifeform() {
		Lifeform l = new LifeformFly(this);
		lifeforms.add(l);
		l.setControlled(true);
		return l;
	}

	/** adds a player to the simulator so that the simulator can keep track of it */
	public void addPlayer(Player player) {
		players.add(player);
	}

	/** decides whether the game is still up and running */
	protected boolean isGameUp() {
		boolean isUp = false;
		for (Player p : players) {
			if (p.hasSomeControl()) {
				isUp = true;
				break;
			}
		}
		return isUp;
	}
}

