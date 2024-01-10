package Tasks._010524UserLoginAppJDBC.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Tasks._010524UserLoginAppJDBC.controller.UserMain;
import Tasks._010524UserLoginAppJDBC.entity.User;

public class UserDao {
	
	static Scanner sc = new Scanner(System.in);
	
	/* creating database connection */
	public static Connection dbConnection() throws SQLException, ClassNotFoundException {
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/jdbc_user";
		String userName = "root";
		String password = "root";
		
		Connection con = DriverManager.getConnection(url, userName, password);
		return con;
	}
	
	
	/* User registration  */	
	public static void register() throws ClassNotFoundException, SQLException {
		
		System.out.print("Enter Username: ");
		String uName = sc.next();
		System.out.print("Enter password");
		String passwd = sc.next();
		
		User user = new User(uName, passwd);
		
		Connection dbCon = dbConnection();
		String insertQuery = "INSERT INTO user(userName,password) VALUES(?,?)";
		
		PreparedStatement pstmt = dbCon.prepareStatement(insertQuery);
		
		/* set the value of parameter */ 				
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		
		pstmt.executeUpdate();
	}
	
	
	/* User login */
	public static void login() throws ClassNotFoundException, SQLException {
	    System.out.print("Enter Username: ");
	    String uName = sc.next();
	    System.out.print("Enter password: ");
	    String passwd = sc.next();

	    Connection dbCon = dbConnection();
	    String fetchUsers = "SELECT * FROM user WHERE userName=? AND password=?";
	    PreparedStatement pstmt = dbCon.prepareStatement(fetchUsers);
	    pstmt.setString(1, uName);
	    pstmt.setString(2, passwd);

	    ResultSet rs = pstmt.executeQuery();
	    
		if (!rs.next()) {
			System.out.println("\nInvalid username or password !\n");
		} else {
			String user = rs.getString("userName");
			String pass = rs.getString("password");

			if (uName.equalsIgnoreCase(user) && passwd.equals(pass)) {
				System.out.println("\nLogin successfull !\n");
				UserMain.main(null);
			} 
		}
	    // Remember to close resources in a finally block if needed in a production environment
	    rs.close();
	    pstmt.close();
	    dbCon.close();
	}

	
	/* update user */
	public static void updateUser() {
		// TODO Auto-generated method stub
		
	}
	

	/* delete user */
	public static void deleteUser() {
		// TODO Auto-generated method stub
		
	}
}
