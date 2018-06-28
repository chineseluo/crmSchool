package com.student.crm.service.impl;

import com.student.crm.domain.Institute;
import com.student.crm.mapper.InstituteMapper;
import com.student.crm.page.PageResult;
import com.student.crm.query.InstituteQueryObject;
import com.student.crm.service.IInstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class InstituteServiceImpl implements IInstituteService {
    @Autowired
    private InstituteMapper instituteMapper;

    @Override
    public void insert(Institute institute) {
        instituteMapper.insert(institute);
    }

    @Override
    public void updateByPrimaryKey(Institute institute) {
        instituteMapper.updateByPrimaryKey(institute);
    }

    @Override
    public void deleteByPrimaryKey(Long id) {
        instituteMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Institute selectByPrimaryKey(Long id) {
        return instituteMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult query(InstituteQueryObject qo) {
        Long total = instituteMapper.queryCount(qo);
        if (total <= 0) {
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        List<Institute> rows = instituteMapper.list(qo);
        return new PageResult(total, rows);
    }

    @Override
    public List<Institute> selectAll() {
        return instituteMapper.selectAll();
    }
}