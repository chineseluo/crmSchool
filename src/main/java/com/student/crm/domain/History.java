package com.student.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Setter@Getter
public class History {
    private Long id;
    // 客户的名称
    private PotentialCustom client;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    // 移交的原因
    private String reason;
    // 以前的销售人员
    private Employee before;
    // 现在的销售人源的id
    private Employee after;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PotentialCustom getClient() {
        return client;
    }

    public void setClient(PotentialCustom client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Employee getBefore() {
        return before;
    }

    public void setBefore(Employee before) {
        this.before = before;
    }

    public Employee getAfter() {
        return after;
    }

    public void setAfter(Employee after) {
        this.after = after;
    }
}