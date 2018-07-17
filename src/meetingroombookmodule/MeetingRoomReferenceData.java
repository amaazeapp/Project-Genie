package meetingroombookmodule;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MeetingRoomReferenceData extends JInternalFrame {
	private JTable table;

	/**
	 * Create the frame.
	 */
	public MeetingRoomReferenceData() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{new Integer(1), "PU2-1C1-Conferance Room", "pu22fc1@johndeere.com", "Tower11", new Integer(4), "No"},
				{new Integer(2), "PU2-1C2-Conferance Room", "pu2fc2@johndeere.com", "Tower11", new Integer(4), "No"},
				{new Integer(3), "PU2-1C3-Conferance Room", "pu2fc3@johndeere.com", "Tower11", new Integer(4), "No"},
				{new Integer(4), "PU2-1C4-Conferance Room", "pu21c-4confroom@johndeere.com", "Tower11", new Integer(4), "No"},
				{new Integer(5), "PU2-1C5-Conferance Room", "pu2fc5@johndeere.com", "Tower11", new Integer(4), "No"},
				{new Integer(6), "PU2-1C6-Conferance Room", "pu2fc6@johndeere.com", "Tower11", new Integer(4), "No"},
				{new Integer(7), "PU2-1N15-Conferance Room", "pu2fn15@johndeere.com", "Tower11", new Integer(8), "Yes"},
				{new Integer(8), "PU2-1N5-Conferance Room", "pu2fn5@johndeere.com", "Tower11", new Integer(8), null},
				{new Integer(9), "PU3-1C10-Conferance Room", "pu31c-10confroomcap6@johndeere.com", "Tower15", new Integer(6), "Yes"},
				{new Integer(10), "PU3-1C2-Conferance Room", "pu31c2@johndeere.com", "Tower15", new Integer(6), "Yes"},
				{new Integer(11), "PU3-1N3-Conferance Room", "pu31n3@johndeere.com", "Tower15", new Integer(12), "Yes"},
				{new Integer(12), "PU3-1S2-Conferance Room", "pu31s2@johndeere.com", "Tower15", new Integer(12), "Yes"}		
			},
			new String[] {
				"RoomID", "RoomName", "RoomEmailId", "Location", "Capacity", "HasVC"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(166);
		table.getColumnModel().getColumn(2).setPreferredWidth(202);
		table.setBounds(10, 39, 200, 50);
		getContentPane().add(table);

	}
	
	public JTable getRefTable()
	{
		return table ; 
	}
}
