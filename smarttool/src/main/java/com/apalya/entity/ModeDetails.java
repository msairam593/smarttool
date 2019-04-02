package com.apalya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="mode_details_table")
public class ModeDetails {
	
	@Id
	@Column(name="mode_id",unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="mode_name",nullable=false)
	private String modenname;
	
	@ManyToOne
	@JoinColumn(name="partner_id")
	private PartnerDetails partnerdetails;

	
	public ModeDetails(Integer id, String modenname, PartnerDetails partnerdetails) {
		super();
		this.id = id;
		this.modenname = modenname;
		this.partnerdetails = partnerdetails;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getModenname() {
		return modenname;
	}


	public void setModenname(String modenname) {
		this.modenname = modenname;
	}


	public PartnerDetails getPartnerdetails() {
		return partnerdetails;
	}


	public void setPartnerdetails(PartnerDetails partnerdetails) {
		this.partnerdetails = partnerdetails;
	}


	@Override
	public String toString() {
		return "ModeDetails [id=" + id + ", modenname=" + modenname + ", partnerdetails=" + partnerdetails + "]";
	}


	public ModeDetails() {
		super();
	}

	
		
	
}
