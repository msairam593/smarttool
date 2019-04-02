package com.apalya.dto;

public class OperatorDetailsDto {
	private int id;
	private String name;
	public OperatorDetailsDto(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public OperatorDetailsDto() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "OperatorDetailsDto [id=" + id + ", name=" + name + "]";
	}
	
	

}
