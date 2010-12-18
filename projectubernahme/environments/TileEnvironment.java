package projectubernahme.environments;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CopyOnWriteArrayList;

import projectubernahme.ProjectUbernahme;
import projectubernahme.lifeforms.Human;
import projectubernahme.lifeforms.Lifeform;
import projectubernahme.lifeforms.Tree;
import projectubernahme.lifeforms.Zombie;
import projectubernahme.simulator.MainSimulator;

/** an environment made up from tiles
  The tile environment is parsed from a text file filled with characters in a rectangular way. Every character stands for something on the map, these keys can be found in the guide file in the same folder this class is in. */
public class TileEnvironment implements Environment {

	/** the loaded tiles */
	private char[][] tiles;
	private BufferedImage bg;

	private int tileWidth = 100;

	/** width of the tiles in meters of the game coordinates */
	private double tileWidthInReal = 0.25;
	
	private Point2D origin = new Point2D.Double(0.0, 0.0);

	/** a copy of the previous transform to compare to the new one
	  This saves a new rendering if the transform stayed all the same, making the game more fluent when not zooming or panning around. */
	private AffineTransform previousTransform;

	public TileEnvironment (String mapname) {

		/* load the map from the text file */
		ClassLoader cl = getClass().getClassLoader();

		try {
			InputStream fis = cl.getResourceAsStream("projectubernahme/environments/tilemap_"+mapname+".txt");

			byte[] text = new byte[fis.available()];

			fis.read(text);

			/* count rows and columns */
			int columns = 0, rows = 0;
			boolean erste = true;

			for (int i = 0; i < text.length; i++) {
				if (erste)
					if (text[i] != '\n' && text[i] != '\r')
						columns++;

				if (text[i] == '\n' || text[i] == '\r') {
					rows++;
					erste = false;
				}
			}

			/* creates the needed array for the tiles */
			tiles = new char[columns][rows];

			/* loads the tiles into the array */
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					tiles[j][i] = (char)text[i*(columns+1)+j];
				}
			}

			fis.close();
		} catch (IOException e1) {
			System.out.println("Error while reading file");
			System.exit(1);
		}
	}

	public boolean isFreeBetween(double x1, double y1, double z1, double x2, double y2, double z2) {
		return true;
	}

	public BufferedImage getBackground() {
		return bg;
	}

	/** returns the background and renders it new, if needed */
	public BufferedImage getBackground (int width, int height, AffineTransform transform) {
		/* do not repaint if the transform has not changed at all */
		if (transform.equals(previousTransform)) {
		}
		else {
			double twiceScreenRadius = Math.hypot(width, height);
			tileWidth = (int)(Math.sqrt(transform.getDeterminant())*tileWidthInReal);
			int w = 1;
			while (tileWidth > w)
				w *= 4;
			tileWidth = w;
			
			tileWidth = Math.min(256, tileWidth);

			

			/* if the tiles are really narrow, some of them might be omitted in the drawing process
			   This tries to figure out a number of how many tiles can be skipped. */
			int increment = 1;
			
			while (15.0/tileWidth > increment) {
				increment++;
			}
			
			/* create a new background image and pull the graphics to draw on it */
			bg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = (Graphics2D) bg.getGraphics();

			/* iterate through the tiles ... */
			for (int i = 0; i < tiles[0].length; i += increment) {
				for (int j = 0; j < tiles.length; j += increment) {
					/* create a new transform for each of the tiles */
					AffineTransform tileTransform = new AffineTransform();
					tileTransform.translate(j*tileWidthInReal, i*tileWidthInReal);
					tileTransform.scale(1.0/tileWidth*tileWidthInReal, 1.0/tileWidth*tileWidthInReal);

					/* also add the (physical) player's transform to generate the picture that he wants to have */
					tileTransform.preConcatenate(transform);

					/* draw only the visible items onto the background */
					Point2D target = tileTransform.transform(origin, null);
					if (target.distance(width/2, height/2) < twiceScreenRadius) {
						/* figure out which tile image is the right one */
						BufferedImage imageToDraw = null;
						imageToDraw = ProjectUbernahme.getImage("tile_"+tiles[j][i], tileWidth*increment);
						if (imageToDraw == null) {
							imageToDraw = ProjectUbernahme.getImage("tile_default", tileWidth*increment);
						}

						/* quit here if not even the default image could be found */
						if (imageToDraw == null) {
							System.out.println("Konnte keine Bilder finden");
							System.exit(1);
						}
						g.drawImage(imageToDraw, tileTransform, null);
					}
				}
			}
			/* clone the current player's transform to compare it in the next iteration of this method */
			previousTransform = (AffineTransform) transform.clone();

		}
		return bg;
	}

	/** iterate through the tiles and spawn some lifeforms where they belong */
	public void initializeNPCs(CopyOnWriteArrayList<Lifeform> list, MainSimulator sim) {
		for (int i = 0; i < tiles[0].length; i++) {
			for (int j = 0; j < tiles.length; j++) {
				if (Math.random() > 0.95) {
					switch (tiles[j][i]) {
					case 'S': list.add(Math.random() < 0.99 ? new Human(sim, (j+0.5)*tileWidthInReal, (i+0.5)*tileWidthInReal) : new Zombie(sim, (j+0.5)*tileWidthInReal, (i+0.5)*tileWidthInReal)); break;
					case 'L': list.add(new Tree(sim, (j+0.5)*tileWidthInReal, (i+0.5)*tileWidthInReal)); break;
					}
				}
			}
		}
	}
}

