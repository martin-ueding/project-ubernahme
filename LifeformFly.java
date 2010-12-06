public class LifeformFly extends Lifeform {


	public String toString () {
		canFly = true;
		canSee = true;
		canMove = true;
		biomass = 0.001/17;
		return "fly";
	}

	public void lookAround () {
		if (ProjectUbernahme.npcLifeforms.size() > 0) {
		System.out.println("You can see the following other lifeforms:");
			for (Lifeform npc : ProjectUbernahme.npcLifeforms) {
				System.out.println(npc.toString());
			}
		}
		else {
			System.out.println("This lifeform cannot see any other lifeforms");
		}
	}
}
