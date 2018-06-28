package com.student.crm.query;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class EmployeeQueryObject extends QueryObject {
	private String keyword;
	private Long inChangeUserId;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Long getInChangeUserId() {
		return inChangeUserId;
	}

	public void setInChangeUserId(Long inChangeUserId) {
		this.inChangeUserId = inChangeUserId;
	}
}
