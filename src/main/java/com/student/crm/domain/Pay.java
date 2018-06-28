package com.student.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
@Getter@Setter
public class Pay {
    public static final int NORMAL_STATUS=0;
    public static final int AUDIT_STATUS=1;
    private Long id;
    //支出时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date payDate;
    //支出金额
    private BigDecimal payMoney;
    //支出说明
    private String info;
    //出纳人
    private Employee cashier;
    //经手人
    private Employee brokerage;
    //支付方式--从字典获取
    private SystemDictionaryItem payMode;
    //支出类型--从字典获取
    private SystemDictionaryItem payType;
    //支出小类--从字典获取
    private SystemDictionaryItem paySmall;
    //支票号码
    private String billNumber;
    //共享费用
    private BigDecimal shareCost;
    //共享类型--从字典获取
    private SystemDictionaryItem shareType;
    //学科--从字典获取
    private SystemDictionaryItem subject;
    //审核
    private int auditStatus=Pay.NORMAL_STATUS;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Employee getCashier() {
        return cashier;
    }

    public void setCashier(Employee cashier) {
        this.cashier = cashier;
    }

    public Employee getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(Employee brokerage) {
        this.brokerage = brokerage;
    }

    public SystemDictionaryItem getPayMode() {
        return payMode;
    }

    public void setPayMode(SystemDictionaryItem payMode) {
        this.payMode = payMode;
    }

    public SystemDictionaryItem getPayType() {
        return payType;
    }

    public void setPayType(SystemDictionaryItem payType) {
        this.payType = payType;
    }

    public SystemDictionaryItem getPaySmall() {
        return paySmall;
    }

    public void setPaySmall(SystemDictionaryItem paySmall) {
        this.paySmall = paySmall;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public BigDecimal getShareCost() {
        return shareCost;
    }

    public void setShareCost(BigDecimal shareCost) {
        this.shareCost = shareCost;
    }

    public SystemDictionaryItem getShareType() {
        return shareType;
    }

    public void setShareType(SystemDictionaryItem shareType) {
        this.shareType = shareType;
    }

    public SystemDictionaryItem getSubject() {
        return subject;
    }

    public void setSubject(SystemDictionaryItem subject) {
        this.subject = subject;
    }

    public int getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(int auditStatus) {
        this.auditStatus = auditStatus;
    }
}