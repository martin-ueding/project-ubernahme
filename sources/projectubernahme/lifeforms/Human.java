package projectubernahme.lifeforms;

import projectubernahme.gfx.ConvertedGraphics;
import projectubernahme.gfx.HumanGraphics;
import projectubernahme.simulator.MainSimulator;

public class Human extends Lifeform {
	

	private static ConvertedGraphics cg = new HumanGraphics();

	public Human (MainSimulator sim) {
		super(sim);
		setCanFly(false);
		setCanSee(true);
		canMove = true;
		setBiomass(60.0 + Math.random()*60);
	}

	public Human(MainSimulator sim, double d, double e) {
		this(sim);
		x = d;
		y = e;
	}

	public boolean canSee (Lifeform l) {
		return (isCanSee() && distance(l) < 10);			
	}

	@Override
	public void act(int sleepTime) {		
	}

	@Override
	public ConvertedGraphics getConvertedGraphics() {
		// TODO Auto-generated method stub
		return cg;
	}

	
}
