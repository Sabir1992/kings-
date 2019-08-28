package Util;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Menu;

public class SelectedComboIndex {
	public static void DtmAdd(JComboBox comboBox, JTable table, DefaultTableModel dtm) {

		if (comboBox.getSelectedIndex() != 0) {

			Menu m = (Menu) comboBox.getSelectedItem();
            String productName = m.getProductName();
			Float paymentAmount = m.getPaymentAmount();
			int count = 1;
			float total = paymentAmount;

			if (ProductExist(table, productName)) {
				dtm.addRow(new Object[] { productName, paymentAmount, count, total ,m.getProductType(),m.getPurchaseAmount()});
			} else {
				JOptionPane.showMessageDialog(null, "Mehsul artiq sifaris olunub!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Mehsul secilmeyib!");

		}

	}
	
	public static boolean ProductExist(JTable table, String productName) {

		int tableRows = table.getRowCount();
		boolean ProductExist = true;

		for (int i = 0; i < tableRows; i++) {

			if (table.getValueAt(i, 0).toString().equalsIgnoreCase(productName)) {

				ProductExist = false;
			}
		}
		return ProductExist;
	}

}
