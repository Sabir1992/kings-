package DaoImplClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBconnection.DBhelper;
import DaoInterface.LoginDao;
import Model.Users;
import Util.DBclose;

public class LoginDaoImpl implements LoginDao {

	@Override
	public Users login(String username, String password,String position) throws Exception {
		
		 Users login = new Users();
	        Connection c = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        String sql = "SELECT UserName,Position,Password FROM Users WHERE Active = 1 AND UserName = ? AND Password = ?";
	        try {
	            c = DBhelper.getConnection();
	            if (c != null) {
	                ps = c.prepareStatement(sql);
	                ps.setString(1, username);
	                ps.setString(2, password);
	                rs = ps.executeQuery();
	                if (rs.next()) {
	                    login.setUserName(rs.getString("UserName"));
	                    login.setPassword(rs.getString("Password"));
	                    login.setPosition(rs.getString("Position"));
	                } else {
	                    login = null;
	                }
	            } else {
	                System.out.println("Connection is null!");
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        } finally {
	            DBclose.close(c, ps, rs);
	        }
	        return login;
	}

}
