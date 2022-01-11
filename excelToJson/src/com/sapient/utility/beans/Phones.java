package com.sapient.utility.beans;

public class Phones {
	
	private String Default;
	private String number;
	private String type;
	public Phones() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Phones(String default1, String number, String type) {
		super();
		Default = default1;
		this.number = number;
		this.type = type;
	}
	public String getDefault() {
		return Default;
	}
	public void setDefault(String default1) {
		Default = default1;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
