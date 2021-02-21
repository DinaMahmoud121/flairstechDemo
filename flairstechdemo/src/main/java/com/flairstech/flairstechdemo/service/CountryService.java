package com.flairstech.flairstechdemo.service;

import java.util.List;

import com.flairstech.flairstechdemo.entity.Country;

public interface CountryService {
	
	public Country fingByCode(String code);
	public List<Country> findAll();
}
