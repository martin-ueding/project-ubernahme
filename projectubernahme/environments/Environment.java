package projectubernahme.environments;

import java.awt.geom.Line2D;
import java.util.ArrayList;

abstract public interface Environment {
	
	public boolean isFreeBetween (double x1, double y1, double z1, double x2, double y2, double z2);
	
	public ArrayList<Line2D> get2DWalls ();

}
