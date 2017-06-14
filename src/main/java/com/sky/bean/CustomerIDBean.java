package com.sky.bean;

import java.util.List;

public class CustomerIDBean {

	private String customerID;
	private List<ProductBean> basket;
	
	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public List<ProductBean> getBasket() {
		return basket;
	}

	public void setBasket(List<ProductBean> basket) {
		this.basket = basket;
	}
}
