package com.apalya.repository.custom.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.apalya.entity.ModeDetails;
import com.apalya.entity.OperatorDetails;
import com.apalya.entity.PartnerDetails;
import com.apalya.exception.DataAccessException;
import com.apalya.repository.custom.UserRepositorycustom;




@Repository
@Transactional
public class UserRepositorycustomImpl implements UserRepositorycustom{
	
	private static final Logger log = LoggerFactory.getLogger(UserRepositorycustomImpl.class);

	
	@PersistenceContext
	EntityManager entity;

	/*@Override
	public PlatformDetails checkModeExist(PlatformDetails details,String check) {
		
		String query="select ";
		if (check=="mode") {
			query="mdt.mode as mode,pdt.operator as operator,cdt.country as country from "
					+ "country_details_table cdt,"
					+ "mode_details_table mdt,"
					+ "operator_details_table odt,"
					+ "partner_details_table pdt "
					+ "where mdt.mode_name=:mode and mdt.partner_id=pdt.operator_id and pdt.operator_id=cdt.country_id and cdt.country=:countryname";
		}else if (check=="partner") {
			query="mdt.mode as mode,pdt.operator as operator,cdt.country as country from "
					+ "country_details_table cdt,"
					+ "mode_details_table mdt,"
					+ "operator_details_table odt,"
					+ "partner_details_table pdt "
					+ "where mdt.mode_name=:mode and mdt.partner_id=pdt.operator_id and pdt.operator_id=cdt.country_id and cdt.country=:countryname";
			
		}else if (check=="operator") {
			query="mdt.mode as mode,pdt.operator as operator,cdt.country as country from "
					+ "country_details_table cdt,"
					+ "mode_details_table mdt,"
					+ "operator_details_table odt,"
					+ "partner_details_table pdt "
					+ "where mdt.mode_name=:mode and mdt.partner_id=pdt.operator_id and pdt.operator_id=cdt.country_id and cdt.country=:countryname";
			
		}else if (check=="country") {
			query="mdt.mode as mode,pdt.operator as operator,cdt.country as country from "
					+ "country_details_table cdt,"
					+ "mode_details_table mdt,"
					+ "operator_details_table odt,"
					+ "partner_details_table pdt "
					+ "where mdt.mode_name=:mode and mdt.partner_id=pdt.operator_id and pdt.operator_id=cdt.country_id and cdt.country=:countryname";
		}
		try {
		Object []	obj=(Object[]) this.entity.createNativeQuery(query).setParameter("mode", details.getMode()).setParameter("countryname", details.getCountry()).getSingleResult();
			details.setCountry(((String)obj[0]).isEmpty()?null:(String)obj[0]);
			details.setCountry(((String)obj[1]).isEmpty()?null:(String)obj[1]);
			details.setCountry((((String)obj[2]).isEmpty()?null:(String)obj[2]));
		}catch (Exception e) {
			
		}
		return details;
	}
*/
	@SuppressWarnings("unchecked")
	@Override
	public List<OperatorDetails> getAllOperatorsBycountryId(int countryid) throws DataAccessException{
		List<OperatorDetails> detailslist=new ArrayList<OperatorDetails>();
		
		try {
		String sql = "select op.id,op.operator from OperatorDetails op where op.countrydetails.id=:countryid";
		Query query = entity.createQuery(sql);
		query.setParameter("countryid", countryid);
		List<Object[]> results = query.getResultList();
		
		for(Object[] result:results) {
			OperatorDetails details=new OperatorDetails();
			details.setId((Integer) result[0]);
			details.setOperator((String) result[1]);
			detailslist.add(details);
		}
		
		}catch (NoResultException e) {
			log.error("Exception occured "+e.getMessage());
			throw new DataAccessException("ERR_1002", " No Records Found");
		}catch(Exception e){
			log.error("Exception occured "+e.getMessage());
			throw new DataAccessException("ERR_1000", "Exception occured while retreiving");
		}
		return detailslist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PartnerDetails> getAllPartnersByOperatorId(int operatorid) throws DataAccessException{
		List<PartnerDetails> partnerlist=new ArrayList<PartnerDetails>();
		try {
		String sql = "select pd.id,pd.partnername from PartnerDetails pd where pd.operatordetails.id=:operatorid";
		Query query = entity.createQuery(sql);
		query.setParameter("operatorid", operatorid);
		List<Object[]> results = query.getResultList();
		for(Object[] result:results) {
			PartnerDetails details=new PartnerDetails();
			details.setId((Integer) result[0]);
			details.setPartnername((String) result[1]);
			partnerlist.add(details);
		}
		}catch (NoResultException e) {
			log.error("Exception occured "+e.getMessage());
			throw new DataAccessException("ERR_1002", " No Records Found");
		}catch(Exception e){
			log.error("Exception occured "+e.getMessage());
			throw new DataAccessException("ERR_1000", "Exception occured while retreiving");
		}
		log.info(""+partnerlist.toString());
		return partnerlist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ModeDetails> getAllModesByPartnerById(int partnerid) throws DataAccessException{
		List<ModeDetails> modes=new ArrayList<ModeDetails>();
		try {
		String sql = "select md.id,md.modenname from ModeDetails md where md.partnerdetails.id=:partnerid";
		Query query = entity.createQuery(sql);
		query.setParameter("partnerid", partnerid);
		List<Object[]> results = query.getResultList();
		
		for(Object[] result:results) {
			ModeDetails details=new ModeDetails();
			details.setId((Integer) result[0]);
			details.setModenname((String) result[1]);
			modes.add(details);
		}
		}catch (NoResultException e) {
			log.error("Exception occured "+e.getMessage());
			throw new DataAccessException("ERR_1002", " No Records Found");
		}catch(Exception e){
			log.error("Exception occured "+e.getMessage());
			throw new DataAccessException("ERR_1000", "Exception occured while retreiving");
		}
		return modes;
	}
	

}
