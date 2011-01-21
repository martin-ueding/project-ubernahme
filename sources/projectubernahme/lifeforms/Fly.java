package projectubernahme.lifeforms;

import java.awt.geom.Point2D;

import projectubernahme.gfx.ConvertedGraphics;
import projectubernahme.gfx.LifeformFlyGraphics;
import projectubernahme.simulator.MainSimulator;

/** lifeform, a simple fly which can look around and fly a little */
public class Fly extends Lifeform {
	
	private static ConvertedGraphics cg = new LifeformFlyGraphics();

	public Fly (MainSimulator sim) {
		super(sim);
		setCanFly(true);
		setCanSee(true);
		setCanMove(true);
		setBiomass(0.001/17);
		setIntelligence(0.1);
		
		position = new Point2D.Double(Math.random()-0.5, Math.random()-0.5);
	}

	public Fly(Point2D randomPointOnMap, MainSimulator sim) {
		this(sim);
		position = randomPointOnMap;
	}

	public boolean canSee (Lifeform l) {
		return (isCanSee() && distance(l) < 200);
	}

	@Override
	public void act(int sleepTime) {
		
	}

	@Override
	public ConvertedGraphics getConvertedGraphics() {
		return cg;
	}
}
