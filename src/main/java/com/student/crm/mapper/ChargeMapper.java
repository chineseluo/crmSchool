package com.student.crm.mapper;

import com.student.crm.domain.Charge;
import com.student.crm.query.ChargeQueryObject;

import java.util.List;

public interface ChargeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Charge record);

    Charge selectByPrimaryKey(Long id);

    List<Charge> selectAll();

    int updateByPrimaryKey(Charge record);

    Long queryCount(ChargeQueryObject qo);

    List<Charge> list(ChargeQueryObject qo);
}