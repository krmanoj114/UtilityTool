package com.sapient.utility.beans;

import java.util.Set;

public class LastLoginLocation {
	
	private String city;
	private Set<Coordinates> coordinates;
	private String country;
	private String state;
	
	public LastLoginLocation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LastLoginLocation(String city, Set<Coordinates> coordinates, String country, String state) {
		super();
		this.city = city;
		this.coordinates = coordinates;
		this.country = country;
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<Coordinates> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Set<Coordinates> coordinates) {
		this.coordinates = coordinates;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
