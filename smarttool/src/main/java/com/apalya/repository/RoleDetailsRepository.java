package com.apalya.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apalya.entity.RoleDetails;

@Repository
public interface RoleDetailsRepository extends CrudRepository<RoleDetails, Integer>{
	RoleDetails findByRolename(String rolename);

	RoleDetails findById(Integer role);

	boolean existsByRolename(String role);
	
}
