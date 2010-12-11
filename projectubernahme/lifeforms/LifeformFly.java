package projectubernahme.lifeforms;

import projectubernahme.simulator.MainSimulator;

/** lifeform, a simple fly which can look around and fly a little */
public class LifeformFly extends Lifeform {

	public LifeformFly (MainSimulator sim) {
		super(sim);
		setCanFly(true);
		setCanSee(true);
		canMove = true;
		setBiomass(0.001/17);
		
		x = Math.random()-0.5;
		y = Math.random()-0.5;
	}

	public boolean canSee (Lifeform l) {
		return (isCanSee() && distance(l) < 10);
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}


}
