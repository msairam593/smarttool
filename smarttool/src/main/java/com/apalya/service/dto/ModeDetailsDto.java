package com.apalya.service.dto;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.apalya.entity.ModeDetails;

public class ModeDetailsDto {
	private static final Logger log = LoggerFactory.getLogger(OperatorsDetailsDto.class);

	public List<com.apalya.dto.ModeDetailsDto> entityToDto(List<ModeDetails> opd) {
		List<com.apalya.dto.ModeDetailsDto> modedetailsdto = new ArrayList<com.apalya.dto.ModeDetailsDto>();
		try {
		for (ModeDetails operatordetails : opd) {
			log.info("opd "+opd.toString());
			com.apalya.dto.ModeDetailsDto dto = new com.apalya.dto.ModeDetailsDto();
			dto.setId(operatordetails.getId());
			dto.setName(operatordetails.getModenname());
			modedetailsdto.add(dto);
		}}catch(Exception e) {
			log.info("Exception in converting to dto "+e);
		}
		return modedetailsdto;
	}
}
