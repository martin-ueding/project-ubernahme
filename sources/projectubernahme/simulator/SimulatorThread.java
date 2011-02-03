package projectubernahme.simulator;

import java.util.Calendar;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JOptionPane;

import projectubernahme.Localizer;
import projectubernahme.lifeforms.Lifeform;

/** moves all the lifeforms around fires off actions */
public class SimulatorThread extends Thread {

	private MainSimulator sim;
	private int cycle = 0;

	int sleepTime = 30;
	
	private boolean halt = false;

	CopyOnWriteArrayList<Integer> calcTime;

	public SimulatorThread(MainSimulator mainSimulator) {
		sim = mainSimulator;
		calcTime = new CopyOnWriteArrayList<Integer>();
	}
	
	public void run() {
		try {
			while (!halt && sim.isGameUp() || cycle < 100) {
				Calendar c = Calendar.getInstance();
				long time = c.getTimeInMillis();
				
				if (cycle > 10) {
					/* let the other lifeforms interact */
					for (Lifeform l : sim.getLifeforms()) {
						l.move(sleepTime);
						l.act(sleepTime);
					}
				}
				// TODO put the 50 into a config file
				if (calcTime.size() > 50) {
					calcTime.remove(0);
				}
				
				c = Calendar.getInstance();
				calcTime.add(new Integer((int) (c.getTimeInMillis() - time)));
				
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