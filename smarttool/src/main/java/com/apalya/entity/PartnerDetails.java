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
@Table(name="partner_details_table")
public class PartnerDetails {
	
	@Id
	@Column(name="partner_id",unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="partnername",nullable=false)
	private String partnername;
	
	@ManyToOne
	@JoinColumn(name="operator_id")
	private OperatorDetails operatordetails;

	
	
	public Integer getId() {
		return id;
	}



	public PartnerDetails(Integer id, String partnername, OperatorDetails operatordetails) {
		super();
		this.id = id;
		this.partnername = partnername;
		this.operatordetails = operatordetails;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getPartnername() {
		return partnername;
	}



	public void setPartnername(String partnername) {
		this.partnername = partnername;
	}



	public OperatorDetails getOperatordetails() {
		return operatordetails;
	}



	public void setOperatordetails(OperatorDetails operatordetails) {
		this.operatordetails = operatordetails;
	}



	@Override
	public String toString() {
		return "PartnerDetails [id=" + id + ", partnername=" + partnername + ", operatordetails=" + operatordetails
				+ "]";
	}



	public PartnerDetails() {
		super();
	}
	
	

}
