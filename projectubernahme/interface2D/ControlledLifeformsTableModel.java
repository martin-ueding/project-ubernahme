package projectubernahme.interface2D;

import javax.swing.table.AbstractTableModel;

import projectubernahme.Player;

@SuppressWarnings("serial")
public class ControlledLifeformsTableModel extends AbstractTableModel {

	Player player;
	String[] columnNames = {"Name", "Type", "Biomass"};
	
	public ControlledLifeformsTableModel (Player player) {
		this.player = player;
	}

	public String getColumnName(int col) {
        return columnNames[col].toString();
    }

	public int getColumnCount() {
		return 3;
	}

	public int getRowCount() {
		return player.getControlledLifeforms().size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0: return player.getControlledLifeforms().get(rowIndex).getName();
		case 1: return player.getControlledLifeforms().get(rowIndex).getClass().getSimpleName();
		case 2: return player.getControlledLifeforms().get(rowIndex).getBiomass();
		default: return "";
		}
	}

	@SuppressWarnings("unchecked")
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	public boolean isCellEditable(int row, int col) {
		return col == 0;
	}

	public void setValueAt(Object value, int row, int col) {
		player.getControlledLifeforms().get(row).setName((String) value);
		fireTableCellUpdated(row, col);
	}
}
