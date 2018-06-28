package com.student.crm.service;

import com.student.crm.domain.MyDate;
import com.student.crm.query.MyDateQueryObject;

import java.util.List;

public interface IMyDateService {

    void deleteByPrimaryKey(Long id);

    void insert(MyDate record);

    MyDate selectByPrimaryKey(Long id);

    void updateByPrimaryKey(MyDate record);

    List<MyDate> query(MyDateQueryObject qo);
}
