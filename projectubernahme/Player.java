package projectubernahme;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import projectubernahme.lifeforms.Lifeform;
import projectubernahme.simulator.MainSimulator;


/** a physical player of the game, controlling a heap of different lifeforms */
public class Player {
	private ArrayList<Lifeform> controlledLifeforms;

	MainSimulator sim;
	
	private Lifeform selectedLifeform;
	
	
	/** initializes the list of controlledLifeforms, add a starting one */
	public Player (MainSimulator sim) {
		this.sim = sim;
		setControlledLifeforms(new ArrayList<Lifeform>());
		getControlledLifeforms().add(sim.giveLifeform());
	}

	public void play () {
		Lifeform lifeformSelection = null;
		int lifeformSelectionNumber = 0;

		/* the game continues as long as there are lifeforms the player is in control of */
		while (getControlledLifeforms().size() > 0) {
			/* select which unit to use */
			System.out.println(Localizer.get("You are in control of the following lifeforms:"));
			int i = 0;
			for (Lifeform form : getControlledLifeforms()) {
				if (form == lifeformSelection)
					lifeformSelectionNumber = i;
				System.out.println(i+++"\t"+form.toString());
			}
			System.out.print(Localizer.get("which unit do you want to use? "));
			if (lifeformSelection != null)
			   System.out.print("["+lifeformSelectionNumber+"] ");	

			/* TODO this needs to be parsed and verified, causes exception if it is out of range! */
			String input = StringRead.read();
			if (!input.equals("")) {
				lifeformSelectionNumber = Integer.parseInt(input);
				lifeformSelection = getControlledLifeforms().get(lifeformSelectionNumber);
			}

			/* use the selected unit */
			System.out.println(Localizer.get("You have selected the unit ")+"'"+lifeformSelection.toString()+"'");
			System.out.println(Localizer.get("What do you want to do now with that unit? You have the following options:"));

			System.out.println(Localizer.get("re\trename unit"));

			if (lifeformSelection.isCanSee()) {
				System.out.println(Localizer.get("lo\tlook around"));
			}
			if (lifeformSelection.isCanFly()) {
				System.out.println(Localizer.get("fl\tfly around"));
			}

			System.out.print(Localizer.get("what do you want to do with this unit? "));
			String choice = StringRead.read();
			if (choice.equals(Localizer.get("re"))) {
				lifeformSelection.rename();
			}
			if (choice.equals(Localizer.get("lo"))) {
				lifeformSelection.lookAround(this);
			}


			
		}

		System.out.println(Localizer.get("Game Over"));
	}

	public void takeControlOver (Lifeform l) {
		getControlledLifeforms().add(l);
		l.setControlled(true);
	}

	public boolean hasSomeControl() {
		return getControlledLifeforms().size() > 0;
	}
	

	
	public void handleKeyPressed(KeyEvent e) {
		if (getSelectedLifeform() != null)
			getSelectedLifeform().handleKeyReleased(e);
	}

	public void handleKeyReleased(KeyEvent e) {
		if (getSelectedLifeform() != null)
			getSelectedLifeform().handleKeyReleased(e);
	}

	public void setControlledLifeforms(ArrayList<Lifeform> controlledLifeforms) {
		this.controlledLifeforms = controlledLifeforms;
	}

	public ArrayList<Lifeform> getControlledLifeforms() {
		return controlledLifeforms;
	}

	public void setSelectedLifeform(Lifeform selectedLifeform) {
		this.selectedLifeform = selectedLifeform;
	}

	public Lifeform getSelectedLifeform() {
		if (selectedLifeform == null)
			selectedLifeform = controlledLifeforms.get(0);
		return selectedLifeform;
	}
}
