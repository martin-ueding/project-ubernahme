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
		Lifeform lifeformSelection = null;
		int lifeformSelectionNumber = 0;

		/* the game continues as long as there are lifeforms the player is in control of */
		while (controlledLifeforms.size() > 0) {
			/* select which unit to use */
			System.out.println("You are in control of the following lifeforms:");
			int i = 0;
			for (Lifeform form : controlledLifeforms) {
				if (form == lifeformSelection)
					lifeformSelectionNumber = i;
				System.out.println(i+++"\t"+form.toString());
			}
			System.out.print("which unit do you want to use? ");
			if (lifeformSelection != null)
			   System.out.print("["+lifeformSelectionNumber+"] ");	

			/* TODO this needs to be parsed and verified, causes exception if it is out of range! */
			String input = StringRead.read();
			if (!input.equals("")) {
				lifeformSelectionNumber = Integer.parseInt(input);
				lifeformSelection = controlledLifeforms.get(lifeformSelectionNumber);
			}

			/* use the selected unit */
			System.out.println("You have selected the unit “"+lifeformSelection.toString()+"”");
			System.out.println("What do you want to do now with that unit? You have the following options:");

			System.out.println("re\trename unit");

			if (lifeformSelection.canSee) {
				System.out.println("lo\tlook around");
			}
			if (lifeformSelection.canFly) {
				System.out.println("fl\tfly around");
			}

			System.out.print("what do you want to do with this unit? ");
			String choice = StringRead.read();
			if (choice.equals("re")) {
				lifeformSelection.rename();
			}
			if (choice.equals("lo")) {
				lifeformSelection.lookAround(this);
			}


			/* let the other blobs interact with you */
			for (Lifeform blob : ProjectUbernahme.npcLifeforms) {
				
			}
		}

		System.out.println(Localizer.get("Game Over"));
	}

	public void takeControlOver (Lifeform l) {
		controlledLifeforms.add(l);
	}
}
