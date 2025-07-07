package com.example.pttk.model;

public class Address {
	int id;
	String road, town, district, city;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return road +", " + town + ", " + district +", " +city;
	}
	public Address(int id, String road, String town, String district, String city) {
		super();
		this.id = id;
		this.road = road;
		this.town = town;
		this.district = district;
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoad() {
		return road;
	}
	public void setRoad(String road) {
		this.road = road;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
