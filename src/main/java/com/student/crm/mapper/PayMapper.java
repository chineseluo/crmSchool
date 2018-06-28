package com.student.crm.mapper;

import com.student.crm.domain.Pay;
import com.student.crm.query.PayQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Pay record);

    Pay selectByPrimaryKey(Long id);

    List<Pay> selectAll();

    int updateByPrimaryKey(Pay record);

    Long queryCount(PayQueryObject qo);

    List<Pay> list(PayQueryObject qo);

    void audit(@Param("id") Long id, @Param("status") Integer status);
}