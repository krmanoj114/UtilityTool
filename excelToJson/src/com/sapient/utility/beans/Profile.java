package com.sapient.utility.beans;

import java.util.Set;

public class Profile {
	
	private String firstName;
    private String lastName;
    private String email;
    private String city;
    private String gender;
    private String zip;
    private String locale;
    private String languages;
    private String activities;
    private String address;
    private Integer age;
    private String bio;
    private Integer birthDay;
    private Integer birthMonth;
    private Integer birthYear;   
    private Set<Certifications> certifications;
    private Set<Education> education;
    private Set<Favorites> favorites;
    private Set<LastLoginLocation> lastLoginLocation;
    private Set<Likes> likes;
    private Set<OidcData> oidcData;
    private Set<Patents> patents;
    private Set<Phones> phones;
    private Set<Publications> publications;
    private Set<Skills> skills;
    private Set<Work> work;
    private String country;
    private String educationLevel;
    private Integer followersCount;
    private Integer followingCount;
    private String hometown;
    private String honors;  
    private String industry;
    private String interestedIn;
    private String interests;
    private String name;
    private String nickname;
    private String photoURL;
    private String politicalView;
    private String professionalHeadline;
    private String profileURL;
    private String proxyemail;
    private String relationshipStatus;
    private String religion;
    private String specialities;
    private String state;
    private String thumbnailURL;
    private String timezone;
    private String username;
    private String verified;
    
    public Profile(){
    	super();
    }

	public Profile(String firstName, String lastName, String email, String city, String gender, String zip,
			String locale, String languages, String activities, String address, Integer age, String bio, Integer birthDay,
			Integer birthMonth, Integer birthYear, Set<Certifications> certifications, Set<Education> education,
			Set<Favorites> favorites, Set<LastLoginLocation> lastLoginLocation, Set<Likes> likes,
			Set<OidcData> oidcData, Set<Patents> patents, Set<Phones> phones, Set<Publications> publications,
			Set<Skills> skills, Set<Work> work, String country, String educationLevel, Integer followersCount,
			Integer followingCount, String hometown, String honors, String industry, String interestedIn,
			String interests, String name, String nickname, String photoURL, String politicalView,
			String professionalHeadline, String profileURL, String proxyemail, String relationshipStatus,
			String religion, String specialities, String state, String thumbnailURL, String timezone, String username,
			String verified) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.city = city;
		this.gender = gender;
		this.zip = zip;
		this.locale = locale;
		this.languages = languages;
		this.activities = activities;
		this.address = address;
		this.age = age;
		this.bio = bio;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.certifications = certifications;
		this.education = education;
		this.favorites = favorites;
		this.lastLoginLocation = lastLoginLocation;
		this.likes = likes;
		this.oidcData = oidcData;
		this.patents = patents;
		this.phones = phones;
		this.publications = publications;
		this.skills = skills;
		this.work = work;
		this.country = country;
		this.educationLevel = educationLevel;
		this.followersCount = followersCount;
		this.followingCount = followingCount;
		this.hometown = hometown;
		this.honors = honors;
		this.industry = industry;
		this.interestedIn = interestedIn;
		this.interests = interests;
		this.name = name;
		this.nickname = nickname;
		this.photoURL = photoURL;
		this.politicalView = politicalView;
		this.professionalHeadline = professionalHeadline;
		this.profileURL = profileURL;
		this.proxyemail = proxyemail;
		this.relationshipStatus = relationshipStatus;
		this.religion = religion;
		this.specialities = specialities;
		this.state = state;
		this.thumbnailURL = thumbnailURL;
		this.timezone = timezone;
		this.username = username;
		this.verified = verified;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getZip() {
		return zip;
	}




	public void setZip(String zip) {
		this.zip = zip;
	}




	public String getLocale() {
		return locale;
	}




	public void setLocale(String locale) {
		this.locale = locale;
	}




	public String getLanguages() {
		return languages;
	}




	public void setLanguages(String languages) {
		this.languages = languages;
	}




	public String getActivities() {
		return activities;
	}




	public void setActivities(String activities) {
		this.activities = activities;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}


	public String getBio() {
		return bio;
	}




	public void setBio(String bio) {
		this.bio = bio;
	}




	



	public Set<Certifications> getCertifications() {
		return certifications;
	}




	public void setCertifications(Set<Certifications> certifications) {
		this.certifications = certifications;
	}




	public Set<Education> getEducation() {
		return education;
	}




	public void setEducation(Set<Education> education) {
		this.education = education;
	}




	public Set<Favorites> getFavorites() {
		return favorites;
	}




	public void setFavorites(Set<Favorites> favorites) {
		this.favorites = favorites;
	}




	public Set<LastLoginLocation> getLastLoginLocation() {
		return lastLoginLocation;
	}




	public void setLastLoginLocation(Set<LastLoginLocation> lastLoginLocation) {
		this.lastLoginLocation = lastLoginLocation;
	}




	public Set<Likes> getLikes() {
		return likes;
	}




	public void setLikes(Set<Likes> likes) {
		this.likes = likes;
	}




	public Set<OidcData> getOidcData() {
		return oidcData;
	}




	public void setOidcData(Set<OidcData> oidcData) {
		this.oidcData = oidcData;
	}




	public Set<Patents> getPatents() {
		return patents;
	}




	public void setPatents(Set<Patents> patents) {
		this.patents = patents;
	}




	public Set<Phones> getPhones() {
		return phones;
	}




	public void setPhones(Set<Phones> phones) {
		this.phones = phones;
	}




	public Set<Publications> getPublications() {
		return publications;
	}




	public void setPublications(Set<Publications> publications) {
		this.publications = publications;
	}




	public Set<Skills> getSkills() {
		return skills;
	}




	public void setSkills(Set<Skills> skills) {
		this.skills = skills;
	}




	public Set<Work> getWork() {
		return work;
	}




	public void setWork(Set<Work> work) {
		this.work = work;
	}




	public String getCountry() {
		return country;
	}




	public void setCountry(String country) {
		this.country = country;
	}




	public String getEducationLevel() {
		return educationLevel;
	}


	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}


	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Integer birthDay) {
		this.birthDay = birthDay;
	}

	public Integer getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(Integer birthMonth) {
		this.birthMonth = birthMonth;
	}

	public Integer getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}

	public Integer getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(Integer followersCount) {
		this.followersCount = followersCount;
	}

	public Integer getFollowingCount() {
		return followingCount;
	}

	public void setFollowingCount(Integer followingCount) {
		this.followingCount = followingCount;
	}

	public String getHometown() {
		return hometown;
	}




	public void setHometown(String hometown) {
		this.hometown = hometown;
	}




	public String getHonors() {
		return honors;
	}




	public void setHonors(String honors) {
		this.honors = honors;
	}




	public String getIndustry() {
		return industry;
	}




	public void setIndustry(String industry) {
		this.industry = industry;
	}




	public String getInterestedIn() {
		return interestedIn;
	}




	public void setInterestedIn(String interestedIn) {
		this.interestedIn = interestedIn;
	}




	public String getInterests() {
		return interests;
	}




	public void setInterests(String interests) {
		this.interests = interests;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getNickname() {
		return nickname;
	}




	public void setNickname(String nickname) {
		this.nickname = nickname;
	}




	public String getPhotoURL() {
		return photoURL;
	}




	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}




	public String getPoliticalView() {
		return politicalView;
	}




	public void setPoliticalView(String politicalView) {
		this.politicalView = politicalView;
	}




	public String getProfessionalHeadline() {
		return professionalHeadline;
	}




	public void setProfessionalHeadline(String professionalHeadline) {
		this.professionalHeadline = professionalHeadline;
	}




	public String getProfileURL() {
		return profileURL;
	}




	public void setProfileURL(String profileURL) {
		this.profileURL = profileURL;
	}




	public String getProxyemail() {
		return proxyemail;
	}




	public void setProxyemail(String proxyemail) {
		this.proxyemail = proxyemail;
	}




	public String getRelationshipStatus() {
		return relationshipStatus;
	}




	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}




	public String getReligion() {
		return religion;
	}




	public void setReligion(String religion) {
		this.religion = religion;
	}




	public String getSpecialities() {
		return specialities;
	}




	public void setSpecialities(String specialities) {
		this.specialities = specialities;
	}




	public String getState() {
		return state;
	}




	public void setState(String state) {
		this.state = state;
	}




	public String getThumbnailURL() {
		return thumbnailURL;
	}




	public void setThumbnailURL(String thumbnailURL) {
		this.thumbnailURL = thumbnailURL;
	}




	public String getTimezone() {
		return timezone;
	}




	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getVerified() {
		return verified;
	}




	public void setVerified(String verified) {
		this.verified = verified;
	}

    

}
