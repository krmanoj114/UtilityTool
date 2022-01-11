package com.sapient.utility.beans;

import java.util.List;

public class Emails {
	
    private List<String> verified;
    private List<String> unverified;
    
	
	public List<String> getVerified() {
		return verified;
	}
	public void setVerified(List<String> verified) {
		this.verified = verified;
	}
	public List<String> getUnverified() {
		return unverified;
	}
	public void setUnverified(List<String> unverified) {
		this.unverified = unverified;
	}   
	  
}
