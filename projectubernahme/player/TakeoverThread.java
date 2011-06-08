// Copyright (c) 2011 Martin Ueding <dev@martin-ueding.de>

package projectubernahme.player;

import java.text.MessageFormat;

import projectubernahme.Localizer;
import projectubernahme.MessageTypes;
import projectubernahme.ProjectUbernahme;
import projectubernahme.lifeforms.Lifeform;
import projectubernahme.simulator.MainSimulator;

public class TakeoverThread extends Thread {

	private Lifeform l;
	private Lifeform prey;
	private Player player;
	private MainSimulator sim;

	public TakeoverThread(Lifeform lifeform, Player controllingPlayer, Lifeform
			lifeform2, MainSimulator sim) {
		l = lifeform;
		player = controllingPlayer;
		prey = lifeform2;
		this.sim = sim;
	}

	public void run () {
		/* set the lifeform to busy */
		l.setBusy(true);
		l.setActionProgress(0.0);

		Enum<MessageTypes> takeoverMessageType;

		if (!l.isControlled() && prey.isControlled()) {
			takeoverMessageType = MessageTypes.WARNING;
		}
		else if (l.isControlled() && !prey.isControlled()) {
			takeoverMessageType = MessageTypes.SUCCESS;
		}
		else {
			takeoverMessageType = MessageTypes.INFO;
		}


		try {
			if (l.canTakeover(prey)) {

				while (l.getActionProgress() < 1.0) {
					/* walk towards the victim */
					if (l.distance(prey) > 0.1) {
						double xdist, ydist;
						xdist = prey.getPoint2D().getX() -
							l.getPoint2D().getX();
						ydist = prey.getPoint2D().getY() -
							l.getPoint2D().getY();

						l.setViewAngle(Math.atan2(ydist, xdist));

						double distSqrt = Math.hypot(xdist, ydist);
						l.getVelocity().setTo(xdist / distSqrt, ydist /
								distSqrt);
					}
					else {
						/* stop when reached the prey */
						l.getVelocity().zero();
					}
					if (l.distance(prey) <= 0.5) {
						sim.alertEverybody(l);

						/* burn time until it is ready */
						l
						.setActionProgress(l.getActionProgress() + 0.05);
					}

					sleep(50);
				}

				/* take over the lifeform */
				prey.setControlled(player);
				player.addControlledLifeform(prey);
				prey.stopAction();

				if ((takeoverMessageType == MessageTypes.INFO &&
							ProjectUbernahme.getVerboseLevel() >= 3) ||
						takeoverMessageType != MessageTypes.INFO)
					ProjectUbernahme.log(MessageFormat.format(Localizer.get(
									"{0} took control over {1}."), new Object[]
								{l.toString(), prey.toString()}),
							takeoverMessageType);
			}
		}
		catch (InterruptedException e) {
			/* if the action was interrupted, then it will just stop, the busy
			 * state is reset at the end of this method anyway */
		}

		/* set the lifeform back to normal */
		l.setBusy(false);
	}
}

