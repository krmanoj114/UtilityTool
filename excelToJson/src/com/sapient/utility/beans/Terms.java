package com.sapient.utility.beans;

import java.util.List;
import com.sapient.utility.convert.SchemaService;

public class Terms {
	
	private Boolean isConsentGranted;
    private String lastConsentModified;
    private String docDate;
   // private float docVersion;
  
    
    private List<String> tags; 
  
	public Boolean getIsConsentGranted() {
		return isConsentGranted;
	}
	public void setIsConsentGranted(Boolean isConsentGranted) {
		this.isConsentGranted = isConsentGranted;
	}
	public String getLastConsentModified() {
		return lastConsentModified;
	}
	public void setLastConsentModified(String lastConsentModified) {
		this.lastConsentModified = new SchemaService().setTimestampFormat(lastConsentModified);
	}
	public String getDocDate() {
		return docDate;
	}
	public void setDocDate(String docDate) {
		this.docDate = new SchemaService().setTimestampFormat(docDate);
	}
	
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	
	
	  
}
