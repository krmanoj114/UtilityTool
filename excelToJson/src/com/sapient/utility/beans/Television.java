package com.sapient.utility.beans;

public class Television {

	private String category;
	private String id;
	private String name;
	
	public Television() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Television(String category, String id, String name) {
		super();
		this.category = category;
		this.id = id;
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
