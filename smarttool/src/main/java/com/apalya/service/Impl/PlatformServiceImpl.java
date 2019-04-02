package com.apalya.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apalya.dao.PlatformDao;
import com.apalya.entity.CountryDetails;
import com.apalya.entity.ModeDetails;
import com.apalya.entity.OperatorDetails;
import com.apalya.entity.PartnerDetails;
import com.apalya.entity.RoleDetails;
import com.apalya.exception.BusinessException;
import com.apalya.exception.DataAccessException;
import com.apalya.repository.custom.UserRepositorycustom;
import com.apalya.service.PlatformService;



@Component
public class PlatformServiceImpl implements PlatformService{
	
	
	private static final Logger log = LoggerFactory.getLogger(PlatformServiceImpl.class);

	@Autowired
	private PlatformDao platformdao;
	
	@Autowired
	UserRepositorycustom userrepositorycustom;
	
		
	@Override
	public RoleDetails saverole(String role) throws BusinessException{
		RoleDetails rd=new RoleDetails();
		try {
			rd.setRolename(role);
			if (platformdao.checkRoleExist(role)) {
				rd.setRolename("role already existed");;
			} else {
				rd=platformdao.saverole(rd);
			}
		}catch(BusinessException e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException(e.getErrorCode(), e.getSystemMessage());
		} catch(DataAccessException e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException(e.getErrorCode(), e.getSystemMessage());
		}catch(Exception e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException("ERR_1000", "Error occured while getting the employee details");
		}
		
		return rd;
	}

	
	@Override
	public CountryDetails createcountry(String country) throws BusinessException{
		CountryDetails cod=new CountryDetails();
		cod.setCountry(country);
		try {
			if (platformdao.findcountryBycountryName(country)) {
				cod.setCountry("already exist");
			}else {
				cod=platformdao.createcountry(cod);
			}
		} catch(DataAccessException e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException(e.getErrorCode(), e.getSystemMessage());
		}catch(Exception e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException("ERR_1000", "Error occured while getting the employee details");
		}
		
		return cod;
	}

	@Override
	public OperatorDetails createoperator(int countryid, String operator) throws BusinessException{
		OperatorDetails opd=new OperatorDetails();
		CountryDetails cod=new CountryDetails();
		cod.setId(countryid);
		opd.setOperator(operator);
		try {
			opd.setCountrydetails(platformdao.getCountryDetails(countryid));
			opd=platformdao.createoperator(opd);
		} catch(DataAccessException e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException(e.getErrorCode(), e.getSystemMessage());
		}catch(BusinessException e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException(e.getErrorCode(), e.getSystemMessage());
		}catch(Exception e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException("ERR_1000", "Error occured while getting the employee details");
		}
		return opd;
	}

	@Override
	public PartnerDetails createPartner(int countryid, int operatorid, String partner) throws BusinessException{
		PartnerDetails pod=new PartnerDetails();
		try {
			pod.setPartnername(partner);
			pod.setOperatordetails(platformdao.getOperatorDetailsById(operatorid));
			pod=platformdao.createPartner(pod);
		}  catch(DataAccessException e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException(e.getErrorCode(), e.getSystemMessage());
		}catch(Exception e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException("ERR_1000", "Error occured while getting the employee details");
		}
		return pod;
	}
	
	@Override
	public ModeDetails createmode(int countryid, int operatorid,String mode,int partnerid) throws BusinessException{
		ModeDetails mod=new ModeDetails();
		try {
			mod.setModenname(mode);
			log.info("partner details:"+operatorid+" ssss "+platformdao.getPartnerDetailsById(operatorid));
			mod.setPartnerdetails(platformdao.getPartnerDetailsById(partnerid));
			log.info("Mode details "+mod.toString());
			mod=platformdao.createmode(mod);
		} catch(DataAccessException e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException(e.getErrorCode(), e.getSystemMessage());
		}catch(Exception e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException("ERR_1000", "Error occured while getting the employee details");
		}
		
		return mod;
	}


	@Override
	public List<CountryDetails> getAllcountries() throws BusinessException{
		List<CountryDetails> countries=new ArrayList<CountryDetails>();
		try {
			countries=platformdao.getAllcountriesDao();
		}catch(DataAccessException e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException(e.getErrorCode(), e.getSystemMessage());
		}catch(Exception e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException("ERR_1000", "Error occured while getting the employee details");
		}
		return countries;
	}


	@Override
	public List<OperatorDetails> getOperatorsBycountryId(int countryid) throws BusinessException {
		List<OperatorDetails> operatorlist=new ArrayList<OperatorDetails>();
		try {
			operatorlist=userrepositorycustom.getAllOperatorsBycountryId(countryid);
		} catch(DataAccessException e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException(e.getErrorCode(), e.getSystemMessage());
		}catch(Exception e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException("ERR_1000", "Error occured while getting the employee details");
		}
		return operatorlist;
	}


	@Override
	public List<PartnerDetails> getPartnerByOperatorId(int operatorid) throws BusinessException{
		List<PartnerDetails> partnerlist=new ArrayList<PartnerDetails>();
		try {
			partnerlist=userrepositorycustom.getAllPartnersByOperatorId(operatorid);
		} catch(DataAccessException e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException(e.getErrorCode(), e.getSystemMessage());
		}catch(Exception e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException("ERR_1000", "Error occured while getting the employee details");
		}
		// TODO Auto-generated method stub
		return partnerlist;
	}


	@Override
	public List<ModeDetails> getModesByPartnerId(int partnerid) throws BusinessException{
		List<ModeDetails> modelist=new ArrayList<ModeDetails>();
		try {
			modelist=userrepositorycustom.getAllModesByPartnerById(partnerid);
		} catch(DataAccessException e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException(e.getErrorCode(), e.getSystemMessage());
		}catch(Exception e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException("ERR_1000", "Error occured while getting the employee details");
		}
		// TODO Auto-generated method stub
		return modelist;
	}


	@Override
	public List<RoleDetails> getAllRoles() throws BusinessException{
		List<RoleDetails> roledetails=new ArrayList<RoleDetails>();
		try {
			roledetails=platformdao.getAllRoles();
		} catch(DataAccessException e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException(e.getErrorCode(), e.getSystemMessage());
		}catch(Exception e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException("ERR_1000", "Error occured while getting the employee details");
		}
		return roledetails;
	}

}
