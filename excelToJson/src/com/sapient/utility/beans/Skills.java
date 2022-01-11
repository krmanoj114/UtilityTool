package com.sapient.utility.beans;

public class Skills {

	private String level;
	private String skill;
	private Integer years;
	public Skills() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Skills(String level, String skill, Integer years) {
		super();
		this.level = level;
		this.skill = skill;
		this.years = years;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public Integer getYears() {
		return years;
	}
	public void setYears(Integer years) {
		this.years = years;
	}
	
	
}
