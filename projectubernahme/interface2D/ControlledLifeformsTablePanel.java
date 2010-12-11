package projectubernahme.interface2D;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import projectubernahme.Player;

@SuppressWarnings("serial")
public class ControlledLifeformsTablePanel extends JPanel {
	
	private JTable table;
	private Player player;

	public ControlledLifeformsTablePanel (Player player) {
		super();
		this.player = player;
		add(new JLabel("Controlled Lifeforms"));
		
		setMinimumSize(new Dimension(200, 300));
		
		JScrollPane scrollpane = new JScrollPane();
		table = new JTable(new ControlledLifeformsTableModel(player));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollpane.add(table);
		
		//this.add(scrollpane);
		table.setShowGrid(true);
		this.add(table);
	}

	public void refresh() {
		if (table.getSelectedRow() >= 0) {
			player.setSelectedLifeform(player.getControlledLifeforms().get(table.getSelectedRow()));
		}
	}

}
