package com.student.crm.page;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class AjaxResult {
	private boolean success;
	private String msg;
	private Integer status;
	public AjaxResult(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}
	public AjaxResult(boolean success, String msg,Integer status) {
		super();
		this.success = success;
		this.msg = msg;
		this.status=status;
	}
	public AjaxResult(String msg) {
		super();
		this.msg = msg;
	}
}
