package com.example.pttk.model;

public class Payment {
	int id;
	String method, state;
	double totalPrice, shipmentPrice, productPrice;
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(int iD, String method, String state, double shipmentPrice, double productPrice) {
		super();
		this.id = iD;
		this.method = method;
		this.state = state;
		this.shipmentPrice = shipmentPrice;
		this.productPrice = productPrice;
		this.totalPrice = shipmentPrice + productPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int iD) {
		this.id = iD;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getShipmentPrice() {
		return shipmentPrice;
	}
	public void setShipmentPrice(double shipmentPrice) {
		this.shipmentPrice = shipmentPrice;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	
	
}
