package com.student.crm.service.impl;

import com.student.crm.domain.Pay;
import com.student.crm.mapper.PayMapper;
import com.student.crm.page.PageResult;
import com.student.crm.query.PayQueryObject;
import com.student.crm.service.IPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PayServiceImpl implements IPayService {
    @Autowired
    private PayMapper payMapper;

    @Override
    public void insert(Pay pay) {
        payMapper.insert(pay);
    }

    @Override
    public void updateByPrimaryKey(Pay pay) {
        payMapper.updateByPrimaryKey(pay);
    }

    @Override
    public void deleteByPrimaryKey(Long id) {
        payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Pay selectByPrimaryKey(Long id) {
        return payMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult query(PayQueryObject qo) {
        Long total = payMapper.queryCount(qo);
        if (total <= 0) {
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        List<Pay> rows = payMapper.list(qo);
        return new PageResult(total, rows);
    }

    @Override
    public List<Pay> selectAll() {
        return payMapper.selectAll();
    }

    @Override
    public void audit(Long id, Integer status) {
        payMapper.audit(id,status);
    }
}