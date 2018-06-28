package com.student.crm.service;

import com.student.crm.domain.Log;

import java.util.List;

public interface ILogService {
    int insert(Log record);

    Log selectByPrimaryKey(Long id);

    List<Log> selectAll();
}
