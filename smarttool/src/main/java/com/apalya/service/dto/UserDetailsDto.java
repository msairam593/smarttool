package com.apalya.service.dto;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.apalya.entity.Userdeatails;

@Service
public class UserDetailsDto {
	
	
	private static final Logger log = LoggerFactory.getLogger(UserDetailsDto.class);

	
	public com.apalya.dto.UserDetailsDto entityToDto(Userdeatails ud,Date endDate) {
		log.info("into the userdetailsdto entitytodto");
		//List<com.apalya.dto.UserDetailsDto> userdetailsdto = new ArrayList<com.apalya.dto.UserDetailsDto>();
		com.apalya.dto.UserDetailsDto dto = new com.apalya.dto.UserDetailsDto();
		try {
		
			log.info("ID"+ud.getId());
			log.info("MODEID"+ud.getPartnerid());
			log.info("ROLEID"+ud.getRoleid());
			dto.setId(ud.getId());
			dto.setPartnerid(ud.getPartnerid());
			dto.setRoleid(ud.getRoleid());
			dto.setUserid(ud.getUserid());
			dto.setCreatedon(ud.getCreatedon());
			dto.setEndDate(endDate);
			
			
		}catch(Exception e) {
			log.info("Exception in converting to dto "+e);
		}
		return dto;
	}
}