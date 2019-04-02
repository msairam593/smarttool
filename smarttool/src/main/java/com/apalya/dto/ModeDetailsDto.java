package com.apalya.dto;

public class ModeDetailsDto {
	private int id;
	private String name;
	
	public ModeDetailsDto() {
		super();
	}

	@Override
	public String toString() {
		return "ModeDetailsDto [id=" + id + ", name=" + name + "]";
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

	public ModeDetailsDto(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	

}
