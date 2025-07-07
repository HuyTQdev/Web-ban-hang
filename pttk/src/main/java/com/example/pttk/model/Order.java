package com.example.pttk.model;

import java.sql.Date;

public class Order {
	int id;
	Cart cart;
	Shipment shipment;
	Payment payment;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Order(int id, Cart cart, Shipment shipment, Payment payment) {
		super();
		this.id = id;
		this.cart = cart;
		this.shipment = shipment;
		this.payment = payment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Shipment getShipment() {
		return shipment;
	}
	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
}
