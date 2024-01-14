package Tasks._122823ShoppingAppDB.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import Tasks._122823ShoppingAppDB.dao.ShoppingDao;
import Tasks._122823ShoppingAppDB.entity.Users;
import Tasks._122823ShoppingAppDB.service.Services;

public class ShoppingMain {

	static Scanner sc = new Scanner(System.in);
	static Services s = new Services();
	public static Users loggedInUser = new Users(0, null, null, null);

	public static void main(String[] args) throws ParseException, SQLException {

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println();
			System.out.println("  1.Admin login");
			System.out.println("  2.Customer login");
			System.out.println("  3.Exit App");
			System.out.println("  ----------------------");
			System.out.print("Enter your choice: ");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				ShoppingDao.userAuthentication();
				break;
			case 2:
				ShoppingDao.userAuthentication();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Your choice is wrong!");
			}
		}
	}

	// Administrator user screen
	static public void adminLogin() throws ParseException, SQLException {

		while (true) {
			System.out.println("-------------------------------------------------------");
			System.out.println("Logged in userId: " + loggedInUser.getUserId() + " userName: "
					+ loggedInUser.getUserName());
			System.out.println("-------------------------------------------------------");
			System.out.println("  0.User management");
			System.out.println("  1.Add Product");
			System.out.println("  2.Display Products");
			System.out.println("  3.Search Product");
			System.out.println("  4.Update Product");
			System.out.println("  5.Delete Product");
			System.out.println("  6.Sort Product on Ascending order on ProdCost");
			System.out.println("  7.Sort Product on Ascending order on ProdName");
			System.out.println("  8.Exit Application");
			System.out.println("-------------------------------------------------------");
			System.out.print("Enter your choice (1 to 8): ");
			int choice = sc.nextInt();

			switch (choice) {
			case 0:
				while (true) {
					System.out.println("-------------------------------------------------------");
					System.out.println("Logged in userId: " + loggedInUser.getUserId() + " userName: "
							+ loggedInUser.getUserName());
					System.out.println("-------------------------------------------------------");
					System.out.println("  1.User List");
					System.out.println("  2.Create new User");
					System.out.println("  3.Delete User");
					System.out.println("  4.Change User");
					System.out.println("  5.Previous Menu");
					System.out.println("-------------------------------------------------------");
					System.out.print(" Enter your choice (1 to 5): ");
					int ch = sc.nextInt();

					switch (ch) {
					case 1:
						s.printUsers();
						break;
					case 2:
						s.createUser();
						break;
					case 3:
						s.delUser();
						break;
					case 4:
						s.changeUser();
						break;
					case 5: // Previous menu
						adminLogin();
						break;
					}
				}
			case 1:
				s.addProducts();
				break;
			case 2:
				s.displayProduct();
				break;
			case 3:
				s.searchProducts();
				break;
			case 4:
				s.updateProduct();
				break;
			case 5:
				s.deleteProduct();
				break;
			case 6:
//				s.productSortByCost();
				break;
			case 7:
//				s.productSortByName();
				break;
			case 8:
				System.out.println("Thank you! for using App...");
				System.exit(0);
				break;
			default:
				System.out.println("Your choice is wrong!");
			}
		}
	}

	// Normal user screen
	static public void customerLogin() throws ParseException, SQLException {

		while (true) {
			System.out.println("-------------------------------------------------------");
			System.out.println("Logged in userId: " + loggedInUser.getUserId() + "          userName: "
					+ loggedInUser.getUserName());
			System.out.println("-------------------------------------------------------");
			System.out.println("  1.Display Products");
			System.out.println("  2.Filter products base on cost");
			System.out.println("  3.Search Products");
			System.out.println("  4.Purchase Product");
			System.out.println("  5.Generate Bill");
			System.out.println("  6.Change User");
			System.out.println("  7.Exit Application");
			System.out.println("-------------------------------------------------------");
			
			System.out.print("Enter your choice (1 to 5): ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				s.displayProduct();
				break;
			case 2:
				s.filterProductByCost();
				break;
			case 3:
				s.searchProducts();
				break;
			case 4:
				s.purchaseProduct();
				break;
			case 5:
				s.generateBill();
				break;
			case 6:
				s.changeUser();
				System.out.println("Logged in userId: " + loggedInUser.getUserId() + " userName: "
						+ loggedInUser.getUserName() + "\n");
				break;
			case 7:
				System.exit(0);
				System.out.println("Thank you! for using app");
				break;
			default:
				System.out.println("Your choice is wrong!");
			}
		}
	}
}
