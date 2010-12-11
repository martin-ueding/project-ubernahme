package projectubernahme.interface2D;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import projectubernahme.Player;

@SuppressWarnings("serial")
public class VisibleLifeformsTablePanel extends JPanel {
	
	Player player;
	private VisibleLifeformsTableModel tablemodel;

	public VisibleLifeformsTablePanel (Player player) {
		super();
		this.player = player;
		add(new JLabel("Visible Lifeforms"));
		
		setMinimumSize(new Dimension(200, 300));
		
		JScrollPane scrollpane = new JScrollPane();
		tablemodel = new VisibleLifeformsTableModel(player);
		JTable table = new JTable(tablemodel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollpane.add(table);
		
		//this.add(scrollpane);
		table.setShowGrid(true);
		this.add(table);
	}

	public void refresh() {
		repaint();
		tablemodel.refresh();
	}
}
