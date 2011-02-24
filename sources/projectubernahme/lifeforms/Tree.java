// Copyright (c) 2011 Martin Ueding <dev@martin-ueding.de>

package projectubernahme.lifeforms;

import java.awt.geom.Point2D;

import projectubernahme.Localizer;
import projectubernahme.ProjectUbernahme;
import projectubernahme.gfx.ConvertedGraphics;
import projectubernahme.gfx.LifeformTreeGraphics;
import projectubernahme.simulator.MainSimulator;

public class Tree extends Lifeform {
	private static ConvertedGraphics cg = new LifeformTreeGraphics();
	
	private double growthFactor = 0.01;

	public Tree (MainSimulator sim) {
		super(sim);
		setCanFly(false);
		setCanSee(false);
		setCanMove(false);
		setBiomass(500+Math.random()*500);

		setPosition(new Point2D.Double(Math.random()-0.5, Math.random()-0.5));
		
		setViewAngle(2*Math.PI*Math.random());
		setIntelligence(0.1);
	}

	public Tree(MainSimulator sim, Point2D p) {
		this(sim);
		setPosition(p);
	}

	@Override
	public void act(int sleepTime) {
		double t = sleepTime/1000.0;
		setBiomass(Math.min(getBiomass() + getBiomass()*(Math.exp(growthFactor*t)-1), Integer.parseInt(ProjectUbernahme.getConfigValue("maxTreeMass"))));
	}

	@Override
	public boolean canSee(Lifeform l) {
		return false;
	}

	@Override
	public ConvertedGraphics getConvertedGraphics() {
		return cg;
	}

	@Override
	public String getI18nClassName() {
		return Localizer.get("Tree");
	}
}
