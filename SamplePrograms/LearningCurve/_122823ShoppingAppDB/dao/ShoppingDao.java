package Tasks._122823ShoppingAppDB.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import Tasks._122823ShoppingAppDB.controller.ShoppingMain;
import Tasks._122823ShoppingAppDB.dbConnection.DbConnection;
import Tasks._122823ShoppingAppDB.entity.Products;

public class ShoppingDao {

	static Scanner sc = new Scanner(System.in);
	static DbConnection dbConnection = new DbConnection();
	static Connection con = DbConnection.createConnection();

	// Adding products into DB
	public void addProducts() throws SQLException {

		System.out.print("Enter product Id: ");
		int pId = sc.nextInt();
		System.out.print("Enter product name: ");
		String name = sc.next();
		System.out.print("Enter product cost: ");
		float cost = sc.nextFloat();

		String insertProduct = "INSERT INTO products VALUES(?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(insertProduct);

		pstmt.setInt(1, pId);
		pstmt.setString(2, name);
		pstmt.setFloat(3, cost);
		pstmt.executeUpdate();

		System.out.println("Product added successfully...!");
	}

	// Display product list
	public void displayProduct() throws SQLException {

		String getProducts = "SELECT * FROM products";
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery(getProducts);
//		resultSet.next();

		while (resultSet.next()) {
			int prodId = resultSet.getInt(1);
			String prodName = resultSet.getString(2);
			int cost = resultSet.getInt(3);
			System.out.println("ProductId: " + prodId + " Product Name: " + prodName + " Cost:" + cost);
		}
	}

	public void filterProductByCost() throws SQLException {
		
		System.out.println("Press '1' for greater than, '2' for less than: ");
		int ltgt = sc.nextInt();
		
		System.out.print("Enter amount to filter by: ");
		int filterAmount = sc.nextInt();
	
		List<Products> prodList = new ArrayList<>();
		
		String products = "SELECT * FROM products";
		Statement stmt = con.createStatement();
		ResultSet result = stmt.executeQuery(products);
		
		while(result.next()) {
			int prodId = result.getInt(1);
			String prodName = result.getString(2);
			float prodCost = result.getFloat(3);
			
			Products prodRecord = new Products(prodId, prodName, prodCost);
			prodList.add(prodRecord);
		}
		
		switch (ltgt) {		
			case 1: 
				Stream<Products> sp = prodList.stream().filter(p->p.getCost()>filterAmount);
				sp.forEach(e->System.out.println(e));
				break;
			case 2:
				Stream<Products> sp2 = prodList.stream().filter(p->p.getCost()<filterAmount);
				sp2.forEach(e->System.out.println(e));
				break;
			default:
				System.out.println("Choice is wrong!");
		}
	}
	
	// Search product
	public void searchProducts() throws SQLException {
		System.out.println("Enter productId: ");
		int productId = sc.nextInt();

		String searchProduct = "SELECT * FROM products WHERE productId=?";
		PreparedStatement pstmt = con.prepareStatement(searchProduct);

		pstmt.setInt(1, productId);
		ResultSet resultSet = pstmt.executeQuery();
		resultSet.next();

		if (Integer.valueOf(productId).equals(resultSet.getObject(1))) {
			System.out.println("Product Id   : " + resultSet.getInt(1));
			System.out.println("Product name : " + resultSet.getString(2));
			System.out.println("Product cost : " + resultSet.getInt(3));
		} else if (!Integer.valueOf(productId).equals(resultSet.getObject(1))) {
			System.out.println("Product not found!");
		}
	}

	// get product by Id
	public Products getProductById(int id) throws SQLException {

		System.out.println("Enter productId: ");
		int productId = sc.nextInt();

		String searchProduct = "SELET * FROM products WHERE productId=?";
		PreparedStatement pstmt = con.prepareStatement(searchProduct);

		pstmt.setInt(1, productId);
		ResultSet resultSet = pstmt.executeQuery();
		resultSet.next();

		String pName = resultSet.getString(2);
		float pCost = resultSet.getFloat(3);

		return new Products(productId, pName, pCost);
	}

	// Update product
	public void updateProduct() throws SQLException {

		System.out.print("Enter productId: ");
		int productId = sc.nextInt();

		String getProduct = "SELECT * FROM products WHERE productId=?";
		PreparedStatement pstmt = con.prepareStatement(getProduct);
		pstmt.setInt(1, productId);
		ResultSet resultSet = pstmt.executeQuery();
//		resultSet.next();

		while (resultSet.next()) {

			if (Integer.valueOf(productId).equals(resultSet.getInt(1))) {

				System.out.println("Press 1 for name update, 2 for cost update: ");
				int ch = sc.nextInt();
				switch (ch) {
				case 1:
					System.out.println("Enter new name: ");
					String name = sc.next();

					String updateName = "UPDATE products SET productName=? WHERE productId=? ";
					PreparedStatement pstmtName = con.prepareStatement(updateName);

					pstmtName.setString(1, name);
					pstmtName.setInt(2, productId);
					pstmtName.executeUpdate();
					System.out.println("Product name updated successfully...!");
					break;
				case 2:
					System.out.println("Enter new cost: ");
					float cost = sc.nextFloat();

					String updateCost = "UPDATE products SET cost=? WHERE productId=? ";
					PreparedStatement pstmtCost = con.prepareStatement(updateCost);
					
					pstmtCost.setFloat(1, cost);
					pstmtCost.setInt(2, productId);
					pstmtCost.executeUpdate();
					System.out.println("Product cost updated successfully...!");
					break;
				default:
					System.out.println("Choice is wrong!");
				}
			}
		}
	}

	// Delete product
	public void deleteProduct() throws SQLException {
		System.out.println("Enter product Id: ");
		int pId = sc.nextInt();

		String deleteProduct = "DELETE FROM products WHERE productId=?";
		PreparedStatement pstmt = con.prepareStatement(deleteProduct);
		pstmt.setInt(1, pId);
		pstmt.executeUpdate();
		System.out.println("Product deleted successfully...!");
	}

	/************************ Product operations (Purchase / Sort / Billing) ************************/

	// Purchase product
	public void purchaseProduct() throws SQLException {

		System.out.println("Enter product Id: ");
		int productId = sc.nextInt();
		System.out.println("Enter quantity: ");
		int quantity = sc.nextInt();

		String purchaseProduct = "INSERT INTO orders(orderDate,customerId,productId,orderQuantity) VALUES(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(purchaseProduct);

		LocalDate currentDate = LocalDate.now();
		pstmt.setObject(1, currentDate);
		pstmt.setInt(2, ShoppingMain.loggedInUser.getUserId());
		pstmt.setInt(3, productId);
		pstmt.setInt(4, quantity);
		pstmt.executeUpdate();
	}

	// Bill generation
	public void generateBill() throws ParseException, SQLException {

		System.out.print("Enter customer Id: ");
		int custId = sc.nextInt();

		System.out.print("Enter date in MM-dd-yyyy format: ");
		String purchaseDate = sc.next();
		System.out.println("_______________________________________________________");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		LocalDate lDate = LocalDate.parse(purchaseDate, formatter);

		String getOrders = "SELECT * FROM orders WHERE customerId=? AND orderDate=?";
		PreparedStatement pstmt = con.prepareStatement(getOrders);
		pstmt.setInt(1, custId);
		pstmt.setDate(2, java.sql.Date.valueOf(lDate));
		ResultSet resultsetOrders = pstmt.executeQuery();
//		resultsetOrders.next();

		while (resultsetOrders.next()==true) {
		// getting customer name
		String getCustomerName = "SELECT * FROM users WHERE userId=?";
		PreparedStatement pstmtCustomerName = con.prepareStatement(getCustomerName);

		pstmtCustomerName.setInt(1, 2);
		ResultSet customerDetails = pstmtCustomerName.executeQuery();
		customerDetails.next();

		// getting product name
		String getProductName = "SELECT * FROM products WHERE productID=?";
		PreparedStatement pstmtProductName = con.prepareStatement(getProductName);
		
		pstmtProductName.setInt(1, resultsetOrders.getInt(4));
		ResultSet productDetails = pstmtProductName.executeQuery();
		productDetails.next();
		
			/* printing billing information */
			System.out.println("Order# " + resultsetOrders.getInt(1));
			System.out.println("Order date       : " + resultsetOrders.getObject(2));
			System.out.println("Bill date        : " + LocalDateTime.now());
			System.out.println("Customer Id   	 : " + resultsetOrders.getInt(3));
			System.out.println("Customer name 	 : " + ShoppingMain.loggedInUser.getUserName());
			System.out.println("Product Id    	 : " + resultsetOrders.getInt(4));
			System.out.println("Product name  	 : " + productDetails.getString(2));
			System.out.println("Product cost  	 : " + productDetails.getString(3));
			System.out.println("Product quantity : " + resultsetOrders.getInt(5));
			System.out.println("Bill amount      : " + (productDetails.getInt(3) * resultsetOrders.getInt(5)));
			System.out.println("_______________________________________________________");
		}
		System.out.println();
	}

	// sorting product by cost
	public void productSortByCost() throws SQLException {

		String prod = "SELECT * FROM products";
		Statement stmt = con.createStatement();
		ResultSet result = stmt.executeQuery(prod);

		List<Products> prodList = new ArrayList<>();
		while (result.next()) {
			Integer prodId = result.getInt(1);
			String prodName = result.getString(2);
			Float prodCost = result.getFloat(3);
			
			Products product = new Products(prodId, prodName, prodCost);
			prodList.add(product);
		}

		Collections.sort(prodList);
		for (Products product : prodList) {
			System.out.println(product);
		}
	}

	// sorting product by name
//	public void productSortByName() {
//		
//		String prod = "SELECT * FROM products";
//		Statement stmt = con.createStatement();
//		ResultSet rs = stmt.executeQuery(prod);
//		
//		List<Products> prodList = new ArrayList<>();
//		while(rs) {
//			Products product = new Products(rs.getString("productName"), rs.getFloat("cost"));
//			prodList.add(product)
//			Collections.sort(prodList, new ProdNameComparator());
//		for (Products product : prodList) {
//			System.out.println(product);
//		}
//	}

	/************************************** User management ********************************/

	public static void userAuthentication() throws SQLException, ParseException {

		System.out.println("Enter username: ");
		String username = sc.next();
		System.out.println("Enter password: ");
		String password = sc.next();

		String getUser = "SELECT * FROM users WHERE userName=? AND password=?";
		PreparedStatement pstmt = con.prepareStatement(getUser);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet resultSet = pstmt.executeQuery();
		resultSet.next();

		if (username.equalsIgnoreCase(resultSet.getString(2)) && password.equals(resultSet.getString(3))) {

			/* updating useId and userName at login time */
			ShoppingMain.loggedInUser.setUserId(resultSet.getInt(1));
			ShoppingMain.loggedInUser.setUserName(resultSet.getString(2));

			/* Displaying menu as per user role */
			if (resultSet.getString(4).equalsIgnoreCase("admin")) {
				ShoppingMain.adminLogin();
			} else if (resultSet.getString(4).equalsIgnoreCase("customer")) {
				ShoppingMain.customerLogin();
			}
		}
	}

	// printing user list
	public void printUsers() throws SQLException {
		
		String printingUsers = "SELECT * FROM users";
		
		Statement stmt = con.createStatement();
		ResultSet set = stmt.executeQuery(printingUsers);
		
		while(set.next()) {
			System.out.println("UserID: " + set.getInt(1) + "  Username: " + set.getString(2)+ "  UserType: " + set.getString(4));
		}
	}

	// User creation
	public void createUser() throws SQLException {

		System.out.print("Enter user Id: ");
		int id = sc.nextInt();
		System.out.print("Enter username: ");
		String user = sc.next();
		System.out.print("Enter password: ");
		String passwd = sc.next();
		System.out.print("Enter usertype 'admin' or 'customer': ");
		String userType = sc.next();

		String createUser = "INSERT INTO users(userId,userName,password,userType) VALUES(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(createUser);
		pstmt.setInt(1, id);
		pstmt.setString(2, user);
		pstmt.setString(3, passwd);
		pstmt.setString(4, userType);
		pstmt.executeUpdate();

		System.out.println("User created successfully...!");
	}

	// User deletion
	public void delUser() throws SQLException {

		System.out.println("Enter userId to delete user:");
		int uId = sc.nextInt();

		String delUser = "DELETE FROM users WHERE userId=?";
		PreparedStatement pstmt = con.prepareStatement(delUser);
		pstmt.setInt(1, uId);
		pstmt.executeUpdate();

		System.out.println("User deleted successfully...!");
	}


// Change logged-in user
	public void changeUser() throws ParseException, SQLException {

		System.out.print("Enter username: ");
		String uName = sc.next();
		System.out.print("Enter password: ");
		String pass = sc.next();

		String getUsers = "SELECT * FROM users WHERE userName=? AND password=?";
		PreparedStatement pstmt = con.prepareStatement(getUsers);
		pstmt.setString(1, uName);
		pstmt.setString(2, pass);
		ResultSet result = pstmt.executeQuery();
//		result.next();

		if (result.next()) {

			/* updating useId and userName at user change time */
				ShoppingMain.loggedInUser.setUserId(result.getInt(1));
				ShoppingMain.loggedInUser.setUserName(result.getString(2));

			/* Displaying menu as per user role */
				if (result.getString(4).equalsIgnoreCase("admin")) {
					ShoppingMain.adminLogin();
				} else if (result.getString(4).equalsIgnoreCase("customer")) {
					ShoppingMain.customerLogin();
				}
				System.out.println("\nLogged in userId: " + ShoppingMain.loggedInUser.getUserId() 
							+ " userName: "	+ ShoppingMain.loggedInUser.getUserName() + "\n");
		}
	}
}

