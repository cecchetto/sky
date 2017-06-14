package com.sky.bean;

/**
 * @author User
 *
 */
public class ProductBean {

	private String refCustomerID;
	private String category;
	private String product;
	private String location;
	
	public static String SPORTS_CATEGORY = "Sports";
	public static String NEWS_CATEGORY = "News";
	
	public ProductBean(String catergory,String product, String location) {
		super();
		this.category = catergory;
		this.product = product;
		this.location = location;
	}
	
	public String getRefCustomerID() {
		return refCustomerID;
	}


	public void setRefCustomerID(String refCustomerID) {
		this.refCustomerID = refCustomerID;
	}


	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}	
}
