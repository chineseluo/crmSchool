package com.student.crm.domain;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter

public class Attendance2 {

	private String employee_username;
	private int latedays;

	public String getEmployee_username() {
		return employee_username;
	}

	public void setEmployee_username(String employee_username) {
		this.employee_username = employee_username;
	}

	public int getLatedays() {
		return latedays;
	}

	public void setLatedays(int latedays) {
		this.latedays = latedays;
	}
}
