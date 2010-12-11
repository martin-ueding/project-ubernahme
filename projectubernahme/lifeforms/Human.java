package projectubernahme.lifeforms;

import projectubernahme.simulator.MainSimulator;

public class Human extends Lifeform {

	public Human (MainSimulator sim) {
		super(sim);
		setCanFly(false);
		setCanSee(true);
		canMove = true;
		setBiomass(60.0 + Math.random()*60);
		

		vx = Math.random()-0.5;
		vy = Math.random()-0.5;
	}

	public boolean canSee (Lifeform l) {
		return (isCanSee() && distance(l) < 10);			
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}

	
}
