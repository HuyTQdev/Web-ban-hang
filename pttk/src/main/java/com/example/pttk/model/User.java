package com.example.pttk.model;

public class User {
	int ID;
	Account account;
	Person person;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int iD, Account account, Person person) {
		super();
		ID = iD;
		this.account = account;
		this.person = person;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
}
