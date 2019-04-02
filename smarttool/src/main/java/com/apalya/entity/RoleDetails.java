package com.apalya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Role_mapping_table")
public class RoleDetails {
	
	@Id
	@Column(name="role_id",unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="role_name")
	private String rolename;

	

	public RoleDetails() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getRolename() {
		return rolename;
	}



	public void setRolename(String rolename) {
		this.rolename = rolename;
	}



	@Override
	public String toString() {
		return "RoleDetails [id=" + id + ", rolename=" + rolename + "]";
	}
	
	

}
