package Tasks._010524UserLoginAppJDBC.controller;

import java.sql.SQLException;
import java.util.Scanner;

import Tasks._010524UserLoginAppJDBC.service.UserService;

public class UserMain {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		while(true) {
			
			System.out.println("1.Register");
			System.out.println("2.Login");
			System.out.println("3.Update");
			System.out.println("4.Delete");
			System.out.println("5.Exit");
			
			System.out.print("Enter your choice (1 to 5): ");
			int ch = sc.nextInt();
			
			switch(ch) {
			case 1:
				UserService.register();
				break;
			case 2:
				UserService.login();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			default:
				System.out.println("You choice is wrong!");
				sc.close();
			}
		}
	}
}
