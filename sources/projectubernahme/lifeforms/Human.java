package projectubernahme.lifeforms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import projectubernahme.gfx.ConvertedGraphics;
import projectubernahme.gfx.LifeformHumanGraphics;
import projectubernahme.simulator.MainSimulator;

public class Human extends Lifeform {
	
	static ArrayList<String> names;
	

	private static ConvertedGraphics cg = new LifeformHumanGraphics();

	public Human (MainSimulator sim) {
		super(sim);
		if (names == null) {
			loadNames();
		}
		setName(names.get((int)(Math.random()*names.size())));
		setCanFly(false);
		setCanSee(true);
		canMove = true;
		setBiomass(60.0 + Math.random()*60);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
