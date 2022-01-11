package com.sapient.utility.beans;

public class Likes {
	
	private String category;
	private String id;
	private String name;
	private String time;
	private String timestamp;
	
	public Likes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Likes(String category, String id, String name, String time, String timestamp) {
		super();
		this.category = category;
		this.id = id;
		this.name = name;
		this.time = time;
		this.timestamp = timestamp;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}	

}
