package DaoImplClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import DBconnection.DBhelper;
import DaoInterface.SaleDao;
import Model.Expense;
import Model.Menu;
import Model.Sale;
import Model.Users;
import Service.KingService;
import Util.DBclose;

public class SaleDaoImpl implements SaleDao {

	@Override
	public List<Sale> getSaleList() throws Exception {
		
		List<Sale> saleList = new ArrayList<Sale>();
		
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="SELECT Id,UserName,ProductName,ProductType,PurchaseAmount,"
				+ "PaymentAmount,RecordDate,Count,Total,TableNumber,Income,Active FROM Sale";
		
		try {
			c=DBhelper.getConnection();
			if(c!=null) {
				ps=c.prepareStatement(sql);
				rs=ps.executeQuery();
				while(rs.next()) {
					
					Sale sale=new Sale();
					sale.setId(rs.getInt("Id"));
					sale.setUserName(rs.getString("UserName"));
					sale.setProductName(rs.getString("ProductName"));
					sale.setProductType(rs.getString("ProductType"));
					sale.setPurchaseAmount(rs.getFloat("PurchaseAmount"));
					sale.setPaymentAmount(rs.getFloat("PaymentAmount"));
					sale.setRecordDate(rs.getDate("RecordDate"));
					sale.setCount(rs.getFloat("Count"));
					sale.setTotal(rs.getFloat("Total"));
					sale.setTableNumber(rs.getString("TableNumber"));
					sale.setIncome(rs.getFloat("Income"));
					sale.setActive(rs.getInt("Active"));
					saleList.add(sale);
				}
			}else {
				System.out.println("Connection is nill!");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose.close(c, ps, rs);
		}
		
		return saleList;
	}

	@Override
	public Sale getSaleByName(String ProductName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateSale(Sale sale, String productName) throws Exception {
		
		boolean result=false;
		Connection c =null;
        PreparedStatement ps = null;
        String sql = "UPDATE  Menu SET UserName=? ProductName=?,ProductType=?,"
        		+ "PurchaseAmount=?,PaymentAmount=?,RecordDate=?,Count=?,Total=?,TableNumber=?,Income=?,Active=? ";
        try {
        	c=DBhelper.getConnection();
        	java.sql.Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        	ps=c.prepareStatement(sql);
        	ps.setString(1, sale.getUserName());
        	ps.setString(2, sale.getProductName());
        	ps.setString(3, sale.getProductType());
        	ps.setTimestamp(4, sqlDate);
        	ps.setFloat(5, sale.getPurchaseAmount());
        	ps.setFloat(6, sale.getPaymentAmount());
        	ps.setInt(7, (int) sale.getCount());
        	ps.setFloat(8, sale.getTotal());
        	ps.setString(9, sale.getTableNumber());
        	ps.setFloat(10, sale.getIncome());
        	ps.setInt(11, sale.getActive());
        	ps.execute();
        	result =true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBclose.close(c, ps, null);
		}
	return result;
	}

	@Override
	public boolean deleteSale(String productName) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	

	

	


	
	

}
