package projectubernahme.simulator;

import java.text.MessageFormat;
import java.util.concurrent.CopyOnWriteArrayList;

import projectubernahme.Localizer;
import projectubernahme.MessageTypes;
import projectubernahme.Player;
import projectubernahme.ProjectUbernahme;
import projectubernahme.environments.TileEnvironment;
import projectubernahme.lifeforms.Fly;
import projectubernahme.lifeforms.Lifeform;
import projectubernahme.lifeforms.SuspicionCase;

/** simulates all the lifeforms and the map, has a thread that moves everything around */
public class MainSimulator {

	/** list of all lifeforms in the whole game */
	private CopyOnWriteArrayList<Lifeform> lifeforms;
	CopyOnWriteArrayList<Player> players;
	
	/** the environment **/
	private TileEnvironment env;
	
	public MainSimulator () {
		lifeforms = new CopyOnWriteArrayList<Lifeform>();
		players = new CopyOnWriteArrayList<Player>();
		
		env = new TileEnvironment("squarecity");
		
		env.initializeNPCs(lifeforms, this);
		
		/* start thread */
		Thread SimulatorThread = new SimulatorThread(this);
		SimulatorThread.start();
	}

	public CopyOnWriteArrayList<Lifeform> getLifeforms() {
		return lifeforms;
	}

	/** generates a lifeform and return is. The player then can add it to its list of controlled lifeforms */
	public Lifeform giveLifeform(Player p) {
		Lifeform l = new Fly(env.getRandomPointOnMap(), this);
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

	public void setLifeforms(CopyOnWriteArrayList<Lifeform> lifeforms) {
		this.lifeforms = lifeforms;
	}

	public void setEnv(TileEnvironment env) {
		this.env = env;
	}

	public TileEnvironment getEnv() {
		return env;
	}

	public void alertEverybody(Lifeform l) {
		for (Lifeform other : lifeforms) {
			if (other.canSee(l) && other.willSuspect(l)) {
				SuspicionCase sc = new SuspicionCase();
				sc.l = l;
				// TODO adjust this strengh
				sc.strengh = 0.5;
				other.suspicionCases.add(sc);
				ProjectUbernahme.log(MessageFormat.format(Localizer.get("{0} suspects {1} now."), new Object[] {other.toString(), l.toString()}),
						l.isControlled() ? MessageTypes.WARNING : MessageTypes.INFO);
			}
		}
	}
}
