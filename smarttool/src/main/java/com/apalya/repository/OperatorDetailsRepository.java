package com.apalya.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apalya.entity.OperatorDetails;

public interface OperatorDetailsRepository extends JpaRepository<OperatorDetails, Integer>{

	OperatorDetails findById(Integer operatorid);
	List<OperatorDetails> findByCountrydetailsId(Integer countryid);
	
	
}
