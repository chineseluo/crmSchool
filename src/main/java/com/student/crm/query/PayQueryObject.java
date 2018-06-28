package com.student.crm.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter@Setter
public class PayQueryObject extends QueryObject{
    private Long brokerageId;
    private Long cashierId;
    private Long payModeId;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date payDate;
    private Long payMoney;
    private Long subjectId;
}
