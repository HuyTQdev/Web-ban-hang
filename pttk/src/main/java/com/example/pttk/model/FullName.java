package com.example.pttk.model;

public class FullName {
	String fName, mName, lName;

	public FullName() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return lName + " " + mName + " " + fName;
	}

	public FullName(String fName, String mName, String lName) {
		super();
		this.fName = fName;
		this.mName = mName;
		this.lName = lName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}
	
}
