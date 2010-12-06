import java.util.ArrayList;

/** a physical player of the game, controlling a heap of different lifeforms */
public class Player {
	ArrayList<Lifeform> controlledLifeforms;

	/** initializes the list of controlledLifeforms, add a starting one */
	public Player () {
		System.out.println(Localizer.get("You are a blob of something. Somewhere, you do not really know where you are actually."));
		controlledLifeforms = new ArrayList<Lifeform>();

		controlledLifeforms.add(new LifeformFly());
	}

	public void play () {
		/* the game continues as long as there are lifeforms the player is in control of */
		while (controlledLifeforms.size() > 0) {
			/* select which unit to use */
			System.out.println("You are in control of the following lifeforms:");
			int i = 0;
			for (Lifeform form : controlledLifeforms) {
				System.out.println(i+++"\t"+form.toString());
			}
			System.out.print("which unit do you want to use? #");

			/* TODO this needs to be parsed and verified, causes exception if it is out of range! */
			int selection = Integer.parseInt(StringRead.read());
			Lifeform sel = controlledLifeforms.get(selection);

			/* use the selected unit */
			System.out.println("You have selected the unit “"+sel.toString()+"”");
			System.out.println("What do you want to do now with that unit? You have the following options:");

			if (sel.canSee) {
				System.out.println("lo\tlook around");
			}
			if (sel.canFly) {
				System.out.println("fl\tfly around");
			}

			System.out.print("what do you want to do with this unit? ");
			String choice = StringRead.read();
			if (choice.equals("lo")) {
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


			/* let the other blobs interact with you */
			for (Lifeform blob : ProjectUbernahme.npcLifeforms) {
				
			}

			/* remove the first blob to get the game over */
			controlledLifeforms.remove(controlledLifeforms.get(0));
		}

		System.out.println(Localizer.get("Game Over"));
	}
}
