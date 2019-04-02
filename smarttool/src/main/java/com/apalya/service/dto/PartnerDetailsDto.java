package com.apalya.service.dto;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apalya.entity.PartnerDetails;

public class PartnerDetailsDto {
	private static final Logger log = LoggerFactory.getLogger(OperatorsDetailsDto.class);

	public List<com.apalya.dto.PartnerDetailsDto> entityToDto(List<PartnerDetails> list) {
		List<com.apalya.dto.PartnerDetailsDto> operatordetailsdto = new ArrayList<com.apalya.dto.PartnerDetailsDto>();
		try {
		for (PartnerDetails operatordetails : list) {
			com.apalya.dto.PartnerDetailsDto dto = new com.apalya.dto.PartnerDetailsDto();
			dto.setId(operatordetails.getId());
			dto.setPartnername(operatordetails.getPartnername());
			operatordetailsdto.add(dto);
		}}catch(Exception e) {
			log.info(""+e.getMessage());
		}
		return operatordetailsdto;
	}

}
