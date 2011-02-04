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
		l.setBusy(true);
		l.setActionProgress(0.0);

		Enum<MessageTypes> ingestionMessageType;

		if (!l.isControlled() && prey.isControlled())
			ingestionMessageType = MessageTypes.WARNING;
		else if (l.isControlled() && !prey.isControlled())
			ingestionMessageType = MessageTypes.SUCCESS;
		else
			ingestionMessageType = MessageTypes.INFO;

		double massTakenIn = 0.0;

		try {
			if (l.canIngest(prey)) {
				double startBioMass = prey.getBiomass();

				while (l.getActionProgress() < 1.0) {

					/* walk towards the victim */
					if (l.distance(prey) > 0.1) {
						double xdist, ydist;
						xdist = prey.getPoint2D().getX() - l.getPoint2D().getX();
						ydist = prey.getPoint2D().getY() - l.getPoint2D().getY();

						l.setViewAngle(Math.atan2(ydist, xdist));

						double distSqrt = Math.hypot(xdist, ydist);
						l.getVelocity().setTo(xdist/distSqrt, ydist/distSqrt);
					}
					else {
						l.getVelocity().zero();
					}
					
					if (l.distance(prey) <= 0.5) {
						/* stop when reached the prey */
						
						sim.alertEverybody(l);

						if (l.canIngest(prey)) {
							double diff = Math.min(prey.getBiomass(), Math.sqrt(l.getBiomass())/10);
							massTakenIn += diff/l.getIngestionEff();

							l.setBiomass(l.getBiomass() + diff/l.getIngestionEff());
							prey.setBiomass(prey.getBiomass() - diff);
						}

						l.setActionProgress((startBioMass-prey.getBiomass()) / startBioMass);
					}
					sleep(50);
				}

				/* add the prey's name to the lifeform's */
				if (!l.getName().equals("") && !prey.getName().equals("") && l.getName().concat(prey.getName()).length() <= 25) {
					l.setName(l.getName()+"-"+prey.getName());
				}

				/* remove lifeform from simulator */
				sim.remove(prey);

				/* remove lifeform from player's list */
				if (prey.isControlled()) {
					if (prey.getControllingPlayer().getControlledLifeforms().contains(prey)) {
						prey.getControllingPlayer().getControlledLifeforms().remove(prey);
					}


					/* if the ingested lifeform was selected before, it will get unselected */
					if (prey.getControllingPlayer().getSelectedLifeform() == prey) {
						prey.getControllingPlayer().setSelectedLifeform(null);
					}
				}
			}


		} catch (InterruptedException e) {
			/* if the action was interrupted, then it will just stop, the busy state is reset at the end of this method anyway */
		}
		

		if ((ingestionMessageType == MessageTypes.INFO && ProjectUbernahme.getVerboseLevel() >= 3) || ingestionMessageType != MessageTypes.INFO)
			ProjectUbernahme.log(MessageFormat.format(Localizer.get("{0} ingested {2} kg of {1}."), new Object[] {l.toString(), prey.toString(), ProjectUbernahme.format(massTakenIn)}), ingestionMessageType);

		/* set the lifeform back to normal */
		l.setBusy(false);
	}
}
