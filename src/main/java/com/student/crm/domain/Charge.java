package com.student.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
@Getter@Setter
public class Charge {
    private Long id;
    //学员
    private PotentialCustom student;
    //收费时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date chargeDate;
    //收费金额
    private BigDecimal chargeMoney;
    //班级
    private Classroom classroom;
    //收款人
    private Employee payee;
    //收款方式
    private SystemDictionaryItem chargeType;
    //收款单
    private String billNumber;
    //是否开票
    private boolean ticket;
    //学科
    private SystemDictionaryItem subject;
    //备注
    private String remark;
    //营销人
    private Employee marketing;
    //班级变动
    private String classChange;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PotentialCustom getStudent() {
        return student;
    }

    public void setStudent(PotentialCustom student) {
        this.student = student;
    }

    public Date getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(Date chargeDate) {
        this.chargeDate = chargeDate;
    }

    public BigDecimal getChargeMoney() {
        return chargeMoney;
    }

    public void setChargeMoney(BigDecimal chargeMoney) {
        this.chargeMoney = chargeMoney;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Employee getPayee() {
        return payee;
    }

    public void setPayee(Employee payee) {
        this.payee = payee;
    }

    public SystemDictionaryItem getChargeType() {
        return chargeType;
    }

    public void setChargeType(SystemDictionaryItem chargeType) {
        this.chargeType = chargeType;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public boolean isTicket() {
        return ticket;
    }

    public void setTicket(boolean ticket) {
        this.ticket = ticket;
    }

    public SystemDictionaryItem getSubject() {
        return subject;
    }

    public void setSubject(SystemDictionaryItem subject) {
        this.subject = subject;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Employee getMarketing() {
        return marketing;
    }

    public void setMarketing(Employee marketing) {
        this.marketing = marketing;
    }

    public String getClassChange() {
        return classChange;
    }

    public void setClassChange(String classChange) {
        this.classChange = classChange;
    }
}