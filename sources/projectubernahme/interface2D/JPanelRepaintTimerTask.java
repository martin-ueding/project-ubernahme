package projectubernahme.interface2D;

import java.util.TimerTask;

public class JPanelRepaintTimerTask extends TimerTask {

	View2D panel;
	boolean lock = false;


	public JPanelRepaintTimerTask(View2D p) {
		panel = p;
	}


	@Override
	public void run() {
		if (!lock) {
			panel.repaint();
		}
		panel.measureTime += 40/1000.0;
	}


	public void lock(boolean b) {
		lock = b;		
	}

}
