package Util;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RemoveTableRow {
	
	public static void RemoveRow( JTable table, DefaultTableModel dtm) {

		if (table.getSelectedRow()!=0) {

			dtm.removeRow(table.getSelectedRow());

		} else {
			JOptionPane.showMessageDialog(null, "Mehsul secilmeyib!");
		}

	}

}
