package projectubernahme;

import java.awt.geom.Point2D;

public class Vector2D {
	private double x, y;

	public Vector2D (double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void addToThis (Vector2D v) {
		x += v.x;
		y += v.y;
	}

	public Vector2D add (Vector2D v) {
		return new Vector2D(x+v.x, y+v.y);
	}

	public Point2D add (Point2D v) {
		return new Point2D.Double(x+v.getX(), y+v.getY());
	}

	public Vector2D multiply (double d) {
		return new Vector2D(x*d, y*d);
	}

	public void lowpassThis(double max) {
		double abs = Math.hypot(x, y);
		if (abs > max) {
			double tooBigBy = Math.sqrt(max/abs);
			x *= tooBigBy;
			y *= tooBigBy;
		}
	}

	public void highpassThis(double min) {
		double abs = Math.hypot(x, y);
		if (abs < min) {
			double tooSmallBy = Math.sqrt(min/abs);
			x /= tooSmallBy;
			y /= tooSmallBy;
		}
	}

}
