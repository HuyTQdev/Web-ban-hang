package com.example.pttk.model;

import java.util.List;

public class Cart {
	int id;
	int idCus;
	List<Item> productsList;
	double totalPrice;
	@Override
	public String toString() {
		return "Cart [ID=" + id + ", idCus=" + idCus + ", productsList=" + productsList + ", getID()=" + getId()
				+ ", getIdCus()=" + getIdCus() + ", getProductsList()=" + getProductsList() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public Cart(int id, int idCus, List<Item> productsList) {
		super();
		this.id = id;
		this.idCus = idCus;
		this.productsList = productsList;
		this.totalPrice = 0;
		for (Item item : productsList) {
			this.totalPrice += item.quantity * item.product.getPrice();
		}
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public int getIdCus() {
		return idCus;
	}
	public void setIdCus(int idCus) {
		this.idCus = idCus;
	}
	public List<Item> getProductsList() {
		return productsList;
	}
	public void setProductsList(List<Item> productsList) {
		this.productsList = productsList;
	}

	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
