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

	/** simulator backbone that simulates all the nonplayer interactions */
	static MainSimulator sim;
	

	public static void main (String[] args) {

		loadImagesIntoMap();
		
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

	/** initializes the hashmap with the images */
	private static void loadImagesIntoMap () {
		/* load the gfx directory */
		File gfxDirectory = new File(ClassLoader.getSystemResource("projectubernahme/gfx").getFile());

		/* if this worked quite well ... */
		if (gfxDirectory != null) {
			/* get all the files within the gfx directory */
			File[] files = gfxDirectory.listFiles();

			/* some debug info, can be omitted later on */
			System.out.println("Absolute Path of gfxDir: "+gfxDirectory.getAbsolutePath());
			System.out.println("does the dir exist? "+gfxDirectory.exists());
			System.out.println("is it a directory? "+gfxDirectory.isDirectory());
			System.out.println("Files inside it: "+gfxDirectory.listFiles());
			
			if (files != null) {
				for (File file : files) {

					/* get all the files which hopefully are pictures */
					if (file.getName().endsWith(".png")) {
						System.out.println("Loading file: "+file.getName());
						try {
							InputStream is = ClassLoader.getSystemResourceAsStream("projectubernahme/gfx/"+file.getName());
							/* place the picture in the hashmap */
							if (is != null) {
								images.put(file.getName().replace(".png", ""), ImageIO.read(is));
							}
							else {
								System.out.println("is is null");
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			else {
				System.out.println(Localizer.get("ERROR: Could not access the files within the gfx-directory somehow. Sorry, quitting now"));
				System.exit(1);
			}

		}
		else {
			System.out.println(Localizer.get("ERROR: Could not access the gfx-directory somehow. Sorry, quitting now"));
			System.exit(1);
		}
	}
}
