package com.student.crm.domain;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class SystemMenu {
	private Long id;
	private String text;
	private String iconCls;
	private String url;
	private SystemMenu parent;
	private List<SystemMenu> children = new ArrayList<SystemMenu>();
	public Map<String,Object> getAttributes(){
		Map<String,Object> attributes = new HashMap<String,Object>();
		attributes.put("url", url);
		return attributes;
	}

}

