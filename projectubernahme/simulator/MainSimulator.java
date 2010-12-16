package projectubernahme.simulator;

import java.util.ArrayList;

import projectubernahme.Player;
import projectubernahme.environments.Environment;
import projectubernahme.environments.TileEnvironment;
import projectubernahme.lifeforms.Fly;
import projectubernahme.lifeforms.Lifeform;

/** simulates all the lifeforms and the map, has a thread that moves everything around */
public class MainSimulator {

	/** list of all lifeforms in the whole game */
	private ArrayList<Lifeform> lifeforms;
	ArrayList<Player> players;
	
	/** the environment **/
	private Environment env;
	
	public MainSimulator () {
		lifeforms = new ArrayList<Lifeform>();
		players = new ArrayList<Player>();
		
		env = new TileEnvironment("squarecity");
		
		env.initializeNPCs(lifeforms, this);
		
		/* start thread */
		Thread SimulatorThread = new SimulatorThread(this);
		SimulatorThread.start();
		
	}

	public ArrayList<Lifeform> getLifeforms() {
		return lifeforms;
	}

	/** generates a lifeform and return is. The player then can add it to its list of controlled lifeforms */
	public Lifeform giveLifeform(Player p) {
		Lifeform l = new Fly(this);
		getLifeforms().add(l);
		l.setControlled(p);
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

	public void setEnv(Environment env) {
		this.env = env;
	}

	public Environment getEnv() {
		return env;
	}
}

