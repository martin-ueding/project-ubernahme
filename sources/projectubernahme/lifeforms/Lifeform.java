package projectubernahme.lifeforms;

import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import projectubernahme.IngestionThread;
import projectubernahme.Localizer;
import projectubernahme.MessageTypes;
import projectubernahme.Player;
import projectubernahme.ProjectUbernahme;
import projectubernahme.TakeoverThread;
import projectubernahme.Vector2D;
import projectubernahme.gfx.ConvertedGraphics;
import projectubernahme.simulator.MainSimulator;


/** something with its own mind in the game, can interact with other lifeforms and the world */
abstract public class Lifeform {	
	/** the simulator this lifeform is connected to */
	MainSimulator sim;
	

	public Lifeform (MainSimulator sim) {
		this.sim = sim;
		name = new String();
		id = next_id++;
		setVelocity(new Vector2D(0.0, 0.0));
		suspicionCases = new CopyOnWriteArrayList<SuspicionCase>();
	}
	
	/*
	 * the AI
	 */

	/** this lets the lifeform act, this can be just sitting around or calling for support or attacking another lifeform */
	abstract public void act(int sleepTime);
	
	/** whether this lifeforms thinks that something weird is going on [0, 1] */
	private double suspicion = 0.05;
	
	public CopyOnWriteArrayList<SuspicionCase> suspicionCases;
	
	/*
	 * everything that has to do with movement
	 * - position
	 * - velocity
	 * - rotation
	 * - distance
	 */

	Point2D position;

	public Point2D getPoint2D () {
		return position;
	}
	
	private Vector2D velocity;

	/** angle of view */
	public double viewAngle;

	/** whether character is turning */
	double dViewAngle;

	public double getViewAngle() {
		return viewAngle;
	}

	public void setViewAngle(double viewAngle) {
		this.viewAngle = viewAngle;
	}

	/** movement state variable */
	public short dvSign;

	/** movement state variable */
	short dViewAngleSign;

	/** maximal velocity */
	private static double vMax = 1.0;

	/** lets the physics work on the lifeform and moves it by its velocities */
	public void move(int sleepTime) {
		/* calculate new velocity if this lifeform is controlled */
		if (inControlledMode && !busy) {
			if (dvSign == 0) {
				getVelocity().zero();
			}
			else {
				setVelocity(new Vector2D(1.0*dvSign*Math.cos(viewAngle), 1.0*dvSign*Math.sin(viewAngle)));
			}
		}
		
		getVelocity().lowpassThis(vMax);
		getVelocity().highpassThis(-vMax);
	
		double t = sleepTime/1000.0;
		neighborsListAge += t;
		
		if (isCanMove() || canFly) {
			Point2D newPosition = getVelocity().multiply(t).add(position);
	
			/* try to move, check for wall */
			if (sim.getEnv().isFreeBetween(position, newPosition)) {
				position = newPosition;
			}
			viewAngle += dViewAngleSign*t;
		}
	}

	/** returns the distance to the other lifeform l, currently just the geometric mean of the axes, later it might include some path trough the world */
	public double distance (Lifeform l) {
		return position.distance(l.getPoint2D());
	}

	/*
	 * everything with perception
	 * - senses
	 * - neighbors
	 */
	
	private boolean canSee = false;
	private boolean canSeeIR = false;
	private boolean canSeeXRay = false;
	private boolean canHear = false;
	private boolean canFeel = false;
	private boolean canSmell = false;
	private boolean canTaste = false;
	private boolean canMove = false;
	private boolean canFly = false;

	public boolean isCanSee() {
		return canSee;
	}

	public boolean isCanFly() {
		return canFly;
	}

	public void setCanMove(boolean canMove) {
		this.canMove = canMove;
	}

	public boolean isCanMove() {
		return canMove;
	}

	public void setCanSeeIR(boolean canSeeIR) {
		this.canSeeIR = canSeeIR;
	}

	public boolean isCanSeeIR() {
		return canSeeIR;
	}

	public void setCanSeeXRay(boolean canSeeXRay) {
		this.canSeeXRay = canSeeXRay;
	}

	public boolean isCanSeeXRay() {
		return canSeeXRay;
	}

	public void setCanHear(boolean canHear) {
		this.canHear = canHear;
	}

	public boolean isCanHear() {
		return canHear;
	}

	public void setCanFeel(boolean canFeel) {
		this.canFeel = canFeel;
	}

	public boolean isCanFeel() {
		return canFeel;
	}

	public void setCanSmell(boolean canSmell) {
		this.canSmell = canSmell;
	}

	public boolean isCanSmell() {
		return canSmell;
	}

	public void setCanTaste(boolean canTaste) {
		this.canTaste = canTaste;
	}

	public boolean isCanTaste() {
		return canTaste;
	}

	public void setCanSee(boolean canSee) {
		this.canSee = canSee;
	}

	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}

	/** decides whether this lifeform can see some other lifeform l */
	public abstract boolean canSee (Lifeform l);
	
	/** list of other lifeforms that this lifeform can see */
	ArrayList<Lifeform> neighbors = new ArrayList<Lifeform>();

	/** In order to save power, the list with neighbors is only refreshed when it expires. This tracks the age of the list */
	private double neighborsListAge = 0.0;
	
	public ArrayList<Lifeform> getNeighbors() {
		if (neighbors == null) {
			neighbors = new ArrayList<Lifeform>();
			generateNeighborsList();
		}
		/* if the neighbors list is old, generate a new one */
		if (neighborsListAge > 0.5) {
			generateNeighborsList();
			neighborsListAge = 0.0;
		}
		return neighbors;
	}

	/** generates a list with all the lifeforms this one can see */
	public void generateNeighborsList() {
		neighbors.clear();
	
		/** only traverse if the lifeform can see */
		if (canSee) {
			for (Lifeform l : sim.getLifeforms()) {
				if (canSee(l) && l != this) {
					neighbors.add(l);
				}
			}
		}
	}

	/*
	 * everything with actions
	 * - ingestion
	 * - takeover
	 */

	/** whether this lifeform is carrying out some sort of action */
	public boolean busy;

	/** progress with that action, from 0.0 to 1.0 */
	public double actionProgress;

	/** thread that handles the current action */
	private Thread actionThread;

	public boolean canTakeover(Lifeform prey) {
		return canSee(prey);
	}

	/** takes over control of the given lifeform, returns whether that was successful */
	public boolean takeover(Lifeform lifeform) {
		if (canTakeover(lifeform) && !busy) {
			return startTakeover(lifeform);
		}
		return false;
	}

	private boolean startTakeover(Lifeform lifeform) {
		actionThread = new TakeoverThread(this, controllingPlayer, lifeform, sim);
		actionThread.start();
		return true;
	}

	public boolean canIngest(Lifeform prey) {
		return canSee(prey);
	}

	/** ingests the given lifeform */
	public void ingest(Lifeform whom) {
		if (whom == null)
			return;

		if (canIngest(whom) && !busy) {
			startIngestion(whom);
		}
	}

	private void startIngestion(Lifeform whom) {
		actionThread = new IngestionThread(this, controllingPlayer, whom, sim);
		actionThread.start();		
	}

	/** stop whatever that lifeform is doing right now */
	private void stopAction() {
		if (actionThread != null && actionThread.isAlive()) {
			actionThread.interrupt();
		}
	}
	
	/*
	 * everything with key handling
	 * - key pressed
	 * - key released
	 */

	/** lets the lifeform handle a key press */
	public void handleKeyPressed (KeyEvent e) {
		switch (e.getKeyChar()) {
		case 'w': dvSign = 1; break;
		case 's': dvSign = -1; break;
		case 'a': dViewAngleSign = -3; break;
		case 'd': dViewAngleSign = 3; break;
		}

		stopAction();
	}

	/** lets the lifeform handle a key release */
	public void handleKeyReleased (KeyEvent e) {
		switch (e.getKeyChar()) {
		case 'w':
		case 's': dvSign = 0; break;
		case 'a':
		case 'd': dViewAngleSign = 0; break;
		case 'p': if (isControlled()) {
			inControlledMode = !inControlledMode;
			stopAction();
			break;
		}
		}
	}

	/*
	 * everything with external control by a player
	 */
	
	/** the player who controls this lifeforms, if null, the computer controls it */
	public Player controllingPlayer = null;
	
	public boolean inControlledMode = false;

	public boolean isControlled() {
		return controllingPlayer != null;
	}

	public void setControlled(Player p) {
		this.controllingPlayer = p;
		inControlledMode = true;
	}
	
	/*
	 * everything with personal properties
	 * - ID
	 * - name
	 * - biomass
	 *   - diameter
	 * - graphics
	 * - intelligence
	 */

	/** unique id */
	int id;

	/** main id counter, determines the next given id */
	protected static int next_id = 0;

	public int getID() {
		return id;
	}

	/** given name of the object */
	String name = new String();

	public String getName() {
		return name;
	}

	public void setName(String value) {
		name = value;
	}

	/** whether this lifeform is still alive */
	boolean alive = true;

	/** the mass of biological stuff the lifeform ingested so far */
	private double biomass = 0.0;

	public double getBiomass() {
		return biomass;
	}

	public void setBiomass(double biomass) {
		this.biomass = biomass;
	}

	/** gives a generic description string of the object */
	public String toString () {
		if (name.equals("")) {
			return getClass().getSimpleName()+" \t"+ProjectUbernahme.f.format(getBiomass())+" kg";
			
		}
		else {
			return getName()+" \t("+getClass().getSimpleName()+") \t"+ProjectUbernahme.f.format(getBiomass())+" kg";
		}
	}

	public double getDiameter() {
		return Math.pow(biomass/1000, 1.0/3.0);
	}

	abstract public ConvertedGraphics getConvertedGraphics();

	/** intelligence level, 1.0 would be a genius */
	private double intelligence;
	
	public void setIntelligence(double intelligence) {
		this.intelligence = intelligence;
	}

	public double getIntelligence() {
		return intelligence;
	}

	public void setVelocity(Vector2D velocity) {
		this.velocity = velocity;
	}

	public Vector2D getVelocity() {
		return velocity;
	}

	public boolean willSuspect(Lifeform l) {
		// TODO tweak the score system
		double points = 0.0;
		
		/* the smaller the other lifeform the less will it become looked at */
		points += Math.log(l.getBiomass()/getBiomass());
		
		/* the more intelligent the other lifeform is, the less points */
		points += 10*(intelligence - l.intelligence);
		
		if (ProjectUbernahme.verboseLevel >= 5)
			ProjectUbernahme.log(MessageFormat.format(Localizer.get("{0} has {1} suspicion points against {2}."), new Object[] {toString(), points, l.toString()}), MessageTypes.DEBUG);
		
		return points > 1;
	}
}
