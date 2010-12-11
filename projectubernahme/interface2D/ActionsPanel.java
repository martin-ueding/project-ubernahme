package projectubernahme.interface2D;

import javax.swing.JPanel;
import javax.swing.JTable;

import projectubernahme.Player;

public class ActionsPanel extends JPanel {
	
	JTable whoTable, whomTable;
	private Player player;
	
	public ActionsPanel (Player player, JTable whoTable, JTable whomTable) {
		super();

		this.player = player;
		this.whoTable = whoTable;
		this.whomTable = whomTable;
		
		add(new ButtonTakeOver(player, whoTable, whomTable));
		add(new ButtonIngest(player, whoTable, whomTable));
	}
	
	

}
