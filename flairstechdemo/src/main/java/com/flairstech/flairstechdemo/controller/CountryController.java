package com.flairstech.flairstechdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flairstech.flairstechdemo.entity.Country;
import com.flairstech.flairstechdemo.service.CountryService;

@RestController
@RequestMapping("/")
public class CountryController {
	
	private CountryService countryService;
	
	@Autowired
	public CountryController(CountryService theCountryService) {
		countryService = theCountryService;
	}
	
	@GetMapping("{countryCode}")
	public ResponseEntity<Country> findCountryByCode(@PathVariable String countryCode) {
		if(countryCode.trim().isEmpty())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(countryService.fingByCode(countryCode));
	}
	
}
