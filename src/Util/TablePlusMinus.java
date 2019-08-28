package Util;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import Model.Menu;

public class TablePlusMinus {
	public static void plus(JComboBox comboBox, JTable table) {

		if (comboBox.getSelectedIndex() != 0) {
			Menu m = (Menu) comboBox.getSelectedItem();

			String productName = m.getProductName();
			Float paymentAmount = m.getPaymentAmount();
			int count = 1;
			float total = paymentAmount;

			increaseCount(table, table.getSelectedRow());

		}

	}

	public static void increaseCount(JTable table, int a) {
		if (a > -1) {

			int count = (int) table.getValueAt(a, 2);
			table.setValueAt(count + 1, a, 2);
			float total = (float) table.getValueAt(a, 1) * (int) table.getValueAt(a, 2);
			table.setValueAt(total, a, 3);
			
			
		} else {
			JOptionPane.showMessageDialog(null, "Melumat Secilmeyib");
		}
		
		
			
			
		}
		
	
	public static void Minus(JTable table,int a) {
		
		  if(a>-1) {
			   int tableRows=table.getRowCount();
				
				 
				 int count=(int) table.getValueAt(a, 2);
				if(count>1) {
					 table.setValueAt(count-1, a, 2);
				}
				 float total=(float) table.getValueAt(a, 1)*(int)table.getValueAt(a, 2);
				 table.setValueAt(total, a, 3);
		  }
		  else {
			  JOptionPane.showMessageDialog(null, "Melumat Secilmeyib");
		  }
	}

}
