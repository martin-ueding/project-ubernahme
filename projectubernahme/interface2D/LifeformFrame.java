package projectubernahme.interface2D;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import projectubernahme.Player;
import projectubernahme.simulator.MainSimulator;

@SuppressWarnings("serial")
public class LifeformFrame extends JFrame {
	
	public LifeformFrame (MainSimulator sim, Player player) {
		super("Lifeform Frame");
		
		JPanel layoutPanel = new JPanel(new BorderLayout());
		
		layoutPanel.add(new LifeformPanel(sim), BorderLayout.CENTER);
		layoutPanel.add(new LifeformTablePanel(player), BorderLayout.EAST);
		
		add(layoutPanel);
		
		/* add key listener */
		addKeyListener(new LifeformControlKeyListener(player));
		
		setSize(800, 500);
		setVisible(true);
		

		Thread refreshWindow = new RefreshWindowThread(this);
		refreshWindow.start();
	}

}
