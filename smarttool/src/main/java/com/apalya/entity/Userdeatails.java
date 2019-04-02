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
@Table(name="user_mapping_table")
public class Userdeatails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true,nullable=false)
	private Integer id;
	
	@Column(name="user_id")
	private Integer userid;
	
	@Column(name="role_id")
	private Integer roleid;
	
	@Column(name="partner_id")
	private Integer partnerid;
	
	@Temporal(TemporalType.DATE)
	private Date createdon;

	public Userdeatails() {
		super();
	}

	@Override
	public String toString() {
		return "Userdeatails [id=" + id + ", userid=" + userid + ", roleid=" + roleid + ", partnerid=" + partnerid
				+ ", createdon=" + createdon + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	
	public Date getCreatedon() {
		return createdon;
	}

	public Integer getPartnerid() {
		return partnerid;
	}

	public void setPartnerid(Integer partnerid) {
		this.partnerid = partnerid;
	}

	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	public Userdeatails(Integer id, Integer userid, Integer roleid, Integer partnerid, Date createdon) {
		super();
		this.id = id;
		this.userid = userid;
		this.roleid = roleid;
		this.partnerid = partnerid;
		this.createdon = createdon;
	}

	
	
}
