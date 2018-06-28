package com.student.crm.domain;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter

public class Attendance3 {

	private String employee_username;
	private int earlydays;

	public String getEmployee_username() {
		return employee_username;
	}

	public void setEmployee_username(String employee_username) {
		this.employee_username = employee_username;
	}

	public int getEarlydays() {
		return earlydays;
	}

	public void setEarlydays(int earlydays) {
		this.earlydays = earlydays;
	}
}
