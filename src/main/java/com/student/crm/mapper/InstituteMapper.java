package com.student.crm.mapper;

import com.student.crm.domain.Institute;
import com.student.crm.query.InstituteQueryObject;

import java.util.List;

public interface InstituteMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Institute record);

    Institute selectByPrimaryKey(Long id);

    List<Institute> selectAll();

    int updateByPrimaryKey(Institute record);

    Long queryCount(InstituteQueryObject qo);

    List<Institute> list(InstituteQueryObject qo);
}