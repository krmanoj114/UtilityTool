package com.sapient.utility.beans;

import java.util.Set;

public class OidcData {
	
	private Set<Address> address;
	private String email_verified;
	private String locale;
	private String middle_name;
	private String name;
	private String phone_number;
	private String phone_number_verified;
	private String updated_at;
	private String website;
	private String zoneinfo;
	
	public OidcData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OidcData(Set<Address> address, String email_verified, String locale, String middle_name, String name,
			String phone_number, String phone_number_verified, String updated_at, String website, String zoneinfo) {
		super();
		this.address = address;
		this.email_verified = email_verified;
		this.locale = locale;
		this.middle_name = middle_name;
		this.name = name;
		this.phone_number = phone_number;
		this.phone_number_verified = phone_number_verified;
		this.updated_at = updated_at;
		this.website = website;
		this.zoneinfo = zoneinfo;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public String getEmail_verified() {
		return email_verified;
	}

	public void setEmail_verified(String email_verified) {
		this.email_verified = email_verified;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getPhone_number_verified() {
		return phone_number_verified;
	}

	public void setPhone_number_verified(String phone_number_verified) {
		this.phone_number_verified = phone_number_verified;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getZoneinfo() {
		return zoneinfo;
	}

	public void setZoneinfo(String zoneinfo) {
		this.zoneinfo = zoneinfo;
	}	

}
