public class LifeformHuman extends Lifeform {

	public LifeformHuman () {
		name = new String();
		canFly = false;
		canSee = true;
		canMove = true;
		biomass = 60.0 + Math.random()*60;
	}

	public boolean canSee (Lifeform l) {
		if (canSee && distance(l) < 10) {
			return true;
		}
		else {
			return false;
		}
	}
}
