package projectubernahme;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Properties;

import projectubernahme.interface2D.Interface2D;
import projectubernahme.simulator.MainSimulator;

/*
 * Copyright 2010 Project Ubernahme Team
 * Copyright 2010 Martin Ueding <dev@martin-ueding.de>
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

/** the main game class */
public class ProjectUbernahme {
	/** main player */
	static Player player;

	/** simulator backbone that simulates all the nonplayer interactions */
	static MainSimulator sim;

	private static Properties config;

	public static String getConfigValue (String key) {
		return (String) config.get(key);
	}

	public static void main (String[] args) {
		logMessages = new ArrayList<String>();
		f = new DecimalFormat();
		f.applyPattern("0.##E0");
		
		config = new Properties();
		try {
			config.load(ClassLoader.getSystemResourceAsStream("projectubernahme/config.properties"));
		} catch (IOException e) {
			ProjectUbernahme.log(Localizer.get("ERROR")+": "+Localizer.get("could not open main config file"));
			e.printStackTrace();
		}		
		
		ProjectUbernahme.log(Localizer.get("Welcome to Project Ubernahme"));
		
		sim = new MainSimulator();

		player = new Player(sim);
		
		sim.addPlayer(player);
		
		/* creates a new interface which lets the physical player take control over the player object */
		@SuppressWarnings("unused")
		Interface2D interface2d = new Interface2D(sim, player);
	}
	
	private static ArrayList<String> logMessages;
	
	/* prints out a log message */
	public static void log (String s) {
		//System.out.println(s);
		if (getLogMessages().size() == 0 || !getLogMessages().get(getLogMessages().size()-1).equals(s)) {
			getLogMessages().add(s);
			while (getLogMessages().size() > 5) {
				getLogMessages().remove(0);
			}
		}
	}

	public static ArrayList<String> getLogMessages() {
		return logMessages;
	}
	
	public static DecimalFormat f;
}
