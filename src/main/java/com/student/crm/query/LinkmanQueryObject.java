package com.student.crm.query;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;

@Getter@Setter
public class LinkmanQueryObject extends QueryObject{
    private String keyword;
    private Integer school;
    private Boolean main;
    public String getKeyword(){
        return StringUtils.isNotBlank(keyword)?keyword:null;
    }
}
