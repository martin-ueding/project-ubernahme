package projectubernahme.lifeforms;

import projectubernahme.gfx.ConvertedGraphics;
import projectubernahme.gfx.FlyGraphics;
import projectubernahme.simulator.MainSimulator;

/** lifeform, a simple fly which can look around and fly a little */
public class Fly extends Lifeform {
	
	private static ConvertedGraphics cg = new FlyGraphics();

	public Fly (MainSimulator sim) {
		super(sim);
		setCanFly(true);
		setCanSee(true);
		canMove = true;
		setBiomass(0.001/17);
		
		x = Math.random()-0.5;
		y = Math.random()-0.5;
		
		
	}

	public boolean canSee (Lifeform l) {
		return (isCanSee() && distance(l) < 2);
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
