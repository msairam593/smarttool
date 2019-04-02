package com.apalya.dto;

import java.util.Date;

public class UserDetailsDto {

	private int id;
	private int userid;
	private int roleid;
	private int partnerid;
	private Date createdon;
	private Date endDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public Date getCreatedon() {
		return createdon;
	}
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getPartnerid() {
		return partnerid;
	}
	public void setPartnerid(int partnerid) {
		this.partnerid = partnerid;
	}
	public UserDetailsDto() {
		super();
	}
	@Override
	public String toString() {
		return "UserDetailsDto [id=" + id + ", userid=" + userid + ", roleid=" + roleid + ", partnerid=" + partnerid
				+ ", createdon=" + createdon + ", endDate=" + endDate + "]";
	}
	public UserDetailsDto(int id, int userid, int roleid, int partnerid, Date createdon, Date endDate) {
		super();
		this.id = id;
		this.userid = userid;
		this.roleid = roleid;
		this.partnerid = partnerid;
		this.createdon = createdon;
		this.endDate = endDate;
	}
	
	
	
}