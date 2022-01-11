package com.sapient.utility.beans;

public class Certifications {

	private String authority;
    private String endDate;
    private String name;
    private String number;
    private String startDate;
    
    
	public Certifications() {
		super();
		
	}
	public Certifications(String authority, String endDate, String name, String number, String startDate) {
		super();
		this.authority = authority;
		this.endDate = endDate;
		this.name = name;
		this.number = number;
		this.startDate = startDate;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
    
    
}
