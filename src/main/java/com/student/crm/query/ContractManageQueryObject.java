package com.student.crm.query;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class ContractManageQueryObject extends QueryObject {
    private String beginDate;
    private String endDate;
    private Integer state;
    private String keyword;
}
