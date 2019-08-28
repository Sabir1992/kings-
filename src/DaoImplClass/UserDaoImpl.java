package DaoImplClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DBconnection.DBhelper;
import DaoInterface.UserDao;
import Model.Users;
import Util.DBclose;

public class UserDaoImpl implements UserDao {

	@Override
	public List<Users> getUserList() throws Exception {

		List<Users> userList = new ArrayList<Users>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT Id,UserName,RecordDate,Position,ChangeUser,ChangeRecordDate,Password,Phone,Address,Active FROM Users ";

		try {
			c = DBhelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs=ps.executeQuery();

				while (rs.next()) {

					Users user = new Users();
					user.setId(rs.getInt("Id"));
					user.setUserName(rs.getString("UserName"));
					user.setRecordDate(rs.getDate("RecordDate"));
					user.setPosition(rs.getString("Position"));
					user.setChangeUser(rs.getString("ChangeUser"));
					user.setRecordDate(rs.getDate("ChangeRecordDate"));
					user.setPassword(rs.getString("Password"));
					user.setPhone(rs.getInt("Phone"));
					user.setAddress(rs.getString("Address"));
					user.setActive(rs.getInt("Active"));
					userList.add(user);

				}
			} else {
				System.out.println("Connection is null!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose.close(c, ps, rs);
		}

		return userList;
	}

	@Override
	public boolean addUser(Users user) throws Exception {

		boolean result = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO Users (Username,RecordDate,Position,ChangeUser,"
				+ "ChangeRecordDate,Password,Phone,Address,Active ) VALUES(?,?,?,?,?,?,?,?,?)";

		try {
			c = DBhelper.getConnection();
			java.sql.Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
			ps = c.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setTimestamp(2, sqlDate);
			ps.setString(3, user.getPosition());
			ps.setString(4, user.getChangeUser());
			ps.setTimestamp(5, sqlDate);
			ps.setString(6, user.getPassword());
			ps.setInt(7, user.getPhone());
			ps.setString(8, user.getAddress());
			ps.setInt(9, user.getActive());
			ps.execute();
			result = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose.close(c, ps, null);
		}
		return result;
	}

	@Override
	public Users getUserById(int UserId) throws Exception {

		Users user = new Users();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT UserName,RecordDate,Position,ChangeUser,"
				+ "ChangeRecordDate,Password,Phone,Address,Active FROM Users WHERE AND Id = ?";
		try {
			c = DBhelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setInt(1, UserId);
				rs = ps.executeQuery();
				if (rs.next()) {
					java.sql.Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
					user.setUserName("UserName");
					user.setRecordDate(sqlDate);
					user.setPosition("Position");
					user.setChangeUser("ChangeUser");
					user.setChangeRecordDate(sqlDate);
					user.setPassword("Password");
					user.setPhone(Integer.parseInt("Phone"));
					user.setAddress("Address");
					user.setActive(Integer.parseInt("Active"));
				} else {
					user = null;
				}
			} else {
				System.out.println("Connection is null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose.close(c, ps, rs);
		}

		return user;
	}

	@Override
	public boolean updateUser(Users user) throws Exception {
		
		    boolean result = false;
	        Connection c = null;
	        PreparedStatement ps = null;
	        String sql = "UPDATE Users SET UserName = ?,Position = ?,ChangeUser = ?,"
	        		+ "ChangeRecordDate = ?,Password = ?,Phone=?,Address=?,Active=? WHERE Id = ?";
	        try {
	            c = DBhelper.getConnection();
	            if (c != null) {
	            	java.sql.Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
	                ps = c.prepareStatement(sql);
	                ps.setString(1, user.getUserName());
	                ps.setString(2, user.getPosition());
	                ps.setString(3, user.getChangeUser());
	                ps.setTimestamp(4, sqlDate);
	                ps.setString(5, user.getPassword());
	                ps.setInt(6, user.getPhone());
	                ps.setString(7, user.getAddress());
	                ps.setInt(8, user.getActive());
	                ps.setLong(9, user.getId());
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

}
