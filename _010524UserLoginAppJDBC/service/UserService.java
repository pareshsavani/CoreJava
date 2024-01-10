package Tasks._010524UserLoginAppJDBC.service;

import java.sql.SQLException;
import Tasks._010524UserLoginAppJDBC.dao.UserDao;


public class UserService {
	
	UserDao userDao = new UserDao();
	
	// User registration	
	public static void register() throws ClassNotFoundException, SQLException {

		UserDao.register();
	}
	
	
	// User login
	public static void login() throws ClassNotFoundException, SQLException {

		UserDao.login();
	}
	
	
	// Update user
	public static void updateUser() {
		
		UserDao.updateUser();
	}
	
	
	// Delete user
	public static void deleteUser() {
		
		UserDao.deleteUser();
	}
}
