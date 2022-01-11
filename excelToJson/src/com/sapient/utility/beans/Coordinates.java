package com.sapient.utility.beans;

public class Coordinates {
	
	private Integer lat;
	private Integer lon;
	
	
	
	public Coordinates() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Coordinates(Integer lat, Integer lon) {
		super();
		this.lat = lat;
		this.lon = lon;
	}

	public Integer getLat() {
		return lat;
	}

	public Integer getLon() {
		return lon;
	}

	public void setLat(Integer lat) {
		this.lat = lat;
	}

	public void setLon(Integer lon) {
		this.lon = lon;
	}
	
	
	
}
