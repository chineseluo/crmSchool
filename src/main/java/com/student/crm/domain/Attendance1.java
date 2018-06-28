package com.student.crm.domain;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter

public class Attendance1 {

	private String employee_username;
	private int attendancedays;

	public String getEmployee_username() {
		return employee_username;
	}

	public void setEmployee_username(String employee_username) {
		this.employee_username = employee_username;
	}

	public int getAttendancedays() {
		return attendancedays;
	}

	public void setAttendancedays(int attendancedays) {
		this.attendancedays = attendancedays;
	}
}
