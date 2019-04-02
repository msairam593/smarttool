package com.apalya.repository.custom;

import java.util.List;

import com.apalya.entity.ModeDetails;
import com.apalya.entity.OperatorDetails;
import com.apalya.entity.PartnerDetails;
import com.apalya.exception.DataAccessException;

public interface UserRepositorycustom {

	//PlatformDetails checkModeExist(PlatformDetails details,String check);

	List<OperatorDetails> getAllOperatorsBycountryId(int countryid) throws DataAccessException;

	List<PartnerDetails> getAllPartnersByOperatorId(int operatorid) throws DataAccessException;

	List<ModeDetails> getAllModesByPartnerById(int partnerid) throws DataAccessException;

}
