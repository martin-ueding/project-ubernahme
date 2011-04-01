// Copyright (c) 2011 Martin Ueding <dev@martin-ueding.de>

package projectubernahme.simulator;

import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.concurrent.CopyOnWriteArrayList;

import projectubernahme.Localizer;
import projectubernahme.MessageTypes;
import projectubernahme.Player;
import projectubernahme.ProjectUbernahme;
import projectubernahme.environments.TileEnvironment;
import projectubernahme.interface2D.GamePauseKeyListener;
import projectubernahme.lifeforms.Fly;
import projectubernahme.lifeforms.Lifeform;
import projectubernahme.lifeforms.SuspicionCase;

/** simulates all the lifeforms and the map, has a thread that moves everything around */
public class MainSimulator {

	/** list of all lifeforms in the whole game */
	private CopyOnWriteArrayList<Lifeform> lifeforms;
	private CopyOnWriteArrayList<Player> players;

	/** the environment **/
	private TileEnvironment env;

	public MainSimulator () {
		lifeforms = new CopyOnWriteArrayList<Lifeform>();
		players = new CopyOnWriteArrayList<Player>();

		// TODO add selector for multiple maps here
		env = new TileEnvironment("squarecity");

		env.initializeNPCs(lifeforms, this);

		simulatorThread = new SimulatorThread(this);
		simulatorThread.start();
	}

	public CopyOnWriteArrayList<Lifeform> getLifeforms() {
		return lifeforms;
	}

	/** generates a lifeform and return is. The player then can add it to its list of controlled lifeforms */
	public Lifeform giveLifeform(Player p) {
		Lifeform l = new Fly(this, env.getRandomPointOnMap());
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
				sc.setL(l);
				// TODO adjust this strengh and let strengths add up, avoid duplicate entries
				sc.setStrengh(0.5);
				other.getSuspicionCases().add(sc);

				if (ProjectUbernahme.getVerboseLevel() >= 4)
					ProjectUbernahme.log(MessageFormat.format(Localizer.get("{0} suspects {1} now."), new Object[] {other.toString(), l.toString()}),
					                     l.isControlled() ? MessageTypes.WARNING : MessageTypes.INFO);
			}
		}
	}

	private double lastCalculatedTotalBiomass;
	private long lastCalculatedTotalBiomassTime;
	private SimulatorThread simulatorThread;
	public double getTotalBiomass() {
		Calendar cal = Calendar.getInstance();
		if (lastCalculatedTotalBiomassTime + Long.parseLong(ProjectUbernahme.getConfigValue("TotalBiomassCalcInterval")) < cal.getTimeInMillis()) {
			lastCalculatedTotalBiomassTime = cal.getTimeInMillis();
			lastCalculatedTotalBiomass = 0.0;
			for (Lifeform l : lifeforms) {
				lastCalculatedTotalBiomass += l.getBiomass();
			}
		}
		return lastCalculatedTotalBiomass;
	}

	private KeyListener gamePauseKeyListener;
	public KeyListener getGamePauseKeyListener () {
		if (gamePauseKeyListener == null) {
			gamePauseKeyListener = new GamePauseKeyListener(this);
		}
		return gamePauseKeyListener;
	}

	public void toggleGamePause() {
		if (simulatorThread.isAlive()) {
			((SimulatorThread) simulatorThread).halt();
		}
		else {
			simulatorThread.run();
		}

	}

	public CopyOnWriteArrayList<Integer> getCalcTimeList() {
		return simulatorThread.getCalcTime();
	}

	public int getPeriod() {
		return simulatorThread.getSleepTime();
	}

	public void remove(Lifeform prey) {
		lifeforms.remove(prey);
		prey.setPosition(new Point2D.Double(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY));

	}

	public void skillShockwave(Point2D point2D, double diff, Lifeform sender) {
		for (Lifeform other : lifeforms) {
			if (other != sender) {
				double damage = diff * 2 / sender.distance(other);
				damage = Math.min(damage, other.getBiomass() / 2);
				other.setBiomass(other.getBiomass() - damage);
				if (other.getBiomass() <= 0.0) {
					remove(other);
				}
			}
		}
	}
}
