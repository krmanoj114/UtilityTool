package com.sapient.utility.beans;

import com.sapient.utility.convert.SchemaService;

public class ExternalApplication {
	
	private String applicationCode;
    private String internalIdentifier;
    private String internalAlternateIdentifier;
    private String creationDate;
    private String lastUpdateDate;
    
   

    public ExternalApplication(){}

   public ExternalApplication(String applicationCode, String internalIdentifier, String internalAlternateIdentifier, String creationDate, String lastUpdateDate) {
       super();
       this.applicationCode = applicationCode;
       this.internalIdentifier = internalIdentifier;
       this.internalAlternateIdentifier = internalAlternateIdentifier;
       this.creationDate = creationDate;
       this.lastUpdateDate = lastUpdateDate;
        
   }

   public String getapplicationCode() {
       return applicationCode;
   }

   public void setapplicationCode(String applicationCode) {
       this.applicationCode = applicationCode;
   }

   public String getinternalIdentifier() {
       return internalIdentifier;
   }
   
   
   public void setinternalIdentifier(String internalIdentifier) {
       this.internalIdentifier = internalIdentifier;
   }
   
   public String getinternalAlternateIdentifier() {
       return internalAlternateIdentifier;
   }
   
   
   public void setinternalAlternateIdentifier(String internalAlternateIdentifier) {
       this.internalAlternateIdentifier = internalAlternateIdentifier;
   }
   
   public String getcreationDate() {
       return creationDate;
   }
   
   
   public void setcreationDate(String creationDate) {
	
	   this.creationDate = new SchemaService().setTimestampFormat(creationDate);;
   }
   public String getlastUpdateDate() {
       return lastUpdateDate;
   }
   
   
   public void setlastUpdateDate(String lastUpdateDate) {
	
	   this.lastUpdateDate = new SchemaService().setTimestampFormat(lastUpdateDate);;
   }

   
}
