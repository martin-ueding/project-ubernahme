package projectubernahme.interface2D;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;

public class MapPanListener implements MouseWheelListener, MouseMotionListener, MouseListener {

	private int x, y;
	private int startx, starty;
	private int wheel = 0;
	private double angle = 0.0;
	
	/** tracks the current pressed mouse button for the panning and rotation movements */
	private int pressedMouseButton;

	private View2D view;
	private double roundedAngle;

	public MapPanListener(View2D view2D) {
		this.view = view2D;
		
		view.addMouseListener(this);
		view.addMouseMotionListener(this);
		view.addMouseWheelListener(this);
		
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

	/** handles dragging events that lead to panning or rotation */
	public void mouseDragged(MouseEvent e) {		
		if (pressedMouseButton == MouseEvent.BUTTON1) {
			view.transform.rotate(-angle);
			view.transform.translate((e.getX()-x) / view.transform.getScaleX(), (e.getY()-y) / view.transform.getScaleY());
			view.transform.rotate(angle);
		}
		else if (pressedMouseButton == MouseEvent.BUTTON2 || pressedMouseButton == MouseEvent.BUTTON3) {
			double oldAngle = roundedAngle;
			angle += (e.getY()-y)/100.0;
			
			double factor = 1.0/Math.PI/2*8;
			
			if (pressedMouseButton == MouseEvent.BUTTON3) {
				roundedAngle = Math.round(angle*factor)/factor;
			}
			else {
				roundedAngle = angle;
			}

			Point2D mouse;
			try {
				mouse = view.transform.inverseTransform(new Point2D.Double(startx, starty), null);
				view.transform.rotate(roundedAngle - oldAngle, mouse.getX(), mouse.getY());
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

	public void mouseClicked(MouseEvent ignored) {}
	public void mouseEntered(MouseEvent ignored) {}
	public void mouseExited(MouseEvent ignored) {}

	public void mousePressed(MouseEvent arg0) {
		pressedMouseButton = arg0.getButton();
	}

	public void mouseReleased(MouseEvent arg0) {
		pressedMouseButton = -1;
	}
}
