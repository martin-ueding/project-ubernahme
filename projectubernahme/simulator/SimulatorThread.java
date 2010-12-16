package projectubernahme.simulator;

import projectubernahme.lifeforms.Lifeform;

/** moves all the lifeforms around fires off actions */
public class SimulatorThread extends Thread {

	private MainSimulator sim;
	private int cycle = 0;

	private int sleepTime = 100;

	public SimulatorThread(MainSimulator mainSimulator) {
		sim = mainSimulator;
	}

	public void run() {
		while (sim.isGameUp() || cycle < 1000) {
			if (cycle > 10) {
				/* let the other blobs interact */
				for (Lifeform l : sim.getLifeforms()) {
					l.move(sleepTime);
					l.act(sleepTime);
				}
			}
			
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			cycle++;
		}
	}

}