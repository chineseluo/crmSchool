package com.student.crm.query;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@Setter@Getter
public class CustomChartQueryObject extends QueryObject {
    public static  Map<Integer,String> typeMap=new LinkedHashMap<>();
    private Integer groupbyCon=1;

    static {
        typeMap.put(1,"意向学科");
        typeMap.put(2,"来源");
        typeMap.put(3,"学历");
        typeMap.put(4,"意向程度");
    }

}
