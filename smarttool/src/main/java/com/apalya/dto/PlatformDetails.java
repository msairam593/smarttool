package com.apalya.dto;

public class PlatformDetails {
	
	private String id;
	private Integer name;
	
	
	@Override
	public String toString() {
		return "PlatformDetails [id=" + id + ", name=" + name + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getName() {
		return name;
	}

	public void setName(Integer name) {
		this.name = name;
	}

	public PlatformDetails(String id, Integer name) {
		super();
		this.id = id;
		this.name = name;
	}

	public PlatformDetails() {
		super();
	}
	
	
}
