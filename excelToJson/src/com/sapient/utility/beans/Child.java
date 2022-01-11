package com.sapient.utility.beans;

import java.util.Set;

public class Child {
	
	private String applicationInternalIdentifier;
	private Set<AreaOfInterest> areaOfInterest;
	private String atopicRisk;
    private String birthDate;
    private String firstName;
    private Integer birthDateReliability;
    private Integer sex;
    private String creationDate;
    private Set<DigitalAsset> digitalAsset;
    private String feeding;
    private String initials;
    private Boolean isDeleted;
    private Boolean isWomanFirstPregnancy;
    private String lastUpdateDate;
    private Integer multipleBirth;
    private String relationshipType;
    
	public Child() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Child(String applicationInternalIdentifier, Set<AreaOfInterest> areaOfInterest, String atopicRisk,
			String birthDate, String firstName, Integer birthDateReliability, Integer sex, String creationDate,
			Set<DigitalAsset> digitalAsset, String feeding, String initials, Boolean isDeleted,
			Boolean isWomanFirstPregnancy, String lastUpdateDate, Integer multipleBirth, String relationshipType) {
		super();
		this.applicationInternalIdentifier = applicationInternalIdentifier;
		this.areaOfInterest = areaOfInterest;
		this.atopicRisk = atopicRisk;
		this.birthDate = birthDate;
		this.firstName = firstName;
		this.birthDateReliability = birthDateReliability;
		this.sex = sex;
		this.creationDate = creationDate;
		this.digitalAsset = digitalAsset;
		this.feeding = feeding;
		this.initials = initials;
		this.isDeleted = isDeleted;
		this.isWomanFirstPregnancy = isWomanFirstPregnancy;
		this.lastUpdateDate = lastUpdateDate;
		this.multipleBirth = multipleBirth;
		this.relationshipType = relationshipType;
	}
	public String getApplicationInternalIdentifier() {
		return applicationInternalIdentifier;
	}
	public void setApplicationInternalIdentifier(String applicationInternalIdentifier) {
		this.applicationInternalIdentifier = applicationInternalIdentifier;
	}
	public Set<AreaOfInterest> getAreaOfInterest() {
		return areaOfInterest;
	}
	public void setAreaOfInterest(Set<AreaOfInterest> areaOfInterest) {
		this.areaOfInterest = areaOfInterest;
	}
	public String getAtopicRisk() {
		return atopicRisk;
	}
	public void setAtopicRisk(String atopicRisk) {
		this.atopicRisk = atopicRisk;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public Set<DigitalAsset> getDigitalAsset() {
		return digitalAsset;
	}
	public void setDigitalAsset(Set<DigitalAsset> digitalAsset) {
		this.digitalAsset = digitalAsset;
	}
	public String getFeeding() {
		return feeding;
	}
	public void setFeeding(String feeding) {
		this.feeding = feeding;
	}
	public String getInitials() {
		return initials;
	}
	public void setInitials(String initials) {
		this.initials = initials;
	}
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
	public Integer getBirthDateReliability() {
		return birthDateReliability;
	}
	public void setBirthDateReliability(Integer birthDateReliability) {
		this.birthDateReliability = birthDateReliability;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getMultipleBirth() {
		return multipleBirth;
	}
	public void setMultipleBirth(Integer multipleBirth) {
		this.multipleBirth = multipleBirth;
	}
	public String getRelationshipType() {
		return relationshipType;
	}
	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Boolean getIsWomanFirstPregnancy() {
		return isWomanFirstPregnancy;
	}
	public void setIsWomanFirstPregnancy(Boolean isWomanFirstPregnancy) {
		this.isWomanFirstPregnancy = isWomanFirstPregnancy;
	}
	
   
}
