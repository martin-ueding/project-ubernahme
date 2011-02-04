package projectubernahme.lifeforms;

import java.awt.geom.Point2D;

import projectubernahme.gfx.ConvertedGraphics;
import projectubernahme.gfx.LifeformPoliceGraphics;
import projectubernahme.simulator.MainSimulator;

public class Police extends Human {
	

	private static ConvertedGraphics cg = new LifeformPoliceGraphics();
	
	public Police (MainSimulator sim) {
		super(sim);
		setCanFly(false);
		setCanSee(true);
		setCanMove(true);
		setRangeOfSight(15);
		setBiomass(60.0 + Math.random()*60);
		setIntelligence(0.4+0.3*Math.random());
	}
	

	public Police (MainSimulator sim, Point2D p) {
		this(sim);
		setPosition(p);
	}
	
	@Override
	public void act(int sleepTime) {		
		if (!isInControlledMode() && !isBusy()) {
			/* check whether there is somebody around that this lifeform does
			 * not really trust
			 */
			double maxSuspicion = 0.0;
			Lifeform target = null;
			SuspicionCase maxSc = null;
			for (SuspicionCase sc : getSuspicionCases()) {
				if (sc.getL().getPoint2D().distance(getPoint2D()) < 5*sc.getStrengh()) {
					if (sc.getStrengh() > maxSuspicion) {
						maxSuspicion = sc.getStrengh();
						target = sc.getL();
						maxSc = sc;
					}
				}
			}
			
			/* if nobody strange is around, walk on */
			if (target == null) {
				headToWaypoint();
			}
			else {
				ingest(target);
				getSuspicionCases().remove(maxSc);
			}
		}
		
		/* drop suspicion rates slowly */
		for (SuspicionCase sc : getSuspicionCases()) {
			sc.setStrengh(Math.max(0.0, sc.getStrengh()-sleepTime/1000.0*0.005));
		}
	}
	
	@Override
	public ConvertedGraphics getConvertedGraphics() {
		return cg;
	}

}
