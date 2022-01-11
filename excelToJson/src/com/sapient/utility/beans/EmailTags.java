package com.sapient.utility.beans;

public class EmailTags {
	
	private String sourceApplication;
    
    public EmailTags(){}

   public EmailTags(String sourceApplication) {
       super();
       this.sourceApplication = sourceApplication;        
   }

   public String getsourceApplication() {
       return sourceApplication;
   }

   public void setsourceApplication(String sourceApplication) {
       this.sourceApplication = sourceApplication;
   }

   
}
