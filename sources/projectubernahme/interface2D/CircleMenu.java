package projectubernahme.interface2D;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;

import projectubernahme.lifeforms.Lifeform;

public class CircleMenu implements MouseListener {
	Lifeform l;
	View2D view;
	Point2D location;
	
	public CircleMenu (View2D view, Lifeform l) {
		this.view = view;
		this.l = l;
		this.location = l.getPoint2D();
		view.addMouseListener(this);
	}
	
	public void draw (Graphics2D g) {
		Point2D center = view.transform.transform(location, null);
		g.drawString("Hello, World. I am the menu!", (int)center.getX(), (int)center.getY());
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
