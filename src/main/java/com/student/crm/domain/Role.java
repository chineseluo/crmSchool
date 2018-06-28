package com.student.crm.domain;


import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Setter@Getter
public class Role {
	private Long id;
	private String sn;
	private String name;
	private List<Permission> permissions = new ArrayList<Permission>();
	private List<SystemMenu> menus = new ArrayList<SystemMenu>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public List<SystemMenu> getMenus() {
		return menus;
	}

	public void setMenus(List<SystemMenu> menus) {
		this.menus = menus;
	}
}
