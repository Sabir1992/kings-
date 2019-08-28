package Util;

import javax.swing.JTable;

public class TotalPrice {
	
	public static  String GetTotalPrice(JTable table) {
		
		float total = 0;
		 for(int i = 0; i < table.getRowCount(); i++){
		        
//		        float Amount = (int) table.getValueAt(i, 3);
//		        total = Amount+total;
			 
			 total=total+Float.parseFloat(table.getValueAt(i, 3).toString());
		    }
		return String.valueOf(total);
}
}