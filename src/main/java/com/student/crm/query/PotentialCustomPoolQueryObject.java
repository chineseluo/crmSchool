package com.student.crm.query;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Administrator on 2017/10/13.
 */
@Setter@Getter
public class PotentialCustomPoolQueryObject extends QueryObject {
    private Long studentState;
    private Long formal_studentState;
    private Long upOrDown;
    private Long schoolType;
    private Long intentionGrade;
    private Long workTime;
    private Long currentStatu;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date collegeBeginTimeMin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date collegeBeginTimeMax;
    private Long  intentionMajor;
    private Long educationRecord;
}
