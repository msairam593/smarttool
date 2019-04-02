package com.apalya.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apalya.entity.CountryDetails;

@Repository
public interface CountryDetailsRepository extends CrudRepository<CountryDetails, Integer>{

	Boolean existsByCountry(String country);

	CountryDetails findById(Integer countryid);

}
