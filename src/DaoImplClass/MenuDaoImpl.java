package DaoImplClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import DBconnection.DBhelper;
import DaoInterface.MenuDao;
import Model.Menu;
import Util.DBclose;

public class MenuDaoImpl implements MenuDao{


	@Override
	public List<Menu> getMenuList() {


		List<Menu> menuList = new ArrayList<Menu>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT Id,UserName,ProductName,ProductType,RecordDate,"
				+ "PurchaseAmount,PaymentAmount,Description,Active FROM Menu";
		try {
			c = DBhelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs=ps.executeQuery();
				while (rs.next()) {

					Menu menu = new Menu();
					menu.setId(rs.getInt("Id"));
					menu.setUserName(rs.getString("UserName"));
					menu.setProductName(rs.getString("ProductName"));
					menu.setProductType(rs.getString("ProductType"));
					menu.setRecordDate(rs.getTimestamp("RecordDate"));
					menu.setPurchaseAmount(rs.getFloat("PurchaseAmount"));
					menu.setPaymentAmount(rs.getFloat("PaymentAmount"));
					menu.setDescription(rs.getString("Description"));
					menu.setActive(rs.getInt("Active"));
					menuList.add(menu);

				}
			} else {
				System.out.println("Conncting is null!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBclose.close(c, ps, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return menuList;
	}
	
	@Override
	public boolean addMenu(Menu menu) throws Exception {
		
	    	boolean result=false;
		    Connection c =null;
	        PreparedStatement ps = null;
	        String sql = "INSERT INTO Menu (UserName,ProductName,ProductType,RecordDate,"
	        		+ "PurchaseAmount,PaymentAmount,Description,Active) VALUES(?,?,?,?,?,?,?,?)";
	        try {
	        	c=DBhelper.getConnection();
	        	java.sql.Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
	        	ps=c.prepareStatement(sql);
	        	ps.setString(1, menu.getUserName());
	        	ps.setString(2, menu.getProductName());
	        	ps.setString(3, menu.getProductType());
	        	ps.setTimestamp(4, sqlDate);
	        	ps.setFloat(5, menu.getPurchaseAmount());
	        	ps.setFloat(6, menu.getPaymentAmount());
	        	ps.setString(7, menu.getDescription());
	        	ps.setInt(8, menu.getActive());
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
	public boolean updateMenu(Menu menu, long id) throws Exception {
		
		boolean result=false;
		Connection c =null;
        PreparedStatement ps = null;
        String sql = "UPDATE  Menu SET ProductName=?,ProductType=?,RecordDate=?,"
        		+ "PurchaseAmount=?,PaymentAmount=?,Description=?,Active=? WHERE Id=?";
        try {
        	c=DBhelper.getConnection();
        	java.sql.Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        	ps=c.prepareStatement(sql);
        	ps.setString(1, menu.getProductName());
        	ps.setString(2, menu.getProductType());
        	ps.setTimestamp(3, sqlDate);
        	ps.setFloat(4, menu.getPurchaseAmount());
        	ps.setFloat(5, menu.getPaymentAmount());
        	ps.setString(6, menu.getDescription());
        	ps.setInt(7, menu.getActive());
        	ps.setLong(8, id);
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
	public Menu getMenuByName(String productName) throws Exception {
		
		Menu menu = new Menu();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT Id,ProductName,ProductType,RecordDate,"
				+ "PurchaseAmount,PaymentAmount,Description FROM Menu WHERE Active=1 AND Username=? ";
		try {
			c = DBhelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setString(1, productName);
				rs=ps.executeQuery();
				if (rs.next()) {
					menu.setId(rs.getInt("Id"));
					menu.setUserName(rs.getString("UserName"));
					menu.setProductName(rs.getString("ProductName"));
					menu.setProductType(rs.getString("ProductType"));
					menu.setRecordDate(rs.getTimestamp("RecordDate"));
					menu.setPurchaseAmount(rs.getFloat("PurchaseAmount"));
					menu.setPaymentAmount(rs.getFloat("PaymentAmount"));
					menu.setDescription(rs.getString("Description"));
					menu.setActive(rs.getInt("Active"));
				}else {
					menu=null;
				}
			} else {
				System.out.println("Conncting is null!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBclose.close(c, ps, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return menu;
	}
	
	@Override
	public List<Menu> searchMenuData(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public boolean deleteMenu(String productName) throws Exception {
//boolean result=false;
//		
//	    Connection c =null;
//        PreparedStatement ps = null;
//        String sql = "UPDATE  Menu SET ProductName=?,RecordDate=?,Active=? WHERE UserName=?";
//        try {
//        	c=DBhelper.getConnection();
//        	java.sql.Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
//        	ps=c.prepareStatement(sql);
//        	ps.setString(1, menu.getProductName());
//        	ps.setString(2, menu.getProductType());
//        	ps.setTimestamp(3, sqlDate);
//        	ps.setFloat(4, menu.getPurchaseAmount());
//        	ps.setFloat(5, menu.getPaymentAmount());
//        	ps.setString(6, menu.getDescription());
//        	ps.setInt(7, menu.getActive());
//        	ps.setString(8, productName);
//        	ps.execute();
//        	result =true;
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			DBclose.close(c, ps, null);
//		}
//	
//	return result;
//	}
	
	@Override
	public boolean deleteMenu(long id) throws Exception {
		 boolean result = false;
	        Connection c = null;
	        PreparedStatement ps = null;
	        String sql = "UPDATE Menu SET ACTIVE = 0 WHERE Id = ?";
	        
	        try {
	            c = DBhelper.getConnection();
	            if (c != null) {
	                ps = c.prepareStatement(sql);
	                ps.setLong(1, id);
	                ps.execute();
	                result = true;
	            } else {
	                System.out.println("Connection is null!");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            DBclose.close(c, ps, null);
	        }

	        return result;
	}

	
	@Override
	public List<Menu> comboadd(String productType) throws Exception {
		List<Menu> menuList=new ArrayList<Menu>();
		
		Connection c= DBhelper.getConnection();
		Statement st=c.createStatement();
		String sql="Select * FROM Menu WHERE ProductType='"+productType+"'";
		ResultSet rs=st.executeQuery(sql);
		
			while(rs.next()) {
			
				Menu m=new Menu();
				m.setProductName(rs.getString("productName"));
				m.setPaymentAmount(rs.getFloat("paymentAmount"));
				menuList.add(m);
			}
		return menuList;
	
	

}
}