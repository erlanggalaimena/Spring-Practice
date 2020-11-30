package com.luv2code.springdemo.model;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	private String favoriteLanguage;
	
	private LinkedHashMap<String, String> countryOptions;
	private LinkedHashMap<String, String> favoriteLanguageOptions;
	
	private String[] operatingSystems;

	public Student() {
		this.countryOptions = new LinkedHashMap<String, String>();
		this.countryOptions.put("IDN", "Indonesia");
		this.countryOptions.put("ITA", "Italy");
		this.countryOptions.put("FRA", "France");
		this.countryOptions.put("ENG", "England");
		this.countryOptions.put("USA", "United States");
		
		this.favoriteLanguageOptions = new LinkedHashMap<String, String>();
		this.favoriteLanguageOptions.put("JAVA", "Java");
		this.favoriteLanguageOptions.put("C#", "C#");
		this.favoriteLanguageOptions.put("PHP", "PHP");
		this.favoriteLanguageOptions.put("RUBY", "Ruby");
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
		return favoriteLanguageOptions;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

}
