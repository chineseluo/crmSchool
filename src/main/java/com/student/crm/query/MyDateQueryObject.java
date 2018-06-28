package com.student.crm.query;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter@Setter
public class MyDateQueryObject {
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date start;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date end;
    private Long userId;
}

