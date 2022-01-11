package com.sapient.utility.beans;

public class Education {

	private String degree;
    private Integer endYear;
    private String fieldOfStudy;
    private String school;
    private String schoolType;
    private Integer startYear;
    
	public Education() {
		super();
		
	}
	public Education(String degree, Integer endYear, String fieldOfStudy, String school, String schoolType,
			Integer startYear) {
		super();
		this.degree = degree;
		this.endYear = endYear;
		this.fieldOfStudy = fieldOfStudy;
		this.school = school;
		this.schoolType = schoolType;
		this.startYear = startYear;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	public String getFieldOfStudy() {
		return fieldOfStudy;
	}
	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}
	public Integer getEndYear() {
		return endYear;
	}
	public Integer getStartYear() {
		return startYear;
	}
	public void setEndYear(Integer endYear) {
		this.endYear = endYear;
	}
	public void setStartYear(Integer startYear) {
		this.startYear = startYear;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getSchoolType() {
		return schoolType;
	}
	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}
	   
    
}
