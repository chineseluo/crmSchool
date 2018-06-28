package com.student.crm.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
@Getter@Setter
public class ChargeQueryObject extends QueryObject {
    private Long studentId;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date chargeDate;
    private BigDecimal chargeMoney;
    private Long classroomId;
    private Long payeeId;
    private Long subjectId;
}