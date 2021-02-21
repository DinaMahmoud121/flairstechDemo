package com.flairstech.flairstechdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flairstech.flairstechdemo.entity.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, String> {

	
//    @Query("SELECT country.*, country_language.is_official FROM country,  c WHERE " +
//            "c.country_code = :code AND country_language.coutry_code = :code And country_language.is_official = true")
//	public Country findByCode(@Param("code") String code);
	
	public Country findByCode(String code);

}
