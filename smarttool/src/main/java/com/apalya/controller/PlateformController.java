
package com.apalya.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.env.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apalya.dto.ModeDetailsDto;
import com.apalya.dto.OperatorDetailsDto;
import com.apalya.entity.CountryDetails;
import com.apalya.entity.ModeDetails;
import com.apalya.entity.OperatorDetails;
import com.apalya.entity.PartnerDetails;
import com.apalya.entity.RoleDetails;
import com.apalya.exception.BusinessException;
import com.apalya.exception.RestServiceException;
import com.apalya.service.PlatformService;
import com.apalya.service.dto.OperatorsDetailsDto;
import com.apalya.service.dto.PartnerDetailsDto;
import com.apalya.util.SmartApalyaUtils;



@Controller
@RequestMapping("/platform")
public class PlateformController {
	
	private static final Logger log = LoggerFactory.getLogger(PlateformController.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private PlatformService platformservice;

	@RequestMapping("/addmode")
	public ResponseEntity<String> createMode(@RequestParam(value="country",required=true)int countryid,@RequestParam(value="operator",required=true)int operatorid,@RequestParam(value="mode",required=true)String mode,@RequestParam(value="partner",required=true)int partnerid) throws RestServiceException{
		log.info("create country and operator controller called with country name:"+countryid+"operator_id : "+operatorid+" mode name:"+mode+" partner id "+partnerid);
		ModeDetails countryoperator=null;
		String responce=null;
		try {
		countryoperator=platformservice.createmode(countryid,operatorid,mode,partnerid);
		
			responce=SmartApalyaUtils.toJsonString(countryoperator);
		}catch (BusinessException e) {
			log.error("Error Occured "+e.getMessage());
			throw new RestServiceException(HttpStatus.BAD_REQUEST.value(), env.getProperty(e.getErrorCode()),
					e.getErrorCode(), "Error occured while creating new user");
		}catch (Exception e) {
			log.error("Error Occured : "+e.getMessage());
			throw new RestServiceException(HttpStatus.BAD_REQUEST.value(), env.getProperty(((BusinessException) e).getErrorCode()),
					((BusinessException) e).getErrorCode(), "Error occured while saving new role");
		}
		return new ResponseEntity<String>(responce,HttpStatus.OK);
		
	}
	
	@RequestMapping("/addcountry")
	public ResponseEntity<String> createCountry(@RequestParam(value="country",required=true)String country) throws RestServiceException{
		log.info("create country and operator controller called with country name:"+country);
		CountryDetails countryoperator=null;
		String responce=null;
		try {
		countryoperator=platformservice.createcountry(country);
		
			responce=SmartApalyaUtils.toJsonString(countryoperator);
		} catch (BusinessException e) {
			log.error("Error Occured "+e.getMessage());
			throw new RestServiceException(HttpStatus.BAD_REQUEST.value(), env.getProperty(e.getErrorCode()),
					e.getErrorCode(), "Error occured while creating new user");
		}catch (Exception e) {
			log.error("Error Occured : "+e.getMessage());
			throw new RestServiceException(HttpStatus.BAD_REQUEST.value(), env.getProperty(((BusinessException) e).getErrorCode()),
					((BusinessException) e).getErrorCode(), "Error occured while saving new role");
		}
		return new ResponseEntity<String>(responce,HttpStatus.OK);
		
	}
	
	@RequestMapping("/addoperator")
	public ResponseEntity<String> createmode(@RequestParam(value="operator",required=true)String operator,@RequestParam(value="country",required=true)int countryid) throws RestServiceException{
		log.info("create mode controller called with mode:"+countryid+operator);
		OperatorDetails details=null;
		String responce=null;
		try {
		details=platformservice.createoperator(countryid,operator);
		
			responce=SmartApalyaUtils.toJsonString(details);
		} catch (BusinessException e) {
			log.error("Error Occured "+e.getMessage());
			throw new RestServiceException(HttpStatus.BAD_REQUEST.value(), env.getProperty(e.getErrorCode()),
					e.getErrorCode(), "Error occured while creating new user");
		}catch (Exception e) {
			log.error("Error Occured : "+e.getMessage());
			throw new RestServiceException(HttpStatus.BAD_REQUEST.value(), env.getProperty(((BusinessException) e).getErrorCode()),
					((BusinessException) e).getErrorCode(), "Error occured while saving new role");
		}
		return new ResponseEntity<String>(responce,HttpStatus.OK);
	}
	
	@RequestMapping("/addpartner")
	public ResponseEntity<String> createoperator(@RequestParam(value="country",required=true)int countryid,@RequestParam(value="operator",required=true)int operatorid,@RequestParam(value="partner",required=true)String partner) throws RestServiceException{
		log.info("create mode controller called with mode:"+countryid+operatorid+partner);
		PartnerDetails details=null;
		String responce=null;
		try {
		details=platformservice.createPartner(countryid,operatorid,partner);
		
		
			responce=SmartApalyaUtils.toJsonString(details);
		}catch (BusinessException e) {
			log.error("Error Occured "+e.getMessage());
			throw new RestServiceException(HttpStatus.BAD_REQUEST.value(), env.getProperty(e.getErrorCode()),
					e.getErrorCode(), "Error occured while creating new user");
		}catch (Exception e) {
			log.error("Error Occured : "+e.getMessage());
			throw new RestServiceException(HttpStatus.BAD_REQUEST.value(), env.getProperty(((BusinessException) e).getErrorCode()),
					((BusinessException) e).getErrorCode(), "Error occured while saving new role");
		}
		return new ResponseEntity<String>(responce,HttpStatus.OK);
	}
	
	@RequestMapping("/addrole")
	public ResponseEntity<String> createRole(@RequestParam(value="role",required=true)String role) throws RestServiceException{
		log.info("create role controller called");
		RoleDetails rd=null;
		String responce=null;
		try {
		rd=platformservice.saverole(role);
		
			responce=SmartApalyaUtils.toJsonString(rd);
		}catch (BusinessException e) {
			log.error("Error Occured "+e.getMessage());
			throw new RestServiceException(HttpStatus.BAD_REQUEST.value(), env.getProperty(e.getErrorCode()),
					e.getErrorCode(), "Error occured while creating new user");
		}catch (Exception e) {
			log.error("Error Occured : "+e.getMessage());
			throw new RestServiceException(HttpStatus.BAD_REQUEST.value(), env.getProperty(((BusinessException) e).getErrorCode()),
					((BusinessException) e).getErrorCode(), "Error occured while saving new role");
		}
		return new ResponseEntity<String>(responce,HttpStatus.OK);
		
	}
	
	@RequestMapping("/getcountries")
	public ResponseEntity<String> getAllCountries() {
		log.info("Get All countries controller called");
		List<CountryDetails> cod=null;
		String responce=null;
		try {
			cod=platformservice.getAllcountries();
			responce=SmartApalyaUtils.toJsonString(cod);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<String>(responce,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getalloperators",method = RequestMethod.GET)
	public ResponseEntity<String> getAllOperators(@RequestParam(value="countryid",required=true)int countryid) {
		log.info("Get All Operators By country id"+ countryid);
		List<OperatorDetailsDto> re=new ArrayList<OperatorDetailsDto>();
		OperatorsDetailsDto dto=new OperatorsDetailsDto();
		String result=null;
		try {
			re=dto.entityToDto(platformservice.getOperatorsBycountryId(countryid));
			result=SmartApalyaUtils.toJsonString(re);
		} catch (Exception e) {
			log.info(" Exception in getAll Operator controller : "+e);
		}
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@RequestMapping("/getallpartners")
	public ResponseEntity<String> getAllPartners(@RequestParam(value="operatorid",required=true)int operatorid) {
		log.info("get All Partners By operator Id"+operatorid);
		List<com.apalya.dto.PartnerDetailsDto> pod=null;
		PartnerDetailsDto dto=new PartnerDetailsDto();
		String responce=null;
		try {
			pod=dto.entityToDto(platformservice.getPartnerByOperatorId(operatorid));
			responce=SmartApalyaUtils.toJsonString(pod);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<String>(responce,HttpStatus.OK);
	}
	
	@RequestMapping("/getallmodes")
	public ResponseEntity<String> getAllModes(@RequestParam(value="partnerid",required=true)int partnerid) {
		log.info("get All Modes By Partner Id "+partnerid);
		List<ModeDetailsDto> mod=null;
		com.apalya.service.dto.ModeDetailsDto dto=new com.apalya.service.dto.ModeDetailsDto();
		String responce=null;
		try {
			mod=dto.entityToDto(platformservice.getModesByPartnerId(partnerid));
			responce=SmartApalyaUtils.toJsonString(mod);
			log.info("modes "+responce);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<String>(responce,HttpStatus.OK);
	}
}
