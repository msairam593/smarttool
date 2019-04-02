package com.apalya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country_details_table")
public class CountryDetails {
	
	@Id
	@Column(name="country_id",unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="country",nullable=false)
	private String country;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "CountryDetails [id=" + id + ", country=" + country + "]";
	}

	public CountryDetails() {
		super();
	}
	
	
}
