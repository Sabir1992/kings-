package DaoImplClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBconnection.DBhelper;
import DaoInterface.TableDao;
import Model.Menu;
import Model.Tables;
import Util.DBclose;

public class TableDaoImpl implements TableDao{

	@Override
	public boolean addTable(Tables tables) throws Exception {
		
		boolean result=false;
	    Connection c =null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO Tables (TableNumber,TableStatus,TableName,RecordDate,Active) VALUES(?,?,?,?,?)";
        try {
        	c=DBhelper.getConnection();
        	java.sql.Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        	ps=c.prepareStatement(sql);
        	ps.setInt(1, tables.getTableNumber());
        	ps.setString(2, tables.getTableStatus());
        	ps.setString(3, tables.getTableName());
        	ps.setTimestamp(4, sqlDate);
        	ps.setInt(5, tables.getActive());
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
	public boolean updateTable(Tables tables, long id) throws Exception {
		
		boolean result=false;
		Connection c =null;
        PreparedStatement ps = null;
        String sql = "UPDATE  Tables SET TableNumber=?,TableStatus=?,TableName=?,RecordDate=?,Active=? WHERE Id=?";
        try {
        	c=DBhelper.getConnection();
        	java.sql.Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        	ps=c.prepareStatement(sql);
        	ps.setInt(1, tables.getTableNumber());
        	ps.setString(2, tables.getTableStatus());
        	ps.setString(3, tables.getTableName());
        	ps.setTimestamp(4, sqlDate);
        	ps.setInt(5, tables.getActive());
        	ps.setLong(6, id);
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
	public List<Tables> getTableList() throws Exception {
		
		List<Tables> tableList = new ArrayList<Tables>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT Id,TableNumber,TableStatus,TableName,RecordDate,Active FROM Tables";
		try {
			c = DBhelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs=ps.executeQuery();
				while (rs.next()) {

					Tables tab = new Tables();
					tab.setId(rs.getInt("Id"));
					tab.setTableNumber(rs.getInt("TableNumber"));
					tab.setTableStatus(rs.getString("TableStatus"));
					tab.setTableName(rs.getString("TableName"));
					tab.setRecordDate(rs.getTimestamp("RecordDate"));
					tab.setActive(rs.getInt("Active"));
					tableList.add(tab);

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

		return tableList;
	}

}
