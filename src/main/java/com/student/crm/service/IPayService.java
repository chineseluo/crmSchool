package com.student.crm.service;

import com.student.crm.domain.Pay;
import com.student.crm.page.PageResult;
import com.student.crm.query.PayQueryObject;

import java.util.List;

public interface IPayService {

    void deleteByPrimaryKey(Long id);

    void insert(Pay record);

    Pay selectByPrimaryKey(Long id);

    void updateByPrimaryKey(Pay record);

    PageResult query(PayQueryObject qo);

    List<Pay> selectAll();

    void audit(Long id, Integer status);
}
