package com.student.crm.query;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;

@Setter@Getter
public class ClassRoomManageQueryObject extends QueryObject {
    private String keyword;


    public String getKeyword(String keyword) {
        return StringUtils.isNotBlank(keyword)?keyword:null;
    }
}
