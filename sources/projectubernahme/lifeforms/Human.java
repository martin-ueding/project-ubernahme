package projectubernahme.lifeforms;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import projectubernahme.Localizer;
import projectubernahme.ProjectUbernahme;
import projectubernahme.Vector2D;
import projectubernahme.gfx.ConvertedGraphics;
import projectubernahme.gfx.LifeformHumanGraphics;
import projectubernahme.simulator.MainSimulator;

public class Human extends Lifeform {
	
	static ArrayList<String> names;
	

	private static ConvertedGraphics cg = new LifeformHumanGraphics();
	
	Point2D waypoint, lastWaypoint;

	public Human (MainSimulator sim) {
		super(sim);
		if (names == null) {
			loadNames();
		}
		setName(names.get((int)(Math.random()*names.size())));
		setCanFly(false);
		setCanSee(true);
		setCanMove(true);
		setRangeOfSight(10);
		setBiomass(60.0 + Math.random()*60);
		setIntelligence(0.3+0.3*Math.random());
	}

	private static void loadNames() {
		InputStream is = ClassLoader.getSystemResourceAsStream("projectubernahme/lifeforms/first_names.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		names = new ArrayList<String>();
		String input;
		try {
			while ((input = br.readLine()) != null)
			names.add(input);
		} catch (IOException e) {
			ProjectUbernahme.log(Localizer.get("ERROR")+": "+Localizer.get("could not open file with list of first names"));
			e.printStackTrace();
		}
	}

	public Human(MainSimulator sim, Point2D p) {
		this(sim);
		position = p;
	}

	@Override
	public void act(int sleepTime) {
		if (!inControlledMode) {
			/* check whether there is somebody around that this lifeform does
			 * not really trust
			 */
			boolean strangeGuyAround = false;
			for (SuspicionCase sc : suspicionCases) {
				if (sc.l.getPoint2D().distance(getPoint2D()) < 5*sc.strengh) {
					/* run away */
					viewAngle = Math.atan2(this.getPoint2D().getY()-sc.l.getPoint2D().getY(), this.getPoint2D().getX()-sc.l.getPoint2D().getX());
					setVelocity(new Vector2D(0.8*Math.cos(viewAngle), 0.8*Math.sin(viewAngle)));
					strangeGuyAround = true;
				}
			}
			
			
			if (reachedWaypoint()) {
				generateNewWaypoint();
			}
			
			if (!strangeGuyAround) {
				viewAngle = Math.atan2(-this.getPoint2D().getY()+waypoint.getY(), -this.getPoint2D().getX()+waypoint.getX());
				setVelocity(new Vector2D(0.8*Math.cos(viewAngle), 0.8*Math.sin(viewAngle)));
			}
		}
		
		/* drop suspicion rates slowly */
		for (SuspicionCase sc : suspicionCases) {
			sc.strengh = Math.max(0.0, sc.strengh-sleepTime/1000.0*0.01);
		}
	}

	private void generateNewWaypoint() {
		Point2D lastLastWaypoint = lastWaypoint;
		lastWaypoint = waypoint;
		
		int trials = 0;
		do {
			waypoint = sim.getEnv().generateNewWaypoint(getPoint2D());
			trials++;
		} while (lastLastWaypoint != null && trials <= 3 && waypoint.equals(lastLastWaypoint));
		
		viewAngle = Math.atan2(-this.getPoint2D().getY()+waypoint.getY(), -this.getPoint2D().getX()+waypoint.getX());
		setVelocity(new Vector2D(0.8*Math.cos(viewAngle), 0.8*Math.sin(viewAngle)));
	}

	private boolean reachedWaypoint() {
		return waypoint == null || this.getPoint2D().distance(waypoint) < 0.25;
	}

	@Override
	public ConvertedGraphics getConvertedGraphics() {
		return cg;
	}

	@Override
	public String getI18nClassName() {
		return Localizer.get("Human");
	}
}
