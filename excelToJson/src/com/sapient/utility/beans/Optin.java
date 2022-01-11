package com.sapient.utility.beans;

public class Optin {

	private String acceptanceDate;
	private String acceptanceDetails;
	private String contactChannelType;
	private String marketingGroupService;
	private String optinSourceApplication;
	private String optoutSourceApplication;
	private String revocationDate;
	private String revocationDetails;
	
	public Optin() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Optin(String acceptanceDate, String acceptanceDetails, String contactChannelType,
			String marketingGroupService, String optinSourceApplication, String optoutSourceApplication,
			String revocationDate, String revocationDetails) {
		super();
		this.acceptanceDate = acceptanceDate;
		this.acceptanceDetails = acceptanceDetails;
		this.contactChannelType = contactChannelType;
		this.marketingGroupService = marketingGroupService;
		this.optinSourceApplication = optinSourceApplication;
		this.optoutSourceApplication = optoutSourceApplication;
		this.revocationDate = revocationDate;
		this.revocationDetails = revocationDetails;
	}



	public String getAcceptanceDate() {
		return acceptanceDate;
	}



	public void setAcceptanceDate(String acceptanceDate) {
		this.acceptanceDate = acceptanceDate;
	}



	public String getAcceptanceDetails() {
		return acceptanceDetails;
	}



	public void setAcceptanceDetails(String acceptanceDetails) {
		this.acceptanceDetails = acceptanceDetails;
	}



	public String getContactChannelType() {
		return contactChannelType;
	}



	public void setContactChannelType(String contactChannelType) {
		this.contactChannelType = contactChannelType;
	}



	public String getMarketingGroupService() {
		return marketingGroupService;
	}



	public void setMarketingGroupService(String marketingGroupService) {
		this.marketingGroupService = marketingGroupService;
	}



	public String getOptinSourceApplication() {
		return optinSourceApplication;
	}



	public void setOptinSourceApplication(String optinSourceApplication) {
		this.optinSourceApplication = optinSourceApplication;
	}



	public String getOptoutSourceApplication() {
		return optoutSourceApplication;
	}



	public void setOptoutSourceApplication(String optoutSourceApplication) {
		this.optoutSourceApplication = optoutSourceApplication;
	}



	public String getRevocationDate() {
		return revocationDate;
	}



	public void setRevocationDate(String revocationDate) {
		this.revocationDate = revocationDate;
	}



	public String getRevocationDetails() {
		return revocationDetails;
	}



	public void setRevocationDetails(String revocationDetails) {
		this.revocationDetails = revocationDetails;
	}

}
