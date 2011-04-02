// Copyright (c) 2011 Martin Ueding <dev@martin-ueding.de>

package projectubernahme.interface2D;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.LinkedList;

import projectubernahme.Localizer;
import projectubernahme.MessageTypes;
import projectubernahme.ProjectUbernahme;
import projectubernahme.gfx.ConvertedGraphics;
import projectubernahme.gfx.MenuAiGreen;
import projectubernahme.gfx.MenuAiRed;
import projectubernahme.gfx.MenuIngest;
import projectubernahme.gfx.MenuRename;
import projectubernahme.gfx.MenuTakeover;
import projectubernahme.lifeforms.Lifeform;
import projectubernahme.player.Player;

public class CircleMenu implements MouseListener, MouseMotionListener {
	private View2D view;
	private Point2D location;
	private boolean display;


	static final int DIAMETER = Integer.parseInt(ProjectUbernahme.getConfigValue("circleMenuItemDiameter"));
	static double MAX_RADIUS = Integer.parseInt(ProjectUbernahme.getConfigValue("circleMenuRadius"));
	private double radiusPart = 0;
	private double anglePart = 0.0;

	private LinkedList<CircleMenuItem> menuitems;
	private Thread thread;

	public CircleMenu (View2D view, Lifeform l, Player player) {
		this.view = view;
		this.location = l.getPoint2D();
		view.addMouseListener(this);
		view.addMouseMotionListener(this);

		menuitems = new LinkedList<CircleMenuItem>();


		/* add the options to the menu that are allowed */
		CircleMenuItem item;

		item = new CircleMenuItemRename(this, l);
		item.angle = 0.0 * Math.PI;
		item.text = Localizer.get("rename");
		item.p = player;
		menuitems.add(item);

		if (player.getSelectedLifeform().canIngest(l)) {
			item = new CircleMenuItemIngest(this, l);
			item.angle = 0.75 * Math.PI;
			item.text = Localizer.get("ingest");
			item.p = player;
			menuitems.add(item);
		}

		if (player.getSelectedLifeform().canTakeover(l)) {
			item = new CircleMenuItemTakeover(this, l);
			item.angle = 1.0 * Math.PI;
			item.text = Localizer.get("take over");
			item.p = player;
			menuitems.add(item);
		}

		if (l.getControllingPlayer() == player) {
			item = new CircleMenuItemPassive(this, l);
			item.angle = 0.25 * Math.PI;
			item.text = l.isInControlledMode() ? Localizer.get("enable auto AI") : Localizer.get("disable auto AI");
			item.p = player;
			menuitems.add(item);
		}

		if (l.getControllingPlayer() == player) {
			item = new CircleMenuItemShockwave(this, l);
			item.angle = 1.75 * Math.PI;
			item.text = Localizer.get("send shockwave");
			item.p = player;
			menuitems.add(item);
		}

		if (l.getControllingPlayer() == player) {
			item = new CircleMenuItemSplit(this, l);
			item.angle = 1.5 * Math.PI;
			item.text = Localizer.get("split");
			item.p = player;
			menuitems.add(item);
		}

		setDisplay(true);


		thread = new CircleMenuUnfoldThread(this);
		thread.start();
	}

	void draw (Graphics2D g) {
		if (isDisplay()) {
			Point2D center = view.getTransform().transform(location, null);
			for (CircleMenuItem item : menuitems) {
				item.draw(g, center);
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
		if (isDisplay()) {
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

	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseDragged(MouseEvent arg0) {}

	public void mouseMoved(MouseEvent arg0) {
		if (isDisplay()) {
			/* go through all the menu items and check whether they are hovered above */
			for (CircleMenuItem item : menuitems) {
				item.mouseMoved(arg0);
			}
		}
	}

	void setAnglePart(double anglePart) {
		this.anglePart = anglePart;
	}

	double getAnglePart() {
		return anglePart;
	}

	void setDisplay(boolean display) {
		this.display = display;
	}

	boolean isDisplay() {
		return display;
	}

	void setRadiusPart(double radiusPart) {
		this.radiusPart = radiusPart;
	}

	double getRadiusPart() {
		return radiusPart;
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
		            (center.getX() + Math.cos(angle) * parent.getRadiusPart() * CircleMenu.MAX_RADIUS) - arg0.getX(),
		            (center.getY() + Math.sin(angle) * parent.getRadiusPart() * CircleMenu.MAX_RADIUS) - arg0.getY()
		        ) < CircleMenu.DIAMETER / 2);
	}

	public void draw(Graphics2D g, Point2D center) {
		this.center = center;
		if (hover) {
			g.setColor(new Color(100, 100, 100, 200));
		}
		else {
			g.setColor(new Color(50, 50, 50, 200));
		}
		g.fillOval((int)(center.getX() + Math.cos(parent.getAnglePart() * angle) * parent.getRadiusPart() * CircleMenu.MAX_RADIUS - CircleMenu.DIAMETER * parent.getRadiusPart() / 2), (int)(center.getY() + Math.sin(parent.getAnglePart() * angle) * parent.getRadiusPart() * CircleMenu.MAX_RADIUS - CircleMenu.DIAMETER * parent.getRadiusPart() / 2), (int)(CircleMenu.DIAMETER * parent.getRadiusPart()), (int)(CircleMenu.DIAMETER * parent.getRadiusPart()));

		/* if the radius is complete, draw string (or later image) */
		if (parent.getRadiusPart() == 1.0) {
			if (getConvertedGraphics() != null) {
				ConvertedGraphics cg = getConvertedGraphics();
				int longerEdge = Math.max(cg.getOrigWidth(), cg.getOrigHeight());

				AffineTransform picTransform = new AffineTransform();
				picTransform.setToIdentity();


				picTransform.translate(center.getX() + Math.cos(parent.getAnglePart() * angle) * parent.getRadiusPart() * CircleMenu.MAX_RADIUS - CircleMenu.DIAMETER * parent.getRadiusPart() / 2, center.getY() + Math.sin(parent.getAnglePart() * angle) * parent.getRadiusPart() * CircleMenu.MAX_RADIUS - CircleMenu.DIAMETER * parent.getRadiusPart() / 2);
				picTransform.scale((double)CircleMenu.DIAMETER / longerEdge, (double)CircleMenu.DIAMETER / longerEdge);

				picTransform.translate(-cg.getOrigX(), -cg.getOrigY());

				/* translate a rectangular shape into the middle of the square */
				if (cg.getOrigWidth() == longerEdge) {
					/* pic is wider than high */
					picTransform.translate(0, (cg.getOrigWidth() - cg.getOrigHeight()) / 2);
				}
				else {
					/* pic is higher than wide */
					picTransform.translate((cg.getOrigHeight() - cg.getOrigWidth()) / 2, 0);
				}


				g.setTransform(picTransform);
				cg.paint(g);
				g.setTransform(new AffineTransform());
			}
			else {
				g.setColor(Color.ORANGE);
				g.drawString(text, (int)(center.getX() + Math.cos(parent.getAnglePart() * angle) * parent.getRadiusPart() * CircleMenu.MAX_RADIUS - CircleMenu.DIAMETER / 2) + CircleMenu.DIAMETER / 20, (int)(center.getY() + Math.sin(parent.getAnglePart() * angle) * parent.getRadiusPart() * CircleMenu.MAX_RADIUS) + CircleMenu.DIAMETER / 20);
			}
		}
	}

	ConvertedGraphics getConvertedGraphics() {
		return null;
	}
}

class CircleMenuItemRename extends CircleMenuItem {
	public CircleMenuItemRename(CircleMenu parent, Lifeform l) {
		super(parent, l);
	}

	void action () {
		l.rename();
	}

	ConvertedGraphics getConvertedGraphics() {
		return new MenuRename();
	}
}

class CircleMenuItemIngest extends CircleMenuItem {
	public CircleMenuItemIngest(CircleMenu parent, Lifeform l) {
		super(parent, l);
	}

	void action () {
		p.getSelectedLifeform().ingest(l);
	}

	ConvertedGraphics getConvertedGraphics() {
		return new MenuIngest();
	}
}

class CircleMenuItemTakeover extends CircleMenuItem {
	public CircleMenuItemTakeover(CircleMenu parent, Lifeform l) {
		super(parent, l);
	}

	void action () {
		p.getSelectedLifeform().takeover(l);
	}

	ConvertedGraphics getConvertedGraphics() {
		return new MenuTakeover();
	}
}

class CircleMenuItemShockwave extends CircleMenuItem {
	public CircleMenuItemShockwave(CircleMenu parent, Lifeform l) {
		super(parent, l);
	}

	void action () {
		l.skillShockwave();
	}
}

class CircleMenuItemSplit extends CircleMenuItem {
	public CircleMenuItemSplit(CircleMenu parent, Lifeform l) {
		super(parent, l);
	}

	void action () {
		l.skillSplit();
	}
}

class CircleMenuItemPassive extends CircleMenuItem {
	public CircleMenuItemPassive(CircleMenu parent, Lifeform l) {
		super(parent, l);
	}

	void action () {
		l.setInControlledMode(!l.isInControlledMode());
	}

	ConvertedGraphics getConvertedGraphics() {
		return l.isInControlledMode() ? new MenuAiRed() : new MenuAiGreen();
	}
}

class CircleMenuUnfoldThread extends Thread {
	private CircleMenu parent;

	public CircleMenuUnfoldThread (CircleMenu parent) {
		this.parent = parent;
	}

	public void run() {
		try {
			while (parent.getRadiusPart() < 1.0) {
				parent.setRadiusPart(Math.min(parent.getRadiusPart() + .35, 1.0));
				sleep(50);
			}

			while (parent.getAnglePart() < 1.0) {
				parent.setAnglePart(Math.min(parent.getAnglePart() + .35, 1.0));
				sleep(50);
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class CircleMenuFoldThread extends Thread {
	private CircleMenu parent;

	public CircleMenuFoldThread (CircleMenu parent) {
		this.parent = parent;
	}

	public void run() {
		try {
			while (parent.getAnglePart() > 0.0) {
				parent.setAnglePart(Math.max(parent.getAnglePart() - .35, 0));
				sleep(50);
			}

			while (parent.getRadiusPart() > 0.0) {
				parent.setRadiusPart(Math.max(parent.getRadiusPart() - .35, 0));
				sleep(50);
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		parent.setDisplay(false);
	}
}
