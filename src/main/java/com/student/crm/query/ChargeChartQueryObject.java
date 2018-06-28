package com.student.crm.query;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@Setter@Getter
public class ChargeChartQueryObject extends QueryObject {
    public static  Map<Integer,String> typeMap=new LinkedHashMap<>();
    private Integer groupbyCon=1;

    static {
        typeMap.put(1,"营销人员");
        typeMap.put(2,"学科");
        typeMap.put(3,"每年");
        typeMap.put(4,"每个月");
    }

}
