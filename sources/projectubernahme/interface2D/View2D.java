package projectubernahme.interface2D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Calendar;
import java.util.Timer;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JPanel;

import projectubernahme.Localizer;
import projectubernahme.LogMessage;
import projectubernahme.MessageTypes;
import projectubernahme.Player;
import projectubernahme.ProjectUbernahme;
import projectubernahme.gfx.ConvertedGraphics;
import projectubernahme.lifeforms.Lifeform;
import projectubernahme.simulator.MainSimulator;

@SuppressWarnings("serial")
public class View2D extends JPanel {

	AffineTransform transform;

	private MainSimulator sim;

	int viewScaling = Integer.parseInt(ProjectUbernahme.getConfigValue("initialViewScaling"));

	private int frames;
	double measureTime;

	private Player player;

	private double selectionRoationAngle;

	private Color colorWarning, colorError, colorInfo, colorDebug, colorSuccess;
	
	private int repaintInterval = 40;
	JPanelRepaintTimerTask repaintTimer;
	

	CopyOnWriteArrayList<Integer> calcTime;

	public View2D (MainSimulator sim, Player player) {

		calcTime = new CopyOnWriteArrayList<Integer>();
		this.sim = sim;
		this.player = player;

		/* set up the transform */
		transform = new AffineTransform();
		transform.setToIdentity();

		Point2D initialPosition = player.getControlledLifeforms().get(0).getPoint2D();

		transform.translate(Integer.parseInt(ProjectUbernahme.getConfigValue("initialWindowWidth"))/2, Integer.parseInt(ProjectUbernahme.getConfigValue("initialWindowHeight"))/2);
		transform.scale(viewScaling, viewScaling);
		transform.translate(-initialPosition.getX(), -initialPosition.getY());

		/* add the mouse listeners for the map movements */
		new MapPanListener(this);

		/* add mouse listener for lifeform selection */
		addMouseListener(new LifeformSelectionMouseListener(this, sim, player, transform));

		/* add key listener */
		addKeyListener(sim.getGamePauseKeyListener());
		addKeyListener(new LifeformControlKeyListener(player));



		colorWarning = new Color(Integer.decode(ProjectUbernahme.getConfigValue("colorWarning")));
		colorError = new Color(Integer.decode(ProjectUbernahme.getConfigValue("colorError")));
		colorInfo = new Color(Integer.decode(ProjectUbernahme.getConfigValue("colorInfo")));
		colorDebug = new Color(Integer.decode(ProjectUbernahme.getConfigValue("colorDebug")));
		colorSuccess = new Color(Integer.decode(ProjectUbernahme.getConfigValue("colorSuccess")));
		

		
		Timer timer = new Timer();
		repaintTimer = new JPanelRepaintTimerTask(this);
		timer.schedule(repaintTimer, 1000, repaintInterval);
		
		clock = new PowerClock();
	}

	protected void paintComponent (Graphics h) {
		repaintTimer.lock(true);
		Calendar c = Calendar.getInstance();
		
		long time = c.getTimeInMillis();
		final Graphics2D g = (Graphics2D)h;
		if (ProjectUbernahme.getConfigValue("anti_alias").equals("true")) {
			g.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
		}

		/* draw the map */
		clock.start();
		g.drawImage(sim.getEnv().getBackground(getWidth(), getHeight(), transform), 0, 0, null);
		clock.end(Localizer.get("draw map"));	

		clock.start();
		drawLifeforms(g);
		clock.end(Localizer.get("draw lifeforms"));

		clock.start();
		drawFramesPerSecond(g);
		clock.end(Localizer.get("draw fps"));

		clock.start();
		drawInterface(g);
		clock.end(Localizer.get("draw interface"));

		clock.start();
		drawCircleMenu(g);
		clock.end(Localizer.get("draw circle menu"));

		clock.start();
		drawPowerMeter(g, sim.getCalcTimeList(), sim.getPeriod(), getWidth()-100, 0);
		drawPowerMeter(g, calcTime, repaintInterval, getWidth()-100, 110);
		clock.end(Localizer.get("draw power meter"));
		

		// limit the count of the history in the power meter
		// TODO put the 50 into a config file
		if (calcTime.size() > 50) {
			calcTime.remove(0);
		}
		
		c = Calendar.getInstance();
		calcTime.add(new Integer((int) (c.getTimeInMillis() - time)));
		

		clock.done();
		repaintTimer.lock(false);
	}
	

	
	PowerClock clock;
	

	private void drawPowerMeter(Graphics2D g, CopyOnWriteArrayList<Integer> list, int time, int x0, int y0) {
		
		g.setColor(Color.gray);
		int barWidth = 2;
		int maxValue = 100;
		int k = 0;
		g.setColor(new Color(0, 0, 0, 100));
		g.fillRect(x0, y0, barWidth*list.size(), maxValue+1);
		for (Integer integer : list) {
			int i = integer.intValue();
			
			if (i < time) {
				g.setColor(Color.green);
				g.fillRect(x0+k*barWidth, y0+maxValue-time, barWidth, time-i);
			}
			else if (i <= maxValue) {
				g.setColor(Color.yellow);
				g.fillRect(x0+k*barWidth, y0+maxValue-i, barWidth, i-time);
			}
			else {
				g.setColor(Color.red);
				g.fillRect(x0+k*barWidth, y0+maxValue-maxValue, barWidth, maxValue-time);
			}
			k++;
		}
		
		g.setColor(Color.WHITE);
		g.drawLine(x0+0, y0+maxValue-time, x0+k*barWidth, y0+maxValue-time);

	}

	private void drawCircleMenu(final Graphics2D g) {
		if (player.circlemenu != null) {
			player.circlemenu.draw(g);
		}
	}

	private void drawLifeforms(final Graphics2D g) {
		selectionRoationAngle = (selectionRoationAngle+0.1) % (Math.PI*2);

		Rectangle2D screen = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
		double twiceScreenRadius = Math.hypot(getWidth(), getHeight());

		/* draw all the lifeforms */
		for (Lifeform l : sim.getLifeforms()) {
			/* reset the transform */
			g.setTransform(new AffineTransform());

			/* only paint lifeforms that are controlled or are within the reach of some other lifeform
			 * that way, nothing is spoiled */
			if (player.canSee(l)) {
				// TODO externalize these colors
				g.setColor(l.isControlled() ? Color.GREEN : Color.BLUE);

				double diameter = l.getDiameter();
				double diameterView = diameter * Math.sqrt(transform.getDeterminant());			

				Point2D p = transform.transform(l.getPoint2D(), null);

				Rectangle2D lifeformShape = new Rectangle2D.Double(l.getPoint2D().getX()-diameter/2, l.getPoint2D().getY()-diameter/2, diameter, diameter);
				Shape lifeformShapeResult = transform.createTransformedShape(lifeformShape);


				/* only draw if the lifeform is within the screen */
				if (p.distance(getWidth()/2, getHeight()/2) < twiceScreenRadius/2 || lifeformShapeResult.intersects(screen)) {

					/* draw red arcs if selected as primary */
					if (player.getSelectedLifeform() == l) {
						g.setColor(new Color(255, 50, 50, 255));
						g.drawArc((int)(p.getX() - diameterView/2), (int)(p.getY() - diameterView/2), (int)diameterView, (int)diameterView, (int)Math.toDegrees(selectionRoationAngle), 90);
						g.drawArc((int)(p.getX() - diameterView/2), (int)(p.getY() - diameterView/2), (int)diameterView, (int)diameterView, (int)Math.toDegrees(selectionRoationAngle+Math.PI), 90);
					}

					/* draw blue arcs if selected as secondary */
					if (player.getSecondarySelectedLifeform() == l) {
						g.setColor(new Color(50, 50, 255, 255));
						g.drawArc((int)(p.getX() - diameterView/2), (int)(p.getY() - diameterView/2), (int)diameterView, (int)diameterView, (int)Math.toDegrees(selectionRoationAngle+Math.PI/2), 90);
						g.drawArc((int)(p.getX() - diameterView/2), (int)(p.getY() - diameterView/2), (int)diameterView, (int)diameterView, (int)Math.toDegrees(selectionRoationAngle+3*Math.PI/2), 90);
					}

					/* draw green shade if controlled */
					if (l.isControlled()) {
						// TODO externalize this color
						g.setColor(new Color(100, 200, 100, 100));
						g.fillOval((int)(p.getX() - diameterView/2), (int)(p.getY() - diameterView/2), (int)diameterView, (int)diameterView);
					}

					/* if the lifeform can be seen by the currently selected lifeform, draw a blue circle below it */
					else if (player.getSelectedLifeform().canSee(l) && l != player.getSelectedLifeform()) {
						// TODO externalize this color
						g.setColor(new Color(100, 100, 200, 100));
						g.fillOval((int)(p.getX() - diameterView/2), (int)(p.getY() - diameterView/2), (int)diameterView, (int)diameterView);
					}

					/* if there is some action in progress, draw a progress indicator pie */
					if (l.busy) {
						// TODO externalize this color
						g.setColor(new Color(200, 100, 0, 200));

						if (l.actionProgress == 0.0) {
							g.fillArc((int)(p.getX() - diameterView/2), (int)(p.getY() - diameterView/2), (int)diameterView, (int)diameterView, (int)Math.toDegrees(2*selectionRoationAngle), 20);
							g.fillArc((int)(p.getX() - diameterView/2), (int)(p.getY() - diameterView/2), (int)diameterView, (int)diameterView, (int)Math.toDegrees(2*selectionRoationAngle+Math.PI*2/3), 20);
							g.fillArc((int)(p.getX() - diameterView/2), (int)(p.getY() - diameterView/2), (int)diameterView, (int)diameterView, (int)Math.toDegrees(2*selectionRoationAngle+Math.PI*4/3), 20);
						}
						else {
							g.fillArc((int)(p.getX() - diameterView/2), (int)(p.getY() - diameterView/2), (int)diameterView, (int)diameterView, 90, -(int)(360*l.actionProgress));
						}
					}


					/* draw the name if lifeform is big enough to be seen */
					if (lifeformShapeResult.getBounds().height > 50 && !l.getName().equals("")) {
						// TODO externalize this color
						g.setColor(new Color(100, 100, 100, 200));
						g.drawString(l.getName(), (int)(p.getX()+diameterView/2), (int)(p.getY()+diameterView/2));
					}


					/* draw image if available */
					if (l.getConvertedGraphics() != null) {

						ConvertedGraphics cg = l.getConvertedGraphics();
						int longerEdge = Math.max(cg.getOrigWidth(), cg.getOrigHeight());

						AffineTransform picTransform = new AffineTransform();
						picTransform.setToIdentity();
						picTransform.preConcatenate(transform);

						picTransform.translate(l.getPoint2D().getX()-diameter/2, l.getPoint2D().getY()-diameter/2);
						picTransform.rotate(l.getViewAngle(), diameter/2, diameter/2);

						picTransform.scale(diameter/longerEdge / 1, diameter/longerEdge / 1);
						picTransform.translate(-cg.getOrigX(), -cg.getOrigY());


						/* translate a rectangular shape into the middle of the square */
						if (cg.getOrigWidth() == longerEdge) {
							/* pic is wider than high */
							picTransform.translate(0, (cg.getOrigWidth()-cg.getOrigHeight()) / 2);
						}
						else {
							/* pic is higher than wide */
							picTransform.translate((cg.getOrigHeight()-cg.getOrigWidth()) / 2, 0);
						}

						g.setTransform(picTransform);
						cg.paint(g);
					}

					/* draw a circle if there is no picture */
					else {
						g.drawOval((int)(p.getX() - diameterView/2), (int)(p.getY() - diameterView/2), (int)diameterView, (int)diameterView);
						Point2D nose = new Point2D.Double(l.getPoint2D().getX() + diameter*Math.cos(l.getViewAngle())/2, l.getPoint2D().getY() + diameter*Math.sin(l.getViewAngle())/2);
						transform.transform(nose, nose);
						g.drawLine((int)p.getX(), (int)p.getY(), (int)nose.getX(), (int)nose.getY());
					}
				}
			}
		}

		/* reset the transform */
		g.setTransform(new AffineTransform());
	}

	private void drawFramesPerSecond(final Graphics2D g) {
		if (ProjectUbernahme.getConfigValue("showFramesPerSecond").equals("true")) {
			frames++;

			// TODO externalize this color
			g.setColor(Color.WHITE);
			g.drawString("FPS: "+Math.round(frames/measureTime), getWidth()-80, 20);

			if (measureTime > 10) {
				frames = 0;
				measureTime = 0.0;
			}
		}
	}

	private void drawInterface(final Graphics2D g) {
		final int INTERFACE_HEIGHT = Integer.parseInt(ProjectUbernahme.getConfigValue("interfaceHeight"));
		/* draw the background */
		// TODO externalize this color
		g.setColor(new Color(100, 100, 100, 230));
		g.fillRect(0, getHeight()-INTERFACE_HEIGHT, getWidth(), INTERFACE_HEIGHT);

		drawLogMessages(g);
		drawBiomassSlider(g, INTERFACE_HEIGHT);
		drawLifeformInfo(g, INTERFACE_HEIGHT);
		final int WIDTH_FOR_SELECTED_LIFEFORMS_LIST = getWidth()-120-(INTERFACE_HEIGHT-120)/2-200;
		drawSelectedLifeformsList(g, INTERFACE_HEIGHT, WIDTH_FOR_SELECTED_LIFEFORMS_LIST);
	}

	private void drawSelectedLifeformsList(final Graphics2D g, final int INTERFACE_HEIGHT, final int WIDTH) {
		int controlledLifeformsColumn = 0;
		int controlledLifeformsLine = 0;
		final int THUMB_WIDTH = 50;
		final int THUMB_MARGIN = 10;
		for (Lifeform lf : player.getControlledLifeforms()) {
			if (lf.getConvertedGraphics() != null) {

				ConvertedGraphics cg = lf.getConvertedGraphics();
				int longerEdge = Math.max(cg.getOrigWidth(), cg.getOrigHeight());

				AffineTransform picTransform = new AffineTransform();
				picTransform.setToIdentity();


				picTransform.translate(THUMB_MARGIN/2 + controlledLifeformsColumn*(THUMB_WIDTH+THUMB_MARGIN), getHeight()-INTERFACE_HEIGHT+THUMB_MARGIN/2 + controlledLifeformsLine*(THUMB_WIDTH+THUMB_MARGIN));
				picTransform.scale((double)THUMB_WIDTH/longerEdge, (double)THUMB_WIDTH/longerEdge);


				picTransform.rotate(lf.getViewAngle(), longerEdge/2, longerEdge/2);

				picTransform.translate(-cg.getOrigX(), -cg.getOrigY());

				/* translate a rectangular shape into the middle of the square */
				if (cg.getOrigWidth() == longerEdge) {
					/* pic is wider than high */
					picTransform.translate(0, (cg.getOrigWidth()-cg.getOrigHeight()) / 2);
				}
				else {
					/* pic is higher than wide */
					picTransform.translate((cg.getOrigHeight()-cg.getOrigWidth()) / 2, 0);
				}


				g.setTransform(picTransform);
				cg.paint(g);
				g.setTransform(new AffineTransform());
			}
			controlledLifeformsColumn++;
			/* if it is too wide, go to the next row */
			if ((THUMB_MARGIN/2 + (controlledLifeformsColumn+1)*(THUMB_WIDTH+THUMB_MARGIN)) > WIDTH) {
				controlledLifeformsColumn = 0;
				controlledLifeformsLine++;
			}
			if (controlledLifeformsLine == 2) {
				break;
			}
		}
	}

	private void drawLifeformInfo(final Graphics2D g, final int INTERFACE_HEIGHT) {
		Lifeform l = player.getSelectedLifeform();
		final int SELECTED_SIZE = 120;
		if (l.getConvertedGraphics() != null) {

			ConvertedGraphics cg = l.getConvertedGraphics();
			int longerEdge = Math.max(cg.getOrigWidth(), cg.getOrigHeight());

			AffineTransform picTransform = new AffineTransform();
			picTransform.setToIdentity();


			picTransform.translate(getWidth()-SELECTED_SIZE-(INTERFACE_HEIGHT-SELECTED_SIZE)/2, getHeight()-SELECTED_SIZE-(INTERFACE_HEIGHT-SELECTED_SIZE)/2);
			picTransform.scale((double)SELECTED_SIZE/longerEdge, (double)SELECTED_SIZE/longerEdge);


			picTransform.rotate(l.getViewAngle(), longerEdge/2, longerEdge/2);

			picTransform.translate(-cg.getOrigX(), -cg.getOrigY());

			/* translate a rectangular shape into the middle of the square */
			if (cg.getOrigWidth() == longerEdge) {
				/* pic is wider than high */
				picTransform.translate(0, (cg.getOrigWidth()-cg.getOrigHeight()) / 2);
			}
			else {
				/* pic is higher than wide */
				picTransform.translate((cg.getOrigHeight()-cg.getOrigWidth()) / 2, 0);
			}


			g.setTransform(picTransform);
			cg.paint(g);
			g.setTransform(new AffineTransform());
		}

		/* draw info strings */
		int infoStringsColumn = 0;
		// TODO externalize this color
		g.setColor(new Color(210, 210, 210));
		g.drawString(Localizer.get("Class"), getWidth()-SELECTED_SIZE-(INTERFACE_HEIGHT-SELECTED_SIZE)/2-200, getHeight()-SELECTED_SIZE-(INTERFACE_HEIGHT-SELECTED_SIZE)/2+infoStringsColumn*40);
		// TODO externalize this color
		g.setColor(Color.WHITE);
		g.drawString(l.getI18nClassName(), getWidth()-SELECTED_SIZE-(INTERFACE_HEIGHT-SELECTED_SIZE)/2-200+10, getHeight()-SELECTED_SIZE-(INTERFACE_HEIGHT-SELECTED_SIZE)/2+infoStringsColumn*40+15);
		infoStringsColumn++;

		// TODO externalize this color
		g.setColor(new Color(210, 210, 210));
		g.drawString(Localizer.get("Biomass"), getWidth()-SELECTED_SIZE-(INTERFACE_HEIGHT-SELECTED_SIZE)/2-200, getHeight()-SELECTED_SIZE-(INTERFACE_HEIGHT-SELECTED_SIZE)/2+infoStringsColumn*40);
		// TODO externalize this color
		g.setColor(Color.WHITE);
		g.drawString(ProjectUbernahme.f.format(l.getBiomass())+" kg", getWidth()-SELECTED_SIZE-(INTERFACE_HEIGHT-SELECTED_SIZE)/2-200+10, getHeight()-SELECTED_SIZE-(INTERFACE_HEIGHT-SELECTED_SIZE)/2+infoStringsColumn*40+15);
		infoStringsColumn++;

		if (l.getName().length() > 0) {
			// TODO externalize this color
			g.setColor(new Color(210, 210, 210));
			g.drawString(Localizer.get("Name"), getWidth()-SELECTED_SIZE-(INTERFACE_HEIGHT-SELECTED_SIZE)/2-200, getHeight()-SELECTED_SIZE-(INTERFACE_HEIGHT-SELECTED_SIZE)/2+infoStringsColumn*40);
			// TODO externalize this color
			g.setColor(Color.WHITE);
			g.drawString(l.getName(), getWidth()-SELECTED_SIZE-(INTERFACE_HEIGHT-SELECTED_SIZE)/2-200+10, getHeight()-SELECTED_SIZE-(INTERFACE_HEIGHT-SELECTED_SIZE)/2+infoStringsColumn*40+15);
			infoStringsColumn++;
		}
	}

	private void drawLogMessages(final Graphics2D g) {
		int i = 0;
		for (LogMessage s : ProjectUbernahme.getLogMessages()) {
			g.setColor(Color.black);
			g.drawString(s.msg, 10, i*15+20);
			if (s.type == MessageTypes.INFO) {
				g.setColor(colorInfo);
			}
			else if (s.type == MessageTypes.WARNING) {
				g.setColor(colorWarning);
			}
			else if (s.type == MessageTypes.ERROR) {
				g.setColor(colorError);
			}
			else if (s.type == MessageTypes.DEBUG) {
				g.setColor(colorDebug);
			}
			else if (s.type == MessageTypes.SUCCESS) {
				g.setColor(colorSuccess);
			}
			else {
				g.setColor(Color.white);
			}
			g.drawString(s.msg, 10-1, i*15+20-1);
			i++;
		}
	}

	private void drawBiomassSlider(final Graphics2D g, final int INTERFACE_HEIGHT) {
		double worldBiomass = sim.getTotalBiomass();
		double playerBiomass = player.getTotalBiomass();

		final int SLIDER_HEIGHT = Integer.parseInt(ProjectUbernahme.getConfigValue("biomassRatioSliderHeight"));
		// TODO externalize this color
		g.setColor(Color.RED);
		g.fillRect(0, getHeight()-INTERFACE_HEIGHT-SLIDER_HEIGHT, getWidth(), SLIDER_HEIGHT);
		// TODO externalize this color
		g.setColor(Color.GREEN);
		g.fillRect(0, getHeight()-INTERFACE_HEIGHT-SLIDER_HEIGHT, (int)Math.round(getWidth()*(playerBiomass/worldBiomass)), SLIDER_HEIGHT);
	}
}
