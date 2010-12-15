package projectubernahme.interface2D;

import javax.swing.table.AbstractTableModel;

import projectubernahme.Player;

@SuppressWarnings("serial")
public class VisibleLifeformsTableModel extends AbstractTableModel {

	Player player;
	String[] columnNames = {"Name", "Type", "Biomass", "controlled"};
	
	public VisibleLifeformsTableModel (Player player) {
		this.player = player;
	}

	public String getColumnName(int col) {
        return columnNames[col].toString();
    }

	public int getColumnCount() {
		return 4;
	}

	public int getRowCount() {
		if (player == null) {
			System.out.println("player is null");
		}
		if (player.getSelectedLifeform() == null) {
			System.out.println("player.getSelectedLifeform() is null");
		}
		if (player.getSelectedLifeform().getNeighbors() == null) {
			System.out.println("player.getSelectedLifeform().getNeighbors() is null");
		}
		return player.getSelectedLifeform().getNeighbors().size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		if (player.getSelectedLifeform().getNeighbors().size() > 0) {
			switch (columnIndex) {
			case 0: return player.getSelectedLifeform().getNeighbors().get(rowIndex).getName();
			case 1: return player.getSelectedLifeform().getNeighbors().get(rowIndex).getClass().getSimpleName();
			case 2: return player.getSelectedLifeform().getNeighbors().get(rowIndex).getBiomass();
			case 3: return player.getSelectedLifeform().getNeighbors().get(rowIndex).isControlled();
			}
		}
		return "";
	}

	@SuppressWarnings("unchecked")
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	public boolean isCellEditable(int row, int col) {
		return false;
	}

	public void refresh() {
		player.getSelectedLifeform().generateNeighborsList();
	}

}
