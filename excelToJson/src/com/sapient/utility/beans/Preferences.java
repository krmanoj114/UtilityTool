package com.sapient.utility.beans;

import java.util.HashMap;
import java.util.Map;

public class Preferences {
	
		
	private Map<String, HashMap<String, Object>> terms;

	public Preferences() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Map<String, HashMap<String, Object>> getTerms() {
		return terms;
	}

	public void setTerms(Map<String, HashMap<String, Object>> terms) {
		this.terms = terms;
	}

	public Preferences(Map<String, HashMap<String, Object>> terms) {
		super();
		this.terms = terms;
	}	

	
}
