package Tasks._122823ShoppingAppDB.service;

import java.sql.SQLException;
import java.text.ParseException;
import Tasks._122823ShoppingAppDB.dao.ShoppingDao;

public class Services {

	ShoppingDao shoppingDao = new ShoppingDao();


	public void addProducts() throws SQLException {
		shoppingDao.addProducts();
	}

	public void displayProduct() throws SQLException {
		shoppingDao.displayProduct();
	}
	
	public void filterProductByCost() throws SQLException {
		shoppingDao.filterProductByCost();
	}

	public void searchProducts() throws SQLException {
		shoppingDao.searchProducts();
	}

	public void updateProduct() throws SQLException {
		shoppingDao.updateProduct();
	}

	public void deleteProduct() throws SQLException {
		shoppingDao.deleteProduct();
	}

	/********************* Product operations (Purchase / Sort / Billing) *************************/

	public void purchaseProduct() throws SQLException {
		shoppingDao.purchaseProduct();
	}

	public void generateBill() throws ParseException, SQLException {

		shoppingDao.generateBill();
	}

//	public void productSortByCost() {
//		shoppingDao.productSortByCost();
//	}

//	public void productSortByName() {
//		shoppingDao.productSortByName();
//	}

	/************************************* User management *************************************/

	public void printUsers() throws SQLException {
		shoppingDao.printUsers();
	}

	public void createUser() throws SQLException {
		shoppingDao.createUser();
	}

	public void delUser() throws SQLException {
		shoppingDao.delUser();
	}

	public void changeUser() throws ParseException, SQLException {
		shoppingDao.changeUser();
	}
}
