package com.apalya.service.dto;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apalya.dto.OperatorDetailsDto;
import com.apalya.entity.OperatorDetails;

public class OperatorsDetailsDto {
	
	private static final Logger log = LoggerFactory.getLogger(OperatorsDetailsDto.class);

	public List<OperatorDetailsDto> entityToDto(List<OperatorDetails> opd) {
		List<OperatorDetailsDto> operatordetailsdto = new ArrayList<OperatorDetailsDto>();
		try {
		for (OperatorDetails operatordetails : opd) {
			OperatorDetailsDto dto = new OperatorDetailsDto();
			dto.setId(operatordetails.getId());
			dto.setName(operatordetails.getOperator());
			operatordetailsdto.add(dto);
		}}catch(Exception e) {
			log.info(""+e.getMessage());
		}
		return operatordetailsdto;
	}

}
