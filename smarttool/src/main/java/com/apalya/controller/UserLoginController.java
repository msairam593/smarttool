package com.apalya.controller;

import java.util.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apalya.dto.UserDetailsDto;
import com.apalya.entity.RoleDetails;
import com.apalya.entity.UserCredentials;
import com.apalya.entity.Userdeatails;
import com.apalya.exception.BusinessException;
import com.apalya.exception.RestServiceException;
import com.apalya.model.Userregistration;
import com.apalya.service.PlatformService;
import com.apalya.service.UserService;
import com.apalya.util.SmartApalyaUtils;

@Controller
// @RequestMapping("/user")
public class UserLoginController {

	private static final Logger log = LoggerFactory.getLogger(UserLoginController.class);
	
	@Autowired
	private Environment env;

	@Autowired
	private UserService userservice;

	@Autowired
	private PlatformService Userregistration;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String loginform(Model model) throws BusinessException {
		Userregistration user = new Userregistration();

		// user.setCountries(Userregistration.getAllcountries());
		model.addAttribute("countries", Userregistration.getAllcountries());
		model.addAttribute("roles", Userregistration.getAllRoles());
		model.addAttribute("user", user);
		return "/registration";
	}

	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
	public String createuser(@Valid Userregistration user, BindingResult result, Model model) throws RestServiceException, BusinessException{
		log.info("create user controller called" + user.getUsername() + " password " + user.getPassword() + " active "
				+ user.toString());
		if (result.hasErrors()) {
			log.info("has some errors");
			model.addAttribute("countries", Userregistration.getAllcountries());
			model.addAttribute("roles", Userregistration.getAllRoles());
			model.addAttribute("user", user);
			return "/registration";
		}
		UserCredentials usercredential = null;
		Userdeatails ud = null;
		String responce = null;
		try {
			usercredential = userservice.saveuserdetails(user);
			ud = userservice.saveuser(usercredential, user);
			model.addAttribute("countries", Userregistration.getAllcountries());
			model.addAttribute("user", user);

			responce=SmartApalyaUtils.toJsonString(ud);

		}  catch (BusinessException e) {
			log.error("Error Occured "+e.getMessage());
			throw new RestServiceException(HttpStatus.BAD_REQUEST.value(), env.getProperty(e.getErrorCode()),
					e.getErrorCode(), "Error occured while creating new user");
		}catch (Exception e) {
			log.error("Error Occured : "+e.getMessage());
			return "/registration";
		}
		return "/registration";

	}

	@RequestMapping(value = "/loginuser", method = RequestMethod.GET)
	public String userLogin(Model model) throws BusinessException {
		return "/login";
	}
	
	
	@RequestMapping("/Userlogin")
	public String loginUser(@RequestParam("username")String username,@RequestParam("password")String password,Model model) throws RestServiceException {
		UserDetailsDto userDetailsDto=new UserDetailsDto();
		
		try {
			userDetailsDto = userservice.loginuser(username, password);
			if(userDetailsDto!=null && !(userDetailsDto.equals(null)))
			{
				log.info("userDetailsDto"+userDetailsDto.toString());
				
				if (!(userDetailsDto.getEndDate().after(new Date()))) {
					model.addAttribute("error","Credententials Expired");
                    return "/login";
				}
			}
			else {
				model.addAttribute("error","INVALID Credententials");
				return "/login";
			}
		}  catch (BusinessException e) {
			log.error("Error Occured "+e.getMessage());
			throw new RestServiceException(HttpStatus.BAD_REQUEST.value(), env.getProperty(e.getErrorCode()),
					e.getErrorCode(), "Error occured while login user");
		}catch (Exception e) {
			log.error("Error Occured : "+e.getMessage());
			model.addAttribute("error","Please check valid credententials or You are Expired");
			return "/login";
		}
		return "/success";
	}
	
	@RequestMapping("/userstatus")
	public ResponseEntity<String> checkusername(@RequestParam("username")String username) throws RestServiceException{
		Boolean b;
		String x="";
		try {
			b = userservice.checkusername(username);
			
			if (b) {
				x=username+" already existed";
			}
		} catch (BusinessException e) {
			log.error("Error Occured "+e.getMessage());
			throw new RestServiceException(HttpStatus.BAD_REQUEST.value(), env.getProperty(e.getErrorCode()),
					e.getErrorCode(), "Error occured while getting username");
		}catch (Exception e) {
			throw new RestServiceException(HttpStatus.BAD_REQUEST.value(), env.getProperty(((BusinessException) e).getErrorCode()),
					((BusinessException) e).getErrorCode(), "Error occured while getting username");
		}
		
		return new ResponseEntity<String>(x, HttpStatus.OK);
	}
	
	@RequestMapping("/token")
	public String token() throws RestServiceException {
		
		return "/checktoken";
	}
	
	@GetMapping("/checktoken/{token}")
	public ResponseEntity<String> checktoken(@PathVariable("token")String token) throws RestServiceException{
		String x=token;
		return new ResponseEntity<String>(x, HttpStatus.OK);
	}

}
