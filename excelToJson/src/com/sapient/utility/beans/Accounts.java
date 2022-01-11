package com.sapient.utility.beans;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.sapient.utility.convert.SchemaService;


public class Accounts {
	
	private String UID;
    private String created;
    private Boolean isActive;
    private Boolean isVerified;
    private Boolean isRegistered;
    private String email;
    private String lang;
    
    private Boolean isLite;
    private Set<Identities> identities;
    private Profile profile;
    private Data data;
    private Map<String,Subscriptions> subscriptions;
    private Map<String, Map<String, HashMap<String, Object>>> preferences;
  
    
    private String rounds;
    private LoginIds loginIDs;
    private Password password;
    private Emails emails;

    public Accounts() {
    	super();
    	// TODO Auto-generated constructor stub
    }
    

	public Emails getEmails() {
		return emails;
	}

	public void setEmails(Emails emails) {
		this.emails = emails;
	}

	public Password getPassword() {
		return password;
	}

	public void setPassword(Password password) {
		this.password = password;
	}

	public LoginIds getLoginIDs() {
		return loginIDs;
	}

	public void setLoginIDs(LoginIds loginIDs) {
		this.loginIDs = loginIDs;
	}

	public Boolean getIsLite() {
		return isLite;
	}

	public void setIsLite(Boolean isLite) {
		this.isLite = isLite;
	}

  
public String getUID() {
       return UID;
   }


public void setUID(String UID) {
       this.UID = UID;
 }
   
public Set<Identities> getIdentities() {
	return identities;
}

public void setIdentities(Set<Identities> identities) {
	this.identities = identities;
}

public Profile getProfile() {
       return (Profile) profile;
   }
   
public Data getData() {
       return (Data) data;
   }

public void setProfile(Profile profile) {
       this.profile = profile;
   }

public void setData(Data data) {
       this.data = data;
   }

public String getRounds() {
	return rounds;
}

public void setRounds(String rounds) {
	this.rounds = rounds;
}

public Boolean getIsRegistered() {
	return isRegistered;
}

public void setIsRegistered(Boolean isRegistered) {
	this.isRegistered = isRegistered;
}

public String getCreated() {
	return created;
}

public void setCreated(String created) throws ParseException {
	this.created = new SchemaService().setTimestampFormat(created);
}

public Boolean getIsActive() {
	return isActive;
}

public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
}

public Boolean getIsVerified() {
	return isVerified;
}

public void setIsVerified(Boolean isVerified) {
	this.isVerified = isVerified;
}
  
public Map<String, Subscriptions> getSubscriptions() {
	return subscriptions;
}

public void setSubscriptions(Map<String, Subscriptions> subscriptions) {
	this.subscriptions = subscriptions;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public Map<String, Map<String, HashMap<String, Object>>> getPreferences() {
	return preferences;
}


public void setPreferences(Map<String, Map<String, HashMap<String, Object>>> finalMap) {
	// TODO Auto-generated method stub
	this.preferences = finalMap;
}


public String getLang() {
	return lang;
}


public void setLang(String lang) {
	this.lang = lang;
}


}
