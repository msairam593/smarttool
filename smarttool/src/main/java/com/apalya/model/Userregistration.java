package com.apalya.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;



public class Userregistration {
	
	@NotNull(message="please enter Username")
	@NotEmpty
	private String username;
	
	@NotNull(message="please enter Password")
	@NotEmpty
	private String password;
	
	@NotNull(message="please Select Country")
	@NotEmpty
	private String countries;
	
	@NotNull(message="please Select Operator")
	@NotEmpty
	private String operators;
	
	@NotNull(message="please Select Partner")
	@NotEmpty
	private String partners;
	
	@NotNull(message="please Select Mode")
	@NotEmpty
	private String mode;
	
	@NotNull(message="please Select Start Date")
	private String startdate;
	
	@NotNull(message="please Select End Date")
	private String enddate;
	
	@NotNull(message="please Select Role")
	private String role;

	public Userregistration(String username, String password, String countries, String operators, String partners,
			String mode, String startdate, String enddate, String role) {
		super();
		this.username = username;
		this.password = password;
		this.countries = countries;
		this.operators = operators;
		this.partners = partners;
		this.mode = mode;
		this.startdate = startdate;
		this.enddate = enddate;
		this.role = role;
	}

	public Userregistration() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountries() {
		return countries;
	}

	public void setCountries(String countries) {
		this.countries = countries;
	}

	public String getOperators() {
		return operators;
	}

	public void setOperators(String operators) {
		this.operators = operators;
	}

	public String getPartners() {
		return partners;
	}

	public void setPartners(String partners) {
		this.partners = partners;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Userregistration [username=" + username + ", password=" + password + ", countries=" + countries
				+ ", operators=" + operators + ", partners=" + partners + ", mode=" + mode + ", startdate=" + startdate
				+ ", enddate=" + enddate + ", role=" + role + "]";
	}
	
	
	
}
