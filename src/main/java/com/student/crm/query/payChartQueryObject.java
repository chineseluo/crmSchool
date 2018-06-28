package com.student.crm.query;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@Setter@Getter
public class payChartQueryObject extends QueryObject {
    public static  Map<Integer,String> typeMap=new LinkedHashMap<>();
    private Integer groupbyCon=1;

    static {
        typeMap.put(1,"销售人员");
        typeMap.put(2,"支付方式");
        typeMap.put(3,"每年");
        typeMap.put(4,"每个月");
    }

}
