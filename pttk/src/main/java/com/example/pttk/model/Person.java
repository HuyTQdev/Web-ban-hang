package com.example.pttk.model;

import java.sql.Date;

import org.springframework.aop.scope.DefaultScopedObject;

public class Person {
	int ID;
	FullName fullName;
	Address address;
	Date dob;
	Boolean sex;
	String phoneNum;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(int iD, FullName fullName, Address address, Date dob, Boolean sex, String phoneNum) {
		super();
		ID = iD;
		this.fullName = fullName;
		this.address = address;
		this.dob = dob;
		this.sex = sex;
		this.phoneNum = phoneNum;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public FullName getFullName() {
		return fullName;
	}
	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	
	
}
