package projectubernahme.environments;

import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Cube extends Environment {

	private ArrayList<Line2D> lines2d;
	
	public Cube () {
		lines2d = new ArrayList<Line2D>();
		
		lines2d.add(new Line2D.Double(-1, 1, 1, 1));
		lines2d.add(new Line2D.Double(-1, -1, 1, -1));
		lines2d.add(new Line2D.Double(-1, 1, -1, -1));
		lines2d.add(new Line2D.Double(1, 1, 1, -1));
	}

	@Override
	public boolean isFreeBetween(double x1, double y1, double z1, double x2, double y2, double z2) {
		boolean isFree = true;
		for (Line2D line : lines2d) {
			if (line.intersectsLine(x1, y1, x2, y2)) {
				isFree = false;
			}
		}
		return isFree;
	}

	@Override
	public ArrayList<Line2D> get2DWalls() {
		return lines2d;
	}

}
