package com.flairstech.flairstechdemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CountryLanguageId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "country_code")
	private String countryCode;
	
	@Column(name = "language")
	private String language;

	
	public CountryLanguageId() {
		
	}
	
	public CountryLanguageId(String language, String countryCode) {
		this.language = language;
		this.countryCode = countryCode;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	
	
}
