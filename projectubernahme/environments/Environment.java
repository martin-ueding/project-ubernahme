package projectubernahme.environments;

import java.awt.geom.Line2D;
import java.util.ArrayList;

abstract public class Environment {
	
	abstract public boolean isFreeBetween (double x1, double y1, double z1, double x2, double y2, double z2);
	
	abstract public ArrayList<Line2D> get2DWalls ();

}
