package com.apalya.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apalya.dao.UserDao;
import com.apalya.entity.UserCredentials;
import com.apalya.entity.Userdeatails;
import com.apalya.exception.BusinessException;
import com.apalya.repository.UserCredentailsRepository;
import com.apalya.repository.UserDetailsRepository;


@Component
public class UserDaoImpl implements UserDao{
	
	private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

	
	@Autowired
	UserCredentailsRepository usercredentailsrepository;
	
	@Autowired
	UserDetailsRepository userdetailsrepository;
	
	@Override
	public UserCredentials saveNewUser(UserCredentials user) throws BusinessException{
		try {
			usercredentailsrepository.save(user);
		} catch(Exception e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException("ERROR", "Error occured while saving the user credentails");
		}
		return usercredentailsrepository.save(user);
	}

	@Override
	public Userdeatails saveNewUserDetails(Userdeatails ud) throws BusinessException {
		Userdeatails udres=new Userdeatails();
		try {
			udres=userdetailsrepository.save(ud);
		} catch(Exception e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException("ERROR", "Error occured while saving the user");
		}
		return udres;
		
		}

	@Override
	public UserCredentials checkuserexist(String username, String password) throws BusinessException {
		UserCredentials user=new UserCredentials();
		try {
			user=usercredentailsrepository.findByUsernameAndPassword(username,password);
		} catch(Exception e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException("ERROR", "Error occured while checking user");
		}
		return user;
		
	}

	@Override
	public Userdeatails getUserDetails(Integer id) throws BusinessException {
		Userdeatails user=new Userdeatails();
		try {
			user=userdetailsrepository.findByUserid(id);
		} catch(Exception e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException("ERROR", "Error occured while saving the user");
		}
		return user;
	}

	@Override
	public Boolean checkusername(String username) throws BusinessException {
		Boolean b;
		try {
			b=usercredentailsrepository.existsByUsername(username);
		} catch(Exception e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException("ERROR", "Error occured while saving the user");
		}
		return b; 
	}

	
}
