package com.example.pttk.model;

import java.sql.Date;

public class Shipment {
	int id;
	Address address;
	String type;
	Double fee;
	
	public Shipment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shipment(int id, Address address, String type) {
		super();
		this.id = id;
		this.address = address;
		this.type = type;
		if(type == "Fast") this.fee = 30000.0;
		else this.fee = 10000.0;
	}

	public int getId() {
		return id;
	}

	public void setId(int iD) {
		this.id = iD;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
	
	
}
