package com.martins.dsvendas.dto;

import com.martins.dsvendas.entities.Seller;

public class sellerDTO {
	private Long id;
	private String name;
	public sellerDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public sellerDTO(Seller entity) {
		
		id = entity.getId();
		name = entity.getName();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
