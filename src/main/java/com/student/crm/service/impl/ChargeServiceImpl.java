package com.student.crm.service.impl;

import com.student.crm.domain.Charge;
import com.student.crm.mapper.ChargeMapper;
import com.student.crm.page.PageResult;
import com.student.crm.query.ChargeQueryObject;
import com.student.crm.service.IChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ChargeServiceImpl implements IChargeService {
    @Autowired
    private ChargeMapper chargeMapper;

    @Override
    public void insert(Charge charge) {
        chargeMapper.insert(charge);
    }

    @Override
    public void updateByPrimaryKey(Charge charge) {
        chargeMapper.updateByPrimaryKey(charge);
    }

    @Override
    public void deleteByPrimaryKey(Long id) {
        chargeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Charge selectByPrimaryKey(Long id) {
        return chargeMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult query(ChargeQueryObject qo) {
        Long total = chargeMapper.queryCount(qo);
        if (total <= 0) {
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        List<Charge> rows = chargeMapper.list(qo);
        return new PageResult(total, rows);
    }
}