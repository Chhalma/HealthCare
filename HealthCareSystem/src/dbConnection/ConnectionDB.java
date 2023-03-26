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
		/*java.sql.Statement st = con.createStatement();
		String str = "INSERT INTO `user` ( `user_name`, `password`, `role`, `active`) VALUES ( 'saifur', '1234', 'admin', '1'); ";
		st.execute(str);
		System.out.println("Data Inserted.");
		
		String str2 = "select * from user";
		ResultSet rs = st.executeQuery(str2);
		while(rs.next()) {
			System.out.println("User_name: "+ rs.getString("user_name")+", Password: "+rs.getString("password"));
		}
		st.close();
		con.close();
	*/
	}
}
