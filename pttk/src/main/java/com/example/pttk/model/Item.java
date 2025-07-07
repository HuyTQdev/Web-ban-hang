package com.example.pttk.model;

public class Item {
	int id, quantity;
	Product product;
	
	@Override
	public String toString() {
		return "Item [ID=" + id + ", quantity=" + quantity + ", product=" + product + ", getID()=" + getId()
				+ ", getQuantity()=" + getQuantity() + ", getProduct()=" + getProduct() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Item(int id, int quantity, Product product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.product = product;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

}
