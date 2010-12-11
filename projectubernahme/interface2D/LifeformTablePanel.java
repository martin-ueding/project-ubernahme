package projectubernahme.interface2D;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import projectubernahme.Player;

@SuppressWarnings("serial")
public class LifeformTablePanel extends JPanel {
	
	public LifeformTablePanel (Player player) {
		super();
		setMinimumSize(new Dimension(200, 300));
		
		JScrollPane scrollpane = new JScrollPane();
		JTable table = new JTable(new LifeformTableModel(player));

		scrollpane.add(table);
		
		//this.add(scrollpane);
		table.setShowGrid(true);
		this.add(table);
	}

}
