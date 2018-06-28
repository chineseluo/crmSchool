package com.student.crm.service.impl;

import com.student.crm.domain.SystemLog;
import com.student.crm.mapper.SystemLogMapper;
import com.student.crm.service.ISystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/28.
 */
@Service
public class SystemLogServiceImpl implements ISystemLogService {
    @Autowired
    private SystemLogMapper systemLogMapper;

    @Override
    public int insert(SystemLog record) {
        return systemLogMapper.insert(record);
    }
}
