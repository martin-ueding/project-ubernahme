package projectubernahme.interface2D;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;

import projectubernahme.Player;
import projectubernahme.lifeforms.Lifeform;
import projectubernahme.simulator.MainSimulator;

public class LifeformSelectionMouseListener implements MouseListener {

	Player player;
	AffineTransform transform;
	MainSimulator sim;
	View2D view;

	public LifeformSelectionMouseListener (View2D view, MainSimulator sim, Player player, AffineTransform transform) {
		this.view = view;
		this.sim = sim;
		this.player = player;
		this.transform = transform;
	}

	public void mouseClicked(MouseEvent e) {
		/* transform the mouse coordinates back to the game coordinates */
		Point2D p;
		Lifeform selected = null;
		boolean primary = false;

		try {
			p = transform.createInverse().transform(e.getPoint(), null);

			/* find the lifeform that is under the cursor */
			for (Lifeform l : player.getControlledLifeforms()) {
				if (selected == null && l.getPoint2D().distance(p) <= l.getDiameter()/2) {
					selected = l;
					primary = true;
				}
			}

			/* if the lifeform is not within the controlled ones, search the whole premises */
			if (selected == null) {
				for (Lifeform l : sim.getLifeforms()) {
					if (selected == null && l.getPoint2D().distance(p) <= l.getDiameter()/2) {
						selected = l;
					}
				}
			}

			if (selected != null) {
				/* if it was a single click, select the lifeform */
				if (e.getClickCount() == 1) {
					/* primary click select the lifeform to act with */
					if (e.getButton() == MouseEvent.BUTTON1 && primary) {
						player.setSelectedLifeform(selected);
					}
					/* secondary click will select the lifeform and open the interaction menu */
					else if (e.getButton() == MouseEvent.BUTTON3) {
						player.setSecondarySelectedLifeform(selected);
						player.setMenu(new CircleMenu(view, selected));
					}
				}

				/* if it was a double click, rename the lifeform */
				else if (e.getClickCount() == 2) {
					selected.rename();
				}
			}

		} catch (NoninvertibleTransformException e1) {
			e1.printStackTrace();
		}
	}


	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

}
