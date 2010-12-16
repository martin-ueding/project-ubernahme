package projectubernahme.environments;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Cube implements Environment {

	private ArrayList<Line2D> lines2d;
	
	BufferedImage bg;
	
	public Cube () {
		lines2d = new ArrayList<Line2D>();
		
		lines2d.add(new Line2D.Double(-1, 1, 1, 1));
		lines2d.add(new Line2D.Double(-1, -1, 1, -1));
		lines2d.add(new Line2D.Double(-1, 1, -1, -1));
		lines2d.add(new Line2D.Double(1, 1, 1, -1));
		
		bg = new BufferedImage(2, 2, BufferedImage.TYPE_INT_ARGB);
		
		Graphics g = bg.getGraphics();
		
		for (Line2D line : lines2d) {
			g.drawLine((int)line.getX1(), (int)line.getY1(), (int)line.getX2(), (int)line.getY2());
		}
	}

	public boolean isFreeBetween(double x1, double y1, double z1, double x2, double y2, double z2) {
		boolean isFree = true;
		for (Line2D line : lines2d) {
			if (line.intersectsLine(x1, y1, x2, y2)) {
				isFree = false;
			}
		}
		return isFree;
	}

	public ArrayList<Line2D> get2DWalls() {
		return lines2d;
	}

	public BufferedImage getBackground() {
		// TODO Auto-generated method stub
		return null;
	}

	public BufferedImage getBackground(int width, int height,
			AffineTransform transform) {
		// TODO Auto-generated method stub
		return null;
	}

}
