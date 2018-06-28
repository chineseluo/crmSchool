package com.student.crm.mapper;

import com.student.crm.domain.Log;

import java.util.List;

public interface LogMapper {

    int insert(Log record);

    Log selectByPrimaryKey(Long id);

    List<Log> selectAll();

}