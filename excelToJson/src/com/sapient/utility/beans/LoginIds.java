package com.sapient.utility.beans;

import java.util.List;

public class LoginIds {
	
	private String username;
	private List<String> emails;

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}  
   
}
