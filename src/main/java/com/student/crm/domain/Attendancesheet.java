package com.student.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Setter@Getter
public class Attendancesheet {
	
	public static final int NORMAL = 0;//正常状态
	public static final int LEAVE = 1;//表示不正常状态
	
    private Long id;

   // private Long employeeId;

    private String ip;

    private int state;

    @DateTimeFormat(pattern="yyyy-MM-dd-HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd-HH:mm:ss",timezone="GMT+8")
    private Date signintime;

    @DateTimeFormat(pattern="yyyy-MM-dd-HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd-HH:mm:ss",timezone="GMT+8")
    private Date signouttime;

    private Employee employee1;
    private Employee employee2;
  //  private String employeeUsername;

    @DateTimeFormat(pattern="yyyy-MM-dd-HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd-HH:mm:ss",timezone="GMT+8")
    private Date retroactivetime;

    private int latedays;
    private int earlyleavedays;
    private int attendancedays;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getSignintime() {
        return signintime;
    }

    public void setSignintime(Date signintime) {
        this.signintime = signintime;
    }

    public Date getSignouttime() {
        return signouttime;
    }

    public void setSignouttime(Date signouttime) {
        this.signouttime = signouttime;
    }

    public Employee getEmployee1() {
        return employee1;
    }

    public void setEmployee1(Employee employee1) {
        this.employee1 = employee1;
    }

    public Employee getEmployee2() {
        return employee2;
    }

    public void setEmployee2(Employee employee2) {
        this.employee2 = employee2;
    }

    public Date getRetroactivetime() {
        return retroactivetime;
    }

    public void setRetroactivetime(Date retroactivetime) {
        this.retroactivetime = retroactivetime;
    }

    public int getLatedays() {
        return latedays;
    }

    public void setLatedays(int latedays) {
        this.latedays = latedays;
    }

    public int getEarlyleavedays() {
        return earlyleavedays;
    }

    public void setEarlyleavedays(int earlyleavedays) {
        this.earlyleavedays = earlyleavedays;
    }

    public int getAttendancedays() {
        return attendancedays;
    }

    public void setAttendancedays(int attendancedays) {
        this.attendancedays = attendancedays;
    }
}