package com.flairstech.flairstechdemo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "country")
public class Country implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NonNull
	@Column(name = "code")
	private String code;

	@NonNull
	@Column(name = "name")
	private String name;

	@NonNull
	@Column(name = "continent")
	private String continent;

	@NonNull
	@Column(name = "population")
	private int population;

	@Column(name = "life_expectancy")
	private long lifeExpectancy;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="countryCode")
	private List<CountryLanguage> languages;

	public Country() {

	}

	public Country(String code, String name, String continent, int population, long lifeExpectancy,
			List<CountryLanguage> languages) {
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.population = population;
		this.lifeExpectancy = lifeExpectancy;
		this.languages = languages;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public long getLifeExpectancy() {
		return lifeExpectancy;
	}

	public void setLifeExpectancy(long lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	public List<CountryLanguage> getLanguages() {
		return languages;
	}

	public void setLanguages(List<CountryLanguage> languages) {
		this.languages = languages;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + ", continent=" + continent + ", population=" + population
				+ ", lifeExpectancy=" + lifeExpectancy + ", languages=" + languages + "]";
	}

}
