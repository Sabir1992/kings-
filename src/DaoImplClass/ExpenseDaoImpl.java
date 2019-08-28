package DaoImplClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBconnection.DBhelper;
import DaoInterface.ExpenseDao;
import Model.Expense;
import Util.DBclose;

public class ExpenseDaoImpl implements ExpenseDao{

	@Override
	public boolean updateExpense(Expense ex) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean addExpense(Expense ex) throws Exception {
		
		boolean result=false;
	    Connection c =null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO Expense (UserName,ExpenseType,Amount,Active) VALUES(?,?,?,?)";
        try {
        	c=DBhelper.getConnection();
        //	java.sql.Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        	ps=c.prepareStatement(sql);
        //	ps.setTimestamp(1, sqlDate);
        	ps.setString(1, ex.getUserName());
        	ps.setString(2, ex.getExpenseType());
        	ps.setFloat(3, ex.getAmount());
        	ps.setInt(4, ex.getActive());
        	//ChangeUser
        	//ChangeRecordDate
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
	public boolean deleteExpense(String expenceType) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public List<Expense> getExpenseList() throws Exception {

		List<Expense> expenseList = new ArrayList<Expense>();

		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT Id,RecordDate,UserName,ExpenseType,Amount,ChangeUser,ChangeRecordDate,Active FROM Expense";

		try {
			c = DBhelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs=ps.executeQuery();
				while (rs.next()) {
					Expense ex = new Expense();
					ex.setId(rs.getInt("Id"));
					ex.setRecordDate(rs.getDate("RecordDate"));
					ex.setUserName(rs.getString("UserName"));
					ex.setExpenseType(rs.getString("ExpenseType"));
					ex.setAmount(rs.getFloat("Amount"));
					ex.setChangeUser(rs.getString("ChangeUser"));
					ex.setChangeRecordDate(rs.getDate("ChangeRecordDate"));
					ex.setActive(rs.getInt("Active"));
					expenseList.add(ex);

				}
			} else {
				System.out.println("Connection is null!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBclose.close(c, ps, rs);
		}

		return expenseList;
	}


}
