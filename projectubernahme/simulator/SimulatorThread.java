package projectubernahme.simulator;

import projectubernahme.lifeforms.Lifeform;

/** moves all the lifeforms around fires off actions */
public class SimulatorThread extends Thread {

	private MainSimulator sim;
	private int cycle = 0;
	
	private int sleepTime = 30;

	public SimulatorThread(MainSimulator mainSimulator) {
		sim = mainSimulator;
	}

	public void run() {
		while (sim.isGameUp() || cycle < 1000) {
			/* let the other blobs interact */
			for (Lifeform l : sim.lifeforms) {
				l.move(sleepTime);

			}

			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			cycle++;
		}
	}

}