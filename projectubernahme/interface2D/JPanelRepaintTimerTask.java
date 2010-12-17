package projectubernahme.interface2D;

import java.util.TimerTask;

public class JPanelRepaintTimerTask extends TimerTask {
	
	View2D panel;
	
	public JPanelRepaintTimerTask(View2D p) {
		panel = p;
	}

	@Override
	public void run() {
		panel.repaint();
		panel.measureTime += 50/1000.0;
	}

}
