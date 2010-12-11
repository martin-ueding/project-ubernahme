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
	private JTable table;

	public VisibleLifeformsTablePanel (Player player) {
		super();
		this.player = player;
		add(new JLabel("Visible Lifeforms"));
		
		setMinimumSize(new Dimension(100, 300));
		setMaximumSize(new Dimension(150, 300));
		
		JScrollPane scrollpane = new JScrollPane();
		tablemodel = new VisibleLifeformsTableModel(player);
		setTable(new JTable(tablemodel));
		getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollpane.add(getTable());
		
		//this.add(scrollpane);
		getTable().setShowGrid(true);
		this.add(getTable());
	}

	public void refresh() {
		repaint();
		tablemodel.refresh();
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTable getTable() {
		return table;
	}
}
