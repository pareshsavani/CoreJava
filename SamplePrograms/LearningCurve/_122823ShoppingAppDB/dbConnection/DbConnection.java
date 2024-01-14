package Tasks._122823ShoppingAppDB.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnection {

	static Connection con;
	
	public static Connection createConnection() {
		
		try{
			/* Load the driver */
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			/* creating connection */
			String user = "root";
			String password ="root";
			String url = "jdbc:mysql://localhost:3306/shoppingapp";
			
			con = (Connection) DriverManager.getConnection(url, user, password);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
