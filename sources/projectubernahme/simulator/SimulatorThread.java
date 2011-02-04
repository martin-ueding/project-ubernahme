package projectubernahme.simulator;

import java.util.Calendar;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JOptionPane;

import projectubernahme.Localizer;
import projectubernahme.ProjectUbernahme;
import projectubernahme.lifeforms.Lifeform;

/** moves all the lifeforms around fires off actions */
public class SimulatorThread extends Thread {

	private MainSimulator sim;
	private int cycle = 0;

	private final int sleepTime = 30;
	
	private boolean halt = false;

	private CopyOnWriteArrayList<Integer> calcTime;
	
	private static int powerMeterMeasurementsCount = Integer.parseInt(ProjectUbernahme.getConfigValue("powerMeterMeasurementsCount"));

	public SimulatorThread(MainSimulator mainSimulator) {
		sim = mainSimulator;
		setCalcTime(new CopyOnWriteArrayList<Integer>());
	}
	
	public void run() {
		try {
			while (!halt && sim.isGameUp() || cycle < 100) {
				Calendar c = Calendar.getInstance();
				long time = c.getTimeInMillis();
				
				if (cycle > 10) {
					/* let the other lifeforms interact */
					for (Lifeform l : sim.getLifeforms()) {
						l.move(getSleepTime());
						l.act(getSleepTime());
					}
				}
				if (getCalcTime().size() > powerMeterMeasurementsCount) {
					getCalcTime().remove(0);
				}
				
				c = Calendar.getInstance();
				getCalcTime().add(new Integer((int) (c.getTimeInMillis() - time)));
				
				Thread.sleep(getSleepTime());

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

	public void setCalcTime(CopyOnWriteArrayList<Integer> calcTime) {
		this.calcTime = calcTime;
	}

	public CopyOnWriteArrayList<Integer> getCalcTime() {
		return calcTime;
	}

	public int getSleepTime() {
		return sleepTime;
	}
}