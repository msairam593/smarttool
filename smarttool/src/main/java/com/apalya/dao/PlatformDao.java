package com.apalya.dao;

import java.util.List;

import com.apalya.entity.CountryDetails;
import com.apalya.entity.ModeDetails;
import com.apalya.entity.OperatorDetails;
import com.apalya.entity.PartnerDetails;
import com.apalya.entity.RoleDetails;
import com.apalya.exception.BusinessException;
import com.apalya.exception.DataAccessException;

public interface PlatformDao {
	
	CountryDetails createcountry(CountryDetails cod) throws BusinessException;

	ModeDetails createmode(ModeDetails mod) throws BusinessException;

	RoleDetails saverole(RoleDetails rd) throws BusinessException;
	
	CountryDetails getCountryDetails(int countryid) throws DataAccessException;

	ModeDetails getModeId(int mode) throws DataAccessException;

	RoleDetails getRoleId(int role) throws DataAccessException;
	
	OperatorDetails createoperator(OperatorDetails opd) throws BusinessException;

	PartnerDetails createPartner(PartnerDetails pod) throws BusinessException;

	boolean findcountryBycountryName(String country) throws DataAccessException;

	OperatorDetails getOperatorDetailsById(int operatorid) throws DataAccessException;

	PartnerDetails getPartnerDetailsById(int operatorid) throws DataAccessException;

	boolean checkRoleExist(String role) throws DataAccessException;

	List<CountryDetails> getAllcountriesDao() throws DataAccessException;

	List<RoleDetails> getAllRoles() throws DataAccessException;
	
}
