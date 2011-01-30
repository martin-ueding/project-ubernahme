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
import projectubernahme.Player;
import projectubernahme.ProjectUbernahme;
import projectubernahme.lifeforms.Lifeform;

public class CircleMenu implements MouseListener, MouseMotionListener {
	private Lifeform l;
	private View2D view;
	private Point2D location;
	boolean display;
	private Player player;

	public static double MAX_RADIUS = 100;
	public double radiusPart = 0;
	public double anglePart = 0.0;

	private LinkedList<CircleMenuItem> menuitems;
	private Thread thread; 

	public CircleMenu (View2D view, Lifeform l, Player player) {
		this.view = view;
		this.l = l;
		this.location = l.getPoint2D();
		view.addMouseListener(this);
		view.addMouseMotionListener(this);

		menuitems = new LinkedList<CircleMenuItem>();


		/* add the options to the menu that are allowed */
		CircleMenuItem item;

		item = new CircleMenuItemRename(this, l);
		item.angle = 0.0*Math.PI;
		item.text = Localizer.get("rename");
		item.p = player;
		menuitems.add(item);

		if (player.getSelectedLifeform().canIngest(l)) {
			item = new CircleMenuItemIngest(this, l);
			item.angle = 0.25*Math.PI;
			item.text = Localizer.get("ingest");
			item.p = player;
			menuitems.add(item);
		}

		if (player.getSelectedLifeform().canTakeover(l)) {
			item = new CircleMenuItemTakeover(this, l);
			item.angle = 0.5*Math.PI;
			item.text = Localizer.get("take over");
			item.p = player;
			menuitems.add(item);
		}

		if (l.controllingPlayer == player) {
			item = new CircleMenuItemPassive(this, l);
			item.angle = 0.75*Math.PI;
			item.text = l.inControlledMode ? Localizer.get("enable auto AI") : Localizer.get("disable auto AI");
			item.p = player;
			menuitems.add(item);
		}

		display = true;


		thread = new CircleMenuUnfoldThread(this);
		thread.start();
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
		if (display) {
			for (CircleMenuItem item : menuitems) {
				item.mouseClicked(e);
			}
		}

		destroy();
	}

	private void destroy () {
		thread = new CircleMenuFoldThread(this);
		thread.start();
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
		if (display) {
			/* go through all the menu items and check whether they are hovered above */
			for (CircleMenuItem item : menuitems) {
				item.mouseMoved(arg0);
			}
		}
	}

}

class CircleMenuItem {
	double angle;
	String text;
	Lifeform l;
	Player p;
	CircleMenu parent;

	boolean hover;

	Point2D center;

	private static final int DIAMETER = 70;

	public CircleMenuItem(CircleMenu circleMenu, Lifeform l) {
		this.l = l;
		this.parent = circleMenu;
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
				(center.getX() + Math.cos(angle)*parent.radiusPart*CircleMenu.MAX_RADIUS) - arg0.getX(),
				(center.getY() + Math.sin(angle)*parent.radiusPart*CircleMenu.MAX_RADIUS) - arg0.getY()
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
		g.fillOval((int)(center.getX() + Math.cos(parent.anglePart*angle)*parent.radiusPart*CircleMenu.MAX_RADIUS -DIAMETER*parent.radiusPart/2), (int)(center.getY() + Math.sin(parent.anglePart*angle)*parent.radiusPart*CircleMenu.MAX_RADIUS -DIAMETER*parent.radiusPart/2), (int)(DIAMETER*parent.radiusPart), (int)(DIAMETER*parent.radiusPart));

		/* if the radius is complete, draw string (or later image) */
		if (parent.radiusPart == 1.0) {
			g.setColor(Color.ORANGE);
			g.drawString(text, (int)(center.getX() + Math.cos(parent.anglePart*angle)*parent.radiusPart*CircleMenu.MAX_RADIUS -DIAMETER/2), (int)(center.getY() + Math.sin(parent.anglePart*angle)*parent.radiusPart*CircleMenu.MAX_RADIUS));
		}
	}
}

class CircleMenuItemRename extends CircleMenuItem {
	public CircleMenuItemRename(CircleMenu parent, Lifeform l) {
		super(parent, l);
	}

	void action () {
		l.rename();
	}
}

class CircleMenuItemIngest extends CircleMenuItem {
	public CircleMenuItemIngest(CircleMenu parent, Lifeform l) {
		super(parent, l);
	}

	void action () {
		p.getSelectedLifeform().ingest(l);
	}
}

class CircleMenuItemTakeover extends CircleMenuItem {
	public CircleMenuItemTakeover(CircleMenu parent, Lifeform l) {
		super(parent, l);
	}

	void action () {
		p.getSelectedLifeform().takeover(l);
	}
}

class CircleMenuItemPassive extends CircleMenuItem {
	public CircleMenuItemPassive(CircleMenu parent, Lifeform l) {
		super(parent, l);
	}

	void action () {
		l.inControlledMode = !l.inControlledMode;
	}
}

class CircleMenuUnfoldThread extends Thread {
	CircleMenu parent;

	public CircleMenuUnfoldThread (CircleMenu parent) {
		this.parent = parent;
	}

	public void run() {
		try {
			while (parent.radiusPart < 1.0) {
				parent.radiusPart = Math.min(parent.radiusPart + .3, 1.0);
				sleep(50);
			}

			while (parent.anglePart < 1.0) {
				parent.anglePart = Math.min(parent.anglePart + .3, 1.0);
				sleep(50);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class CircleMenuFoldThread extends Thread {
	CircleMenu parent;

	public CircleMenuFoldThread (CircleMenu parent) {
		this.parent = parent;
	}

	public void run() {
		try {
			while (parent.anglePart > 0.0) {
				parent.anglePart = Math.max(parent.anglePart - .3, 0);
				sleep(50);
			}

			while (parent.radiusPart > 0.0) {
				parent.radiusPart = Math.max(parent.radiusPart - .3, 0);
				sleep(50);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		parent.display = false;
	}
}