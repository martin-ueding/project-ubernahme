import java.util.ArrayList;

/** something with its own mind in the game, can interact with other lifeforms and the world */
public abstract class Lifeform {
	double x, y, z;
	double vx, vy, vz;

	/** given name of the object */
	String name = new String();

	boolean alive = true;

	/* senses */
	boolean canSee = false;
	boolean canSeeIR = false;
	boolean canSeeXRay = false;
	boolean canHear = false;
	boolean canFeel = false;
	boolean canSmell = false;
	boolean canTaste = false;

	/* actions */
	boolean canMove = false;
	boolean canFly = false;

	/** the mass of biological stuff the lifeform ingested so far */
	double biomass;

	/** gives a generic description string of the object */
	public String toString () {
		if (name.equals("")) {
			return getClass().getName()+"\t"+biomass+" kg";
		}
		else {
			return name+"\t("+getClass().getName()+")\t"+biomass+" kg";
		}
	}

	/** lets the lifeform look around and interact with its proximity */
	public void lookAround (Player player) {
		ArrayList<Lifeform> inProximity = new ArrayList<Lifeform>();
		if (ProjectUbernahme.npcLifeforms.size() > 0) {
			for (Lifeform npc : ProjectUbernahme.npcLifeforms) {
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
					ProjectUbernahme.npcLifeforms.remove(selected);
				}
				else if (action.equals(Localizer.get("in"))) {
					ProjectUbernahme.npcLifeforms.remove(selected);
					this.biomass += selected.biomass;
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
		return Math.sqrt(Math.pow(x-l.x, 2) + Math.pow(y-l.y, 2) + Math.pow(z-l.z, 2));
	}

	/** polls for a new name and applies it */
	public void rename () {
		System.out.print(Localizer.get("New Name: "));
		name = StringRead.read();
	}
}
