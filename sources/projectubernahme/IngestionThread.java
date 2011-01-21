package projectubernahme;

import java.text.MessageFormat;

import projectubernahme.lifeforms.Lifeform;
import projectubernahme.simulator.MainSimulator;

public class IngestionThread extends Thread {

	private Lifeform l;
	private Lifeform prey;
	private MainSimulator sim;

	public IngestionThread(Lifeform lifeform, Player controllingPlayer, Lifeform lifeform2, MainSimulator sim) {
		l = lifeform;
		prey = lifeform2;
		this.sim = sim;
	}

	public void run () {
		/* set the lifeform to busy */
		l.busy = true;
		l.actionProgress = 0.0;
		
		Enum<MessageTypes> ingestionMessageType;
		
		if (!l.isControlled() && prey.isControlled())
			ingestionMessageType = MessageTypes.WARNING;
		else if (l.isControlled() && !prey.isControlled())
			ingestionMessageType = MessageTypes.SUCCESS;
		else
			ingestionMessageType = MessageTypes.INFO;
		

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

			/* ingest the prey */
			if (l.canIngest(prey)) {
				/* add the prey's name to the lifeform's */
				if (!l.getName().equals("") && !prey.getName().equals("") && l.getName().concat(prey.getName()).length() <= 25) {
					l.setName(l.getName()+"-"+prey.getName());
				}

				double startBioMass = prey.getBiomass();

				while (l.actionProgress < 1.0) {
					if (l.canIngest(prey)) {
						double diff = Math.min(prey.getBiomass(), Math.sqrt(l.getBiomass())/10);

						l.setBiomass(l.getBiomass() + diff);
						prey.setBiomass(prey.getBiomass() - diff);
					}

					l.actionProgress = (startBioMass-prey.getBiomass()) / startBioMass;

					sleep(50);
				}
				
				/* remove lifeform from simulator */
				sim.getLifeforms().remove(prey);
				
				/* remove lifeform from player's list */
				if (prey.isControlled()) {
					if (prey.controllingPlayer.getControlledLifeforms().contains(prey)) {
						prey.controllingPlayer.getControlledLifeforms().remove(prey);
					}


					/* if the ingested lifeform was selected before, it will get unselected */
					if (prey.controllingPlayer.getSelectedLifeform() == prey) {
						prey.controllingPlayer.setSelectedLifeform(null);
					}
				}
			}

		} catch (InterruptedException e) {
			/* if the action was interrupted, then it will just stop, the busy state is reset at the end of this method anyway */
		}

		/* set the lifeform back to normal */
		l.busy = false;

		ProjectUbernahme.log(MessageFormat.format(Localizer.get("{0} ingested {1}."), new Object[] {l.toString(), prey.toString()}), ingestionMessageType);
	}
}
