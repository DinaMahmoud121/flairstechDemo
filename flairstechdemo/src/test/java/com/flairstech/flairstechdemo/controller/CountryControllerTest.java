package com.flairstech.flairstechdemo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flairstech.flairstechdemo.entity.Country;
import com.flairstech.flairstechdemo.entity.CountryLanguage;
import com.flairstech.flairstechdemo.service.CountryService;

class CountryControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private CountryService countryService;

	@Test
    void testFindCountryByCode1() throws Exception {
		
		String code = "BHR";
		String URI = "http://localhost:12120/"+code;
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = code;
	    String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).contains(expectedJson);
    }
	
	@Test
	public void testFindCountryByCode2() throws Exception {
		
		Country mocCountry = new Country();
		CountryLanguage mocCountryLanguage1 = new CountryLanguage();
		CountryLanguage mocCountryLanguage2 = new CountryLanguage();
		List<CountryLanguage> mocCountryLanguages = new ArrayList<>();
		
		mocCountryLanguage1.setCountryCode("BHR");
		mocCountryLanguage1.setLanguage("Arabic");
		mocCountryLanguage2.setCountryCode("BHR");
		mocCountryLanguage2.setLanguage("English");
		
		mocCountryLanguages.add(mocCountryLanguage1);
		mocCountryLanguages.add(mocCountryLanguage2);
		
		
		mocCountry.setCode("BHR");
		mocCountry.setName("Bahrain");
		mocCountry.setContinent("Asia");
		mocCountry.setPopulation(617000);
		mocCountry.setLifeExpectancy(73);
		mocCountry.setLanguages(new ArrayList<CountryLanguage>());
		mocCountry.setLanguages(mocCountryLanguages);
		
		Mockito.when(countryService.fingByCode(Mockito.anyString())).thenReturn(mocCountry);
		
		String URI = "http://localhost:12120/BHR";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(mocCountry);
	    String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson); 
		
	}
	
	private String mapToJson(Object object) throws JsonProcessingException  {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

}
