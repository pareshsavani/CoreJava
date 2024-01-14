package Tasks._122823ShoppingAppDB.entity;
import java.time.LocalDate;
import java.util.Comparator;

public class Orders implements Comparator<Orders> {

	private int orderId;
	private LocalDate orderDate;
	private int customerId;
	private String customerName;
	private int productId;
	private String productName;
	private float productCost;
	private int orderQuantity;
	private float orderAmt;
	
	// constructors
	public Orders() {
		super();
	}
	public Orders(int orderId, int orderQuantity) {
		super();
		this.orderId = orderId;
		this.orderQuantity = orderQuantity;
	}

	// getters and setters
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate date) {
		this.orderDate = date;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public float getProductCost() {
		return productCost;
	}
	public void setProductCost(float productCost) {
		this.productCost = productCost;
	}
	
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	
	public float getOrderAmt() {
		return orderAmt;
	}
	public void setOrderAmt(float orderAmt) {
		this.orderAmt = orderAmt;
	}
	
	// toString() overridden
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderQuantity=" + orderQuantity + "]";
	}
	@Override
	public int compare(Orders o1, Orders o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
