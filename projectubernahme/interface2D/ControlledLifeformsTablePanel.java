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

		setMinimumSize(new Dimension(100, 300));
		setMaximumSize(new Dimension(150, 100));
		
		JScrollPane scrollpane = new JScrollPane();
		setTable(new JTable(new ControlledLifeformsTableModel(player)));
		getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollpane.add(getTable());
		
		//this.add(scrollpane);
		getTable().setShowGrid(true);
		this.add(getTable());
	}

	public void refresh() {
		if (getTable().getSelectedRow() >= 0) {
			player.setSelectedLifeform(player.getControlledLifeforms().get(getTable().getSelectedRow()));
		}
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTable getTable() {
		return table;
	}

}
