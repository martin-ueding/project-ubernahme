public abstract class Lifeform {
	double x, y, z;
	double vx, vy, vz;

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

	public String toString () {
		return "generic lifeform";
	}

	public abstract void lookAround();
}
