package com.student.crm.query;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class OrderBillQueryObject extends QueryObject {
private String beginDate;
private String endDate;
private Integer state;
private String keyword;
}
