package com.apalya.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.apalya.entity.Userdeatails;

@Component
public interface UserDetailsRepository extends CrudRepository<Userdeatails, Integer>{
	
	Userdeatails findByUserid(Integer userid);

}
