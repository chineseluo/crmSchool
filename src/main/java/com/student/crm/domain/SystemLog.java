package com.student.crm.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter@Getter
public class SystemLog {
    private Long id;

    private Employee opuser;

    private Date optime;

    private String function;

    private String params;

    private String opip;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getOpuser() {
        return opuser;
    }

    public void setOpuser(Employee opuser) {
        this.opuser = opuser;
    }

    public Date getOptime() {
        return optime;
    }

    public void setOptime(Date optime) {
        this.optime = optime;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getOpip() {
        return opip;
    }

    public void setOpip(String opip) {
        this.opip = opip;
    }
}