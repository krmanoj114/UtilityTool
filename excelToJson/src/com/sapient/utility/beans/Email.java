package com.sapient.utility.beans;

import java.util.List;

import com.sapient.utility.convert.SchemaService;

public class Email {
	
	private Boolean isSubscribed;
    private String lastUpdatedSubscriptionState;
    private List<String> tags;
  
	public Boolean getIsSubscribed() {
		return isSubscribed;
	}
	public void setIsSubscribed(Boolean isSubscribed) {
		this.isSubscribed = isSubscribed;
	}
	public String getLastUpdatedSubscriptionState() {
		return lastUpdatedSubscriptionState;
	}
	public void setLastUpdatedSubscriptionState(String lastUpdatedSubscriptionState) {
		
		this.lastUpdatedSubscriptionState = new SchemaService().setTimestampFormat(lastUpdatedSubscriptionState);
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	  
}
