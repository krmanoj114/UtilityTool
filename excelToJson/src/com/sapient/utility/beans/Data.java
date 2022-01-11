package com.sapient.utility.beans;

import java.util.HashMap;
import java.util.Set;

public class Data {
	
	private String mobile;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String birthDate;
    private Integer birthDateReliability;
    private String initialAppSourceCode;
    private String region;
    private String title;
    private String education;
    private Set<ExternalApplication> externalApplication;
    private Set<Child> child;
    private Set<Pet> pet;
    private Set<Asset> asset;
    private Set<AreaOfInterest> areaOfInterest;
    private String additionalName1;
    private String occupation;
    private String phone;
    private String companyName;
    private String prefferedLanguageCode;
    private String nutritionCookingLevel;
    private String nutritionCookingFrequency;
    private Set<NutritionCookingLikes> nutritionCookingLikes;
    private Set<NutritionCookingDislikes> nutritionCookingDislikes;
    private Set<NutritionCookingFor> nutritionCookingFor;
    private Set<NutritionCookingStyle> nutritionCookingStyle;
    private Set<NutritionDiet> nutritionDiet;
    private Set<Optin> optin;
    private Integer householdAdultsCount;
    private String emailDataQualityStatus;
    private String additionalName2;
    private Boolean doNotContactAddress;
    private Boolean doNotContactEmail;
    private Boolean doNotContactMobile;
    private Boolean doNotContactPhone;
    private String addressDataQualityStatus;
    private Boolean isPrimary;
    private String dataQualityStatus;
    private String gigsys_ignore;
    private Integer gigyaImportJobID;
    private String zipCodeExtension;
    private String mobileDataQualityStatus;
    private String phoneDataQualityStatus; 
    private Boolean isPostalAddressValid;
    private Boolean isEmailValid;
    private Boolean subscribe;
    private Boolean terms;
    private Integer householdResidentsCount;
    private Boolean householdOwnsPets;
    private Boolean isPhoneValid;
    private Boolean isMobileValid;
    private  Boolean householdOwnsCats;
    private Boolean householdOwnsDogs;
    private Integer householdCatsCount;
    private Integer householdChildrenCount;
    private Integer householdDogsCount;
    private Integer householdOtherPetsCount;
    private Boolean isContactDisallowed;
    private String maritalStatus;
    private Boolean isDeleted;
    private String salutation;
    private Boolean nutritionSensitiveRisk; 
    private Set<DigitalAsset> digitalAsset; 
    private Boolean gigsys_RGdamak;
    private Integer marketCode;
    private String consumerType;
    private String countryCode;
    
    private HashMap<String, Boolean> gigsys;

   public Data() {
		super();
   }

public Data(String mobile, String addressLine1, String addressLine2, String addressLine3, String addressLine4,
		String birthDate, Integer birthDateReliability, String initialAppSourceCode, String region, String title,
		String education, Set<ExternalApplication> externalApplication, Set<Child> child, Set<Pet> pet,
		Set<Asset> asset, Set<AreaOfInterest> areaOfInterest, String additionalName1, String occupation, String phone,
		String companyName, String prefferedLanguageCode, String nutritionCookingLevel,
		String nutritionCookingFrequency, Set<NutritionCookingLikes> nutritionCookingLikes,
		Set<NutritionCookingDislikes> nutritionCookingDislikes, Set<NutritionCookingFor> nutritionCookingFor,
		Set<NutritionCookingStyle> nutritionCookingStyle, Set<NutritionDiet> nutritionDiet, Set<Optin> optin,
		Integer householdAdultsCount, String emailDataQualityStatus, String additionalName2, Boolean doNotContactAddress,
		Boolean doNotContactEmail, Boolean doNotContactMobile, Boolean doNotContactPhone,
		String addressDataQualityStatus, Boolean isPrimary, String dataQualityStatus, String gigsys_ignore,
		Integer gigyaImportJobID, String zipCodeExtension, String mobileDataQualityStatus, String phoneDataQualityStatus,
		Boolean isPostalAddressValid, Boolean isEmailValid, Boolean subscribe, Boolean terms,
		Integer householdResidentsCount, Boolean householdOwnsPets, Boolean isPhoneValid, Boolean isMobileValid,
		Boolean householdOwnsCats, Boolean householdOwnsDogs, Integer householdCatsCount, Integer householdChildrenCount,
		Integer householdDogsCount, Integer householdOtherPetsCount, Boolean isContactDisallowed, String maritalStatus,
		Boolean isDeleted, String salutation, Boolean nutritionSensitiveRisk, Set<DigitalAsset> digitalAsset,
		Boolean gigsys_RGdamak, Integer marketCode, String consumerType, String countryCode) {
	super();
	this.mobile = mobile;
	this.addressLine1 = addressLine1;
	this.addressLine2 = addressLine2;
	this.addressLine3 = addressLine3;
	this.addressLine4 = addressLine4;
	this.birthDate = birthDate;
	this.birthDateReliability = birthDateReliability;
	this.initialAppSourceCode = initialAppSourceCode;
	this.region = region;
	this.title = title;
	this.education = education;
	this.externalApplication = externalApplication;
	this.child = child;
	this.pet = pet;
	this.asset = asset;
	this.areaOfInterest = areaOfInterest;
	this.additionalName1 = additionalName1;
	this.occupation = occupation;
	this.phone = phone;
	this.companyName = companyName;
	this.prefferedLanguageCode = prefferedLanguageCode;
	this.nutritionCookingLevel = nutritionCookingLevel;
	this.nutritionCookingFrequency = nutritionCookingFrequency;
	this.nutritionCookingLikes = nutritionCookingLikes;
	this.nutritionCookingDislikes = nutritionCookingDislikes;
	this.nutritionCookingFor = nutritionCookingFor;
	this.nutritionCookingStyle = nutritionCookingStyle;
	this.nutritionDiet = nutritionDiet;
	this.optin = optin;
	this.householdAdultsCount = householdAdultsCount;
	this.emailDataQualityStatus = emailDataQualityStatus;
	this.additionalName2 = additionalName2;
	this.doNotContactAddress = doNotContactAddress;
	this.doNotContactEmail = doNotContactEmail;
	this.doNotContactMobile = doNotContactMobile;
	this.doNotContactPhone = doNotContactPhone;
	this.addressDataQualityStatus = addressDataQualityStatus;
	this.isPrimary = isPrimary;
	this.dataQualityStatus = dataQualityStatus;
	this.gigsys_ignore = gigsys_ignore;
	this.gigyaImportJobID = gigyaImportJobID;
	this.zipCodeExtension = zipCodeExtension;
	this.mobileDataQualityStatus = mobileDataQualityStatus;
	this.phoneDataQualityStatus = phoneDataQualityStatus;
	this.isPostalAddressValid = isPostalAddressValid;
	this.isEmailValid = isEmailValid;
	this.subscribe = subscribe;
	this.terms = terms;
	this.householdResidentsCount = householdResidentsCount;
	this.householdOwnsPets = householdOwnsPets;
	this.isPhoneValid = isPhoneValid;
	this.isMobileValid = isMobileValid;
	this.householdOwnsCats = householdOwnsCats;
	this.householdOwnsDogs = householdOwnsDogs;
	this.householdCatsCount = householdCatsCount;
	this.householdChildrenCount = householdChildrenCount;
	this.householdDogsCount = householdDogsCount;
	this.householdOtherPetsCount = householdOtherPetsCount;
	this.isContactDisallowed = isContactDisallowed;
	this.maritalStatus = maritalStatus;
	this.isDeleted = isDeleted;
	this.salutation = salutation;
	this.nutritionSensitiveRisk = nutritionSensitiveRisk;
	this.digitalAsset = digitalAsset;
	this.gigsys_RGdamak = gigsys_RGdamak;
	this.marketCode = marketCode;
	this.consumerType = consumerType;
	this.countryCode = countryCode;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getAddressLine1() {
	return addressLine1;
}

public void setAddressLine1(String addressLine1) {
	this.addressLine1 = addressLine1;
}

public String getAddressLine2() {
	return addressLine2;
}

public void setAddressLine2(String addressLine2) {
	this.addressLine2 = addressLine2;
}

public String getAddressLine3() {
	return addressLine3;
}

public void setAddressLine3(String addressLine3) {
	this.addressLine3 = addressLine3;
}

public String getAddressLine4() {
	return addressLine4;
}

public void setAddressLine4(String addressLine4) {
	this.addressLine4 = addressLine4;
}

public String getBirthDate() {
	return birthDate;
}

public void setBirthDate(String birthDate) {
	this.birthDate = birthDate;
}



public String getInitialAppSourceCode() {
	return initialAppSourceCode;
}

public void setInitialAppSourceCode(String initialAppSourceCode) {
	this.initialAppSourceCode = initialAppSourceCode;
}

public String getRegion() {
	return region;
}

public void setRegion(String region) {
	this.region = region;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getEducation() {
	return education;
}

public void setEducation(String education) {
	this.education = education;
}

public Set<ExternalApplication> getExternalApplication() {
	return externalApplication;
}

public void setExternalApplication(Set<ExternalApplication> externalApplication) {
	this.externalApplication = externalApplication;
}

public Set<Child> getChild() {
	return child;
}

public void setChild(Set<Child> child) {
	this.child = child;
}

public Set<Pet> getPet() {
	return pet;
}

public void setPet(Set<Pet> pet) {
	this.pet = pet;
}

public Set<Asset> getAsset() {
	return asset;
}

public void setAsset(Set<Asset> asset) {
	this.asset = asset;
}

public Set<AreaOfInterest> getAreaOfInterest() {
	return areaOfInterest;
}

public void setAreaOfInterest(Set<AreaOfInterest> areaOfInterest) {
	this.areaOfInterest = areaOfInterest;
}

public String getAdditionalName1() {
	return additionalName1;
}

public void setAdditionalName1(String additionalName1) {
	this.additionalName1 = additionalName1;
}

public String getOccupation() {
	return occupation;
}

public void setOccupation(String occupation) {
	this.occupation = occupation;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getCompanyName() {
	return companyName;
}

public void setCompanyName(String companyName) {
	this.companyName = companyName;
}

public String getPrefferedLanguageCode() {
	return prefferedLanguageCode;
}

public void setPrefferedLanguageCode(String prefferedLanguageCode) {
	this.prefferedLanguageCode = prefferedLanguageCode;
}

public String getNutritionCookingLevel() {
	return nutritionCookingLevel;
}

public void setNutritionCookingLevel(String nutritionCookingLevel) {
	this.nutritionCookingLevel = nutritionCookingLevel;
}

public String getNutritionCookingFrequency() {
	return nutritionCookingFrequency;
}

public void setNutritionCookingFrequency(String nutritionCookingFrequency) {
	this.nutritionCookingFrequency = nutritionCookingFrequency;
}

public Set<NutritionCookingLikes> getNutritionCookingLikes() {
	return nutritionCookingLikes;
}

public void setNutritionCookingLikes(Set<NutritionCookingLikes> nutritionCookingLikes) {
	this.nutritionCookingLikes = nutritionCookingLikes;
}

public Set<NutritionCookingDislikes> getNutritionCookingDislikes() {
	return nutritionCookingDislikes;
}

public void setNutritionCookingDislikes(Set<NutritionCookingDislikes> nutritionCookingDislikes) {
	this.nutritionCookingDislikes = nutritionCookingDislikes;
}

public Set<NutritionCookingFor> getNutritionCookingFor() {
	return nutritionCookingFor;
}

public void setNutritionCookingFor(Set<NutritionCookingFor> nutritionCookingFor) {
	this.nutritionCookingFor = nutritionCookingFor;
}

public Set<NutritionCookingStyle> getNutritionCookingStyle() {
	return nutritionCookingStyle;
}

public void setNutritionCookingStyle(Set<NutritionCookingStyle> nutritionCookingStyle) {
	this.nutritionCookingStyle = nutritionCookingStyle;
}

public Set<NutritionDiet> getNutritionDiet() {
	return nutritionDiet;
}

public void setNutritionDiet(Set<NutritionDiet> nutritionDiet) {
	this.nutritionDiet = nutritionDiet;
}

public Set<Optin> getOptin() {
	return optin;
}

public void setOptin(Set<Optin> optin) {
	this.optin = optin;
}



public String getEmailDataQualityStatus() {
	return emailDataQualityStatus;
}

public void setEmailDataQualityStatus(String emailDataQualityStatus) {
	this.emailDataQualityStatus = emailDataQualityStatus;
}

public String getAdditionalName2() {
	return additionalName2;
}

public void setAdditionalName2(String additionalName2) {
	this.additionalName2 = additionalName2;
}

public Boolean getDoNotContactAddress() {
	return doNotContactAddress;
}

public void setDoNotContactAddress(Boolean doNotContactAddress) {
	this.doNotContactAddress = doNotContactAddress;
}

public Boolean getDoNotContactEmail() {
	return doNotContactEmail;
}

public void setDoNotContactEmail(Boolean doNotContactEmail) {
	this.doNotContactEmail = doNotContactEmail;
}

public Boolean getDoNotContactMobile() {
	return doNotContactMobile;
}

public void setDoNotContactMobile(Boolean doNotContactMobile) {
	this.doNotContactMobile = doNotContactMobile;
}

public Boolean getDoNotContactPhone() {
	return doNotContactPhone;
}

public void setDoNotContactPhone(Boolean doNotContactPhone) {
	this.doNotContactPhone = doNotContactPhone;
}

public String getAddressDataQualityStatus() {
	return addressDataQualityStatus;
}

public void setAddressDataQualityStatus(String addressDataQualityStatus) {
	this.addressDataQualityStatus = addressDataQualityStatus;
}

public Boolean getIsPrimary() {
	return isPrimary;
}

public void setIsPrimary(Boolean isPrimary) {
	this.isPrimary = isPrimary;
}

public String getDataQualityStatus() {
	return dataQualityStatus;
}

public void setDataQualityStatus(String dataQualityStatus) {
	this.dataQualityStatus = dataQualityStatus;
}

public String getGigsys_ignore() {
	return gigsys_ignore;
}

public void setGigsys_ignore(String gigsys_ignore) {
	this.gigsys_ignore = gigsys_ignore;
}



public String getZipCodeExtension() {
	return zipCodeExtension;
}

public void setZipCodeExtension(String zipCodeExtension) {
	this.zipCodeExtension = zipCodeExtension;
}

public String getMobileDataQualityStatus() {
	return mobileDataQualityStatus;
}

public void setMobileDataQualityStatus(String mobileDataQualityStatus) {
	this.mobileDataQualityStatus = mobileDataQualityStatus;
}

public String getPhoneDataQualityStatus() {
	return phoneDataQualityStatus;
}

public void setPhoneDataQualityStatus(String phoneDataQualityStatus) {
	this.phoneDataQualityStatus = phoneDataQualityStatus;
}

public Boolean getIsPostalAddressValid() {
	return isPostalAddressValid;
}

public void setIsPostalAddressValid(Boolean isPostalAddressValid) {
	this.isPostalAddressValid = isPostalAddressValid;
}

public Boolean getIsEmailValid() {
	return isEmailValid;
}

public void setIsEmailValid(Boolean isEmailValid) {
	this.isEmailValid = isEmailValid;
}

public Boolean getSubscribe() {
	return subscribe;
}

public void setSubscribe(Boolean subscribe) {
	this.subscribe = subscribe;
}

public Boolean getTerms() {
	return terms;
}

public void setTerms(Boolean terms) {
	this.terms = terms;
}



public Boolean getHouseholdOwnsPets() {
	return householdOwnsPets;
}

public void setHouseholdOwnsPets(Boolean householdOwnsPets) {
	this.householdOwnsPets = householdOwnsPets;
}

public Boolean getIsPhoneValid() {
	return isPhoneValid;
}

public void setIsPhoneValid(Boolean isPhoneValid) {
	this.isPhoneValid = isPhoneValid;
}

public Boolean getIsMobileValid() {
	return isMobileValid;
}

public void setIsMobileValid(Boolean isMobileValid) {
	this.isMobileValid = isMobileValid;
}

public Boolean getHouseholdOwnsCats() {
	return householdOwnsCats;
}

public void setHouseholdOwnsCats(Boolean householdOwnsCats) {
	this.householdOwnsCats = householdOwnsCats;
}

public Boolean getHouseholdOwnsDogs() {
	return householdOwnsDogs;
}

public void setHouseholdOwnsDogs(Boolean householdOwnsDogs) {
	this.householdOwnsDogs = householdOwnsDogs;
}



public Boolean getIsContactDisallowed() {
	return isContactDisallowed;
}

public void setIsContactDisallowed(Boolean isContactDisallowed) {
	this.isContactDisallowed = isContactDisallowed;
}

public String getMaritalStatus() {
	return maritalStatus;
}

public void setMaritalStatus(String maritalStatus) {
	this.maritalStatus = maritalStatus;
}

public Boolean getIsDeleted() {
	return isDeleted;
}

public void setIsDeleted(Boolean isDeleted) {
	this.isDeleted = isDeleted;
}

public String getSalutation() {
	return salutation;
}

public void setSalutation(String salutation) {
	this.salutation = salutation;
}

public Boolean getNutritionSensitiveRisk() {
	return nutritionSensitiveRisk;
}

public void setNutritionSensitiveRisk(Boolean nutritionSensitiveRisk) {
	this.nutritionSensitiveRisk = nutritionSensitiveRisk;
}

public Set<DigitalAsset> getDigitalAsset() {
	return digitalAsset;
}

public void setDigitalAsset(Set<DigitalAsset> digitalAsset) {
	this.digitalAsset = digitalAsset;
}

public Boolean getGigsys_RGdamak() {
	return gigsys_RGdamak;
}

public void setGigsys_RGdamak(Boolean gigsys_RGdamak) {
	this.gigsys_RGdamak = gigsys_RGdamak;
}



public String getConsumerType() {
	return consumerType;
}

public void setConsumerType(String consumerType) {
	this.consumerType = consumerType;
}

public String getCountryCode() {
	return countryCode;
}

public void setCountryCode(String countryCode) {
	this.countryCode = countryCode;
}

public HashMap<String, Boolean> getGigsys() {
	return gigsys;
}

public void setGigsys(HashMap<String, Boolean> gigsys) {
	this.gigsys = gigsys;
}

public Integer getHouseholdCatsCount() {
	return householdCatsCount;
}

public void setHouseholdCatsCount(Integer householdCatsCount) {
	this.householdCatsCount = householdCatsCount;
}

public Integer getBirthDateReliability() {
	return birthDateReliability;
}

public void setBirthDateReliability(Integer birthDateReliability) {
	this.birthDateReliability = birthDateReliability;
}

public Integer getHouseholdAdultsCount() {
	return householdAdultsCount;
}

public void setHouseholdAdultsCount(Integer householdAdultsCount) {
	this.householdAdultsCount = householdAdultsCount;
}

public Integer getGigyaImportJobID() {
	return gigyaImportJobID;
}

public void setGigyaImportJobID(Integer gigyaImportJobID) {
	this.gigyaImportJobID = gigyaImportJobID;
}

public Integer getHouseholdResidentsCount() {
	return householdResidentsCount;
}

public void setHouseholdResidentsCount(Integer householdResidentsCount) {
	this.householdResidentsCount = householdResidentsCount;
}

public Integer getHouseholdChildrenCount() {
	return householdChildrenCount;
}

public void setHouseholdChildrenCount(Integer householdChildrenCount) {
	this.householdChildrenCount = householdChildrenCount;
}

public Integer getHouseholdDogsCount() {
	return householdDogsCount;
}

public void setHouseholdDogsCount(Integer householdDogsCount) {
	this.householdDogsCount = householdDogsCount;
}

public Integer getHouseholdOtherPetsCount() {
	return householdOtherPetsCount;
}

public void setHouseholdOtherPetsCount(Integer householdOtherPetsCount) {
	this.householdOtherPetsCount = householdOtherPetsCount;
}

public Integer getMarketCode() {
	return marketCode;
}

public void setMarketCode(Integer marketCode) {
	this.marketCode = marketCode;
}



}
