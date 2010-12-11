package projectubernahme.interface2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;

import projectubernahme.Player;

public class ButtonTakeOver extends JButton implements ActionListener {
	
	Player player;
	JTable whoTable, whomTable;
	
	public ButtonTakeOver (Player player, JTable whoTable, JTable whomTable) {
		super("Take Over");
		
		this.player = player;
		this.whoTable = whoTable;
		this.whomTable = whomTable;
		
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		int who = whoTable.getSelectedRow();
		int whom = whomTable.getSelectedRow();
		
		if (who >= 0 && whom >= 0) {
			System.out.println("Take over "+who+" "+whom);
			player.takeover(who, whom);
		}
	}
	

}
