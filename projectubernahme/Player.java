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

	public void takeControlOver (Lifeform l) {
		getControlledLifeforms().add(l);
		l.setControlled(true);
	}

	/** checks whether the player is in control of at least one lifeform */
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

	public void takeover(int who, int whom) {
		if (controlledLifeforms.get(who).takeover(controlledLifeforms.get(who).getNeighbors().get(whom)))
			controlledLifeforms.add(controlledLifeforms.get(who).getNeighbors().get(whom));
	}

	public void ingest(int who, int whom) {
		if (controlledLifeforms.get(who).getNeighbors().size() > whom) {
			sim.getNpcLifeforms().remove(controlledLifeforms.get(who).getNeighbors().get(whom));
			controlledLifeforms.get(who).setBiomass(controlledLifeforms.get(who).getBiomass() + controlledLifeforms.get(who).getNeighbors().get(whom).getBiomass());
		}
	}
}
