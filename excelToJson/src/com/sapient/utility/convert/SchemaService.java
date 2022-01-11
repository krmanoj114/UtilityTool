package com.sapient.utility.convert;

import static com.sapient.utility.convert.Constants.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import javax.naming.directory.InvalidAttributesException;
import javax.swing.JTextArea;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.joda.time.DateTime;

import com.sapient.utility.beans.Accounts;
import com.sapient.utility.beans.Activities;
import com.sapient.utility.beans.Address;
import com.sapient.utility.beans.AreaOfInterest;
import com.sapient.utility.beans.Asset;
import com.sapient.utility.beans.Books;
import com.sapient.utility.beans.Certifications;
import com.sapient.utility.beans.Child;
import com.sapient.utility.beans.Coordinates;
import com.sapient.utility.beans.Data;
import com.sapient.utility.beans.DigitalAsset;
import com.sapient.utility.beans.Education;
import com.sapient.utility.beans.Email;
import com.sapient.utility.beans.ExternalApplication;
import com.sapient.utility.beans.Favorites;
import com.sapient.utility.beans.Identities;
import com.sapient.utility.beans.Interests;
import com.sapient.utility.beans.LastLoginLocation;
import com.sapient.utility.beans.Likes;
import com.sapient.utility.beans.Movies;
import com.sapient.utility.beans.Music;
import com.sapient.utility.beans.NutritionCookingDislikes;
import com.sapient.utility.beans.NutritionCookingFor;
import com.sapient.utility.beans.NutritionCookingLikes;
import com.sapient.utility.beans.NutritionCookingStyle;
import com.sapient.utility.beans.NutritionDiet;
import com.sapient.utility.beans.OidcData;
import com.sapient.utility.beans.Optin;
import com.sapient.utility.beans.Patents;
import com.sapient.utility.beans.Pet;
import com.sapient.utility.beans.Phones;
import com.sapient.utility.beans.Preferences;
import com.sapient.utility.beans.Profile;
import com.sapient.utility.beans.Publications;
import com.sapient.utility.beans.Skills;
import com.sapient.utility.beans.Subscriptions;
import com.sapient.utility.beans.Television;
import com.sapient.utility.beans.Terms;
import com.sapient.utility.beans.Work;


/**
 * Sets the bean property of the schema fields
 * @author manbatra1
 * @version 1.1
 * @since 1.0
 */
public class SchemaService {
	
	static Map<String, List<Integer>> invalidBooleanValues = new HashMap<String, List<Integer>>();
	static List<Integer> invalidBooleanIndexes = new ArrayList<Integer>();
	static Map<String, List<Integer>> mandatoryValues = new HashMap<String, List<Integer>>();
	static List<Integer> mandatoryValuesIndexes = new ArrayList<Integer>();
	static ArrayList<String> fieldNames = new ArrayList<>(Arrays.asList("isActive","isVerified","isRegistered","emails","consumerType","countryCode","initialAppSourceCode","marketCode","compoundHashedPassword","hashedPassword"));
	public static String fieldName;
	
	/**
	 * Set bean properties for fields
	 * @param obj - Get the Bean Object
	 * @param cell - The current cell of the Excel
	 * @param methodName - The field name in the cell
	 * @return - Object after setting the property
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException 
	 * @throws InvalidAttributesException 
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public Object setSchema(Object obj, Cell cell, String methodName) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InvalidAttributesException, NoSuchFieldException, SecurityException, ClassNotFoundException {
		
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			try {
				Class<?> type = PropertyUtils.getPropertyType(obj, methodName);
				System.out.println("type = " + type);
				System.out.println("method = " + methodName);
				 if(type.getSimpleName().equalsIgnoreCase("Boolean") && !type.getSimpleName().equals(null)) {
	            		
	            		invalidBooleanValues.putIfAbsent(methodName, new ArrayList<Integer>());
	            		invalidBooleanValues.get(methodName).add(cell.getRow().getRowNum()+1);
	            		invalidBooleanIndexes.add(cell.getRow().getRowNum());
	            }
				 else {
					 
					 	BeanUtils.setProperty(obj, methodName, cell.getStringCellValue().trim());
		            	
		            }
			}
			catch(NullPointerException e) {
				break;
			}
           
            
            break;		
		case Cell.CELL_TYPE_BOOLEAN:
			
			if(methodName.contains("gigsys_RG")) {
		 		
		 		
		 		Map<String, Boolean> gigsys1 = new HashMap<String, Boolean>();
		 		gigsys1.put(methodName, cell.getBooleanCellValue());
		 		BeanUtils.setProperty(obj, "gigsys",gigsys1);
	
		 	}
			else {
				BeanUtils.setProperty(obj, methodName, cell.getBooleanCellValue());
			}
			
			break;
		
		case Cell.CELL_TYPE_NUMERIC:
			try {
				Class<?> type = PropertyUtils.getPropertyType(obj, methodName);
			
				 if(type.getSimpleName().equalsIgnoreCase("Boolean") && !type.getSimpleName().equals(null)) {
	            		
	            		invalidBooleanValues.putIfAbsent(methodName, new ArrayList<Integer>());
	            		invalidBooleanValues.get(methodName).add(cell.getRow().getRowNum()+1);
	            		invalidBooleanIndexes.add(cell.getRow().getRowNum());
	            }
				if (DateUtil.isCellDateFormatted(cell)) {
					
					 SimpleDateFormat format = new SimpleDateFormat(DATA_FORMAT);
					 BeanUtils.setProperty(obj, methodName,  format.format(cell.getDateCellValue()));    
		        }
				else {
				
						BeanUtils.setProperty(obj, methodName, new BigDecimal(cell.getNumericCellValue()).setScale(0, RoundingMode.HALF_UP).intValue());
						//System.out.println("type = " + obj  + methodName  +  cell.getNumericCellValue());
				}
			}
			catch(NullPointerException e) {
				break;
			}
			
			break;
		case Cell.CELL_TYPE_BLANK:
	
			//System.out.println("method name before = " + methodName + obj + cell);
			if(fieldNames.contains(methodName)) {
				
				System.out.println("method name = " + methodName + obj + cell);
				mandatoryValues.putIfAbsent(methodName, new ArrayList<Integer>());
				mandatoryValues.get(methodName).add(cell.getRow().getRowNum()+1);
				mandatoryValuesIndexes.add(cell.getRow().getRowNum());
			}
			break;
		case Cell.CELL_TYPE_FORMULA:
            break;
		}
		
		return obj;
	}

	
	/**
	 * Set the Array element values
	 * @param obj - Get the Bean Object
	 * @param cell - The current cell of the Excel
	 * @param methodName -The field name in the cell
	 * @return - Object after setting the array element data
	 */
	public Object setSchemaArray(Object obj, Cell cell, String methodName, JTextArea textAreaStatus) {
		
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			List<String> myList = new ArrayList<String>(Arrays.asList(cell.getStringCellValue().split(",")));
			setObjects(obj, methodName, myList,textAreaStatus);
			break;
		
		}
		
			
		return obj;
	}
	

	/**
	 * Setting the bean property for array elements
	 * @param obj - Get the Bean Object
	 * @param fieldName - The field name whose array property needs to be set
	 * @param fieldValue - The value of array elements
	 */
	public void setObjects(Object obj, String fieldName, Object fieldValue, JTextArea textAreaStatus) { 
		try {
			
			BeanUtils.setProperty(obj, fieldName, fieldValue);
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter stackTraceWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stackTraceWriter));
			textAreaStatus.setText(e.toString() + "\n" + stackTraceWriter.toString());
			
		}
	}

	
	/**
	 * Set subscription values
	 * @param subMap - Map to add subscriptions
	 * @param subscriptionName - Name of the subscription
	 * @param fieldName - schema field name in the subscription
	 * @param fieldValue - The value of the field
	 * @return - Map of Subscriptions
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws InstantiationException 
	 */
	public Map<String,Subscriptions> addSubscriptions(Map<String,Subscriptions> subMap, String subscriptionName, String fieldName,
			Email fieldValue) throws IllegalAccessException, InvocationTargetException, InstantiationException {
		
		Subscriptions subscriptions = new Subscriptions();
		BeanUtils.setProperty(subscriptions, fieldName, fieldValue);
		if(!StringUtils.isEmpty(subscriptionName)) {
			subMap.put(subscriptionName, subscriptions);
		}
		return subMap;
	}

	

	
	/**
	 * @param preMap- preferences map
	 * @param preferenceName - name of the consent
	 * @param fieldName - terms field names
	 * @param fieldValue - terms field values
	 * @return premap
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, HashMap<String, Object>> addPreferences(Map<String, HashMap<String, Object>> preMap, String preferenceName, String fieldName,
			Terms fieldValue) throws IllegalAccessException, InvocationTargetException, InstantiationException {
		
		HashMap<String, Object> valuesMap = new HashMap<String, Object>();
		Terms term = new Terms();
		BeanUtils.setProperty(term, fieldName, fieldValue);
		if(!StringUtils.isEmpty(preferenceName)) {
			
			 for (Field field : Terms.class.getDeclaredFields()) {
	                field.setAccessible(true);
	                
	                if (field.getType().equals(String.class)){
	                	valuesMap.put(field.getName(), (String) field.get(fieldValue));
	                  
	                } else if (field.getType().equals(Integer.TYPE)) {
	                	valuesMap.put(field.getName(), (Integer) field.get(fieldValue));
	                
	                }
	                else if (field.getType().equals(Float.TYPE)) {
	                	valuesMap.put(field.getName(), (Float) field.get(fieldValue));
	                	
	                }
	                else if (field.getType().equals(Boolean.class)) {
	                	valuesMap.put(field.getName(), (Boolean) field.get(fieldValue));
	                
	                }
	                else if (field.getType().equals(List.class)) {
	                	valuesMap.put(field.getName(), (List<String>) field.get(fieldValue));
	                }
	                else {
	                	System.out.println("Other value = " + field.getType());
	                }
	            }
			
			 
			preMap.put(preferenceName, valuesMap);
		
		}
		return preMap;
	}
	
	/**
	 * Setting data for a user
	 * @param email
	 * @param acc
	 * @param subMap
	 * @param childList
	 * @param childData
	 * @param petList
	 * @param petData
	 * @param subscriptionMap
	 * @param childMap
	 * @param petMap
	 * @param data
	 * @param profile
	 * @param subscriptions
	 * @param identitiesList
	 * @param identitiesData
	 * @param identitiesMap
	 * @param areaOfInterestList
	 * @param areaOfInterestData
	 * @param areaOfInterestMap
	 * @param externalApplicationList
	 * @param externalApplicationMap
	 * @param externalApplicationData
	 * @return - accounts object after setting the properties for the user
	 */
	
	public Accounts setAccountObj(JTextArea textAreaStatus,String email, Accounts acc, Map<String,Subscriptions> subMap, Set<Child> childList,
			Child childData, Set<Pet> petList, Pet petData, Map<String, Map<String,Subscriptions>> subscriptionMap, Map<String, Set<Child>> childMap, Map<String, Set<Pet>> petMap,Data data,
			Profile profile,Subscriptions subscriptions,Set<Identities> identitiesList,Identities identitiesData,Map<String, Set<Identities>>identitiesMap, Set<AreaOfInterest> areaOfInterestList, AreaOfInterest areaOfInterestData, Map<String, Set<AreaOfInterest>> areaOfInterestMap,   Set<ExternalApplication> externalApplicationList,   Map<String, Set<ExternalApplication>>externalApplicationMap,ExternalApplication externalApplicationData,
			Set<NutritionCookingDislikes> nutritionCookingDislikesList, NutritionCookingDislikes nutritionCookingDislikesData, Map<String, Set<NutritionCookingDislikes>> nutritionCookingDislikesMap,
			Set<NutritionCookingLikes> nutritionCookingLikesList, NutritionCookingLikes nutritionCookingLikesData, Map<String, Set<NutritionCookingLikes>> nutritionCookingLikesMap,
			Set<NutritionCookingFor> nutritionCookingForList, NutritionCookingFor nutritionCookingForData, Map<String, Set<NutritionCookingFor>> nutritionCookingForMap,
			Set<NutritionCookingStyle> nutritionCookingStyleList, NutritionCookingStyle nutritionCookingStyleData, Map<String, Set<NutritionCookingStyle>> nutritionCookingStyleMap,
			Set<NutritionDiet> nutritionDietList, NutritionDiet nutritionDietData, Map<String, Set<NutritionDiet>> nutritionDietMap,
			Set<Asset> assetList, Asset assetData, Map<String, Set<Asset>> assetMap,
			Set<DigitalAsset> digitalAssetList, DigitalAsset digitalAssetData, Map<String, Set<DigitalAsset>> digitalAssetMap,
			Set<Optin> optinList, Optin optinData, Map<String, Set<Optin>> optinMap,
			Set<Certifications> certificationsList, Certifications certificationsData, Map<String, Set<Certifications>> certificationsMap,
			Set<Education> educationList, Education educationData, Map<String, Set<Education>> educationMap,
			Set<Favorites> favoritesList, Favorites favoritesData, Map<String, Set<Favorites>> favoritesMap,
			Set<LastLoginLocation> lastLoginLocationList, LastLoginLocation lastLoginLocationData, Map<String, Set<LastLoginLocation>> lastLoginLocationMap,
			Set<Likes> likesList, Likes likesData, Map<String, Set<Likes>> likesMap,
			Set<OidcData> oidcDataList, OidcData oidcDataData, Map<String, Set<OidcData>> oidcDataMap,
			Set<Patents> patentsList, Patents patentsData, Map<String, Set<Patents>> patentsMap,
			Set<Phones> phonesList, Phones phonesData, Map<String, Set<Phones>> phonesMap,
			Set<Publications> publicationsList, Publications publicationsData, Map<String, Set<Publications>> publicationsMap,
			Set<Skills> skillsList, Skills skillsData, Map<String, Set<Skills>> skillsMap,
			Set<Work> workList, Work workData, Map<String, Set<Work>> workMap,
			Set<Activities> activitiesList, Activities activitiesData, Map<String, Set<Activities>> activitiesMap,
			Set<Books> booksList, Books booksData, Map<String, Set<Books>> booksMap,
			Set<Interests> interestsList, Interests interestsData, Map<String, Set<Interests>> interestsMap,
			Set<Movies> moviesList, Movies moviesData, Map<String, Set<Movies>> moviesMap,
			Set<Music> musicList, Music musicData, Map<String, Set<Music>> musicMap,
			Set<Television> televisionList, Television televisionData, Map<String, Set<Television>> televisionMap,
			Set<Coordinates> coordinatesList, Coordinates coordinatesData, Map<String, Set<Coordinates>> coordinatesMap,
			Set<Address> addressList, Address addressData, Map<String, Set<Address>> addressMap,
			Set<AreaOfInterest> areaOfInterestChildList, AreaOfInterest areaOfInterestChildData, Map<String, Set<AreaOfInterest>> areaOfInterestChildMap,
			Set<AreaOfInterest> areaOfInterestPetList, AreaOfInterest areaOfInterestPetData, Map<String, Set<AreaOfInterest>> areaOfInterestPetMap, Map<String,HashMap<String, Object>> preMap,
			Map<String, Map<String,HashMap<String, Object>>> preferencesMap, Preferences preferences,Terms terms) {
		
		try {
			
			if(childData!=null) {
				
				if(areaOfInterestChildData!= null) {
					
					areaOfInterestChildList.clear();
					areaOfInterestChildList.add(areaOfInterestChildData);
					areaOfInterestChildList.remove(null);
					areaOfInterestChildMap.put(email, areaOfInterestChildList);
					childData.setAreaOfInterest(areaOfInterestChildMap.get(email));
					
				}
				//childList.clear();
				childData.setApplicationInternalIdentifier(UUID.randomUUID().toString());
				childList.add(childData);
				childList.remove(null);
				childMap.put(email, childList);
			}
			if(petData!=null) {
				
				if(areaOfInterestPetData!= null) {
					
					areaOfInterestPetList.add(areaOfInterestPetData);
					areaOfInterestPetList.remove(null);
					areaOfInterestPetMap.put(email, areaOfInterestPetList);
					petData.setAreaOfInterest(areaOfInterestPetMap.get(email));
					
				}
				
				petData.setApplicationInternalIdentifier(UUID.randomUUID().toString());
				//petList.clear();
				petList.add(petData);
				petMap.put(email, petList);
			}
			if(externalApplicationData!=null) {
			
				externalApplicationList.add(externalApplicationData);
				externalApplicationMap.put(email, externalApplicationList);
			}
			if(areaOfInterestData!= null) {
			
				areaOfInterestList.add(areaOfInterestData);
				areaOfInterestList.remove(null);
				areaOfInterestMap.put(email, areaOfInterestList);
				
			}
			if(nutritionCookingDislikesData!= null) {
				
				nutritionCookingDislikesList.add(nutritionCookingDislikesData);
				nutritionCookingDislikesList.remove(null);
				nutritionCookingDislikesMap.put(email, nutritionCookingDislikesList);
				
			}
			if(nutritionCookingLikesData!= null) {
				
				nutritionCookingLikesList.add(nutritionCookingLikesData);
				nutritionCookingLikesList.remove(null);
				nutritionCookingLikesMap.put(email, nutritionCookingLikesList);
				
			}
			if(nutritionCookingForData!= null) {
				
				nutritionCookingForList.add(nutritionCookingForData);
				nutritionCookingForList.remove(null);
				nutritionCookingForMap.put(email, nutritionCookingForList);
				
			}			
			if(nutritionCookingStyleData!= null) {
				
				nutritionCookingStyleList.add(nutritionCookingStyleData);
				nutritionCookingStyleList.remove(null);
				nutritionCookingStyleMap.put(email, nutritionCookingStyleList);
				
			}
			if(nutritionDietData!= null) {
				
				nutritionDietList.add(nutritionDietData);
				nutritionDietList.remove(null);
				nutritionDietMap.put(email, nutritionDietList);
				
			}
			if(assetData!= null) {
	
				assetData.setApplicationInternalIdentifier(UUID.randomUUID().toString());
				assetList.add(assetData);
				assetList.remove(null);
				assetMap.put(email, assetList);
				
			}
			if(digitalAssetData!= null) {
	
				digitalAssetList.add(digitalAssetData);
				digitalAssetList.remove(null);
				digitalAssetMap.put(email, digitalAssetList);
				
			}
			if(optinData!= null) {
	
				optinList.add(optinData);
				optinList.remove(null);
				optinMap.put(email, optinList);
	
			}
			if(identitiesData != null) {
				
				identitiesList.add(identitiesData);
				identitiesMap.put(email, identitiesList);

			}			
			if(certificationsData!= null) {
				
				certificationsList.add(certificationsData);
				certificationsList.remove(null);
				certificationsMap.put(email, certificationsList);
	
			}
			if(educationData!= null) {
				
				educationList.add(educationData);
				educationList.remove(null);
				educationMap.put(email, educationList);
	
			}
			if(favoritesData!= null) {
				
				if(activitiesData!= null) {
					
					activitiesList.add(activitiesData);
					activitiesList.remove(null);
					activitiesMap.put(email, activitiesList);
					favoritesData.setActivities(activitiesMap.get(email));
		
				}
				if(booksData!= null) {
					
					booksList.add(booksData);
					booksList.remove(null);
					booksMap.put(email, booksList);
					favoritesData.setBooks(booksMap.get(email));
				
				}
				if(interestsData!= null) {
					
					interestsList.add(interestsData);
					interestsList.remove(null);
					interestsMap.put(email, interestsList);
					favoritesData.setInterests(interestsMap.get(email));
				
				}
				if(moviesData!= null) {
					
					moviesList.add(moviesData);
					moviesList.remove(null);
					moviesMap.put(email, moviesList);
					favoritesData.setMovies(moviesMap.get(email));
				
				}
				if(musicData!= null) {
					
					musicList.add(musicData);
					musicList.remove(null);
					musicMap.put(email, musicList);
					favoritesData.setMusic(musicMap.get(email));
				
				}
				if(televisionData!= null) {
					
					televisionList.add(televisionData);
					televisionList.remove(null);
					televisionMap.put(email, televisionList);
					favoritesData.setTelevision(televisionMap.get(email));
				
				}
				favoritesList.clear();
				favoritesList.add(favoritesData);
				favoritesList.remove(null);
				favoritesMap.put(email, favoritesList);

			}
			///
			if(lastLoginLocationData!= null) {
				
				if(coordinatesData!= null) {
					
					coordinatesList.add(coordinatesData);
					coordinatesList.remove(null);
					coordinatesMap.put(email, coordinatesList);
					lastLoginLocationData.setCoordinates(coordinatesMap.get(email));
				}
				//lastLoginLocationList.clear();
				lastLoginLocationList.add(lastLoginLocationData);
				lastLoginLocationList.remove(null);
				lastLoginLocationMap.put(email, lastLoginLocationList);
	
			}
			
			if(likesData!= null) {
				
				likesList.add(likesData);
				likesList.remove(null);
				likesMap.put(email, likesList);
	
			}
			if(oidcDataData!= null) {
				
				if(addressData!= null) {
					
					addressList.clear();
					addressList.add(addressData);
					addressList.remove(null);
					addressMap.put(email, addressList);
					oidcDataData.setAddress(addressMap.get(email));
					
		
				}
			
				//oidcDataList.clear();
				oidcDataList.add(oidcDataData);
				oidcDataList.remove(null);	
				oidcDataMap.put(email, oidcDataList);
		
			}
			if(patentsData!= null) {
				
				patentsList.add(patentsData);
				patentsList.remove(null);
				patentsMap.put(email, patentsList);
	
			}
			if(publicationsData!= null) {
				
				publicationsList.add(publicationsData);
				publicationsList.remove(null);
				publicationsMap.put(email, publicationsList);
	
			}
			if(skillsData!= null) {
				
				skillsList.add(skillsData);
				skillsList.remove(null);
				skillsMap.put(email, skillsList);
	
			}
			if(workData!= null) {
				
				workList.add(workData);
				workList.remove(null);
				workMap.put(email, workList);
	
			}
					
				
			subscriptionMap.put(email, subMap);
			preferencesMap.put(email, preMap);
			acc.setIdentities(identitiesMap.get(email));		
			profile.setCertifications(certificationsMap.get(email));
			profile.setEducation(educationMap.get(email));
			profile.setFavorites(favoritesMap.get(email));
			profile.setLastLoginLocation(lastLoginLocationMap.get(email));
			profile.setLikes(likesMap.get(email));
			profile.setOidcData(oidcDataMap.get(email));
			profile.setPatents(patentsMap.get(email));
			profile.setPhones(phonesMap.get(email));
			profile.setPublications(publicationsMap.get(email));
			profile.setSkills(skillsMap.get(email));
			profile.setWork(workMap.get(email));		
			data.setChild(childMap.get(email));
			data.setPet(petMap.get(email));
			data.setExternalApplication(externalApplicationMap.get(email));
			data.setAreaOfInterest(areaOfInterestMap.get(email));
			data.setNutritionCookingDislikes(nutritionCookingDislikesMap.get(email));
			data.setNutritionCookingLikes(nutritionCookingLikesMap.get(email));
			data.setNutritionCookingFor(nutritionCookingForMap.get(email));
			data.setNutritionCookingStyle(nutritionCookingStyleMap.get(email));
			data.setNutritionDiet(nutritionDietMap.get(email));
			data.setAsset(assetMap.get(email));
			data.setDigitalAsset(digitalAssetMap.get(email));
			data.setOptin(optinMap.get(email));
			acc.setData(data);
			acc.setProfile(profile);
			subscriptionMap.put(email, subMap);
					
			Map<String, Map<String, HashMap<String, Object>>> consentMap = new HashMap<String, Map<String, HashMap<String, Object>>>();
			consentMap.put("terms", preferencesMap.get(email));
		
			if(!subscriptionMap.get(email).isEmpty())
				acc.setSubscriptions(subscriptionMap.get(email));
			if(!preferencesMap.get(email).isEmpty()) {
				acc.setPreferences(consentMap);				
			}
				
			
		}catch(NullPointerException e) {
		
			e.printStackTrace();
			StringWriter stackTraceWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stackTraceWriter));
			textAreaStatus.setText(e.toString() + "\n" + stackTraceWriter.toString());
		}
		return acc;
	}
	
		
	/**
	 * Setting the array data fields
	 * @param obj - Get the Bean Object
	 * @param cell - the current cell in the excel
	 * @param methodName - The value of the field name in the cell
	 * @return - object after setting the array data values
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException 
	 * @throws InvalidAttributesException 
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public Object setArrayData(Object obj, Cell cell, String methodName) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InvalidAttributesException, NoSuchFieldException, SecurityException, ClassNotFoundException {
		
		Object temp = obj;
		if(cell.getCellType() != 3 && obj instanceof Child) {
			obj = (Child) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof Pet) {
			obj = (Pet) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof Identities) {
			obj = (Identities) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof AreaOfInterest) {
			obj = (AreaOfInterest) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof NutritionCookingDislikes) {
			obj = (NutritionCookingDislikes) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof NutritionCookingLikes) {
			obj = (NutritionCookingLikes) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof NutritionCookingFor) {
			obj = (NutritionCookingFor) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof NutritionCookingStyle) {
			obj = (NutritionCookingStyle) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof NutritionDiet) {
			obj = (NutritionDiet) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof Asset) {
			obj = (Asset) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof DigitalAsset) {
			obj = (DigitalAsset) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof Optin) {
			obj = (Optin) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof ExternalApplication) {
			obj = (ExternalApplication) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof Certifications) {
			obj = (Certifications) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof Education) {
			obj = (Education) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof Favorites) {
			obj = (Favorites) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof LastLoginLocation) {
			obj = (LastLoginLocation) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof Likes) {
			obj = (Likes) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof OidcData) {
			obj = (OidcData) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof Patents) {
			obj = (Patents) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof Phones) {
			obj = (Phones) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof Publications) {
			obj = (Publications) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof Skills) {
			obj = (Skills) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof Work) {
			obj = (Work) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof Activities) {
			obj = (Activities) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof Books) {
			obj = (Books) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof Interests) {
			obj = (Interests) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof Movies) {
			obj = (Movies) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof Music) {
			obj = (Music) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof Television) {
			obj = (Television) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof Coordinates) {
			obj = (Coordinates) setSchema(obj, cell, methodName);
		}
		else if(cell.getCellType() != 3 && obj instanceof Address) {
			obj = (Address) setSchema(obj, cell, methodName);
		}
		else {
			obj = temp;
		}
		return obj;
	}
	
		
	/**
	 * Setting the schema for Static sheet values
	 * @param obj - Get the Bean Object
	 * @param value - the value of the field
	 * @param methodName - The field whose value needs to be set
	 * @return - Object after setting its property
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public Object setSchema(Object obj, String value, String methodName) throws IllegalAccessException, InvocationTargetException {
		
			BeanUtils.setProperty(obj, methodName, value);
			return obj;
	}
	
	
	/**
	 * @param value - Schema timestamp field
	 * @return formatted timestamp value
	 */
	public String setTimestampFormat(String value) {
		  
		SimpleDateFormat convertTimestamp = new SimpleDateFormat(CREATE_DATE_FORMAT);
		convertTimestamp.setTimeZone(TimeZone.getTimeZone("GMT"));
		return convertTimestamp.format(new DateTime(value).toDate()).toString();
		
	}
	
	
	/**
	 * @param value - Schema Date field
	 * @return formatted date value
	 */
	public String setDateFormat(String value) {
		  
		SimpleDateFormat convertDate = new SimpleDateFormat(DATA_FORMAT);
		return convertDate.format(value);		
	}
	
	
	
}
