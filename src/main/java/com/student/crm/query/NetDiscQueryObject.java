package com.student.crm.query;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter@Setter
public class NetDiscQueryObject extends QueryObject {
    private Long parentId;
    private Long userId;
    private String keyword;
//    private String netDiscName;
    private int shareStatus=-1;
    private Long typeId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date minTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maxTime;
    private Integer advStatus;
    public String getKeyword() {
        return StringUtils.isNotBlank(keyword)?keyword:null;
    }
   /* public String getNetDiscName() {
        return StringUtils.isNotBlank(netDiscName)?netDiscName:null;
    }*/

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getShareStatus() {
        return shareStatus;
    }

    public void setShareStatus(int shareStatus) {
        this.shareStatus = shareStatus;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Date getMinTime() {
        return minTime;
    }

    public void setMinTime(Date minTime) {
        this.minTime = minTime;
    }

    public Date getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Date maxTime) {
        this.maxTime = maxTime;
    }

    public Integer getAdvStatus() {
        return advStatus;
    }

    public void setAdvStatus(Integer advStatus) {
        this.advStatus = advStatus;
    }
}
