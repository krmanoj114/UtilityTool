package com.sapient.utility.convert;

import static com.sapient.utility.convert.Constants.*;


import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.swing.JTextArea;

import org.apache.commons.io.FileUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import com.sapient.utility.beans.Emails;
import com.sapient.utility.beans.ExternalApplication;
import com.sapient.utility.beans.Favorites;
import com.sapient.utility.beans.HashSettings;
import com.sapient.utility.beans.Identities;
import com.sapient.utility.beans.Interests;
import com.sapient.utility.beans.LastLoginLocation;
import com.sapient.utility.beans.Likes;
import com.sapient.utility.beans.LoginIds;
import com.sapient.utility.beans.Movies;
import com.sapient.utility.beans.Music;
import com.sapient.utility.beans.NutritionCookingDislikes;
import com.sapient.utility.beans.NutritionCookingFor;
import com.sapient.utility.beans.NutritionCookingLikes;
import com.sapient.utility.beans.NutritionCookingStyle;
import com.sapient.utility.beans.NutritionDiet;
import com.sapient.utility.beans.OidcData;
import com.sapient.utility.beans.Optin;
import com.sapient.utility.beans.Password;
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
 * @author manbatra1
 * @version 1.1
 * @since 1.0
 */
public class ConvertJson {
			
	/**
	 * Get user data from excel
	 * @param excelInputFilePath - Input path of the excel
	 * @param excelOutputFilePath - Output path of the JSON that will be created
	 * @param textAreaStatus - Text area to display output message
	 */
	public static void importExcel(String excelInputFilePath, String excelOutputFilePath, JTextArea textAreaStatus) {
		
		try {
			textAreaStatus.setText("");
			StringBuffer mandatoryFields = new StringBuffer();
			Map<String, String> staticValues = new HashMap<String, String>();
			int header = 0, value = 1;
			FileInputStream inputStream = new FileInputStream(new File(excelInputFilePath));
			
			
			//implementing to read more excel rows
			Workbook workbook = WorkbookFactory.create(inputStream);
			
			/*Workbook workbook = StreamingReader.builder()
		            .rowCacheSize(100)    
		            .bufferSize(4096)     
		            .open(inputStream);  */
			
			Sheet firstSheet = workbook.getSheet(USER_DATA_EXCEL);
			Sheet secondSheet = workbook.getSheet(MARKET_DATA_EXCEL);
			Iterator<Row> iterator = firstSheet.iterator();
			Iterator<Row> iteratorSecond = secondSheet.iterator();		
			Row staticSheetRow = ((Iterator<Row>) iteratorSecond).next();
			Row staticSheetRow2 = ((Iterator<Row>) iteratorSecond).next();
			staticSheetRow.setRowNum(header);
			staticSheetRow2.setRowNum(value);
			
			Iterator<Cell> cellIteratorHeader = staticSheetRow.cellIterator();
			Iterator<Cell> cellIteratorValue = staticSheetRow2.cellIterator();
			
			//Get the header values
			while(cellIteratorHeader.hasNext() && cellIteratorValue.hasNext()) {
				
				Cell cellHeader = cellIteratorHeader.next();
				Cell cellValue = cellIteratorValue.next();
				
				if(!cellValue.getStringCellValue().isEmpty()) {
					
					staticValues.put(cellHeader.getStringCellValue(), cellValue.getStringCellValue());
				}
				else {
					mandatoryFields.append(cellHeader.getStringCellValue());
					mandatoryFields.append("  ");
				}	
			}
			staticSheetRow = null;
			staticSheetRow2 = null;
			secondSheet = null;
			if(mandatoryFields.length() > 0 ) {
				
				textAreaStatus.setText("");
				textAreaStatus.setText(STATIC_VALIDATION_ERROR + mandatoryFields.toString() );
				Font font = new Font("Calibri", Font.BOLD, 15);
				textAreaStatus.setBackground(Color.ORANGE);
				textAreaStatus.setFont(font);
				textAreaStatus.setLineWrap(true);
				textAreaStatus.setForeground(Color.RED);
				textAreaStatus.setEditable(false);
			}
			else {	
			String headerName[] = new String[500];
			int i = 0;
			Map<String, Accounts> accList = new HashMap<String, Accounts>();
			String email = "";
			String loginEmail = "";
			int emailIndex = 0;
			int loginEmailIndex = 0;
			
			//Creating HashSets for Array fields
			Set<Child> childList = new HashSet<Child>();
			Set<Pet> petList = new HashSet<Pet>();
			Set<ExternalApplication> externalApplicationList = new HashSet<ExternalApplication>();
			Set<AreaOfInterest> areaOfInterestList = new HashSet<AreaOfInterest>();
			Set<AreaOfInterest> areaOfInterestChildList = new HashSet<AreaOfInterest>();
			Set<AreaOfInterest> areaOfInterestPetList = new HashSet<AreaOfInterest>();
			Set<Certifications> certificationsList = new HashSet<Certifications>();
			Set<Education> educationList = new HashSet<Education>();
			Set<LastLoginLocation> lastLoginLocationList = new HashSet<LastLoginLocation>();
			Set<Likes> likesList = new HashSet<Likes>();
			Set<OidcData> oidcDataList = new HashSet<OidcData>();
			Set<Patents> patentsList = new HashSet<Patents>();
			Set<Phones> phonesList = new HashSet<Phones>();
			Set<Publications> publicationsList = new HashSet<Publications>();
			Set<Skills> skillsList = new HashSet<Skills>();
			Set<Work> workList = new HashSet<Work>();
			Set<Favorites> favoritesList = new HashSet<Favorites>();
			Set<Activities> activitiesList = new HashSet<Activities>();
			Set<Books> booksList = new HashSet<Books>();
			Set<Interests> interestsList = new HashSet<Interests>();
			Set<Movies> moviesList = new HashSet<Movies>();
			Set<Music> musicList = new HashSet<Music>();
			Set<Television> televisionList = new HashSet<Television>();
			Set<Coordinates> coordinatesList = new HashSet<Coordinates>();
			Set<Address> addressList = new HashSet<Address>();
			Set<NutritionCookingDislikes> nutritionCookingDislikesList = new HashSet<NutritionCookingDislikes>();
			Set<NutritionCookingLikes> nutritionCookingLikesList = new HashSet<NutritionCookingLikes>();
			Set<NutritionCookingFor> nutritionCookingForList = new HashSet<NutritionCookingFor>();
			Set<NutritionCookingStyle> nutritionCookingStyleList = new HashSet<NutritionCookingStyle>();
			Set<NutritionDiet> nutritionDietList = new HashSet<NutritionDiet>();
			Set<Asset> assetList = new HashSet<Asset>();
			Set<DigitalAsset> digitalAssetList = new HashSet<DigitalAsset>();
			Set<Optin> optinList = new HashSet<Optin>();
			Set<Identities> identitiesList = new HashSet<Identities>();
			
			//Initializing HashMaps
			Map<String,Subscriptions> subMap = new HashMap<>();
			Map<String,HashMap<String, Object>> preMap = new HashMap<>();
			Map<String, Set<Child>> childMap = new HashMap<String, Set<Child>>();
			Map<String, Set<Pet>> petMap = new HashMap<String, Set<Pet>>();
			Map<String, Set<ExternalApplication>> externalApplicationMap = new HashMap<String, Set<ExternalApplication>>();
			Map<String, Set<AreaOfInterest>> areaOfInterestMap = new HashMap<String, Set<AreaOfInterest>>();	
			Map<String, Set<AreaOfInterest>> areaOfInterestChildMap = new HashMap<String, Set<AreaOfInterest>>();
			Map<String, Set<AreaOfInterest>> areaOfInterestPetMap = new HashMap<String, Set<AreaOfInterest>>();
			Map<String, Set<Certifications>> certificationsMap = new HashMap<String, Set<Certifications>>();
			Map<String, Set<Education>> educationMap = new HashMap<String, Set<Education>>();
			Map<String, Set<Favorites>> favoritesMap = new HashMap<String, Set<Favorites>>();
			Map<String, Set<LastLoginLocation>> lastLoginLocationMap = new HashMap<String, Set<LastLoginLocation>>();
			Map<String, Set<Likes>> likesMap = new HashMap<String, Set<Likes>>();
			Map<String, Set<OidcData>> oidcDataMap = new HashMap<String, Set<OidcData>>();
			Map<String, Set<Patents>> patentsMap = new HashMap<String, Set<Patents>>();
			Map<String, Set<Phones>> phonesMap = new HashMap<String, Set<Phones>>();
			Map<String, Set<Publications>> publicationsMap = new HashMap<String, Set<Publications>>();
			Map<String, Set<Skills>> skillsMap = new HashMap<String, Set<Skills>>();
			Map<String, Set<Work>> workMap = new HashMap<String, Set<Work>>();
			Map<String, Set<Activities>> activitiesMap = new HashMap<String, Set<Activities>>();
			Map<String, Set<Books>> booksMap = new HashMap<String, Set<Books>>();
			Map<String, Set<Interests>> interestsMap = new HashMap<String, Set<Interests>>();
			Map<String, Set<Movies>> moviesMap = new HashMap<String, Set<Movies>>();
			Map<String, Set<Music>> musicMap = new HashMap<String, Set<Music>>();
			Map<String, Set<Television>> televisionMap = new HashMap<String, Set<Television>>();
			Map<String, Set<Coordinates>> coordinatesMap = new HashMap<String, Set<Coordinates>>();
			Map<String, Set<Address>> addressMap = new HashMap<String, Set<Address>>();			
			Map<String, Set<NutritionCookingDislikes>> nutritionCookingDislikesMap = new HashMap<String, Set<NutritionCookingDislikes>>();
			Map<String, Set<NutritionCookingLikes>> nutritionCookingLikesMap = new HashMap<String, Set<NutritionCookingLikes>>();
			Map<String, Set<NutritionCookingFor>> nutritionCookingForMap = new HashMap<String, Set<NutritionCookingFor>>();
			Map<String, Set<NutritionCookingStyle>> nutritionCookingStyleMap = new HashMap<String, Set<NutritionCookingStyle>>();
			Map<String, Set<NutritionDiet>> nutritionDietMap = new HashMap<String, Set<NutritionDiet>>();
			Map<String, Set<Asset>> assetMap = new HashMap<String, Set<Asset>>();
			Map<String, Set<DigitalAsset>> digitalAssetMap = new HashMap<String, Set<DigitalAsset>>();
			Map<String, Set<Optin>> optinMap = new HashMap<String, Set<Optin>>();			
			Map<String, Set<Identities>> identitiesMap = new HashMap<String, Set<Identities>>();
			Map<String, Map<String,Subscriptions>> subscriptionMap = new HashMap<String, Map<String,Subscriptions>>();
		//	Map<String, Map<String,Preferences>> preferMap = new HashMap<String, Map<String,Preferences>>();
			Map<String, Map<String,HashMap<String, Object>>> preferencesMap = new HashMap<String,Map<String,HashMap<String, Object>>>();
			SchemaService schemaService = new SchemaService();
			SchemaService.invalidBooleanValues.clear();
			SchemaService.invalidBooleanIndexes.clear();
			SchemaService.mandatoryValues.clear();
			SchemaService.mandatoryValuesIndexes.clear();
			
			
			
			List<Integer> emailIndexes = new ArrayList<Integer>();	
			List<Integer> emailInvalidIndexes = new ArrayList<Integer>();
			boolean isLite = true;
			//Row iterator
			while (iterator.hasNext()) {
				
				Subscriptions subscriptions = new Subscriptions();
				Preferences preferences = new Preferences();
				Email emailData = new Email();
				Terms termsData = new Terms();
				LoginIds loginData = new LoginIds();
				Emails emailsData = new Emails();
				Password password = new Password();
				HashSettings hashSettings = new HashSettings();
				Accounts acc = new Accounts();
				Profile profile = new Profile();
				String subsClassName = "";
				String preClassName = "";
				Data data = new Data();
				boolean emailValid = true;
				boolean loginEmailValid = true;
				boolean passwordCheck = false;
				SchemaService.invalidBooleanIndexes.clear();
				SchemaService.mandatoryValuesIndexes.clear();
				
				
				Row nextRow = iterator.next();
				System.out.println("row number = " + nextRow.getRowNum());
				
				if (null!=nextRow.getCell(0) && nextRow.getCell(0).getStringCellValue().equalsIgnoreCase("DONE")) {
						
						break;
				}
				
				
				if (nextRow.getRowNum() == 0) {
					
					continue;
				} else if (nextRow.getRowNum() == 1) {
					
					Iterator<Cell> cellIterator = nextRow.cellIterator();
					
					while (cellIterator.hasNext()) {
						headerName[i] = ((Cell) cellIterator.next()).getStringCellValue();
						if(headerName[i].equals(SCHEMA_PROFILE_EMAIL)) {
							emailIndex = i;									
						}
						if(headerName[i].equals(SCHEMA_LOGINID_EMAIL)) {
							isLite = false;
							loginEmailIndex = i;									
						}
						i++;
					}
					continue;
				} else {
					
					//Objects declaration
					Child childData = null;
					Pet petData = null;
					ExternalApplication externalApplicationData = null;
					AreaOfInterest areaOfInterestData = null;
					AreaOfInterest areaOfInterestChildData = null;
					AreaOfInterest areaOfInterestPetData = null;
					NutritionCookingDislikes nutritionCookingDislikesData = null;
					NutritionCookingLikes nutritionCookingLikesData = null;
					NutritionCookingFor nutritionCookingForData = null;
					NutritionCookingStyle nutritionCookingStyleData = null;
					NutritionDiet nutritionDietData = null;
					Asset assetData = null;
					DigitalAsset digitalAssetData = null;
					Optin optinData = null;
					Certifications certificationsData = null;
					Education educationData = null;
					Favorites favoritesData = null;
					LastLoginLocation lastLoginLocationData = null;
					Likes likesData = null;
					OidcData oidcDataData = null;
					Patents patentsData = null;
					Phones phonesData = null;
					Publications publicationsData = null;
					Skills skillsData = null;
					Work workData = null;					
					Activities activitiesData = null;
					Books booksData = null;
					Interests interestsData = null;
					Movies moviesData = null;
					Music musicData = null;
					Television televisionData = null;
					Coordinates coordinatesData = null;
					Address addressData = null;
					Identities identitiesData = null;
					
					boolean rowAreaOfInterest = true;
					boolean rowNutritionCookingDislikes = true;
					boolean rowNutritionCookingLikes = true;
					boolean rowNutritionCookingFor = true;
					boolean rowNutritionCookingStyle = true;
					boolean rowNutritionDiet = true;
					boolean rowAsset = true;
					boolean rowDigitalAsset = true;
					boolean rowOptin = true;
					boolean rowIdentities = true;
					boolean rowExternalApplication = true;
					boolean rowChild = true;
					boolean rowPet = true;					
					boolean rowCertifications = true;					
					boolean rowEducation = true;					
					boolean rowFavorites = true;					
					boolean rowLastLoginLocation = true;  				
					boolean rowLikes = true;					
					boolean rowOidcData = true;					
					boolean rowPatents = true;					
					boolean rowPhones = true;					
					boolean rowPublications = true;				
					boolean rowSkills = true;
					boolean rowWork = true;	
					boolean rowActivities = true;	
					boolean rowBooks = true;	
					boolean rowInterests = true;	
					boolean rowMovies = true;	
					boolean rowMusic = true;	
					boolean rowTelevision = true;	
					boolean rowCoordinates = true;	
					boolean rowAddress = true;	
					boolean rowAreaOfInterestChild = true;
					boolean rowAreaOfInterestPet = true;
	
					email = "";
					loginEmail = "";
					
					Iterator<Cell> cellIterator = nextRow.cellIterator();
					
					// coll iterator
					while (cellIterator.hasNext()) { 
						Cell cell = cellIterator.next();

						if(null!=nextRow.getCell(emailIndex)) {
						email = nextRow.getCell(emailIndex).getStringCellValue();
						emailValid = EmailValidator.getInstance().isValid(email);

						}
						
						if(!isLite) {
							if(null!=nextRow.getCell(loginEmailIndex)) {
							loginEmail = nextRow.getCell(loginEmailIndex).getStringCellValue();
							loginEmailValid = EmailValidator.getInstance().isValid(loginEmail);
							}
						}					
						if(!isLite && (email.isEmpty() || loginEmail.isEmpty())) {
							emailIndexes.add(nextRow.getRowNum()+1);
							break;
						}
						if(!isLite && (!emailValid || !loginEmailValid)) {
							emailInvalidIndexes.add(nextRow.getRowNum()+1);
							break;
						}
						if(isLite && email.isEmpty()) {
							emailIndexes.add(nextRow.getRowNum()+1);
							break;
						}
						if(isLite && !emailValid) {
							emailInvalidIndexes.add(nextRow.getRowNum()+1);
							break;
						}
							
						//Split fields based on schema
						if (cell.getColumnIndex() < i && headerName[cell.getColumnIndex()].contains(".")) {
							String[] schemaAttr = headerName[cell.getColumnIndex()].toString().split("\\.");
							
							if (schemaAttr[0].equals(SCHEMA_PROFILE)) {		


								if (schemaAttr[1].equals(SCHEMA_CERTIFICATIONS) && cell.getCellType() != 3) {
									
									if (!certificationsMap.containsKey(email)) {
										certificationsList = new HashSet<Certifications>();
									}
									
									if(rowCertifications) {
										certificationsData = new Certifications();
										rowCertifications = false;
									}									
									certificationsData = (Certifications) schemaService.setArrayData(certificationsData, cell, schemaAttr[2]);
																	
																	
								} else if (schemaAttr[1].equals(SCHEMA_EDUCATION) && cell.getCellType() != 3) {
									
									if (!educationMap.containsKey(email)) {
										educationList = new HashSet<Education>();
									}
									
									if(rowEducation) {
										educationData = new Education();
										rowEducation = false;
									}									
									educationData = (Education) schemaService.setArrayData(educationData, cell, schemaAttr[2]);
																	
																	
								} else if (schemaAttr[1].equals(SCHEMA_FAVORITES) && cell.getCellType() != 3) {
								
									if (!favoritesMap.containsKey(email)) {
										favoritesList = new HashSet<Favorites>();
									}
									if(rowFavorites) {
										favoritesData = new Favorites();
										rowFavorites = false;
									}
					
									
									if (schemaAttr[2].equals(SCHEMA_FAVORITES_ACTIVITIES) && cell.getCellType() != 3) {
										
										if (!activitiesMap.containsKey(email)) {
											activitiesList = new HashSet<Activities>();
										}
										
										if(rowActivities) {
											activitiesData = new Activities();
											rowActivities = false;
										}									
										activitiesData = (Activities) schemaService.setArrayData(activitiesData, cell, schemaAttr[3]);
																		
																		
									} else if (schemaAttr[2].equals(SCHEMA_FAVORITES_BOOKS) && cell.getCellType() != 3) {
										
										if (!booksMap.containsKey(email)) {
											booksList = new HashSet<Books>();
										}
										
										if(rowBooks) {
											booksData = new Books();
											rowBooks = false;
										}									
										booksData = (Books) schemaService.setArrayData(booksData, cell, schemaAttr[3]);
																		
																		
									} else if (schemaAttr[2].equals(SCHEMA_FAVORITES_INTERESTS) && cell.getCellType() != 3) {
										
										if (!interestsMap.containsKey(email)) {
											interestsList = new HashSet<Interests>();
										}
										
										if(rowInterests) {
											interestsData = new Interests();
											rowInterests = false;
										}									
										interestsData = (Interests) schemaService.setArrayData(interestsData, cell, schemaAttr[3]);
																		
																		
									} else if (schemaAttr[2].equals(SCHEMA_FAVORITES_MOVIES) && cell.getCellType() != 3) {
										
										if (!moviesMap.containsKey(email)) {
											moviesList = new HashSet<Movies>();
										}
										
										if(rowMovies) {
											moviesData = new Movies();
											rowMovies = false;
										}									
										moviesData = (Movies) schemaService.setArrayData(moviesData, cell, schemaAttr[3]);
																		
																		
									} else if (schemaAttr[2].equals(SCHEMA_FAVORITES_MUSIC) && cell.getCellType() != 3) {
										
										if (!musicMap.containsKey(email)) {
											musicList = new HashSet<Music>();
										}
										
										if(rowMusic) {
											musicData = new Music();
											rowMusic = false;
										}									
										musicData = (Music) schemaService.setArrayData(musicData, cell, schemaAttr[3]);
																		
																		
									} else if (schemaAttr[2].equals(SCHEMA_FAVORITES_TELEVISION) && cell.getCellType() != 3) {
										
										if (!televisionMap.containsKey(email)) {
											televisionList = new HashSet<Television>();
										}
										
										if(rowTelevision) {
											televisionData = new Television();
											rowTelevision = false;
										}									
										televisionData = (Television) schemaService.setArrayData(televisionData, cell, schemaAttr[3]);
																		
																		
									} 
									else {
										favoritesData = (Favorites) schemaService.setArrayData(favoritesData, cell, schemaAttr[2]);
									}

									
								} else if (schemaAttr[1].equals(SCHEMA_LAST_LOGIN_LOCATION) && cell.getCellType() != 3) {
									if (!lastLoginLocationMap.containsKey(email)) {
										lastLoginLocationList = new HashSet<LastLoginLocation>();
									}
									if(rowLastLoginLocation) {
										lastLoginLocationData = new LastLoginLocation();
										rowLastLoginLocation = false;
									}
									if (schemaAttr[2].equals(SCHEMA_COORDINATES) && cell.getCellType() != 3) {
										
										if (!coordinatesMap.containsKey(email)) {
											coordinatesList = new HashSet<Coordinates>();
										}
										
										if(rowCoordinates) {
											coordinatesData = new Coordinates();
											rowCoordinates = false;
										}									
										coordinatesData = (Coordinates) schemaService.setArrayData(coordinatesData, cell, schemaAttr[3]);
										
																											
																		
									}
									else {
										
										lastLoginLocationData = (LastLoginLocation) schemaService.setArrayData(lastLoginLocationData, cell, schemaAttr[2]);	
									}
									
								
								} else if (schemaAttr[1].equals(SCHEMA_LIKES) && cell.getCellType() != 3) {
									if (!likesMap.containsKey(email)) {
										likesList = new HashSet<Likes>();
									}
									if(rowLikes) {
										likesData = new Likes();
										rowLikes = false;
									}
									
									likesData = (Likes) schemaService.setArrayData(likesData, cell, schemaAttr[2]);	
									
								} else if (schemaAttr[1].equals(SCHEMA_OIDC_DATA) && cell.getCellType() != 3) {
									if (!oidcDataMap.containsKey(email)) {
										oidcDataList = new HashSet<OidcData>();
									}
									if(rowOidcData) {
										oidcDataData = new OidcData();
										rowOidcData = false;
									}
									
									if (schemaAttr[2].equals(SCHEMA_ADDRESS) && cell.getCellType() != 3) {
										
										if (!addressMap.containsKey(email)) {
											addressList = new HashSet<Address>();
										}
										
										if(rowAddress) {
											addressData = new Address();
											rowAddress = false;
										}									
										addressData = (Address) schemaService.setArrayData(addressData, cell, schemaAttr[3]);
										
										
									}
									
									else {
										oidcDataData = (OidcData) schemaService.setArrayData(oidcDataData, cell, schemaAttr[2]);
									}
									
									
								} else if (schemaAttr[1].equals(SCHEMA_PATENTS) && cell.getCellType() != 3) {
									if (!patentsMap.containsKey(email)) {
										patentsList = new HashSet<Patents>();
									}
									if(rowPatents) {
										patentsData = new Patents();
										rowPatents = false;
									}
									
									patentsData = (Patents) schemaService.setArrayData(patentsData, cell, schemaAttr[2]);
									
								} else if (schemaAttr[1].equals(SCHEMA_PHONES) && cell.getCellType() != 3) {
									if (!phonesMap.containsKey(email)) {
										phonesList = new HashSet<Phones>();
									}
									if(rowPhones) {
										phonesData = new Phones();
										rowPhones = false;
									}
									
									phonesData = (Phones) schemaService.setArrayData(phonesData, cell, schemaAttr[2]);	
									
								}  else if (schemaAttr[1].equals(SCHEMA_PUBLICATIONS) && cell.getCellType() != 3) {
									if (!publicationsMap.containsKey(email)) {
										publicationsList = new HashSet<Publications>();
									}
									if(rowPublications) {
										publicationsData = new Publications();
										rowPublications = false;
									}
									
									publicationsData = (Publications) schemaService.setArrayData(publicationsData, cell, schemaAttr[2]);
									
								}   else if (schemaAttr[1].equals(SCHEMA_SKILLS) && cell.getCellType() != 3) {
									if (!skillsMap.containsKey(email)) {
										skillsList = new HashSet<Skills>();
									}
									if(rowSkills) {
										skillsData = new Skills();
										rowSkills = false;
									}
									
									skillsData = (Skills) schemaService.setArrayData(skillsData, cell, schemaAttr[2]);
									
								}   else if (schemaAttr[1].equals(SCHEMA_WORK) && cell.getCellType() != 3) {
									if (!workMap.containsKey(email)) {
										workList = new HashSet<Work>();
									}
									if(rowWork) {
										workData = new Work();
										rowWork = false;
									}
									
									workData = (Work) schemaService.setArrayData(workData, cell, schemaAttr[2]);
								}
							
								
								else {	
									
									profile = (Profile) schemaService.setSchema(profile, cell, schemaAttr[1]);
								}
								

							} else if (schemaAttr[0].equals(SCHEMA_DATA)) {
								
																
								if (schemaAttr[1].equals(SCHEMA_CHILD) && cell.getCellType() != 3) {
										
										if (!childMap.containsKey(email)) {
											childList = new HashSet<Child>();
										}
										
										if(rowChild) {
											childData = new Child();
											rowChild = false;
										}
										
										
										if (schemaAttr[2].equals(SCHEMA_AREA_OF_INTEREST) && cell.getCellType() != 3) {
											if (!areaOfInterestChildMap.containsKey(email)) {
												areaOfInterestChildList = new HashSet<AreaOfInterest>();
											}
											if(rowAreaOfInterestChild) {
												areaOfInterestChildData = new AreaOfInterest();
												rowAreaOfInterestChild = false;
											}
											
											areaOfInterestChildData = (AreaOfInterest) schemaService.setArrayData(areaOfInterestChildData, cell, schemaAttr[3]);	
										}
										
										else {
											childData = (Child) schemaService.setArrayData(childData, cell, schemaAttr[2]);
										}
											
																												
																		
									} else if (schemaAttr[1].equals(SCHEMA_PET) && cell.getCellType() != 3) {
										
										if (!petMap.containsKey(email)) {
											petList = new HashSet<Pet>();
										}
										
										if(rowPet) {
											petData = new Pet();
											rowPet = false;
										}	
										
										if (schemaAttr[2].equals(SCHEMA_AREA_OF_INTEREST) && cell.getCellType() != 3) {
											if (!areaOfInterestPetMap.containsKey(email)) {
												areaOfInterestPetList = new HashSet<AreaOfInterest>();
											}
											if(rowAreaOfInterestPet) {
												areaOfInterestPetData = new AreaOfInterest();
												rowAreaOfInterestPet = false;
											}
											
											areaOfInterestPetData = (AreaOfInterest) schemaService.setArrayData(areaOfInterestPetData, cell, schemaAttr[3]);	
										}
										
										else {
											petData = (Pet) schemaService.setArrayData(petData, cell, schemaAttr[2]);
										}
										
																		
																		
									}else if (schemaAttr[1].equals(SCHEMA_EXTERNAL_APPLICATION) && cell.getCellType() != 3) {
										
										if (!externalApplicationMap.containsKey(email)) {
											externalApplicationList = new HashSet<ExternalApplication>();
										}
										if(rowExternalApplication) {
											externalApplicationData = new ExternalApplication();
											rowExternalApplication = false;
										}
										externalApplicationData = (ExternalApplication) schemaService.setArrayData(externalApplicationData, cell, schemaAttr[2]);
										
									} 
									 else if (schemaAttr[1].equals(SCHEMA_AREA_OF_INTEREST) && cell.getCellType() != 3) {
										if (!areaOfInterestMap.containsKey(email)) {
											areaOfInterestList = new HashSet<AreaOfInterest>();
										}
										if(rowAreaOfInterest) {
											areaOfInterestData = new AreaOfInterest();
											rowAreaOfInterest = false;
										}
										
										areaOfInterestData = (AreaOfInterest) schemaService.setArrayData(areaOfInterestData, cell, schemaAttr[2]);	
									}
								
									 else if (schemaAttr[1].equals(SCHEMA_NUTRITION_COOKING_DISLIKES) && cell.getCellType() != 3) {
											if (!nutritionCookingDislikesMap.containsKey(email)) {
												nutritionCookingDislikesList = new HashSet<NutritionCookingDislikes>();
											}
											if(rowNutritionCookingDislikes) {
												nutritionCookingDislikesData = new NutritionCookingDislikes();
												rowNutritionCookingDislikes = false;
											}
											
											nutritionCookingDislikesData = (NutritionCookingDislikes) schemaService.setArrayData(nutritionCookingDislikesData, cell, schemaAttr[2]);	
										}
								
								////////////
									 else if (schemaAttr[1].equals(SCHEMA_NUTRITION_COOKING_STYLE) && cell.getCellType() != 3) {
											if (!nutritionCookingStyleMap.containsKey(email)) {
												nutritionCookingStyleList = new HashSet<NutritionCookingStyle>();
											}
											if(rowNutritionCookingStyle) {
												nutritionCookingStyleData = new NutritionCookingStyle();
												rowNutritionCookingStyle = false;
											}
											
											nutritionCookingStyleData = (NutritionCookingStyle) schemaService.setArrayData(nutritionCookingStyleData, cell, schemaAttr[2]);	
										}
								
								
									 else if (schemaAttr[1].equals(SCHEMA_NUTRITION_DIET) && cell.getCellType() != 3) {
											if (!nutritionDietMap.containsKey(email)) {
												nutritionDietList = new HashSet<NutritionDiet>();
											}
											if(rowNutritionDiet) {
												nutritionDietData = new NutritionDiet();
												rowNutritionDiet = false;
											}
											
											nutritionDietData = (NutritionDiet) schemaService.setArrayData(nutritionDietData, cell, schemaAttr[2]);	
										}
								
									 else if (schemaAttr[1].equals(SCHEMA_ASSET) && cell.getCellType() != 3) {
											if (!assetMap.containsKey(email)) {
												assetList = new HashSet<Asset>();
											}
											if(rowAsset) {
												assetData = new Asset();
												rowAsset = false;
											}
											
											assetData = (Asset) schemaService.setArrayData(assetData, cell, schemaAttr[2]);	
										}
								
									 else if (schemaAttr[1].equals(SCHEMA_DIGITAL_ASSET) && cell.getCellType() != 3) {
											if (!digitalAssetMap.containsKey(email)) {
												digitalAssetList = new HashSet<DigitalAsset>();
											}
											if(rowDigitalAsset) {
												digitalAssetData = new DigitalAsset();
												rowDigitalAsset = false;
											}
											
											digitalAssetData = (DigitalAsset) schemaService.setArrayData(digitalAssetData, cell, schemaAttr[2]);	
										}
								
									 else if (schemaAttr[1].equals(SCHEMA_OPTIN) && cell.getCellType() != 3) {
											if (!optinMap.containsKey(email)) {
												optinList = new HashSet<Optin>();
											}
											if(rowOptin) {
												optinData = new Optin();
												rowOptin = false;
											}
											
											optinData = (Optin) schemaService.setArrayData(optinData, cell, schemaAttr[2]);	
										}
								
									 else if (schemaAttr[1].equals(SCHEMA_NUTRITION_COOKING_LIKES) && cell.getCellType() != 3) {
											if (!nutritionCookingLikesMap.containsKey(email)) {
												nutritionCookingLikesList = new HashSet<NutritionCookingLikes>();
											}
											if(rowNutritionCookingLikes) {
												nutritionCookingLikesData = new NutritionCookingLikes();
												rowNutritionCookingLikes = false;
											}
											
											nutritionCookingLikesData = (NutritionCookingLikes) schemaService.setArrayData(nutritionCookingLikesData, cell, schemaAttr[2]);	
										}
								
									 else if (schemaAttr[1].equals(SCHEMA_NUTRITION_COOKING_FOR) && cell.getCellType() != 3) {
											if (!nutritionCookingForMap.containsKey(email)) {
												nutritionCookingForList = new HashSet<NutritionCookingFor>();
											}
											if(rowNutritionCookingFor) {
												nutritionCookingForData = new NutritionCookingFor();
												rowNutritionCookingFor = false;
											}
											
											nutritionCookingForData = (NutritionCookingFor) schemaService.setArrayData(nutritionCookingForData, cell, schemaAttr[2]);	
										}
									
									else {										
										data = (Data) schemaService.setSchema(data, cell, schemaAttr[1]);
									}

							} else if (schemaAttr[0].equals(SCHEMA_SUBSCRIPTIONS)) {
								
								if (!subscriptionMap.containsKey(email)) {
									subMap = new HashMap<>();
								}
								if (schemaAttr[1].equals(SCHEMA_SUBSCRIPTIONS_NAME)) {
									subsClassName = cell.getStringCellValue();
								}
								if (schemaAttr[1].equals(SCHEMA_SUBSCRIPTIONS_EMAIL)) {
									if (schemaAttr[2].equals(SCHEMA_SUBSCRIPTIONS_EMAIL_TAGS)) {
										emailData = (Email) schemaService.setSchemaArray(emailData, cell,
												schemaAttr[2],textAreaStatus);
									} else {
										emailData = (Email) schemaService.setSchema(emailData, cell, schemaAttr[2]);
									}
								}
							}
							
							
							///Preferences object
							
							else if (schemaAttr[0].equals(SCHEMA_PREFERENCES)) {
								
								if (!preferencesMap.containsKey(email)) {
									preMap = new HashMap<>();
								}
								if (schemaAttr[1].equals(SCHEMA_PREFERENCES_NAME)) {
									preClassName = cell.getStringCellValue();
								}
								if (schemaAttr[1].equals(SCHEMA_PREFERENCES_TERMS)) {
									if (schemaAttr[2].equals(SCHEMA_PREFERENCES_TERMS_TAGS)) {
									
										termsData = (Terms) schemaService.setSchemaArray(termsData, cell,
												schemaAttr[2],textAreaStatus);
								}else {
									termsData = (Terms) schemaService.setSchema(termsData, cell, schemaAttr[2]);
									}
								}
							}
							
							else if(schemaAttr[0].equals(SCHEMA_IDENTITIES) && cell.getCellType() != 3) {
								
								if (!identitiesMap.containsKey(email)) {
									identitiesList = new HashSet<Identities>();
								}
								if(rowIdentities) {
									identitiesData = new Identities();
									rowIdentities = false;
								}

								identitiesData = (Identities) schemaService.setArrayData(identitiesData, cell, schemaAttr[1]);		
								
							}
							else if(schemaAttr[0].equals(SCHEMA_LOGIN_IDS) && cell.getCellType() !=3) {	
							
								if(schemaAttr[1].equals(SCHEMA_LOGIN_IDS_EMAILS) ) {
									
									loginData = (LoginIds) schemaService.setSchemaArray(loginData, cell,
											schemaAttr[1],textAreaStatus);														
								}
								
									acc.setLoginIDs(loginData);
								
								
							}
							else if(schemaAttr[0].equals(SCHEMA_EMAILS)) {	
								
								if(schemaAttr[1].equals(SCHEMA_EMAILS_VERIFIED)) {
									
									emailsData = (Emails) schemaService.setSchemaArray(emailsData, cell,
											schemaAttr[1],textAreaStatus);	
									
								}
								if(schemaAttr[1].equals(SCHEMA_EMAILS_UNVERIFIED)) {
									
									emailsData = (Emails) schemaService.setSchemaArray(emailsData, cell,
											schemaAttr[1],textAreaStatus);	
									
								}
								
									
								acc.setEmails(emailsData);
								
							}
							else if(schemaAttr[0].equals(SCHEMA_PASSWORD)) {
								
								if(schemaAttr[1].equals(SCHEMA_PASSWORD_COMPOUND_HASH)) {
																		
									if(cell.getCellType() != 3) {
										passwordCheck= true;
										password = (Password) schemaService.setSchema(password, cell, schemaAttr[1]);
										acc.setPassword(password);
										
									}				
								}
								
								else if(schemaAttr[1].equals(SCHEMA_PASSWORD_HASH) && !passwordCheck && cell.getCellType() != 3) {

									password = (Password) schemaService.setSchema(password, cell, schemaAttr[1]);							
								}
								else if(schemaAttr[1].equals(SCHEMA_PASSWORD_HASH_SETTINGS) && !passwordCheck && cell.getCellType() !=3) {
									
									if(schemaAttr[2].equals(SCHEMA_PASSWORD_HASH_SETTINGS_ALGORITHM)){
										
										hashSettings = (HashSettings) schemaService.setSchema(hashSettings, cell, schemaAttr[2]);
										
									}
									if(schemaAttr[2].equals(SCHEMA_PASSWORD_HASH_SETTINGS_SALT)){
										
										hashSettings = (HashSettings) schemaService.setSchema(hashSettings, cell, schemaAttr[2]);
										
									}
									if(schemaAttr[2].equals(SCHEMA_PASSWORD_HASH_SETTINGS_FORMAT)){
	
										hashSettings = (HashSettings) schemaService.setSchema(hashSettings, cell, schemaAttr[2]);
	
									}
									if(schemaAttr[2].equals(SCHEMA_PASSWORD_HASH_SETTINGS_URL)){
										
										hashSettings = (HashSettings) schemaService.setSchema(hashSettings, cell, schemaAttr[2]);
	
									}
									password.setHashSettings(hashSettings);
									acc.setPassword(password);		
								}	
							}
						}
						 else {
							
							acc = (Accounts) schemaService.setSchema(acc, cell, headerName[cell.getColumnIndex()]);
						}
						
	
					} // coll iterator ends
					
					if(!isLite && !email.isEmpty() && emailValid && !loginEmail.isEmpty() && loginEmailValid && SchemaService.invalidBooleanIndexes.isEmpty() && SchemaService.mandatoryValuesIndexes.isEmpty()) {
						
						subMap = schemaService.addSubscriptions(subMap, subsClassName, "email",
								emailData);
						
						preMap = schemaService.addPreferences(preMap, preClassName, "terms",
								termsData);
						
						
						acc =setStaticData(staticValues, schemaService, profile, acc, data);			
						acc.setUID(UUID.randomUUID().toString());
						
						accList.put(email, schemaService.setAccountObj(textAreaStatus,email, acc, subMap, childList, childData,petList,petData,
									subscriptionMap, childMap, petMap, data, profile, subscriptions,identitiesList,identitiesData,identitiesMap,areaOfInterestList, areaOfInterestData,areaOfInterestMap, externalApplicationList,externalApplicationMap,externalApplicationData,nutritionCookingDislikesList,nutritionCookingDislikesData, nutritionCookingDislikesMap,
									nutritionCookingLikesList, nutritionCookingLikesData,nutritionCookingLikesMap, nutritionCookingForList, nutritionCookingForData,nutritionCookingForMap,
									nutritionCookingStyleList,nutritionCookingStyleData,nutritionCookingStyleMap,nutritionDietList,nutritionDietData,nutritionDietMap,assetList,assetData,assetMap,
									digitalAssetList,digitalAssetData,digitalAssetMap,optinList,optinData,optinMap,certificationsList, certificationsData,certificationsMap, educationList,educationData,educationMap,
									favoritesList,favoritesData,favoritesMap, lastLoginLocationList,lastLoginLocationData,lastLoginLocationMap, likesList, likesData, likesMap, oidcDataList, oidcDataData, oidcDataMap,
									patentsList, patentsData, patentsMap, phonesList, phonesData, phonesMap, publicationsList, publicationsData, publicationsMap, skillsList, skillsData, skillsMap, workList, workData, workMap,
									activitiesList,activitiesData,activitiesMap,booksList,booksData,booksMap,interestsList,interestsData,interestsMap,moviesList,moviesData,moviesMap,musicList,musicData,musicMap,
									televisionList,televisionData,televisionMap,coordinatesList,coordinatesData,coordinatesMap,addressList,addressData,addressMap,areaOfInterestChildList,areaOfInterestChildData,areaOfInterestChildMap,
									areaOfInterestPetList,areaOfInterestPetData,areaOfInterestPetMap,preMap, preferencesMap,preferences,termsData));	 
					}
					if(isLite && !email.isEmpty() && emailValid && SchemaService.invalidBooleanIndexes.isEmpty() && SchemaService.mandatoryValuesIndexes.isEmpty()) {
						subMap = schemaService.addSubscriptions(subMap, subsClassName, "email",
								emailData);
						preMap = schemaService.addPreferences(preMap, preClassName, "terms",
								termsData);
						acc =setStaticData(staticValues, schemaService, profile, acc, data);
						acc.setUID(UUID.randomUUID().toString());	
						accList.put(email, schemaService.setAccountObj(textAreaStatus,email, acc, subMap, childList, childData,petList,petData,
									subscriptionMap, childMap, petMap, data, profile, subscriptions,identitiesList,identitiesData,identitiesMap,areaOfInterestList, areaOfInterestData,areaOfInterestMap, externalApplicationList,externalApplicationMap,externalApplicationData,nutritionCookingDislikesList,nutritionCookingDislikesData, nutritionCookingDislikesMap,
									nutritionCookingLikesList, nutritionCookingLikesData,nutritionCookingLikesMap, nutritionCookingForList, nutritionCookingForData,nutritionCookingForMap,
									nutritionCookingStyleList,nutritionCookingStyleData,nutritionCookingStyleMap,nutritionDietList,nutritionDietData,nutritionDietMap,assetList,assetData,assetMap,
									digitalAssetList,digitalAssetData,digitalAssetMap,optinList,optinData,optinMap,certificationsList, certificationsData,certificationsMap, educationList,educationData,educationMap,
									favoritesList,favoritesData,favoritesMap, lastLoginLocationList,lastLoginLocationData,lastLoginLocationMap, likesList, likesData, likesMap, oidcDataList, oidcDataData, oidcDataMap,
									patentsList, patentsData, patentsMap, phonesList, phonesData, phonesMap, publicationsList, publicationsData, publicationsMap, skillsList, skillsData, skillsMap, workList, workData, workMap,
									activitiesList,activitiesData,activitiesMap,booksList,booksData,booksMap,interestsList,interestsData,interestsMap,moviesList,moviesData,moviesMap,musicList,musicData,musicMap,
									televisionList,televisionData,televisionMap,coordinatesList,coordinatesData,coordinatesMap,addressList,addressData,addressMap,areaOfInterestChildList,areaOfInterestChildData,areaOfInterestChildMap,
									areaOfInterestPetList,areaOfInterestPetData,areaOfInterestPetMap,preMap, preferencesMap,preferences,termsData));
					}
					
					
								
				}		
				
				nextRow = null;
			}//row iterator ends
			
			firstSheet = null;
			workbook = null;
			inputStream = null;			
			List<Accounts> list = new ArrayList<Accounts>(accList.values());
			createJson(list, excelOutputFilePath,textAreaStatus, emailIndexes, emailInvalidIndexes);
			}
			} catch (Exception e) {
			e.printStackTrace();
			StringWriter stackTraceWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stackTraceWriter));
			textAreaStatus.setText(e.toString() + "\n" + stackTraceWriter.toString());
		}
	}
	
	
	/**
	 * @param staticValues - Map to store static data
	 * @param schemaService - Object of Scehma Service class
	 * @param profile - Object of Profile Class
	 * @param acc - Accounts Class Object
	 * @param data - Data Class Object
	 * @return - acc after setting the static data
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static Accounts setStaticData(Map<String, String> staticValues ,SchemaService schemaService, Profile profile, Accounts acc, Data data) throws IllegalAccessException, InvocationTargetException {
		for (Map.Entry<String, String> entry : staticValues.entrySet()) {
		    if (entry.getKey().contains(".")) {
				String[] schemaAttrStatic = entry.getKey().toString().split("\\.");
				if (schemaAttrStatic[0].equals(SCHEMA_PROFILE)) {

					acc.setProfile(((Profile) ((SchemaService) schemaService).setSchema(profile, entry.getValue(), schemaAttrStatic[1])));

				}
				else if (schemaAttrStatic[0].equals(SCHEMA_DATA)) {

					acc.setData(((Data) ((SchemaService) schemaService).setSchema(data, entry.getValue(), schemaAttrStatic[1])));							
				}
		}
		
		}
		return acc;
	}

	/**
	 * Creates the output JSON and writes it to the output file
	 * @param list - List of all the accounts 
	 * @param outputJsonFilePath - File where the output JSON will be created
	 * @param textAreaStatus - Text area to display the output message
	 * @param emailIndexes - Stores empty email indexes
	 * @param emailInvalidIndexes - Stores invalid email indexes
	 * @throws IOException
	 * 
	 */

		public static void createJson(List<Accounts> list, String outputJsonFilePath, JTextArea textAreaStatus, List<Integer> emailIndexes, List<Integer> emailInvalidIndexes) throws IOException {	
			Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();	
			String jsonOutput = gson.toJson(list);
			jsonOutput = jsonOutput.replace("\\\\","\\");
			jsonOutput = jsonOutput.replace("\"gigsys\": {","");
			jsonOutput = jsonOutput.replaceAll("(gigsys_RG.*)\\r?\\n\\s+}", "$1");
					
			FileUtils.writeStringToFile(new File(outputJsonFilePath), jsonOutput,"utf8");

			if(!emailIndexes.isEmpty() && emailInvalidIndexes.isEmpty()) {
				textAreaStatus.setText(SUCCESS_MESSAGE + list.size() + RECORDS + outputJsonFilePath + ROW_ERROR_MESSAGE + emailIndexes + NO_EMAIL_ERROR_MESSAGE );
			}
			else if(!emailInvalidIndexes.isEmpty() && emailIndexes.isEmpty()) {
				textAreaStatus.setText(SUCCESS_MESSAGE + list.size() + RECORDS + outputJsonFilePath + ROW_ERROR_MESSAGE + emailInvalidIndexes + INVALID_EMAIL_ERROR_MESSAGE );
			}
			else if(!emailIndexes.isEmpty() && !emailInvalidIndexes.isEmpty()) {
				textAreaStatus.setText(SUCCESS_MESSAGE + list.size() + RECORDS + outputJsonFilePath + ROW_ERROR_MESSAGE  + emailIndexes + NO_EMAIL_ROW_ERROR_MESSAGE + emailInvalidIndexes + INVALID_EMAIL_ERROR_MESSAGE);
			}
			else {
				
				if(SchemaService.invalidBooleanValues.isEmpty() && !SchemaService.mandatoryValues.isEmpty()) {
					textAreaStatus.setText(SUCCESS_MESSAGE + list.size() + RECORDS + outputJsonFilePath + ENTER + BOOLEAN_VALUE_MESSAGE + NEWLINE + MANDATORY_VALUE_ERROR_MESSAGE + NEWLINE + SchemaService.mandatoryValues);
				}
				else if(!SchemaService.invalidBooleanValues.isEmpty() && SchemaService.mandatoryValues.isEmpty()) {
					textAreaStatus.setText(SUCCESS_MESSAGE + list.size() + RECORDS + outputJsonFilePath + ENTER + BOOLEAN_VALUE_MESSAGE + NEWLINE + BOOLEAN_VALUE_ERROR_MESSAGE + NEWLINE + SchemaService.invalidBooleanValues);
				}
				else if(!SchemaService.invalidBooleanValues.isEmpty() && !SchemaService.mandatoryValues.isEmpty()) {
					textAreaStatus.setText(SUCCESS_MESSAGE + list.size() + RECORDS + outputJsonFilePath + ENTER + BOOLEAN_VALUE_MESSAGE + NEWLINE + BOOLEAN_VALUE_ERROR_MESSAGE + NEWLINE + SchemaService.invalidBooleanValues + NEWLINE + AND + NEWLINE + MANDATORY_ERROR_MESSAGE + NEWLINE + SchemaService.mandatoryValues);
				}
				else {
					textAreaStatus.setText(SUCCESS_MESSAGE + list.size() + RECORDS + outputJsonFilePath);
				}
										
			}
			
			Font font = new Font("Calibri", Font.BOLD, 15);
			textAreaStatus.setBackground(Color.DARK_GRAY);
			textAreaStatus.setFont(font);
			textAreaStatus.setLineWrap(true);
			textAreaStatus.setForeground(Color.WHITE);
			textAreaStatus.setEditable(false);
			System.out.println("file is created");	
			
	}

}
