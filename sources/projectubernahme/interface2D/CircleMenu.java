package projectubernahme.interface2D;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.util.LinkedList;

import projectubernahme.Localizer;
import projectubernahme.MessageTypes;
import projectubernahme.ProjectUbernahme;
import projectubernahme.lifeforms.Lifeform;

public class CircleMenu implements MouseListener, MouseMotionListener {
	Lifeform l;
	View2D view;
	Point2D location;
	boolean display;
	
	public static final double RADIUS = 100;
	
	LinkedList<CircleMenuItem> menuitems;
	
	public CircleMenu (View2D view, Lifeform l) {
		this.view = view;
		this.l = l;
		this.location = l.getPoint2D();
		view.addMouseListener(this);
		view.addMouseMotionListener(this);
		
		menuitems = new LinkedList<CircleMenuItem>();
		
		/* add the options to the menu that are allowed */
		CircleMenuItem item;
		
		item = new CircleMenuItemRename(l);
		item.angle = 0.0;
		item.text = "rename";
		menuitems.add(item);
		
		display = true;
	}
	
	public void draw (Graphics2D g) {
		if (display) {
			Point2D center = view.transform.transform(location, null);
			for (CircleMenuItem item : menuitems) {
				item.draw(g, center);
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
		for (CircleMenuItem item : menuitems) {
			item.mouseClicked(e);
		}
		
		destroy();
	}
	
	private void destroy () {
		display = false;
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

	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent arg0) {
		/* go through all the menu items and check whether they are hovered above */
		for (CircleMenuItem item : menuitems) {
			item.mouseMoved(arg0);
		}
		
	}
	
}

class CircleMenuItem {
	double angle;
	String text;
	Lifeform l;
	
	boolean hover;
	
	Point2D center;
	
	private static final int DIAMETER = 70;
	
	public CircleMenuItem(Lifeform l) {
		this.l = l;
	}

	public boolean mouseClicked(MouseEvent e) {
		if (isMouseIn(e.getPoint())) {
			action();
			return true;
		}
		return false;
	}

	void action() {
		ProjectUbernahme.log(Localizer.get("This menu item was clicked."), MessageTypes.INFO);
	}

	public void mouseMoved(MouseEvent arg0) {
		hover = isMouseIn(arg0.getPoint());
	}
	
	private boolean isMouseIn(Point arg0) {
		return (center != null && Math.hypot(
				(center.getX() + Math.cos(angle)*CircleMenu.RADIUS) - arg0.getX(),
				(center.getY() + Math.sin(angle)*CircleMenu.RADIUS) - arg0.getY()
			) < DIAMETER/2);
	}

	public void draw(Graphics2D g, Point2D center) {
		this.center = center;
		if (hover) {
			g.setColor(new Color(200, 200, 200, 200));
		}
		else {
			g.setColor(new Color(100, 100, 100, 200));
		}
		g.fillOval((int)(center.getX() + Math.cos(angle)*CircleMenu.RADIUS -DIAMETER/2), (int)(center.getY() + Math.sin(angle)*CircleMenu.RADIUS -DIAMETER/2), DIAMETER, DIAMETER);
		g.setColor(Color.ORANGE);
		g.drawString(text, (int)(center.getX() + Math.cos(angle)*CircleMenu.RADIUS -DIAMETER/2), (int)(center.getY() + Math.sin(angle)*CircleMenu.RADIUS));
	}
}

class CircleMenuItemRename extends CircleMenuItem {
	public CircleMenuItemRename(Lifeform l) {
		super(l);
	}

	void action () {
		l.rename();
	}
}