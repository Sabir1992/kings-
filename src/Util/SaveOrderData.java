package Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import DBconnection.DBhelper;
import Model.Sale;

public class SaveOrderData {
	
	JLabel  label;
	
	public static void Save(DefaultTableModel dtm)  throws Exception {

		Connection c = null;
		PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO Sale (UserName,ProductName,ProductType,PurchaseAmount,"
					+ "PaymentAmount,RecordDate,Count,Total,TableNumber,Income,Active) WHERE tableNumber=?"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            
				c=DBhelper.getConnection();
			
			ps = c.prepareStatement(sql);
			java.sql.Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        	ps=c.prepareStatement(sql);
//        	ps.setString(1,);              
//        	ps.setString(2, Sale.getProductName());
//        	ps.setString(3, Sale.getProductType());
//        	ps.setFloat(4, Sale.getPurchaseAmount());
//        	ps.setFloat(5, Sale.getPaymentAmount());
//        	ps.setTimestamp(6, sqlDate);
//        	ps.setInt(7, Sale.getCount());
//        	ps.setFloat(8, Sale.getTotal());
//        	ps.setString(9,Sale.getTableNumber());
//        	ps.setFloat(10,Sale.getIncome());
        	ps.setInt(11,1);
			ps.execute();
			
		 }  catch (SQLException e) {
			e.printStackTrace();
			}   finally {
			            try {
				             DBclose.close(c, ps, null);
			            } catch (Exception e) {
				             e.printStackTrace();
			              }
		        }

	}

}
