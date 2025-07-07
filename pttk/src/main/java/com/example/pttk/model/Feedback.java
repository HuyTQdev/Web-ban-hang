package com.example.pttk.model;

public class Feedback {
	int id;
	float rate;
	String content;
	Product product;
	Customer customer;
	public Feedback(int id, float rate, String content, Product product, Customer customer) {
		super();
		this.id = id;
		this.rate = rate;
		this.content = content;
		this.product = product;
		this.customer = customer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
