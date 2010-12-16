package projectubernahme.interface2D;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;

import javax.swing.JOptionPane;

import projectubernahme.Localizer;
import projectubernahme.Player;
import projectubernahme.lifeforms.Lifeform;
import projectubernahme.simulator.MainSimulator;


public class LifeformSelectionMouseListener implements MouseListener {

	Player player;
	AffineTransform transform;
	MainSimulator sim;

	public LifeformSelectionMouseListener (MainSimulator sim, Player player, AffineTransform transform) {
		this.sim = sim;
		this.player = player;
		this.transform = transform;
	}

	public void mouseClicked(MouseEvent e) {
		/* transform the mouse coordinates back to the game coordinates */
		Point2D p;
		Lifeform selected = null;

		try {
			p = transform.createInverse().transform(e.getPoint(), null);

			System.out.println(p);

			/* find the lifeform that is under the cursor */
			for (Lifeform l : player.getControlledLifeforms()) {
				if (selected == null && l.getPoint2D().distance(p) <= l.getDiameter()/2) {
					selected = l;
				}
			}

			if (selected != null) {
				player.setSelectedLifeform(selected);
			}

			/* if the lifeform is not within the controlled ones, search the whole premises */
			if (selected == null) {

			}

			if (selected != null) {
				/* if it was a single click, select the lifeform */
				if (e.getClickCount() == 1) {
					player.setSelectedLifeform(selected);
				}



				/* if it was a double click, rename the lifeform */
				else if (e.getClickCount() == 2) {
					selected.setName(JOptionPane.showInputDialog(Localizer.get("New Name:")));
				}
			}

		} catch (NoninvertibleTransformException e1) {
			e1.printStackTrace();
		}
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
