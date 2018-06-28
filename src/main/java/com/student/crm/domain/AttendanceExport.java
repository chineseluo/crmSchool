package com.student.crm.domain;




import lombok.Getter;
import lombok.Setter;

@Setter@Getter

public class AttendanceExport {

	
	private Long id;
	private String employee_username;
	
/*	@DateTimeFormat(pattern="yyyy-MM-dd-HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd-HH:mm:ss",timezone="GMT+8")
	private Date date;*/
	private int earlydays;
	private int attendancedays;
	private int latedays;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public int getAttendancedays() {
		return attendancedays;
	}

	public void setAttendancedays(int attendancedays) {
		this.attendancedays = attendancedays;
	}

	public int getLatedays() {
		return latedays;
	}

	public void setLatedays(int latedays) {
		this.latedays = latedays;
	}
}
