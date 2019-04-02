package com.apalya.service.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apalya.dao.PlatformDao;
import com.apalya.dao.UserDao;
import com.apalya.dto.UserDetailsDto;
import com.apalya.entity.UserCredentials;
import com.apalya.entity.Userdeatails;
import com.apalya.exception.BusinessException;
import com.apalya.model.Userregistration;
import com.apalya.service.UserService;

@Component
public class UserServiceImpl implements UserService {
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userdao;

	@Autowired
	private PlatformDao platformdao;

	@Autowired
	private com.apalya.service.dto.UserDetailsDto userdetailsdto;

	@Override
	public UserCredentials saveuserdetails(Userregistration userre) throws BusinessException {
		UserCredentials user = new UserCredentials();
		user.setUsername(userre.getUsername());
		user.setPassword(userre.getPassword());
		try {
			user.setActivedate(new SimpleDateFormat("yyyy-MM-dd").parse(userre.getStartdate()));
			user.setEnddate(new SimpleDateFormat("yyyy-MM-dd").parse(userre.getEnddate()));
			user = userdao.saveNewUser(user);
		} catch (BusinessException e) {
			log.error("Error Occured : " + e.getMessage());
			throw new BusinessException(e.getErrorCode(), e.getSystemMessage());
		} catch (Exception e) {
			log.error("Error Occured : " + e.getMessage());
			throw new BusinessException("ERR_1000", "Error occured while saving new user credentails");
		}

		return user;
	}

	@Override
	public Userdeatails saveuser(UserCredentials usercredential, Userregistration userre) throws BusinessException {
		Userdeatails ud = new Userdeatails();
		ud.setUserid(usercredential.getId());
		ud.setPartnerid(Integer.parseInt(userre.getPartners()));
		ud.setRoleid(Integer.parseInt(userre.getRole()));
		ud.setCreatedon(new Date());
		try {
			ud = userdao.saveNewUserDetails(ud);
		} catch (BusinessException e) {
			log.error("Error Occured : " + e.getMessage());
			throw new BusinessException(e.getErrorCode(), e.getSystemMessage());
		} catch (Exception e) {
			log.error("Error Occured : " + e.getMessage());
			throw new BusinessException("ERR_1000", "Error occured while saving new user details");
		}
		return ud;
	}

	@Override
	public UserDetailsDto loginuser(String username, String password) throws BusinessException {
		UserCredentials uc = null;
		Userdeatails userdetails = null;
		UserDetailsDto user = null;
		try {
			uc = userdao.checkuserexist(username, password);

			if (uc != null && !(uc.equals(null))) {
				userdetails = userdao.getUserDetails(uc.getId());
				log.info("user details :" + userdetails.toString());
				user = userdetailsdto.entityToDto(userdetails,uc.getEnddate());
				log.info("entity to dto :" + user);
			}
			} catch (BusinessException e) {
			log.error("Error Occured : " + e.getMessage());
			throw new BusinessException(e.getErrorCode(), e.getSystemMessage());
		} catch (Exception e) {
			log.error("Error Occured : " + e.getMessage());
			throw new BusinessException("ERR_1000", "Error occured while saving new user details");
		}
		return user;

	}

	@Override
	public Boolean checkusername(String username) throws BusinessException {
		Boolean b;
		try {
			b = userdao.checkusername(username.trim());
		} catch (BusinessException e) {
			log.error("Error Occured : " + e.getMessage());
			throw new BusinessException(e.getErrorCode(), e.getSystemMessage());
		} catch (Exception e) {
			log.error("Error Occured : " + e.getMessage());
			throw new BusinessException("ERR_1000", "Error occured while saving new user details");
		}
		return b;
	}

}
