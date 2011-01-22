package projectubernahme.lifeforms;

import java.awt.geom.Point2D;

import projectubernahme.gfx.ConvertedGraphics;
import projectubernahme.gfx.LifeformZombieGraphics;
import projectubernahme.simulator.MainSimulator;

public class Zombie extends Lifeform {

	private static ConvertedGraphics cg = new LifeformZombieGraphics();

	public Zombie(MainSimulator sim) {
		super(sim);
		setCanFly(false);
		setCanSee(true);
		setCanMove(true);
		setBiomass(60.0 + Math.random()*60);
		setIntelligence(0.0);
	}

	public Zombie(MainSimulator sim, Point2D p) {
		this(sim);
		position = p;
	}

	@Override
	public void act(int sleepTime) {
		if (!isControlled()) {
			/* find the closest human to this zombie */
			Lifeform closest = null;
			double minDistance = Double.MAX_VALUE;

			for(Lifeform n : getNeighbors()) {
				if (n.getClass().getName().endsWith("Human")) {
					double distance = distance(n);
					if (distance < minDistance) {
						minDistance = distance;
						closest = n;
					}
				}
			}
			
			/* if there is no human to ingest, eat another, smaller zombie
			 * instead, that way, zombies do not start piling up on a spot but
			 * become huge */
			if (closest == null) {
				for(Lifeform n : getNeighbors()) {
					if (n.getClass().getName().endsWith("Zombie")) {
						double distance = distance(n);
						if (distance < minDistance && n.getBiomass() < getBiomass()) {
							minDistance = distance;
							closest = n;
						}
					}
				}
			}

			/* if there is a victim ... */
			if (closest != null) {
				if (!busy) {
					ingest(closest);
				}
			}
		}
	}

	@Override
	public boolean canSee(Lifeform l) {
		return distance(l) < 5.0;
	}

	@Override
	public ConvertedGraphics getConvertedGraphics() {
		return cg;
	}
}
