package projectubernahme;

import java.awt.image.BufferedImage;
import java.util.HashMap;

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
	

	public static void main (String[] args) {
		
		sim = new MainSimulator();

		player = new Player(sim);
		
		sim.addPlayer(player);
		
		/* creates a new interface which lets the physical player take control over the player object */
		@SuppressWarnings("unused")
		Interface2D interface2d = new Interface2D(sim, player);
	}
	
	/** stores all the images needed for the game */
	private static HashMap<String,BufferedImage> images = new HashMap<String,BufferedImage>();

	/** gets an image out of the map
	  The graphics used to be very slow due to the fact that high resolution graphics were used even in lower zoom levels. This function tries to return the best sizes image for the current application. */
	public static BufferedImage getImage(String name, int resolution) {
		/* go up with the resolution until it matches at least the needed one */
		int res = 1;
		while (resolution > res)
			res *= 2;
		
		/* there are no images bigger than 256 pixels, so this cuts it off */
		res = Math.min(res, 256);

		/* try to find the picture */
		String key = name+res;
		if (images.containsKey(key)) {
			return images.get(key);
		}
		else {
			return null;
		}
	}
}
