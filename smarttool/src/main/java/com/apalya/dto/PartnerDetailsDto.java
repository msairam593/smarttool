package com.apalya.dto;

public class PartnerDetailsDto {
	private int id;
	private String partnername;
	
	
	public PartnerDetailsDto() {
		super();
	}
	public PartnerDetailsDto(int id, String partnername) {
		super();
		this.id = id;
		this.partnername = partnername;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPartnername() {
		return partnername;
	}
	public void setPartnername(String partnername) {
		this.partnername = partnername;
	}
	@Override
	public String toString() {
		return "PartnerDetailsDto [id=" + id + ", partnername=" + partnername + "]";
	}
	
	
	

}
