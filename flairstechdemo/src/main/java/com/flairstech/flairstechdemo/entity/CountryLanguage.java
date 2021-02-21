package com.flairstech.flairstechdemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "country_language")
public class CountryLanguage implements Serializable {

	private static final long serialVersionUID = 1L;

//	@EmbeddedId
//    private CountryLanguageId id;

	@Id
	@JsonIgnore
	@Column(name = "country_code")
	private String countryCode;

	@Id
	@Column(name = "\"language\"")
	private String language;

	@JsonIgnore
	@Column(name = "is_official")
	private boolean isOfficial;
	
	public CountryLanguage() {

	}

	public CountryLanguage(String countryCode, String language, boolean isOfficial) {
		super();
		this.countryCode = countryCode;
		this.language = language;
		this.isOfficial = isOfficial;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setOfficial(boolean isOfficial) {
		this.isOfficial = isOfficial;
	}

	@Override
	public String toString() {
		return "CountryLanguage [countryCode=" + countryCode + ", language=" + language + ", isOfficial=" + isOfficial
				+ "]";
	}

}