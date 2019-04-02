package com.apalya.service;

import java.util.List;

import com.apalya.entity.CountryDetails;
import com.apalya.entity.ModeDetails;
import com.apalya.entity.OperatorDetails;
import com.apalya.entity.PartnerDetails;
import com.apalya.entity.RoleDetails;
import com.apalya.exception.BusinessException;

public interface PlatformService {

	ModeDetails createmode(int countryid,int operatorid,String mode,int partnerid) throws BusinessException;

	RoleDetails saverole(String role) throws BusinessException;

	CountryDetails createcountry(String country) throws BusinessException;

	OperatorDetails createoperator(int countryid, String operator) throws BusinessException;

	PartnerDetails createPartner(int countryid, int operatorid, String partner) throws BusinessException;

	List<CountryDetails> getAllcountries() throws BusinessException;

	List<OperatorDetails> getOperatorsBycountryId(int countryid) throws BusinessException;

	List<PartnerDetails> getPartnerByOperatorId(int operatorid) throws BusinessException;

	List<ModeDetails> getModesByPartnerId(int partnerid) throws BusinessException;

	List<RoleDetails> getAllRoles() throws BusinessException;
	
}
