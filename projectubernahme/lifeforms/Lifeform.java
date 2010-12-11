package projectubernahme.lifeforms;

import java.util.ArrayList;

import projectubernahme.Localizer;
import projectubernahme.Player;
import projectubernahme.StringRead;
import projectubernahme.simulator.MainSimulator;


/** something with its own mind in the game, can interact with other lifeforms and the world */
abstract public class Lifeform {
	double x, y, z;
	
	/** velocities in the three coordinate axes, [m/s] */
	double vx, vy, vz;

	/** given name of the object */
	String name = new String();

	boolean alive = true;

	/* senses */
	private boolean canSee = false;
	boolean canSeeIR = false;
	boolean canSeeXRay = false;
	boolean canHear = false;
	boolean canFeel = false;
	boolean canSmell = false;
	boolean canTaste = false;

	/* actions */
	boolean canMove = false;
	private boolean canFly = false;
	
	/** whether this lifeform is controlled by some player, meaning that it does not need to be controlled by the computer */
	private boolean isControlled;

	/** the mass of biological stuff the lifeform ingested so far */
	private double biomass;
	
	MainSimulator sim;
	
	public Lifeform (MainSimulator sim) {
		this.sim = sim;
		name = new String();
	}

	/** gives a generic description string of the object */
	public String toString () {
		if (name.equals("")) {
			return getClass().getSimpleName()+"\t"+getBiomass()+" kg";
		}
		else {
			return name+"\t("+getClass().getSimpleName()+")\t"+getBiomass()+" kg";
		}
	}

	/** lets the lifeform look around and interact with its proximity */
	public void lookAround (Player player) {
		ArrayList<Lifeform> inProximity = new ArrayList<Lifeform>();
		if (sim.getNpcLifeforms().size() > 0) {
			for (Lifeform npc : sim.getNpcLifeforms()) {
				if (this.canSee(npc)) {
					inProximity.add(npc);
				}
			}
		}
		if (inProximity.size() > 0) {
			System.out.println(Localizer.get("This lifeform can see the following other lifeforms:"));
			int i = 0;
			for (Lifeform npc : inProximity) {
				System.out.println(i+++"\t"+npc.toString());
			}
			System.out.println(Localizer.get("choose a lifeform to interact with (-1 for no interaction) "));
			int choice = Integer.parseInt(StringRead.read());
			if (choice > -1) {
				Lifeform selected = inProximity.get(choice);
				System.out.println(Localizer.get("choose an interaction"));
				System.out.println(Localizer.get("ta\ttake over control"));
				System.out.println(Localizer.get("in\tingest biomass"));
				String action = StringRead.read();

				if (action.equals(Localizer.get("ta"))) {
					player.takeControlOver(selected);
				}
				else if (action.equals(Localizer.get("in"))) {
					sim.getNpcLifeforms().remove(selected);
					this.setBiomass(this.getBiomass() + selected.getBiomass());
				}
			}
		}
		else {
			System.out.println(Localizer.get("This lifeform cannot see any other lifeforms"));
		}
	}

	/** decides whether this lifeform can see some other lifeform l */
	public abstract boolean canSee (Lifeform l);

	/** returns the distance to the other lifeform l, currently just the geometric mean of the axes, later it might include some path trough the world */
	public double distance (Lifeform l) {
		return Math.sqrt(Math.pow(getX()-l.getX(), 2) + Math.pow(getY()-l.getY(), 2) + Math.pow(z-l.z, 2));
	}

	/** polls for a new name and applies it */
	public void rename () {
		System.out.print(Localizer.get("New Name: "));
		name = StringRead.read();
	}

	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}

	public boolean isCanFly() {
		return canFly;
	}

	public void setCanSee(boolean canSee) {
		this.canSee = canSee;
	}

	public boolean isCanSee() {
		return canSee;
	}

	public void setControlled(boolean isControlled) {
		this.isControlled = isControlled;
	}

	public boolean isControlled() {
		return isControlled;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getX() {
		return x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getY() {
		return y;
	}

	/** lets the physics work on the lifeform and moves it by its velocities */
	public void move(int sleepTime) {
		double t = sleepTime/1000.0;
		x += vx*t;
		y += vy*t;
		z += vz*t;
	}
	
	/** this lets the lifeform act, this can be just sitting around or calling for support or attacking another lifeform */
	abstract public void act();

	public void setBiomass(double biomass) {
		this.biomass = biomass;
	}

	public double getBiomass() {
		return biomass;
	}
}
