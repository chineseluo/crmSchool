package com.student.crm.service;

import com.student.crm.domain.Institute;
import com.student.crm.page.PageResult;
import com.student.crm.query.InstituteQueryObject;

import java.util.List;

public interface IInstituteService {

    void deleteByPrimaryKey(Long id);

    void insert(Institute record);

    Institute selectByPrimaryKey(Long id);

    void updateByPrimaryKey(Institute record);

    PageResult query(InstituteQueryObject qo);

    List<Institute> selectAll();
}
