package DBconnection;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBhelper {
		
		private static	String driver, Url;
		private static Connection con;
		
		public static Connection getConnection() throws Exception{
			
			Properties p= new Properties();
			p.load(new FileReader("src/DBconnection/config.proporties"));
			
			Class.forName(p.getProperty("driver"));
			con = DriverManager.getConnection(p.getProperty("Url"));
			
			return con;
	     }
	  }
