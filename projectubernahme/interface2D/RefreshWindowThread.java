package projectubernahme.interface2D;

import javax.swing.JFrame;

public class RefreshWindowThread extends Thread {
	
	private JFrame frame;

	public RefreshWindowThread (JFrame lifeformFrame) {
		frame = lifeformFrame;
	}
	
	public void run () {
		while (true) {
			frame.repaint();
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
