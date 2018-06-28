package com.student.crm.domain;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Permission {
	private Long id;
	private String name;
	private String resource;

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

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}
}
