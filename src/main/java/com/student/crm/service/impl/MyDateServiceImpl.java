package com.student.crm.service.impl;

import com.student.crm.domain.Employee;
import com.student.crm.domain.MyDate;
import com.student.crm.mapper.MyDateMapper;
import com.student.crm.query.MyDateQueryObject;
import com.student.crm.service.IMyDateService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyDateServiceImpl implements IMyDateService {
    @Autowired
    private MyDateMapper myDateMapper;

    @Override
    public void insert(MyDate myDate) {
        Employee user = (Employee) SecurityUtils.getSubject().getPrincipal();
        myDate.setUser(user);
        myDateMapper.insert(myDate);
    }

    @Override
    public void updateByPrimaryKey(MyDate myDate) {
        myDateMapper.updateByPrimaryKey(myDate);
    }

    @Override
    public List<MyDate> query(MyDateQueryObject qo) {
        Employee user = (Employee) SecurityUtils.getSubject().getPrincipal();
        if(!user.isAdmin()){
            qo.setUserId(user.getId());
        }
        return myDateMapper.query(qo);
    }

    @Override
    public void deleteByPrimaryKey(Long id) {
        myDateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public MyDate selectByPrimaryKey(Long id) {
        return myDateMapper.selectByPrimaryKey(id);
    }

}