package projectubernahme.interface2D;


public class RefreshWindowThread extends Thread {
	
	private LifeformFrame frame;

	public RefreshWindowThread (LifeformFrame lifeformFrame) {
		frame = lifeformFrame;
	}
	
	public void run () {
		while (true) {
			frame.refresh();
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
