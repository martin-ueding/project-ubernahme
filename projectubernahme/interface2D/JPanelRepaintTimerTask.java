package projectubernahme.interface2D;

import java.util.TimerTask;

import javax.swing.JPanel;

public class JPanelRepaintTimerTask extends TimerTask {
	
	JPanel panel;
	
	public JPanelRepaintTimerTask(JPanel p) {
		panel = p;
	}

	@Override
	public void run() {
		
		panel.repaint();

	}

}
