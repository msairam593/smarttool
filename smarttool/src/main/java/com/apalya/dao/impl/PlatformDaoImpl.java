package com.apalya.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

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
import com.apalya.repository.CountryDetailsRepository;
import com.apalya.repository.ModeDetailsRepository;
import com.apalya.repository.OperatorDetailsRepository;
import com.apalya.repository.PartnerDetailsRepository;
import com.apalya.repository.RoleDetailsRepository;
import com.apalya.repository.custom.UserRepositorycustom;


@Component
public class PlatformDaoImpl implements PlatformDao{
	
	private static final Logger log = LoggerFactory.getLogger(PlatformDaoImpl.class);

	
	@Autowired
	CountryDetailsRepository countryrepository;
	
	@Autowired
	ModeDetailsRepository modeDetailsrepository;
	
	@Autowired
	RoleDetailsRepository roledetailsrepository;
	
	@Autowired
	OperatorDetailsRepository operatordetailsrepository;
	
	@Autowired
	PartnerDetailsRepository partnerdetailsrepository;
	
	@Autowired
	UserRepositorycustom userrepositorycustom;

	@Override
	public RoleDetails saverole(RoleDetails rd) throws BusinessException {
		RoleDetails role=new RoleDetails();
		try {
			role=roledetailsrepository.save(rd);
		} catch(Exception e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException("ERROR", "Error occured while saving the user");
		}
		return role;
	}

	@Override
	public CountryDetails getCountryDetails(int countryid) throws DataAccessException {
		CountryDetails cod=null;
		try {
			cod= countryrepository.findById(countryid);
		}catch (NoResultException e) {
			log.error("Exception occured "+e.getMessage());
			throw new DataAccessException("ERR_1002", " No Records Found");
		}catch(Exception e){
			log.error("Exception occured "+e.getMessage());
			throw new DataAccessException("ERR_1000", "Exception occured while retreiving partner");
		}
		return cod;
	}

	@Override
	public ModeDetails getModeId(int mode) throws DataAccessException {
		ModeDetails modedetails=null;
		try {
		modedetails=modeDetailsrepository.findById(mode);
		} catch (NoResultException e) {
			log.error("Exception occured "+e.getMessage());
			throw new DataAccessException("ERR_1002", " No Records Found");
		}catch(Exception e){
			log.error("Exception occured "+e.getMessage());
			throw new DataAccessException("ERR_1000", "Exception occured while retreiving partner");
		}
		return modedetails;
	}

	@Override
	public RoleDetails getRoleId(int role) throws  DataAccessException {
		RoleDetails roledetails=null;
		try {
			roledetails=roledetailsrepository.findById(role);
		} catch (NoResultException e) {
			log.error("Exception occured "+e.getMessage());
			throw new DataAccessException("ERR_1002", " No Records Found");
		}catch(Exception e){
			log.error("Exception occured "+e.getMessage());
			throw new DataAccessException("ERR_1000", "Exception occured while retreiving partner");
		}
		return roledetails;
	}

	@Override
	public CountryDetails createcountry(CountryDetails cod) throws BusinessException {
		CountryDetails countrydetails=new CountryDetails();
		try {
			countrydetails=countryrepository.save(cod);
		}catch(Exception e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException("ERROR", "Error occured while saving country");
		}
		return countrydetails;
	}

	@Override
	public OperatorDetails createoperator(OperatorDetails opd) throws BusinessException {
		OperatorDetails operator=new OperatorDetails();
		try {
			operator=operatordetailsrepository.save(opd);
		}catch(Exception e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException("ERROR", "Error occured while saving the operator");
		}
		return operator;
		
	}

	@Override
	public ModeDetails createmode(ModeDetails modelist) throws BusinessException {
		ModeDetails modedetails=new ModeDetails();
		try {
			modedetails = modeDetailsrepository.save(modelist);
		} catch(Exception e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException("ERROR", "Error occured while saving mode");
		}
		return modedetails;
	}

	@Override
	public PartnerDetails createPartner(PartnerDetails pod) throws BusinessException {
		PartnerDetails partner=new PartnerDetails();
		try {
			partner=partnerdetailsrepository.save(pod);
		} catch(Exception e){
			log.error("Error Occured : "+e.getMessage());
			throw new BusinessException("ERROR", "Error occured while saving partner");
		}
		return partner;
	}

	@Override
	public boolean findcountryBycountryName(String country) throws DataAccessException{
		Boolean b;
		try {
			b=countryrepository.existsByCountry(country);
		}catch (NoResultException e) {
			log.error("Exception occured "+e.getMessage());
			throw new DataAccessException("ERR_1002", " No Records Found");
		}catch(Exception e){
			log.error("Exception occured "+e.getMessage());
			throw new DataAccessException("ERR_1000", "Exception occured while retreiving partner");
		}
		return b;
	}

	@Override
	public OperatorDetails getOperatorDetailsById(int operatorid) throws DataAccessException {
		OperatorDetails opertor=new OperatorDetails();
		try {
			opertor=operatordetailsrepository.findById(operatorid);
		} catch (NoResultException e) {
			log.error("Exception occured "+e.getMessage());
			throw new DataAccessException("ERR_1002", " No Records Found");
		}catch(Exception e){
			log.error("Exception occured "+e.getMessage());
			throw new DataAccessException("ERR_1000", "Exception occured while retreiving partner");
		}
		return opertor;
	}

	@Override
	public PartnerDetails getPartnerDetailsById(int operatorid) throws DataAccessException {
		PartnerDetails partner=new PartnerDetails();
		try {
			partner=partnerdetailsrepository.findById(operatorid);
		} catch (NoResultException e) {
			log.error("Exception occured "+e.getMessage());
			throw new DataAccessException("ERR_1002", " No Records Found");
		}catch(Exception e){
			log.error("Exception occured "+e.getMessage());
			throw new DataAccessException("ERR_1000", "Exception occured while retreiving partner");
		}
		return partner;
	}

	@Override
	public boolean checkRoleExist(String role) throws DataAccessException{
		Boolean b;
		try {
			b=roledetailsrepository.existsByRolename(role);
		} catch (NoResultException e) {
			log.error("Exception occured "+e.getMessage());
			throw new DataAccessException("ERR_1002", " No Records Found");
		}catch(Exception e){
			log.error("Exception occured "+e.getMessage());
			throw new DataAccessException("ERR_1000", "Exception occured while checking role");
		}
		return b;
	}

	@Override
	public List<CountryDetails> getAllcountriesDao() throws DataAccessException {
		List<CountryDetails> countrylist=new ArrayList<CountryDetails>();
		try {
			countrylist=(List<CountryDetails>) countryrepository.findAll();
		}catch (NoResultException e) {
			log.error("Exception occured "+e.getMessage());
			throw new DataAccessException("ERR_1002", " No Records Found");
		}catch(Exception e){
			log.error("Exception occured "+e.getMessage());
			throw new DataAccessException("ERR_1000", "Exception occured while retreiving countries");
		}
		return countrylist;
	}

	@Override
	public List<RoleDetails> getAllRoles() throws DataAccessException {
		List<RoleDetails> rolelist=new ArrayList<RoleDetails>();
		try {
			rolelist=(List<RoleDetails>) roledetailsrepository.findAll();
		} catch (NoResultException e) {
			log.error("Exception occured "+e.getMessage());
			throw new DataAccessException("ERR_1002", " No Records Found");
		}catch(Exception e){
			log.error("Exception occured "+e.getMessage());
			throw new DataAccessException("ERR_1000", "Exception occured while retreiving roles");
		}
		// TODO Auto-generated method stub
		return rolelist;
	}

}
