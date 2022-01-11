package com.sapient.utility.beans;

import java.util.Set;

public class Asset {
	private String applicationInternalIdentifier;
    private String assetSerialNb;
    private String assetType;
    private String brand;
    private Set<AreaOfInterest> areaOfInterest;

	private String creationDate;
    private String details;
    private Boolean isDeleted;
    private String lastUpdateDate;
    private String model;
	private String purchaseDate;
    private String registrationDate;
    private String registrationReferenceID;
    private String source;
    private String warrantyEndDate;
    
    
  
  	public Asset() {
		super();
	}



	public Asset(String applicationInternalIdentifier, String assetSerialNb, String assetType, String brand,
			Set<AreaOfInterest> areaOfInterest, String creationDate, String details, Boolean isDeleted,
			String lastUpdateDate, String model, String purchaseDate, String registrationDate,
			String registrationReferenceID, String source, String warrantyEndDate) {
		super();
		this.applicationInternalIdentifier = applicationInternalIdentifier;
		this.assetSerialNb = assetSerialNb;
		this.assetType = assetType;
		this.brand = brand;
		this.areaOfInterest = areaOfInterest;
		this.creationDate = creationDate;
		this.details = details;
		this.isDeleted = isDeleted;
		this.lastUpdateDate = lastUpdateDate;
		this.model = model;
		this.purchaseDate = purchaseDate;
		this.registrationDate = registrationDate;
		this.registrationReferenceID = registrationReferenceID;
		this.source = source;
		this.warrantyEndDate = warrantyEndDate;
	}



	public String getApplicationInternalIdentifier() {
		return applicationInternalIdentifier;
	}



	public void setApplicationInternalIdentifier(String applicationInternalIdentifier) {
		this.applicationInternalIdentifier = applicationInternalIdentifier;
	}



	public String getAssetSerialNb() {
		return assetSerialNb;
	}



	public void setAssetSerialNb(String assetSerialNb) {
		this.assetSerialNb = assetSerialNb;
	}



	public String getAssetType() {
		return assetType;
	}



	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public Set<AreaOfInterest> getAreaOfInterest() {
		return areaOfInterest;
	}



	public void setAreaOfInterest(Set<AreaOfInterest> areaOfInterest) {
		this.areaOfInterest = areaOfInterest;
	}



	public String getCreationDate() {
		return creationDate;
	}



	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}



	public String getDetails() {
		return details;
	}



	public void setDetails(String details) {
		this.details = details;
	}



	public Boolean getIsDeleted() {
		return isDeleted;
	}



	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}



	public String getLastUpdateDate() {
		return lastUpdateDate;
	}



	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}



	public String getPurchaseDate() {
		return purchaseDate;
	}



	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}



	public String getRegistrationDate() {
		return registrationDate;
	}



	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}



	public String getRegistrationReferenceID() {
		return registrationReferenceID;
	}



	public void setRegistrationReferenceID(String registrationReferenceID) {
		this.registrationReferenceID = registrationReferenceID;
	}



	public String getSource() {
		return source;
	}



	public void setSource(String source) {
		this.source = source;
	}



	public String getWarrantyEndDate() {
		return warrantyEndDate;
	}



	public void setWarrantyEndDate(String warrantyEndDate) {
		this.warrantyEndDate = warrantyEndDate;
	}

  	
}
