package com.sapient.utility.beans;

public class Address {

	private String country;
	private String formatted;
	private String locality;
	private String postal_code;
	private String region;
	private String street_address;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String country, String formatted, String locality, String postal_code, String region,
			String street_address) {
		super();
		this.country = country;
		this.formatted = formatted;
		this.locality = locality;
		this.postal_code = postal_code;
		this.region = region;
		this.street_address = street_address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getFormatted() {
		return formatted;
	}
	public void setFormatted(String formatted) {
		this.formatted = formatted;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getStreet_address() {
		return street_address;
	}
	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}
	
	
	
}
