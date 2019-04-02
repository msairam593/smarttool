package com.apalya.service;

import com.apalya.dto.UserDetailsDto;
import com.apalya.entity.UserCredentials;
import com.apalya.entity.Userdeatails;
import com.apalya.exception.BusinessException;
import com.apalya.model.Userregistration;

public interface UserService {
	
	UserCredentials saveuserdetails(Userregistration userre) throws BusinessException;

	Userdeatails saveuser(UserCredentials usercredential,Userregistration userre) throws BusinessException;

	UserDetailsDto loginuser(String username, String password) throws BusinessException;

	Boolean checkusername(String username) throws BusinessException;

	

}
