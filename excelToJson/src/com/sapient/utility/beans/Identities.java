package com.sapient.utility.beans;

public class Identities {
	
	private String provider;
    public Identities() {
		super();
		
	}
    
  	private String providerUID;
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getProviderUID() {
		return providerUID;
	}
	public void setProviderUID(String providerUID) {
		this.providerUID = providerUID;
	}
}
