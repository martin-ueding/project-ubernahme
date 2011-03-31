// Copyright (c) 2011 Martin Ueding <dev@martin-ueding.de>

package projectubernahme.interface2D;

import java.util.TimerTask;

public class JPanelRepaintTimerTask extends TimerTask {

	private View2D panel;
	private boolean lock = false;


	public JPanelRepaintTimerTask(View2D p) {
		panel = p;
	}


	@Override
	public void run() {
		if (!lock) {
			panel.repaint();
		}
		panel.setMeasureTime(panel.getMeasureTime() + (40/1000.0));
	}


	void lock(boolean b) {
		lock = b;		
	}

}
