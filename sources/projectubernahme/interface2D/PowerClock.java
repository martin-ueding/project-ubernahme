package projectubernahme.interface2D;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class PowerClock {
	BufferedOutputStream os;
	boolean first = true;
	long clockBegin;

	public PowerClock() {
		try {
			os = new BufferedOutputStream(new FileOutputStream("power.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		clockBegin = Calendar.getInstance().getTimeInMillis();
	}

	public void end(String task) {
		try {
			os.write((String.valueOf(Calendar.getInstance().getTimeInMillis()-clockBegin)+",").getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (first) {
			System.out.print(task+",");
		}
		else {
			System.out.print((Calendar.getInstance().getTimeInMillis()-clockBegin)+",");
		}
	}

	public void done() {
		try {
			os.write("\n".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		first = false;
	}
}
