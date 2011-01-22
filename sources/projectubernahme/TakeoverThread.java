package projectubernahme;

import java.text.MessageFormat;

import projectubernahme.lifeforms.Lifeform;
import projectubernahme.simulator.MainSimulator;

public class TakeoverThread extends Thread {

	private Lifeform l;
	private Lifeform prey;
	private Player player;
	private MainSimulator sim;

	public TakeoverThread(Lifeform lifeform, Player controllingPlayer, Lifeform lifeform2, MainSimulator sim) {
		l = lifeform;
		player = controllingPlayer;
		prey = lifeform2;
		this.sim = sim;
	}

	public void run () {
		/* set the lifeform to busy */
		l.busy = true;
		l.actionProgress = 0.0;

		Enum<MessageTypes> takeoverMessageType;

		if (!l.isControlled() && prey.isControlled())
			takeoverMessageType = MessageTypes.WARNING;
		else if (l.isControlled() && !prey.isControlled())
			takeoverMessageType = MessageTypes.SUCCESS;
		else
			takeoverMessageType = MessageTypes.INFO;


		try {
			/* walk towards the victim */
			while (l.distance(prey) > 0.5) {
				double xdist, ydist;
				xdist = prey.getPoint2D().getX() - l.getPoint2D().getX();
				ydist = prey.getPoint2D().getY() - l.getPoint2D().getY();

				l.viewAngle = Math.atan2(ydist, xdist);

				double distSqrt = Math.sqrt(Math.hypot(xdist, ydist));
				l.getVelocity().setTo(xdist/distSqrt, ydist/distSqrt);

				/* wait a little till the next check */
				sleep(100);
			}

			/* stop when reached the prey */
			l.getVelocity().zero();


			sim.alertEverybody(l);

			/* burn time until it is ready */
			while (l.actionProgress < 1.0) {
				l.actionProgress += 0.05;

				sleep(50);
			}

			/* take over the lifeform */
			if (l.canTakeover(prey)) {
				prey.setControlled(player);				
				player.addControlledLifeform(prey);
			}

			if ((takeoverMessageType == MessageTypes.INFO && ProjectUbernahme.verboseLevel >= 3) || takeoverMessageType != MessageTypes.INFO)
				ProjectUbernahme.log(MessageFormat.format(Localizer.get("{0} took control over {1}."), new Object[] {l.toString(), prey.toString()}), takeoverMessageType);

		} catch (InterruptedException e) {
			/* if the action was interrupted, then it will just stop, the busy state is reset at the end of this method anyway */
		}

		/* set the lifeform back to normal */
		l.busy = false;
	}


}
