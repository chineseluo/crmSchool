package com.student.crm.page;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter@Getter
public class PageResult {
	private Long total;
	private List rows;
	private Long pid;
	public PageResult(Long total, List rows) {
		this.total = total;
		this.rows = rows;
	}

	public PageResult() {
	}
}
