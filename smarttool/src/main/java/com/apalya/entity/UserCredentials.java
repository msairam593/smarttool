package com.apalya.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="User_details_table")
public class UserCredentials {
	
	@Id
	@Column(name="user_id",unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="username",nullable=false)
	private String username;
	
	@Column(name="password",nullable=false)
	private String password;
	
	@Temporal(TemporalType.DATE)
	@Column(name="activate_date")
	private Date activedate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date enddate;

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public Date getActivedate() {
		return activedate;
	}


	public void setActivedate(Date activedate) {
		this.activedate = activedate;
	}


	public Date getEnddate() {
		return enddate;
	}


	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}


	@Override
	public String toString() {
		return "UserCredentials [id=" + id + ", username=" + username + ", password=" + password + ", activedate="
				+ activedate + ", enddate=" + enddate + "]";
	}


	public UserCredentials() {
		super();
	}

		
}
