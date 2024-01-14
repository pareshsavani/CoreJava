package Tasks._122823ShoppingAppDB.entity;

import java.util.Comparator;

public class Products implements Comparable<Products>{

	private int productId;
	private String productName;
	private float cost;
	
	// constructors
	public Products() {
		super();
	}

	public Products(int productId, String productName, float cost) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.cost = cost;
	}

	// getters and setters
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

	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}

	// toString() overridden
	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", cost=" + cost + "]";
	}


	@Override
	public int compareTo(Products otherProduct) {
		return Float.compare(this.cost, otherProduct.cost);
	}

	public static Comparator<Products> NameComparator = new Comparator<Products>() {
		@Override
		public int compare(Products p1, Products p2) {
			return p1.getProductName().compareTo(p2.getProductName());
		}
	};
}
