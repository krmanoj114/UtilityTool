package com.sapient.utility.beans;

import org.apache.commons.lang.StringEscapeUtils;

public class Password {
	
	
    private String compoundHashedPassword;
   	private String hashedPassword;
    private HashSettings hashSettings;

	public HashSettings getHashSettings() {
		return hashSettings;
	}

	public void setHashSettings(HashSettings hashSettings) {
		this.hashSettings = hashSettings;
	}

	public String getCompoundHashedPassword() {
		return StringEscapeUtils.unescapeJava(compoundHashedPassword);
	}

	public void setCompoundHashedPassword(String compoundHashedPassword) {
		this.compoundHashedPassword = compoundHashedPassword;
	}

	public String getHashedPassword() {
		return StringEscapeUtils.unescapeJava(hashedPassword);
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	
	
}
