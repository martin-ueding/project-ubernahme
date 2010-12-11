package projectubernahme.interface2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;

import projectubernahme.Player;

@SuppressWarnings("serial")
public class ButtonIngest extends JButton implements ActionListener {
	
	Player player;
	JTable whoTable, whomTable;
	
	public ButtonIngest (Player player, JTable whoTable, JTable whomTable) {
		super("Ingest");
		
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
			player.ingest(who, whom);
		}
		
		whoTable.invalidate();
	}
	

}
