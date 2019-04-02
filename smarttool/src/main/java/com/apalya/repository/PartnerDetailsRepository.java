package com.apalya.repository;

import org.springframework.data.repository.CrudRepository;

import com.apalya.entity.PartnerDetails;

public interface PartnerDetailsRepository extends CrudRepository<PartnerDetails, Integer>{

	PartnerDetails findById(Integer operatorid);

}
