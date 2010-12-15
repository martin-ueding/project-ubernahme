package projectubernahme.interface2D;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import projectubernahme.Player;
import projectubernahme.simulator.MainSimulator;


@SuppressWarnings("serial")
public class LifeformFrame extends JFrame {
	
	ControlledLifeformsTablePanel controlledPanel;
	VisibleLifeformsTablePanel visiblePanel;
	ActionsPanel actionspanel;
	
	public LifeformFrame (MainSimulator sim, Player player) {
		super("Lifeform Frame");
		JPanel layoutPanel = new JPanel(new BorderLayout());


		controlledPanel = new ControlledLifeformsTablePanel(player);
		visiblePanel = new VisibleLifeformsTablePanel(player);
		
		JSplitPane splitpane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, controlledPanel, visiblePanel);

		layoutPanel.add(splitpane1, BorderLayout.CENTER);
		
		actionspanel = new ActionsPanel(player, controlledPanel.getTable(), visiblePanel.getTable());
		layoutPanel.add(actionspanel, BorderLayout.SOUTH);
		
		add(layoutPanel);
		
		setSize(300, 500);
		setVisible(true);
		

		Thread refreshWindow = new RefreshWindowThread(this);
		refreshWindow.start();
	}

	public void refresh() {
		repaint();
		controlledPanel.refresh();
		visiblePanel.refresh();
	}

}
