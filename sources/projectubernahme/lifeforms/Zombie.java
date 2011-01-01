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
		setIntelligence(30);
	}

	public Zombie(MainSimulator sim, Point2D p) {
		this(sim);
		position = p;
	}

	@Override
	public void act(int sleepTime) {
		if (!isControlled()) {
			/* find the closest human to this zombie */
			Human closest = null;
			double minDistance = Double.MAX_VALUE;

			for(Lifeform n : getNeighbors()) {
				if (n.getClass().getName().endsWith("Human")) {
					double distance = distance(n);
					if (distance < minDistance) {
						minDistance = distance;
						closest = (Human) n;
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
