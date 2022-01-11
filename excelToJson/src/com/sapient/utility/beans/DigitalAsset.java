package com.sapient.utility.beans;

public class DigitalAsset {
	
	private String creationDate;
    private String typeOfInformation;
    private String uniformResourceIdentifier;
      
    
    
	public DigitalAsset() {
		super();
		// TODO Auto-generated constructor stub
	}



	public DigitalAsset(String creationDate, String typeOfInformation, String uniformResourceIdentifier) {
		super();
		this.creationDate = creationDate;
		this.typeOfInformation = typeOfInformation;
		this.uniformResourceIdentifier = uniformResourceIdentifier;
	}



	public String getCreationDate() {
		return creationDate;
	}



	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}



	public String getTypeOfInformation() {
		return typeOfInformation;
	}



	public void setTypeOfInformation(String typeOfInformation) {
		this.typeOfInformation = typeOfInformation;
	}



	public String getUniformResourceIdentifier() {
		return uniformResourceIdentifier;
	}



	public void setUniformResourceIdentifier(String uniformResourceIdentifier) {
		this.uniformResourceIdentifier = uniformResourceIdentifier;
	}
	
	
}
