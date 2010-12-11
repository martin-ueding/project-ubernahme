package projectubernahme.lifeforms;

public class LifeformHuman extends Lifeform {

	public LifeformHuman () {
		name = new String();
		setCanFly(false);
		setCanSee(true);
		canMove = true;
		biomass = 60.0 + Math.random()*60;
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
