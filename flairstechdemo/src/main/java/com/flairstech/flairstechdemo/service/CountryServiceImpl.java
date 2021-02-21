package com.flairstech.flairstechdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flairstech.flairstechdemo.entity.Country;
import com.flairstech.flairstechdemo.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {
	
	private CountryRepository countryRepository;
	
	@Autowired
	public CountryServiceImpl(CountryRepository theCountryRepository) {
		countryRepository = theCountryRepository;
	}

	@Override
	@Transactional
	public Country fingByCode(String code) {
		return countryRepository.findByCode(code);
	}

	@Override
	@Transactional
	public List<Country> findAll() {
		return (List<Country>) countryRepository.findAll();
	}
	
	
	
}
