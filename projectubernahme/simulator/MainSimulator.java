package projectubernahme.simulator;

import java.util.ArrayList;

import projectubernahme.Player;
import projectubernahme.environments.Cube;
import projectubernahme.environments.Environment;
import projectubernahme.lifeforms.Lifeform;
import projectubernahme.lifeforms.LifeformFly;
import projectubernahme.lifeforms.LifeformHuman;

/** simulates all the lifeforms and the map, has a thread that moves everything around */
public class MainSimulator {

	/** list of all lifeforms in the whole game */
	private ArrayList<Lifeform> lifeforms;
	ArrayList<Player> players;
	
	/** the environment **/
	private Environment env = new Cube();
	
	public MainSimulator () {
		setLifeforms(new ArrayList<Lifeform>());
		players = new ArrayList<Player>();

		/* add some NPCs to the game */
		for (int i = 0; i < 5; i++) {
			getLifeforms().add(new LifeformHuman(this));
		}
		
		/* start thread */
		Thread SimulatorThread = new SimulatorThread(this);
		SimulatorThread.start();
		
	}

	public ArrayList<Lifeform> getNpcLifeforms() {
		return getLifeforms();
	}

	/** generates a lifeform and return is. The player then can add it to its list of controlled lifeforms */
	public Lifeform giveLifeform() {
		Lifeform l = new LifeformFly(this);
		getLifeforms().add(l);
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

	public void setLifeforms(ArrayList<Lifeform> lifeforms) {
		this.lifeforms = lifeforms;
	}

	public ArrayList<Lifeform> getLifeforms() {
		return lifeforms;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	public Environment getEnv() {
		return env;
	}
}

