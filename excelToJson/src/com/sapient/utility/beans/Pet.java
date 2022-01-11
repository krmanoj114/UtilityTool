package com.sapient.utility.beans;

import java.util.Set;

import com.sapient.utility.convert.SchemaService;

public class Pet {
	
	private String applicationInternalIdentifier;
    private String birthDate;
    private String name;
    private String petSizeCode;
    private Set<AreaOfInterest> areaOfInterest;
    private Set<DigitalAsset> digitalAsset;
    
    
    private String adoptionDate;
    private String adoptionSource;
    private Integer birthDateReliability;
    private String breed;
    private String creationDate;
    private Boolean dentalHealth;
    private Boolean digestiveSensitivity;
    private String dryFoodBrand;
    
    private Boolean hairballCare;
    private Boolean indoorPet;
    private Boolean isDeleted;
    private Boolean kidneyHealth;
    private String lastUpdateDate;
    private Boolean neutered;
    private Boolean overweight;
    private String petNutrition;
    private String petTypeCode;
    private Boolean pregnantNursing;
    private Boolean senior;
    
    private Integer sex;
    private Boolean skinSensitivity;
    private Boolean urinarySystemSensitivity;
    private String wetFoodBrand;
    private Boolean workingDog;
    private Boolean young;
    private String furType;
    private String coatColor;
    private String size;
    private String type; 
    
	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Pet(String applicationInternalIdentifier, String birthDate, String name, String petSizeCode,
			Set<AreaOfInterest> areaOfInterest, Set<DigitalAsset> digitalAsset, String adoptionDate,
			String adoptionSource, Integer birthDateReliability, String breed, String creationDate, Boolean dentalHealth,
			Boolean digestiveSensitivity, String dryFoodBrand, Boolean hairballCare, Boolean indoorPet,
			Boolean isDeleted, Boolean kidneyHealth, String lastUpdateDate, Boolean neutered, Boolean overweight,
			String petNutrition, String petTypeCode, Boolean pregnantNursing, Boolean senior, Integer sex,
			Boolean skinSensitivity, Boolean urinarySystemSensitivity, String wetFoodBrand, Boolean workingDog,
			Boolean young, String furType, String coatColor, String size, String type) {
		super();
		this.applicationInternalIdentifier = applicationInternalIdentifier;
		this.birthDate = birthDate;
		this.name = name;
		this.petSizeCode = petSizeCode;
		this.areaOfInterest = areaOfInterest;
		this.digitalAsset = digitalAsset;
		this.adoptionDate = adoptionDate;
		this.adoptionSource = adoptionSource;
		this.birthDateReliability = birthDateReliability;
		this.breed = breed;
		this.creationDate = creationDate;
		this.dentalHealth = dentalHealth;
		this.digestiveSensitivity = digestiveSensitivity;
		this.dryFoodBrand = dryFoodBrand;
		this.hairballCare = hairballCare;
		this.indoorPet = indoorPet;
		this.isDeleted = isDeleted;
		this.kidneyHealth = kidneyHealth;
		this.lastUpdateDate = lastUpdateDate;
		this.neutered = neutered;
		this.overweight = overweight;
		this.petNutrition = petNutrition;
		this.petTypeCode = petTypeCode;
		this.pregnantNursing = pregnantNursing;
		this.senior = senior;
		this.sex = sex;
		this.skinSensitivity = skinSensitivity;
		this.urinarySystemSensitivity = urinarySystemSensitivity;
		this.wetFoodBrand = wetFoodBrand;
		this.workingDog = workingDog;
		this.young = young;
		this.furType = furType;
		this.coatColor = coatColor;
		this.size = size;
		this.type = type;
	}


	public String getApplicationInternalIdentifier() {
		return applicationInternalIdentifier;
	}
	public void setApplicationInternalIdentifier(String applicationInternalIdentifier) {
		this.applicationInternalIdentifier = applicationInternalIdentifier;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPetSizeCode() {
		return petSizeCode;
	}
	public void setPetSizeCode(String petSizeCode) {
		this.petSizeCode = petSizeCode;
	}
	public String getAdoptionDate() {
		return adoptionDate;
	}
	public void setAdoptionDate(String adoptionDate) {
		this.adoptionDate = adoptionDate;
	}
	public String getAdoptionSource() {
		return adoptionSource;
	}
	public void setAdoptionSource(String adoptionSource) {
		this.adoptionSource = adoptionSource;
	}
	
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = new SchemaService().setTimestampFormat(creationDate);
	}
	public Boolean getDentalHealth() {
		return dentalHealth;
	}
	public void setDentalHealth(Boolean dentalHealth) {
		this.dentalHealth = dentalHealth;
	}
	public Boolean getDigestiveSensitivity() {
		return digestiveSensitivity;
	}
	public void setDigestiveSensitivity(Boolean digestiveSensitivity) {
		this.digestiveSensitivity = digestiveSensitivity;
	}
	public String getDryFoodBrand() {
		return dryFoodBrand;
	}
	public void setDryFoodBrand(String dryFoodBrand) {
		this.dryFoodBrand = dryFoodBrand;
	}
	
	public Boolean getHairballCare() {
		return hairballCare;
	}
	public void setHairballCare(Boolean hairballCare) {
		this.hairballCare = hairballCare;
	}
	public Boolean getIndoorPet() {
		return indoorPet;
	}
	public void setIndoorPet(Boolean indoorPet) {
		this.indoorPet = indoorPet;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Boolean getKidneyHealth() {
		return kidneyHealth;
	}
	public void setKidneyHealth(Boolean kidneyHealth) {
		this.kidneyHealth = kidneyHealth;
	}
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}
	
	public Boolean getNeutered() {
		return neutered;
	}
	public void setNeutered(Boolean neutered) {
		this.neutered = neutered;
	}
	public Boolean getOverweight() {
		return overweight;
	}
	public void setOverweight(Boolean overweight) {
		this.overweight = overweight;
	}
	public String getPetNutrition() {
		return petNutrition;
	}
	public void setPetNutrition(String petNutrition) {
		this.petNutrition = petNutrition;
	}
	public String getPetTypeCode() {
		return petTypeCode;
	}
	public void setPetTypeCode(String petTypeCode) {
		this.petTypeCode = petTypeCode;
	}
	public Boolean getPregnantNursing() {
		return pregnantNursing;
	}
	public void setPregnantNursing(Boolean pregnantNursing) {
		this.pregnantNursing = pregnantNursing;
	}
	
	public Boolean getSenior() {
		return senior;
	}
	public void setSenior(Boolean senior) {
		this.senior = senior;
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


	public Boolean getSkinSensitivity() {
		return skinSensitivity;
	}
	public void setSkinSensitivity(Boolean skinSensitivity) {
		this.skinSensitivity = skinSensitivity;
	}
	public Boolean getUrinarySystemSensitivity() {
		return urinarySystemSensitivity;
	}
	public void setUrinarySystemSensitivity(Boolean urinarySystemSensitivity) {
		this.urinarySystemSensitivity = urinarySystemSensitivity;
	}
	public String getWetFoodBrand() {
		return wetFoodBrand;
	}
	public void setWetFoodBrand(String wetFoodBrand) {
		this.wetFoodBrand = wetFoodBrand;
	}
	public Boolean getWorkingDog() {
		return workingDog;
	}
	public void setWorkingDog(Boolean workingDog) {
		this.workingDog = workingDog;
	}
	public Boolean getYoung() {
		return young;
	}
	public void setYoung(Boolean young) {
		this.young = young;
	}
	public String getFurType() {
		return furType;
	}
	public void setFurType(String furType) {
		this.furType = furType;
	}
	public String getCoatColor() {
		return coatColor;
	}
	public void setCoatColor(String coatColor) {
		this.coatColor = coatColor;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Set<AreaOfInterest> getAreaOfInterest() {
		return areaOfInterest;
	}
	public void setAreaOfInterest(Set<AreaOfInterest> areaOfInterest) {
		this.areaOfInterest = areaOfInterest;
	}
	public Set<DigitalAsset> getDigitalAsset() {
		return digitalAsset;
	}
	public void setDigitalAsset(Set<DigitalAsset> digitalAsset) {
		this.digitalAsset = digitalAsset;
	}


	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = new SchemaService().setTimestampFormat(lastUpdateDate);
	}

	
}
