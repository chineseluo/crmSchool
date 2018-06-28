package com.student.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import generator.ObjectProp;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Setter@Getter@ObjectProp("签订合同")
public class ContractManage {
    private Long id;
    //合同编号
    private String contractSn;
    @ObjectProp("签订客户")
    private PotentialCustom client;
    @ObjectProp("签订时间")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date signTime;
    @ObjectProp("销售人员")
    private Employee saleMan;
    @ObjectProp("总金额")
    private BigDecimal totalAmount;
    @ObjectProp("签订金额")
    private BigDecimal orderAmount;
    @ObjectProp("签订附件")
    private String accessory;
    @ObjectProp("备注")
    private String mark;
    @ObjectProp("最近修改人")
    private Employee recentUpdateMan;
    @ObjectProp("签订客户")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recentUpdateTime;
    @ObjectProp("")
    private Integer state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractSn() {
        return contractSn;
    }

    public void setContractSn(String contractSn) {
        this.contractSn = contractSn;
    }

    public PotentialCustom getClient() {
        return client;
    }

    public void setClient(PotentialCustom client) {
        this.client = client;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public Employee getSaleMan() {
        return saleMan;
    }

    public void setSaleMan(Employee saleMan) {
        this.saleMan = saleMan;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Employee getRecentUpdateMan() {
        return recentUpdateMan;
    }

    public void setRecentUpdateMan(Employee recentUpdateMan) {
        this.recentUpdateMan = recentUpdateMan;
    }

    public Date getRecentUpdateTime() {
        return recentUpdateTime;
    }

    public void setRecentUpdateTime(Date recentUpdateTime) {
        this.recentUpdateTime = recentUpdateTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
