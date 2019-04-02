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
@Table(name="operator_details_table")
public class OperatorDetails {
	@Id
	@Column(name="operator_id",unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="operator",nullable=false)
	private String operator;
	
	@ManyToOne
	@JoinColumn(name="country_id")
	private CountryDetails countrydetails;

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getOperator() {
		return operator;
	}


	public void setOperator(String operator) {
		this.operator = operator;
	}


	public CountryDetails getCountrydetails() {
		return countrydetails;
	}


	public void setCountrydetails(CountryDetails countrydetails) {
		this.countrydetails = countrydetails;
	}


	@Override
	public String toString() {
		return "OperatorDetails [id=" + id + ", operator=" + operator + ", countrydetails=" + countrydetails + "]";
	}


	public OperatorDetails() {
		super();
	}


	public OperatorDetails(Integer id, String operator, CountryDetails countrydetails) {
		super();
		this.id = id;
		this.operator = operator;
		this.countrydetails = countrydetails;
	}
	
	
	
}
