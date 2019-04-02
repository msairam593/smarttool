package com.apalya.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apalya.entity.ModeDetails;


@Repository
public interface ModeDetailsRepository extends CrudRepository<ModeDetails, Integer>{

	ModeDetails findByModenname(String modenname);

	ModeDetails findById(Integer mode);

}
