package com.student.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Getter@Setter
public class SaleChart {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date saleDate;
    private Employee username;//姓名

    private Department dept;//部门

    private BigDecimal saleAmount;//工资

    private BigDecimal livesubsidy;//补贴

    private Integer workday;//工作时间

    private Integer totalworkday;//全勤

    private BigDecimal socialsecurity;//社保

    private BigDecimal actualsalary;//实际工资

    private String remarks;//备注

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Employee getUsername() {
        return username;
    }

    public void setUsername(Employee username) {
        this.username = username;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public BigDecimal getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(BigDecimal saleAmount) {
        this.saleAmount = saleAmount;
    }

    public BigDecimal getLivesubsidy() {
        return livesubsidy;
    }

    public void setLivesubsidy(BigDecimal livesubsidy) {
        this.livesubsidy = livesubsidy;
    }

    public Integer getWorkday() {
        return workday;
    }

    public void setWorkday(Integer workday) {
        this.workday = workday;
    }

    public Integer getTotalworkday() {
        return totalworkday;
    }

    public void setTotalworkday(Integer totalworkday) {
        this.totalworkday = totalworkday;
    }

    public BigDecimal getSocialsecurity() {
        return socialsecurity;
    }

    public void setSocialsecurity(BigDecimal socialsecurity) {
        this.socialsecurity = socialsecurity;
    }

    public BigDecimal getActualsalary() {
        return actualsalary;
    }

    public void setActualsalary(BigDecimal actualsalary) {
        this.actualsalary = actualsalary;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}