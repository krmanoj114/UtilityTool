package com.sapient.utility.beans;

public class Work {

	private String company;
	private String companyID;
	private String companySize;
	private String description;
	private String endDate;
	private String industry;
	private Boolean isCurrent;
	private String location;
	private String startDate;
	private String title;
	public Work() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Work(String company, String companyID, String companySize, String description, String endDate,
			String industry, String location, String startDate, String title, Boolean isCurrent) {
		super();
		this.company = company;
		this.companyID = companyID;
		this.companySize = companySize;
		this.description = description;
		this.endDate = endDate;
		this.industry = industry;
		this.isCurrent = isCurrent;
		this.location = location;
		this.startDate = startDate;
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompanyID() {
		return companyID;
	}
	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}
	public String getCompanySize() {
		return companySize;
	}
	public void setCompanySize(String companySize) {
		this.companySize = companySize;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getIsCurrent() {
		return isCurrent;
	}
	public void setIsCurrent(Boolean isCurrent) {
		this.isCurrent = isCurrent;
	}
	
	
}
