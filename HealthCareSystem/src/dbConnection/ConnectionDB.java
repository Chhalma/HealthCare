package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB extends Configs{
	
	Connection con;
	
	public Connection getConnection( )throws SQLException,ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String str = "jdbc:mysql://"+Configs.dbHost+":"+Configs.dbPort+"/"+Configs.dbName;
		try {
			con = DriverManager.getConnection(str,Configs.dbUser,Configs.dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}
}
