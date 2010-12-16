package projectubernahme.environments;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

abstract public interface Environment {
	
	public boolean isFreeBetween (double x1, double y1, double z1, double x2, double y2, double z2);
	
	public BufferedImage getBackground ();

	public BufferedImage getBackground(int width, int height, AffineTransform transform);

}
