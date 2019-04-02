package com.apalya.dao;

import com.apalya.entity.UserCredentials;
import com.apalya.entity.Userdeatails;
import com.apalya.exception.BusinessException;

public interface UserDao {
	
	UserCredentials saveNewUser(UserCredentials user) throws BusinessException;

	Userdeatails saveNewUserDetails(Userdeatails ud) throws BusinessException;

	UserCredentials checkuserexist(String username, String password) throws BusinessException;

	Userdeatails getUserDetails(Integer id) throws BusinessException;

	Boolean checkusername(String trim) throws BusinessException;

		
}
