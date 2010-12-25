package projectubernahme.interface2D;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;

public class MapPanListener implements MouseWheelListener, MouseMotionListener {

	int x, y;
	int startx, starty;
	int wheel = 0;
	double angle = 0.0;

	View2D view;

	public MapPanListener(View2D view2D) {
		this.view = view2D;
		
		wheel = (int) (Math.log(Math.sqrt(view.transform.getDeterminant()) / 100.0) * 15);
	}

	public void mouseWheelMoved(MouseWheelEvent e) {
		wheel -= e.getWheelRotation();
		if (wheel >= -65) {
			try {
				/* get the current mouse position and translate it from the px coordinate system of the screen into the meter
				 * coordinate system of the game with the inverse transformation */
				Point2D currentMousePos = e.getPoint();
				AffineTransform inverse = view.transform.createInverse();
				Point2D mouseInverse = inverse.transform(currentMousePos, null);
				view.transform.translate(mouseInverse.getX(), mouseInverse.getY());

				view.transform.scale(1.0/view.viewScaling, 1.0/view.viewScaling);

				view.viewScaling = (int)(Math.exp(wheel/15.0)*100);

				view.transform.scale(view.viewScaling, view.viewScaling);

				view.transform.translate(-mouseInverse.getX(), -mouseInverse.getY());
			} catch (NoninvertibleTransformException e1) {
				e1.printStackTrace();
			}
		}
		else {
			wheel = -65;
		}
	}

	public void mouseDragged(MouseEvent e) {
		/* print current position */
		System.out.println(x+"\t"+e.getX()+"\t"+y+"\t"+e.getY()+"\t"+e.getButton());
		
		if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == 0) {
			view.transform.rotate(-angle);
			view.transform.translate((e.getX()-x) / view.transform.getScaleX(), (e.getY()-y) / view.transform.getScaleY());
			view.transform.rotate(angle);
		}
		else if (e.getButton() == MouseEvent.BUTTON3) {
			double oldAngle = angle;
			angle += (e.getY()-y)/100.0;

			Point2D mouse;
			try {
				mouse = view.transform.inverseTransform(new Point2D.Double(startx, starty), null);
				view.transform.rotate(angle - oldAngle, mouse.getX(), mouse.getY());
			} catch (NoninvertibleTransformException e1) {
				e1.printStackTrace();
			}

		}

		x = e.getX();
		y = e.getY();
	}

	/** update the mouse position when it is just moved without any action */
	public void mouseMoved(MouseEvent e) {
		startx = x = e.getX();
		starty = y = e.getY();

	}

}
