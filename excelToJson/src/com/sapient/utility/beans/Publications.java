package com.sapient.utility.beans;

public class Publications {
	
	private String date;
	private String publisher;
	private String summary;
	private String title;
	private String url;
	public Publications() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Publications(String date, String publisher, String summary, String title, String url) {
		super();
		this.date = date;
		this.publisher = publisher;
		this.summary = summary;
		this.title = title;
		this.url = url;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
