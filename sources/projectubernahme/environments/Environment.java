package projectubernahme.environments;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.concurrent.CopyOnWriteArrayList;

import projectubernahme.lifeforms.Lifeform;
import projectubernahme.simulator.MainSimulator;

/** this sets the methods that the simulator and lifeforms should have to interact with the environment
  Since the tile map is probably going to be the only way of building a map for this game, this interface might be omitted.
  When the game should be ported to a three dimensional version, this might be useful to implement some three dimensional world where the artifical intelligence of the lifeforms does not need to be changed a bit, just the methods of this interface need to be reimplemented. */
abstract public interface Environment {
	
	/** whether there is no obstruction between two given points */
	public boolean isFreeBetween (double x1, double y1, double z1, double x2, double y2, double z2);
	
	/** gets a background image
	  Not really useful anymore */
	public BufferedImage getBackground ();

	/** generates a background image tailored to the viewport */
	public BufferedImage getBackground(int width, int height, AffineTransform transform);
	
	/** generates the NPCs on the map
	  Every map has different starting settings, so this is the map's chance to set up the initial bunch of lifeforms */
	public void initializeNPCs (CopyOnWriteArrayList<Lifeform> list, MainSimulator sim);

	public Point2D getRandomPointOnMap();
}
