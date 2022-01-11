package com.sapient.utility.beans;

public class Patents {
	
	private String date;
	private String number;
	private String office;
	private String summary;
	private String status;
	private String title;
	private String url;
	public Patents() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patents(String date, String number, String office, String summary, String status, String title, String url) {
		super();
		this.date = date;
		this.number = number;
		this.office = office;
		this.summary = summary;
		this.status = status;
		this.title = title;
		this.url = url;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
