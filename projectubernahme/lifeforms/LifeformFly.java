package projectubernahme.lifeforms;

/** lifeform, a simple fly which can look around and fly a little */
public class LifeformFly extends Lifeform {

	public LifeformFly () {
		name = new String();
		setCanFly(true);
		setCanSee(true);
		canMove = true;
		biomass = 0.001/17;
	}

	public boolean canSee (Lifeform l) {
		if (isCanSee() && distance(l) < 10) {
			return true;
		}
		else {
			return false;
		}
	}
}
