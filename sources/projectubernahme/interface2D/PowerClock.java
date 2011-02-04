package projectubernahme.interface2D;

import java.util.Calendar;

public class PowerClock {
	private boolean first = true;
	private long clockBegin;

	void start() {
		clockBegin = Calendar.getInstance().getTimeInMillis();
	}

	void end(String task) {
		if (first) {
			System.out.print(task+",");
		}
		else {
			System.out.print((Calendar.getInstance().getTimeInMillis()-clockBegin)+",");
		}
	}

	void done() {
		System.out.println();
		first = false;
	}
}
