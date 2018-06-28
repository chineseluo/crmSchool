package com.student.crm.service;

import com.student.crm.domain.Charge;
import com.student.crm.page.PageResult;
import com.student.crm.query.ChargeQueryObject;

public interface IChargeService {

    void deleteByPrimaryKey(Long id);

    void insert(Charge record);

    Charge selectByPrimaryKey(Long id);

    void updateByPrimaryKey(Charge record);

    PageResult query(ChargeQueryObject qo);
}
