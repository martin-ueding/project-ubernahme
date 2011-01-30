package projectubernahme.simulator;

import javax.swing.JOptionPane;

import projectubernahme.Localizer;
import projectubernahme.lifeforms.Lifeform;

/** moves all the lifeforms around fires off actions */
public class SimulatorThread extends Thread {

	private MainSimulator sim;
	private int cycle = 0;

	private int sleepTime = 30;
	
	private boolean halt = false;

	public SimulatorThread(MainSimulator mainSimulator) {
		sim = mainSimulator;
	}

	public void run() {
		try {
			while (!halt && sim.isGameUp() || cycle < 100) {
				if (cycle > 10) {
					/* let the other lifeforms interact */
					for (Lifeform l : sim.getLifeforms()) {
						l.move(sleepTime);
						l.act(sleepTime);
					}
				}

				Thread.sleep(sleepTime);

				cycle++;
			}

			if (!sim.isGameUp()) {
				JOptionPane.showMessageDialog(null, Localizer.get("Game Over!"));
				System.exit(0);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void halt () {
		halt = true;
	}
}