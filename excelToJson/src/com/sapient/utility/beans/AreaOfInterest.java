package com.sapient.utility.beans;

import com.sapient.utility.convert.SchemaService;

public class AreaOfInterest {
	
	private String interestCode;
    private String answerDetails;
    private String creationDate;
    private String lastUpdateDate;
    private Boolean flag;
        
    public AreaOfInterest(){}

   public AreaOfInterest(String interestCode, String answerDetails, String creationDate, String lastUpdateDate, Boolean flag) {
       super();
       this.interestCode = interestCode;
       this.answerDetails = answerDetails;
       this.creationDate = creationDate;
       this.lastUpdateDate = lastUpdateDate;
       this.flag = flag;
        
   }

   public String getinterestCode() {
       return interestCode;
   }

   public void setinterestCode(String interestCode) {
       this.interestCode = interestCode;
   }

   public String getanswerDetails() {
       return answerDetails;
   }
   
   
   public void setanswerDetails(String answerDetails) {
       this.answerDetails = answerDetails;
   }
   
   public String getcreationDate() {
       return creationDate;
   }
   
   
   public void setcreationDate(String creationDate) {

	   this.creationDate = new SchemaService().setTimestampFormat(creationDate);
   }
   public String getlastUpdateDate() {
       
	   return lastUpdateDate;
   }
   
   
   public void setlastUpdateDate(String lastUpdateDate) {
	   this.lastUpdateDate = new SchemaService().setTimestampFormat(lastUpdateDate);
   }

   public Boolean getFlag() {
	   return flag;
   }

   public void setFlag(Boolean flag) {
	   this.flag = flag;
   }

   
   
}
