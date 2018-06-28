package com.student.crm.mapper;

import com.student.crm.domain.MyDate;
import com.student.crm.query.MyDateQueryObject;

import java.util.List;

public interface MyDateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MyDate record);

    MyDate selectByPrimaryKey(Long id);

    List<MyDate> selectAll();

    int updateByPrimaryKey(MyDate record);

    List<MyDate> query(MyDateQueryObject qo);
}