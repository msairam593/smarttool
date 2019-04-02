package com.apalya.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apalya.entity.UserCredentials;


@Repository
public interface UserCredentailsRepository extends CrudRepository<UserCredentials, Integer>{
	
	UserCredentials findByUsernameAndPassword(String username,String password);

	Boolean existsByUsername(String username);

}
