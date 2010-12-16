package projectubernahme;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.imageio.ImageIO;

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
	static MainSimulator sim;
	

	public static void main (String[] args) {

		loadImagesIntoMap();
		
		sim = new MainSimulator();

		player = new Player(sim);
		
		sim.addPlayer(player);
		
		@SuppressWarnings("unused")
		Interface2D interface2d = new Interface2D(sim, player);
	}
	
	private static HashMap<String,BufferedImage> images = new HashMap<String,BufferedImage>();

	public static BufferedImage getImage(String name, int resolution) {
		//System.out.println("Query for "+name+resolution);
		
		int res = 1;
		while (resolution > res)
			res *= 2;
		
		res = Math.min(res, 256);

		//System.out.println("Query for "+name+res);
		
		String key = name+res;
		if (images.containsKey(key)) {
			return images.get(key);
		}
		else {
			return null;
		}
	}

	private static void loadImagesIntoMap () {
		File f = new File(ClassLoader.getSystemResource("projectubernahme/gfx/").getFile());

		File[] files = f.listFiles();

		for (File file : files) {

			if (file.getName().endsWith(".png")) {
				System.out.println("Loading file: "+file.getName());
				try {
					InputStream is = ClassLoader.getSystemResourceAsStream("projectubernahme/gfx/"+file.getName());
					if (is != null) {
						images.put(file.getName().replace(".png", ""), ImageIO.read(is));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}



	}
}
