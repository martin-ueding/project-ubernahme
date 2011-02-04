package projectubernahme.interface2D;

import java.io.BufferedOutputStream;
import java.util.Calendar;

public class PowerClock {
	BufferedOutputStream os;
	boolean first = true;
	long clockBegin;

	public void start() {
		clockBegin = Calendar.getInstance().getTimeInMillis();
	}

	public void end(String task) {
		if (first) {
			System.out.print(task+",");
		}
		else {
			System.out.print((Calendar.getInstance().getTimeInMillis()-clockBegin)+",");
		}
	}

	public void done() {
		System.out.println();
		first = false;
	}
}
