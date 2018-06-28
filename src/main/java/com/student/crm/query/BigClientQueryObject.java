package com.student.crm.query;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;
@Getter@Setter
public class BigClientQueryObject extends QueryObject {
    private String school;
    private Long marketing;
    private String schoolType;
    private String starLevel;

    public String getSchool() {
        return StringUtils.isNotBlank(school)?school:null;
    }
    public String getSchoolType() {
        return StringUtils.isNotBlank(schoolType)?schoolType:null;
    }
    public String getStarLevel() {
        return StringUtils.isNotBlank(starLevel)?starLevel:null;
    }
}